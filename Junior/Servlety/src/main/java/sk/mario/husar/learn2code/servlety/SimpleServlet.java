package sk.mario.husar.learn2code.servlety;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html> <html><body>");
        out.println("<h1>Som v simple servlete</h1>");

        String name = req.getParameter("name");

        out.println("<br>");
        out.printf("name: %s",name);

        HttpSession session = req.getSession();
        ServletContext context = req.getServletContext();

        if(name!=null && !name.isEmpty()){
            session.setAttribute("SavedName",name);
            context.setAttribute("SavedContext",name);
        }

        out.println("<br>");
        out.printf("saved name: %s",session.getAttribute("SavedName"));
        out.println("<br>");
        out.printf("saved context: %s",context.getAttribute("SavedContext"));


        String filterAttribute = (String) req.getSession().getAttribute("filterAttribute");
        out.println("<br>");
        out.printf("filterAttribute: %s",filterAttribute);

        String contextAttribute = (String) req.getServletContext().getAttribute("filter");
        out.println("<br>");
        out.printf("contextAttribute: %s",contextAttribute);

        out.println("</body> </html>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String[] state = req.getParameterValues("state");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html> <html><body>");
        out.println("<h1>Som v simple servlete POST</h1>");

        out.println("<br>");
        out.printf("name: %s",name);

        out.println("<br>");
        out.printf("sex: %s",sex);

        out.println("<br>");
        for (String s : state) {
            out.println("<br>");
            out.printf("state: %s ", s);
        }

        out.println("</body> </html>");

    }
}
