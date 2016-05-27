<%-- 
    Document   : cliente
    Created on : 27-apr-2016, 17.42.37
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="M3/css/style.css" rel="stylesheet" type="text/css">
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marco Cauli">
        <meta name="description" content="Area contenente inserzioni per clienti">
        <meta name="keywords" content="acquisto, inserzioni, cliente, elettronica">
    </head>
    <body>
        <div id="paginaCliente">
        <h1> Articoli in Vendita </h1>
        <!-- AREA DI NAVIGAZIONE IMPLEMENTATA CON LISTA-->
        <jsp:include page="menu.jsp"/>
        <!-- AREA CLIENTE CON MOSTRA DI VARI OGGETTI RAPPRESENTATI IN TABELLA E
             POSSIBILITA' DI AGGIUNGERE AL CARRELLO-->
        <div class="submenu">
            <p>Sei Loggato Come: ${Nome}</p>
            <p>Il tuo saldo: ${Saldo}</p>
        </div>
        <jsp:include page="tabellacliente.jsp"/>
        </div>
    </body>
</html>
