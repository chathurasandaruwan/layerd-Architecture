package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    boolean saveOrderDetail(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException;

    boolean saveOD(String orderId,OrderDetailDTO detail) throws SQLException, ClassNotFoundException;
}
