package com.aakash.books.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BooksDao {
    private static final String InsertSql = "INSERT INTO BOOKS VALUES(?,?,?)";
    public boolean saveBook (int bookId , String bookName , double price) throws SQLException, IOException {

       Connection con = connectionFactory.getConnection();

       PreparedStatement pstmt = con.prepareStatement(InsertSql);
       pstmt.setInt(1,bookId);
       pstmt.setString(2,bookName);
       pstmt.setDouble(3,price);

       int rowsEffected = pstmt.executeUpdate();

       return  rowsEffected >0;
    };

}
