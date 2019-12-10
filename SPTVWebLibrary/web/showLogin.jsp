<%@page contentType="text/html" pageEncoding="utf-8"%>
<div class="margin-container-center w-50">
    <center>
<h1>Вход в систему</h1>
<form action="login" method="POST">
  <div class="form-group">
    <label for="login">Логин: </label>
    <input type="text" class="form-control" name="login" id="login" placeholder="Введите логин">
  </div>
  <div class="form-group">
    <label for="password">Пароль: </label>
    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary">Войти</button>
  <br><br>
  <a href="showNewReader">Зарегистрироваться</a><br>
           <a href="index.jsp">Вернутся в главное меню</a><br>
</form>
</center>
</div>