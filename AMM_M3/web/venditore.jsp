<%-- 
    Document   : venditore
    Created on : 27-apr-2016, 17.44.25
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="M3/css/style.css" rel="stylesheet" type="text/css">
        <title>Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marco Cauli">
        <meta name="description" content="Area di caricamento dell'oggetto">
        <meta name="keywords" content="vendita, inserzioni, elettronica">
    </head>
    <body>
        <div id="paginaVenditore">
        <h1 id="header"> Area Venditore: </h1>
        <!-- AREA DI NAVIGAZIONE IMPLEMENTATA CON LISTA-->
        <jsp:include page="menu.jsp"/>
        <div class="submenu">
            <p>Sei Loggato Come: ${Nome}</p>
        </div>
        <!-- FORM UTILIZZATO PER RICHIEDERE I PARAMETRI DELL'OGGETTO CHE SI 
        VUOLE METTERE IN VENDITA E INVIO TRAMITE SUBMIT-->
        
        <form id="AreaVenditore" action="venditore.html" method="POST">
                    
                    <label for="name"> Inserire nome oggetto:</label>
                    <input type="text" name="name"
                         id="name" value=""/>
                    <label for="url"> Inserire URL dell'immagine dell'oggetto:</label>
                    <input type="url" name="url"
                        id="url"/>
                    <label for='descrizione'> Inserire descrizione dell'oggetto:</label>
                    <textarea rows='5' cols='40' name='descrizione' id='descrizione'></textarea>
                    <label for='prezzo'> Inserire il prezzo dell'oggetto:</label>
                    <input type="number" name="prezzo"
                        id="prezzo" value=""/>
                    <label for='npezzi'> Inserire il numero dei pezzi in vendita:</label>
                    <input type="number" name="npezzi"
                        id="npezzi" value=""/>
                    <input name="Submit" type="submit" value="Aggiungi Oggetto">
            </form>
        </div>
    </body>
</html>
