<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<center>
        <h1>Введите данные читателя:</h1>
            <form action="createReader" method="POST">
            Имя читателя:<br>
            <input class="w-50" type="text" name="name"><br>
            Фамилия читателя:<br>
            <input class="w-50" type="text" name="surname"><br>
            Год рождения читателя:<br>
            <input class="w-50" type="text" name="year"><br>
            Логин:<br>
            <input class="w-50" type="text" name="login"><br>
            Пароль:<br>
            <input class="w-50" type="password" name="password"><br>

            <input type="submit" value="Создать" class="w-50 mt-3 btn btn-primary"><br>
        </form>
        <br>
           <a href="index.jsp">Вернутся в главное меню</a><br>
</center>
