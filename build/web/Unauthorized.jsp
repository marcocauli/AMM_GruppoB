<%-- 
    Document   : venditorenonautorizzato
    Created on : 2-mag-2016, 11.02.19
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="Marco Cauli">
        <meta name="description" content="Area di reindirizzamento">
        <meta name="keywords" content="login, logout, redirect, e-commerce">
        <link href="M3/css/style.css" rel="stylesheet" type="text/css">
        
        <title>NON SEI AUTORIZZATO!!</title>
    </head>
    <body>
        
        <h1 id="header"> ERRORE </h1>
        <jsp:include page="menu.jsp"/>
        <div class="generic"> 
            <p>non sei autorizzato a entrare in questa pagina. Prima ti devi Loggare</p>
        <a href="login.jsp">VAI AL LOGIN</a>
        </div>
    </body>
</html>
