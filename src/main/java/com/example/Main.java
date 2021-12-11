package com.example;

import com.example.entities.Company;
import com.example.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        QueryRunner runner = new QueryRunner();
        Company company = runner.query(JdbcUtil.getDataSource().getConnection(), "select * from company", new BeanHandler<>(Company.class));
        System.out.println(company);
    }
}
