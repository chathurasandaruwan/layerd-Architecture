package com.example.layeredarchitecture.dao;


import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;


public class OrderDAOImpl {
    ItemDAOImpl itemDAO = new ItemDAOImpl();
    OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
    public String generateOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = null;

            connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
            stm.setString(1, orderId);
            /*if not order id already exist*/
            if (!(stm.executeQuery().next())) {
                boolean isSavedOrder = saveNewOrder(connection,stm,orderId,orderDate,customerId);

                if (!(isSavedOrder)) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                //save order detail
                boolean isSavedOD = orderDetailDAO.saveOrderDetail(connection,orderDetails,stm,orderId);

                if (!(isSavedOD)) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                //Search & Update Item
                boolean isItemUpdate = itemDAO.newUpdateItem(connection, orderDetails);

                if (!(isItemUpdate)) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

    }
    public boolean saveNewOrder(Connection connection,PreparedStatement stm,String orderId,LocalDate orderDate,String customerId) throws SQLException {
        connection.setAutoCommit(false);
        stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderId);
        stm.setDate(2, Date.valueOf(orderDate));
        stm.setString(3, customerId);
        return stm.executeUpdate() == 1;
    }




}
