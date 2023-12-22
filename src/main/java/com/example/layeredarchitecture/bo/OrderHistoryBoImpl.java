package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dao.custom.impl.QueryDAOImpl;
import com.example.layeredarchitecture.model.SearchOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderHistoryBoImpl implements OrderHistoryBO{
    QueryDAO queryDAO = new QueryDAOImpl();
    @Override
    public ArrayList<SearchOrderDTO> getAllOrderHistory() throws SQLException, ClassNotFoundException {
        return queryDAO.getAllOrder();
    }
}
