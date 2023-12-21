package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.SearchOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {

    ArrayList<SearchOrderDTO> getAll() throws SQLException, ClassNotFoundException;
}
