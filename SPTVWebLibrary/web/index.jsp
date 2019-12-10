<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <h1 class="text-center">Добро пожаловать!</h1>
    <hr>
    <div class="text-center p-4">
        <p class="alert-success w-100">${info}</p>
        <a class="btn btn-light border-container w-75" href="showLogin">Вход в систему</a>
        <a class="btn btn-light border-container w-75" href="showNewReader">Зарегистрироваться</a>
        <a class="btn btn-light border-container w-75" href="logout">Выйти</a>
        <a class="btn btn-light border-container w-75" href="showNewBook">Новая книга</a>
        <a class="btn btn-light border-container w-75" href="showListBooks">Список книг</a>
        <a class="btn btn-light border-container w-75" href="showListReaders">Список читателей</a>
        <a class="btn btn-light border-container w-75" href="showTakeBookToReader">Выдать книгу читателю</a>
        <a class="btn btn-light border-container w-75" href="showReturnBook">Вернуть книгу в библиотеку</a>
    </div>