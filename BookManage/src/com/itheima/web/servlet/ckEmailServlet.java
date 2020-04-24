package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ckEmailServlet",urlPatterns = {"/ckEmailServlet"})
public class ckEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String email=request.getParameter("email");
        PrintWriter out = response.getWriter();
        if("tom@163.com".equals(email))
     {
          out.print(true);
     }else
        {
            out.print(false);
        }
    }
}
