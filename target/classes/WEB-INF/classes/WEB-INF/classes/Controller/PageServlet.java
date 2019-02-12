package Controller;

import Dao.Page;
import Dao.SelectPageDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            String value = request.getParameter("states");
            System.out.println(value);
            SelectPageDao dao = new SelectPageDao();
            List<Page> list = dao.findByType(value);
            request.setAttribute("list",list);
            request.getRequestDispatcher("index1.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
