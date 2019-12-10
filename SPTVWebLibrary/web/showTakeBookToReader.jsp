<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
   select {
    width: 300px; /* Ширина списка в пикселах */
   }
  </style>        
<form action="takeBookToReader" method="Post">
            <center>
        <h1>Выдать книгу читателю</h1><br>
                   Список читателей:<br>
        <select name="readerId">
            <c:forEach var="reader" items="${listReaders}">
                <option  value="${reader.id}">${reader.name} ${reader.surname}</option>
            </c:forEach>
        </select><br>
        Список книг:<br>
        <select name="bookId">
            <c:forEach var="book" items="${listBooks}">
                <option  value="${book.id}">"${book.name}" ${book.author}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Выдать книгу" class="w-50 mt-3 btn btn-primary"><br>
       <a href="index.jsp">Вернутся в главное меню</a><br>
        </center>
    </form>
    
