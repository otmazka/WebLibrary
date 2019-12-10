<%@page contentType="text/html" pageEncoding="UTF-8"%>      
 <h1 class="text-cener p-3"><center>Данные читателя</center></h1>
 <div class="p-3 d-flex flex-row justify-content-center">
 <div class="card" style="width: 28rem;">
    <ul class="list-group list-group-fkush">
    <li class="list-group-item bg-list">Имя читателя: ${reader.name}</li>
    <li class="list-group-item bg-list">Фамилия читателя: ${reader.surname}</li>
    <li class="list-group-item bg-list">Год рождения читателя: ${reader.year}</li> 
    <li class="list-group-item bg-list">Читает книги: ${book.name}
    <ul>
    <c:forEach var="history" items="${listHistories}">
        <li class="list-group-item bg-list">${history.book.name}</li><br>
    </c:forEach>
        </ul>
    </li>
    </ul>
        </div>
           <a href="index.jsp">Вернутся в главное меню</a><br>  </div>  
