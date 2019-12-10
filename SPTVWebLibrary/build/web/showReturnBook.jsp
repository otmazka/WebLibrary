 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <style>
   select {
    width: 300px; /* Ширина списка в пикселах */
   }
  </style>
        <form action="returnBook" method="POST">
           <center>
            <h1>Вернуть книгу в библиотеку</h1><br>
           
           <select name="historyId">
               <c:forEach var="history" items="${listHistories}">
                   <option value="${history.id}"> ${history.reader.name} ${history.reader.surname} купил книгу "${history.book.name}"</option>
               </c:forEach>
           </select><br>
           <input type="submit" value="Вернуть книгу" class="w-50 mt-3 btn btn-primary"><br>
           <a href="index.jsp">Вернутся в главное меню</a><br>
          </center>
        </form>
    
