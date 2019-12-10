<%@page contentType="text/html" pageEncoding="UTF-8"%>
<center>
        <h1>Введите данные книги:</h1>
        <form action="createBook" method="POST">
            Название книги:<br>
            <input type="text" name="name"><br>
            Автор книги:<br>
            <input type="text" name="author"><br>
            Год издания книги<br>
            <input type="text" name="year"><br>

            <input type="submit" value="Создать" class="w-50 mt-3 btn btn-primary"><br>
           <a href="index.jsp">Вернутся в главное меню</a><br>
        </form>
   
</center>