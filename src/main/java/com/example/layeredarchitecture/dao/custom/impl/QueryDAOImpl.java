package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.SearchOrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {


    @Override
    public ArrayList<SearchOrderDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT o.oid as oid,date,customerID,itemCode,qty from Orders o join OrderDetails d on o.oid = d.oid");
        ArrayList<SearchOrderDTO> getAllOrders = new ArrayList<>();
        while (rst.next()){
            SearchOrderDTO searchOrderDTO =new SearchOrderDTO(rst.getString(1),rst.getDate(2).toLocalDate(), rst.getString(3),rst.getString(4),rst.getInt(5));
            getAllOrders.add(searchOrderDTO);
        }
        return getAllOrders;
    }
}
