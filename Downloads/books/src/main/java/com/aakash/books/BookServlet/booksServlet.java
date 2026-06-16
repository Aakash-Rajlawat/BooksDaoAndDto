package com.aakash.books.BookServlet;

import com.aakash.books.Dao.BooksDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.awt.SystemColor.text;
@WebServlet("/books")
public class booksServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Capture data from the form
        try {

            String bookName = req.getParameter("bookName");

            int bookId = Integer.parseInt(req.getParameter("bookId"));
            double bookPrice = Double.parseDouble(req.getParameter("price"));

            // Store the  data into database using DAO
            BooksDao booksDao = new BooksDao();
            boolean status = booksDao.saveBook(bookId, bookName, bookPrice);

            String respond = null;

            if (status) {
                respond = "Record has been inserted";
            }else {
                respond = "Record has not been inserted";
            };


            resp.setContentType("text/html");
            PrintWriter write = resp.getWriter();

            write.println(respond);

        } catch (Exception e) {
            PrintWriter write = resp.getWriter();
            e.printStackTrace();
            write.append("<h3>Error: " + e.getMessage() + "</h3>");
        }


    }
}
