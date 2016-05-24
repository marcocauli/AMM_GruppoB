<%-- 
    Document   : tabellacliente
    Created on : 28-apr-2016, 11.07.27
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
            <table id="tabellacliente">
                <tr id="Intestazioni">
                    <th>Oggetto</th>
                    <th>Foto</th>
                    <th>N. Pezzi </th>
                    <th> Prezzo </th>
                    <th> Descrizione </th>
                    <th> Aggiungi al Carrello </th>
                </tr> 
                <c:forEach items="${listaoggetti}" var="oggetto">
                        
                            <tr>
                                <td>
                                    <p>${oggetto.getNomeOggetto()}</p>
                                </td>
                                <td>
                                    <img src="${oggetto.getUrlImg()}" alt="Foto Oggetto" width="100" height="100"/> 
                                </td>
                                <td>
                                    <p> ${oggetto.getnPezzi()}</p>
                                </td>
                                <td>
                                    <p>${oggetto.getPrezzo()}</p> 
                                </td>
                                <td>
                                    <p>${oggetto.getDescrizione()}</p> 
                                </td>
                                <td>
                                    <form method="POST" action="acquisto.html">
                                        <input name="invio_oggetti" type="Submit" value="Vai">
                                        <input id="hidden" type="text" name="idogg"
                                            id="idogg" value=${oggetto.getId()}>
                                    </form>
                                </td>
                            </tr>
                             </c:forEach>
                    </table>
</div>
