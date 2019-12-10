package controller;

import entity.Reader;
import entity.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ReaderFacade;
import session.UserFacade;

/**
 *
 * @author user1
 */
@WebServlet(name = "SecurityController", urlPatterns = {
    "/showLogin",
    "/login",
    "/logout",
    "/showNewReader",
    "/createReader",
    
})
public class SecurityController extends HttpServlet {
    @EJB ReaderFacade readerFacade;
    @EJB UserFacade userFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path=request.getServletPath();
        switch (path) {
            case "/showLogin":
                request.getRequestDispatcher("/showLogin.jsp")
                        .forward(request, response);
                break;
            case "/login":
                String login = request.getParameter("login");
                User enteredUser = userFacade.findByLogin(login);
                if(enteredUser == null){
                    request.setAttribute("info", "Такого пользователя нет.");
                    request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                }
                String password = request.getParameter("password");
                if(password.equals(enteredUser.getPassword())){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("enteredUser",enteredUser);
                    request.setAttribute("info",
                            "Вы вошли как "
                            +enteredUser.getReader().getName()
                            +" "
                            +enteredUser.getReader().getSurname());
                }
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            case "/logout":
                HttpSession session = request.getSession(false);
                if(session !=null){
                    session.invalidate();
                    request.setAttribute("info","Вы вышли из системы");
                }
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            case"/showNewReader":
                request.getRequestDispatcher("/NewReader.jsp")
                   .forward(request, response);
                break;  
            case"/createReader":
                String name=request.getParameter("name");
                String surname=request.getParameter("surname");
                String year=request.getParameter("year");
                login=request.getParameter("login");
                password=request.getParameter("password");
                Reader reader=new Reader(
                        null,
                        name,
                        surname,
                        new Integer(year)
                );
                User user = userFacade.findByLogin(login);
                if(user != null){
                    request.setAttribute("info", "Такой логин уже используется");
                    request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
                }
                readerFacade.create(reader);
                user = new User(login, password, reader);
                userFacade.create(user);
                request.setAttribute(
                        "info", "Новый читатель, "
                        +user.getReader().getName()
                        +" "
                        +user.getReader().getSurname()+""
                        +", добавлен."
                );
                request.getRequestDispatcher("/index.jsp")
                   .forward(request, response);
                break;
        }
} 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
