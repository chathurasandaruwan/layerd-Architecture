package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    public boolean saveOrderDetail(Connection connection, List<OrderDetailDTO> orderDetails, PreparedStatement stm, String orderId) throws SQLException;

    public boolean saveOD(Connection connection,PreparedStatement stm,String orderId,OrderDetailDTO detail) throws SQLException;
}
