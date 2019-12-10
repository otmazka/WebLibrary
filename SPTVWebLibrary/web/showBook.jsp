<%@page contentType="text/html" pageEncoding="UTF-8"%>      
 <h1 class="text-cener p-3"><center>Содержание книги</center></h1>
 <div class="p-3 d-flex flex-row justify-content-center">
 <div class="card" style="width: 28rem;">
    <ul class="list-group list-group-fkush">
    <li class="list-group-item bg-list">Название книги: ${book.name}</li>
    <li class="list-group-item bg-list"> Автор книги: ${book.author}</li>
    <li class="list-group-item bg-list">Год издания книги: ${book.year} году</li> 
    </ul>
        </div><br>
           <a href="index.jsp">Вернутся в главное меню</a><br>  </div>  
