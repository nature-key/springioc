package com.tx;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void lessMoney(){
        String sql ="update account set salary=salary-? where username = ?";
        jdbcTemplate.update(sql,20,"小马");
    }
    public void moreMoney(){
        String sql ="update account set salary=salary+? where username = ?";
        jdbcTemplate.update(sql,20,"小王");
    }
}
