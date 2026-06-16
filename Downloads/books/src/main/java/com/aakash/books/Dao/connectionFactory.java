package com.aakash.books.Dao;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class connectionFactory {

    //datasource is kept outside function cuz we don't wanna create a new connection pool each time we call the function
    private static DataSource dataSource = null;

    //function to get the connection
    //=================================
    public static Connection getConnection() throws SQLException, IOException {


        if (dataSource == null){
            //so basically if dataSource is null which is when connection pool is'nt created
            //the fn, creates the connectionPool but skips the connection pool making process
            //again and again which saves us from creating unnecessary conenction pools.


            //using the db.properties file
            //==============================

            FileInputStream fis = new FileInputStream(new File("/Users/aakashrajlawat/Downloads/books/src/main/resources/db.properties"));
            Properties p = new Properties();
            p.load(fis);

            //Getting the key properties
            //===========================
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");
            String url = p.getProperty("db.url");
            String driver = p.getProperty("db.driver");

            //Getting the connection using hikari connection pool
            //===================================================

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(username);
            config.setPassword(password);
            config.setDriverClassName(driver);


            config.setMaximumPoolSize(20);
            config.setMinimumIdle(5);
            dataSource = new HikariDataSource(config);
        }


        //directly return the connection if the connection pool is already created

       return dataSource.getConnection();
    };

}
