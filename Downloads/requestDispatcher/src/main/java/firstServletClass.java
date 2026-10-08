import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/firstServlet")
public class firstServletClass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.append("<h1>Response from first Servlet</h1>");
        RequestDispatcher rd = req.getRequestDispatcher("/secondServlet");
        rd.include(req,resp);
    }
}
