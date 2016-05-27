<%-- 
    Document   : riepilogo_Acquisto
    Created on : 1-mag-2016, 17.13.49
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="M3/css/style.css" rel="stylesheet" type="text/css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marco Cauli">
        <meta name="description" content="Area di riepilogo acquisto oggetto">
        <meta name="keywords" content="acquisto, inserzione, cliente, oggetto">
        <title>Riepilogo Acquisto</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="submenu">
            <p>Sei Loggato Come: ${Nome}</p>
        </div>
        <div class="generictable">
            <ul id="riepilogo">
                    <li>${oggetto.getNomeOggetto()}</li>
                    <li><img src="${oggetto.getUrlImg()}" alt="Foto Oggetto" width="150px"height="150px"/> </li>
                    <li> ${oggetto.getnPezzi()}</li>
                    <li>${oggetto.getPrezzo()}</li> 
                    <li>${oggetto.getDescrizione()}</li>
                    <li>${Acquisto}</li>
                     <a href="cliente.html">CONTINUA GLI ACQUISTI</a>
            </ul>
        </div>
        </div>
    </body>
</html>
