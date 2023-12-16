package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO{
    @Override
    public boolean saveOrderDetail(Connection connection, List<OrderDetailDTO> orderDetails, PreparedStatement stm,String orderId) throws SQLException {
        for (OrderDetailDTO detail : orderDetails) {
            if(!saveOD(connection,stm,orderId,detail)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean saveOD(Connection connection,PreparedStatement stm,String orderId,OrderDetailDTO detail) throws SQLException {
        stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        stm.setString(1, orderId);
        stm.setString(2, detail.getItemCode());
        stm.setBigDecimal(3, detail.getUnitPrice());
        stm.setInt(4, detail.getQty());
        return stm.executeUpdate() == 1;
    }
}
