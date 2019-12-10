<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <h1 class="text-cener"><center>Книги нашей библиотеки:</center></h1>
        <hr>
        <center>
        <table class="list-elements">
            <c:forEach var="book" items="${listBooks}" varStatus="number">
                <tr>
                <p><td>${number.index+1}. "${book.name}", ${book.author} </td><td> <a href="showBook?bookId=${book.id}"> Посмотреть</a></td></p>
                </tr>
            </c:forEach>
                </table>
        <hr>
        <table>
                <tr>    
                <p><td>Всего: </td><td>${count}</td></p>
                </tr>
                </table>
          
                </center>
               
       
    