<%@page contentType="text/html" pageEncoding="UTF-8"%>
<center>      
<h1>Список выданых книг:</h1>
    </center>   
        <ul>
            <c:forEach var="history" items="${listHistories}">
                <li>${history.reader.name} ${history.reader.surname} читает книгу:"${history.book.name}" ${history.book.author}</li>
            </c:forEach>
        </ul><br>
           <a href="index.jsp">Вернутся в главное меню</a><br>
    
 