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
                    <th> Aggiungi al Carrello </th>
                </tr> 
                        <c:forEach var="oggetto" items="${listaOggettiinVendita}">
                            <tr>
                                <td>
                                    <p>${oggetto.getNomeOggetto()}</p>
                                </td>
                                <td>
                                    <img src="${oggetto.getUrlImg()}" alt="Foto Oggetto" width="120" height=120/> 
                                </td>
                                <td>
                                    <p> ${oggetto.getnPezzi()}</p>
                                </td>
                                <td>
                                    <p>${oggetto.getPrezzo()}</p> 
                                </td>
                                <td>
                                    <a href="inserisci.jsp"> Aggiungi al Carrello </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
            </table>
        </div>
