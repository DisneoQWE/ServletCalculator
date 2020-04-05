import javafx.scene.transform.MatrixType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    protected static String operator;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int c;
        c=Calculate(req);
        System.out.println(c);
        resp.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
        req.setAttribute("result", c);
        requestDispatcher.forward(req,resp);
    }

    protected static int Calculate(HttpServletRequest request){
        int a, b ,c=0;
        a = Integer.parseInt(request.getParameter("number1"));
        b = Integer.parseInt(request.getParameter("number2"));
        operator = request.getParameter("operator");
        System.out.println(operator);
        if(operator.equals("+")) c = a+b;
        if(operator.equals("-")) c = a-b;
        if(operator.equals("/")) c = a/b;
        if(operator.equals("*")) c = a*b;
        return c;
    }
}
