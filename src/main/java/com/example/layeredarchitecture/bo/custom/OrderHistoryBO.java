package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.SearchOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderHistoryBO {

    ArrayList<SearchOrderDTO> getAllOrderHistory() throws SQLException, ClassNotFoundException;
}
