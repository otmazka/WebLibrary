<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <h1 class="text-cener"><center>Читатели нашей библиотеки:</center></h1>
        <hr>
        <center>
        <table class="list-elements">
            <c:forEach var="reader" items="${listReaders}" varStatus="number">
                <tr>
                <p><td>${number.index+1}. ${reader.name} ${reader.surname} </td><td> <a href="showReader?readerId=${reader.id}"> Посмотреть</a></td></p>
                </tr>
            </c:forEach>
                </table>
        <hr>
        <table>
                <tr>    
                <p><td>Всего: </td><td> ${count}</td></p>
                </tr>
                </table>
           
                </center>
