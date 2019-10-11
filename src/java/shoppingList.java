/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 797494
 */
public class shoppingList extends HttpServlet {
    
     protected void Do(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {

            username = request.getParameter("username");
        }else {
            request.setAttribute("message", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        ArrayList<String> itemlist = (ArrayList<String>) session.getAttribute("list");

        if (itemlist == null) {
            itemlist = new ArrayList();
        }

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        } else if (action.equals("register")) {
            session.setAttribute("username", request.getParameter("username"));
            session.setAttribute("user", username);

        } else if (action.equals("logout")) {

            session.removeAttribute("username");
            session.invalidate();
            request.setAttribute("message", "You successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } else if (action.equals("add")) {
            itemlist.add(request.getParameter("item"));
            session.setAttribute("list", itemlist);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        } else if (action.equals("delete")) {

            try {

                String item = request.getParameter("items");
                int countItem = Integer.parseInt(item);
                itemlist.remove(countItem - 1);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;

            } catch (NumberFormatException e) {
            }

        }

        if (username == null || username.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Do(request, response);
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             Do(request, response);
    }

}
