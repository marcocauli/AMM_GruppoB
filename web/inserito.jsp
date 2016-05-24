<%-- 
    Document   : inserito
    Created on : 1-mag-2016, 14.02.29
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="M3/css/style.css" rel="stylesheet" type="text/css">
        <title>Inserito!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marco Cauli">
        <meta name="description" content="Area di riepilogo inserimento oggetto">
        <meta name="keywords" content="vendita, inserzione, venditore, oggetto">
    </head>
    <body>
        <h1 id="header"> Sezione di Riepilogo Oggetto: </h1>
        <jsp:include page="menu.jsp"/>
        <div>
            <div class="submenu">
            <p>Sei Loggato Come: ${Nome}</p>
        </div>
        <div class="generictable">
            <ul>
                <li>${oggetto.getNomeOggetto()}</li>
                <li><image src="${oggetto.getUrlImg()}" alt="Foto Oggetto" width="150px"height="150px"/></li>
                <li>${oggetto.getDescrizione()}</li>
                <li>${oggetto.getPrezzo()}</li>
                <li> ${oggetto.getnPezzi()}</li>
            </ul>
            <p>Oggetto Inserito!</p>
            <a href="venditore.jsp">NUOVO INSERIMENTO</a>
        </div>
        </div>
    </body>
</html>
