package com.example;

import com.example.entities.Company;
import com.example.utils.JdbcUtil;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {

    //@Test
    public void testUpdate() throws SQLException {
        Connection conn = JdbcUtil.createConnection();
        QueryRunner runner = new QueryRunner();
        int n = runner.update(conn,"insert into company values (1, 'alice', 18, 'beijing',8000)");
        System.out.println("插入条数：" + n);
        DbUtils.closeQuietly(conn);
    }

    @Test
    public void testQuery() throws SQLException {
        Connection conn = JdbcUtil.createConnection();
        QueryRunner runner = new QueryRunner();
        Company company1 = runner.query(conn, "select * from company", new BeanHandler<>(Company.class));
        System.out.println(company1);
        DbUtils.closeQuietly(conn);

        Company company2 = runner.query(JdbcUtil.getDataSource().getConnection(), "select * from company", new BeanHandler<>(Company.class));
        System.out.println(company2);
    }
}
