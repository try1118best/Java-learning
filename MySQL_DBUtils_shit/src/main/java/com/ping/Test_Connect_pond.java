package com.ping;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.Statement;

public class Test_Connect_pond {
    public static void main(String[] args) {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            //1、设置数据库驱动
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            //2、设置URL
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
            //3、设置用户名和密码
            dataSource.setUser("root");
            dataSource.setPassword("123456");
            //4、设置连接池的参数
            dataSource.setInitialPoolSize(20); //连接池初始化大小
            dataSource.setMaxPoolSize(40);     //连接池最大连接数
            dataSource.setMinPoolSize(2);      //连接池最小连接数
            dataSource.setAcquireIncrement(5); //连接池每次增加的连接数,扩容
            Connection connection = dataSource.getConnection();
            String sql = "insert into user(name,age,score,money) values" +
                    "('user666',18,100,1000)";
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
