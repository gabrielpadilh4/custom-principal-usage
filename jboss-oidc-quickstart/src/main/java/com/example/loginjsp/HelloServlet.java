package com.example.loginjsp;

import java.io.*;

import org.example.CustomOidcPrincipal;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        CustomOidcPrincipal customOidcPrincipal = (CustomOidcPrincipal) request.getUserPrincipal();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + customOidcPrincipal.getName() + "</h1>");
        out.println("<h1>" + customOidcPrincipal.getMyProperty() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}