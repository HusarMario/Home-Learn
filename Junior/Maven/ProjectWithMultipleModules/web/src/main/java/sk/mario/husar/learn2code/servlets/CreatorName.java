package sk.mario.husar.learn2code.servlets;

import sk.mario.husar.learn2code.CoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/creator")
public class CreatorName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        CoreService coreService = new CoreService();
        resp.setContentType("text/html");
        out.println("<DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>" + coreService.giveCreatorName() + "</h2>\n" +
                "</body>\n" +
                "</html>");
    }
}
