package com.datababy.service;

import com.datababy.enity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * Created by yongma on 2017/1/26.
 */
@Service
public class TestService implements Serializable{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Test> getTest(){
        String sql = "select * from test";

        return jdbcTemplate.query(sql, new RowMapper<Test>() {
            @Override
            public Test mapRow(ResultSet resultSet, int i) throws SQLException {
                Test t = new Test(resultSet.getString("NAME"),resultSet.getString("AGE"));
                return t;
            }
        });
    }



}
