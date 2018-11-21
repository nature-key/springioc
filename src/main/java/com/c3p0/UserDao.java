package com.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {


    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add() {
        String sql = "insert into user values(?,?)";
        int row = jdbcTemplate.update(sql, "ddd", "ddd");
        System.out.println(row);
    }
}
