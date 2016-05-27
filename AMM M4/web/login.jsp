<%-- 
    Document   : login
    Created on : 27-apr-2016, 17.38.36
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
    -->
<html>
    <head>
        <link href="M3/css/style.css" rel="stylesheet" type="text/css">
        <title>LOG-IN</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marco Cauli">
        <meta name="description" content="Area di login per venditori e clienti">
        <meta name="keywords" content="login, utente, cliente, venditore">
    </head>
    <body>
        <div id="paginaLogin">
        <h1 id="header"> Sezione di Log-in: </h1>
        <!-- AREA DI NAVIGAZIONE IMPLEMENTATA CON LISTA-->
        <jsp:include page="menu.jsp"/>
        <!-- AREA DI LOGIN CON RICHIESTA ID E PW, INVIO CON SUBMIT  -->
        <form id="login" method="POST" action="login.html">
            <label id="label1" for="idv"> Inserire id:</label>
            <input type="text" name="idv"
                    id="idv" value=""/>
            <label id="label2" for="pw"> Inserire password:</label>
            <input type="password" name="pw"
                    id="pw" value=""/>
            <input id="Invio1" name="Submit" type="Submit" value="Invia Dati">
        </form>
        </div>
    </body>
</html>

