package controller;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;

/**
 *
 * @author user
 */
@WebServlet(name = "LibraryController", urlPatterns = {
    "/book",
    "/reader",
    "/showNewBook",
    "/createBook",
    "/showListBooks",
    "/showListReaders",
    "/showTakeBookToReader",
    "/takeBookToReader",
    "/showReturnBook",
    "/returnBook",
    "/showBook",
    "/showReader", //Шаблоны запроса, который отлавливает сервлет
})
public class LibraryController extends HttpServlet {
//List<Book> listBooks=new ArrayList<>();

    @EJB
    BookFacade bookFacade;
    @EJB
    ReaderFacade readerFacade;
    @EJB
    HistoryFacade historyFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String path = request.getServletPath();
        if (!path.equals("/showListBooks")) {
            
        
        HttpSession session = request.getSession(false);
        if (session == null) {
            request.getRequestDispatcher("/showLogin.jsp")
                    .forward(request, response);
            return;
        }
        User enteredUser = (User) session.getAttribute("enteredUser");
        if (enteredUser == null) {
            request.getRequestDispatcher("/showLogin.jsp")
                    .forward(request, response);
            return;
        }
        }
        switch (path) {
            case "/book":
                Book book = new Book(); //Инициация объекта книги
                book.setId(1L);
                book.setName("Voina i mir");
                book.setAuthor("L. Tolstoi");
                book.setYear(2010);
                request.setAttribute("book", book); // Создание переменной book в контексте обработки jsp
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response); // Формирование ответа браузеру
                break;
            case "/reader":
                Reader reader = new Reader(1L, "Ivan", "Ivanov", 2003);
                request.setAttribute("reader", reader);
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            case "/showNewBook":
                request.getRequestDispatcher("/NewBook.jsp")
                        .forward(request, response);
                break;
            case "/createBook":
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String year = request.getParameter("year");
                book = new Book(null, name, author, new Integer(year));
                //listBooks.add(book);
                bookFacade.create(book);
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            case "/showListBooks":
                listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.setAttribute("count", listBooks.size());
                request.getRequestDispatcher("/showListBooks.jsp")
                        .forward(request, response);
                break;
            case "/showBook":
                String bookId = request.getParameter("bookId");
                book = bookFacade.find(new Long(bookId));
                request.setAttribute("book", book);
                request.getRequestDispatcher("/showBook.jsp")
                        .forward(request, response);
                break;
            case "/showListReaders":
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.setAttribute("count", listReaders.size());
                request.getRequestDispatcher("/showListReaders.jsp")
                        .forward(request, response);
                break;
            case "/showReader":
                String readerId = request.getParameter("readerId");
                reader = readerFacade.find(new Long(readerId));
                List<History> listHistories = historyFacade.findNotReturnBooks(reader);
                request.setAttribute("reader", reader);
                request.setAttribute("listHistories", listHistories);
                request.getRequestDispatcher("/showReader.jsp")
                        .forward(request, response);
                break;
            case "/showTakeBookToReader":
                listReaders = readerFacade.findAll();
                listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/showTakeBookToReader.jsp")
                        .forward(request, response);
                break;
            case "/takeBookToReader":
                readerId = request.getParameter("readerId");
                bookId = request.getParameter("bookId");
                reader = readerFacade.find(new Long(readerId));
                book = bookFacade.find(new Long(bookId));
                Calendar c = new GregorianCalendar();
                History history = new History(null, book, reader, c.getTime(), null);
                historyFacade.create(history);
                listHistories = historyFacade.findTakeBooks();
                request.setAttribute("listHistories", listHistories);
                request.getRequestDispatcher("/showListTakeBooks.jsp")
                        .forward(request, response);
                break;
            case "/showReturnBook":
                listHistories = historyFacade.findTakeBooks();
                request.setAttribute("listHistories", listHistories);
                request.getRequestDispatcher("/showReturnBook.jsp")
                        .forward(request, response);

                break;
            case "/returnBook":
                String historyId = request.getParameter("historyId");
                if(historyId == null){
                    request.setAttribute("info", "Книг больше не выдано");
                    request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                    break;
                }
                history = historyFacade.find(new Long(historyId));
                c = new GregorianCalendar();
                history.setEndDate(c.getTime());
                historyFacade.edit(history);
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
