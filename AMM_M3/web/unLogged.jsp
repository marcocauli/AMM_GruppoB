<%-- 
    Document   : unLogged
    Created on : 2-mag-2016, 11.15.21
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="M3/css/style.css" rel="stylesheet" type="text/css">
        <meta name="author" content="Marco Cauli">
        <meta name="description" content="Area di reindirizzamento">
        <meta name="keywords" content="login, logout, redirect, e-commerce">
        <title>NON LOGGATO</title>
    </head>
    <body>
        <h1 id="header">Attenzione!</h1>
        <jsp:include page="menu.jsp"/>
        <div class="generic">
            <p>sei uscito dal tuo account </p>
        <a href="descrizione.jsp">VAI ALLA DESCRIZIONE</a>
        </div>
    </body>
</html>
