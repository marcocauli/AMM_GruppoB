<%-- 
    Document   : descrizione
    Created on : 27-apr-2016, 17.25.39
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>E-Commerce</title>
         <link href="M3/css/style.css" rel="stylesheet" type="text/css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Marco Cauli">
        <meta name="keywords" content="E-commerce, acquisti, vendita, elettronica">
        <meta name="description" content="Pagina iniziale e descrizione">
    </head>
    <body>
        <div id="pagina">
        <h1 id="header"> E-commerce online </h1>
        <!-- AREA DI NAVIGAZIONE IMPLEMENTATA CON LISTA-->
        <jsp:include page="menu.jsp"/>
        <jsp:include page="sidebar.jsp"/>
            <!-- AREA DISCORSIVA IMPLEMENTATA IN VARIE SEZIONI-->
            <div id="content">
            <section>
                <h2 id="descrizione">Descrizione</h2>
                    <p> Nuovissimo sito di E-Commerce online in tempo reale.Grazie a
                    questo sito un qualsiasi venditore è in grado di poter vendere un
                    proprio oggetto a un altro cliente presente nel nostro sito.
                    Il sito è mirato in particolare all'elettronica, 
                    tra le inserzioni più frequenti nella pagina possiamo infatti classificare
                    le parti per pc al primo posto.
                    </p>
            </section>
            <section>
                <h2>Lo Staff:</h2>
                    <p>Siamo un team di giovani ragazzi che vogliono aiutare i 
                        propri clienti a trovare l'oggetto che cercano, grazie 
                        ad un monitorato sistema di inserzioni e acquisti tramite
                        il nostro sito garantiamo la totale sicurezza nelle fasi
                        di pagamento verso un remoto venditore.
                        Lo staff è composto da:
                    <ul  id="Staff">
                        <li><h3>Antonio Rossi</h3><p>Sin da piccolo mostrava interesse
                            nell'ambito elettronico, nonappena diplomato decide
                            di iscriversi nella facoltà di ingegneria elettronica
                            dove sta proseguendo i suoi studi.
                            </p>
                        </li>
                        <li><h3>Andrea Ponti</h3><p>Gestisce la parte finanziaria
                                del nostro sito On-line, è laureato in Economia
                                da 4 anni, dimostra grandi capacità di calcolo
                                e di gestire al meglio le finanze a nostra 
                                disposizione.
                            </p>
                        </li>
                        <li><h3>Matteo Fruga</h3><p>Informatico del gruppo, ha 
                                creato il sito con l'aiuto di Antonio, e lo gestiscono
                                assieme, cura la parte di programmazione
                                del sito.
                            </p>
                        </li>
                        
                        
                    </ul>
            </section>
            <section>
                <h2 id="Venditori">Chi carica le inserzioni?</h2>
                    <p>Diamo la possibilita a ogni utente registrato di poter caricare
                    un suo oggetto sul notro sito, in modo che qualsiasi altro utente 
                    registrato lo possa acquistare.</p>
            </section>
            <section>
                <h2 id='Clienti'> A chi è rivolto?</h2>
                    <p>Il nostro e-commerce è rivolto a ogni genere di utente interessato
                        agli annunci proposti sul notro sito.</p>
            </section>
        </div>
            
        </div>
    </body>
</html>
