/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Marco
 * Created: 18-mag-2016
 */


INSERT INTO CLIENTE (id, username, password) 
VALUES (default, 'cliente1', '1'), (default, 'cliente2', '2'), 
(default, 'cliente3', '3'),(default, 'cliente4', '4'),(default, 'cliente5', '5');

INSERT INTO VENDITORE (ID, USERNAME, PASSWORD)
VALUES (default, 'venditore1','1'), (default, 'venditore2','2'), 
(default, 'venditore3','3'), (default, 'venditore4','4'), (default, 'venditore5','5');

INSERT INTO OGGETTO (ID, NOME, NPEZZI, PREZZO, IMG, DESCRIZIONE , VENDITORE)
VALUES
(default, 'RAM', 20, 30, '../../M3/img/RAM.jpg', 'OTTIMA RAM', 'venditore1'),
(default, 'monitor', 20, 30, '../../M3/img/monitor.jpg', 'OTTIMO MONITOR', 'venditore1'),
(default, 'mouse', 20, 30, '../../M3/img/mouse.jpg', 'OTTIMO MOUSE', 'venditore2'),
(default, 'pc', 20, 30, '../../M3/img/pc.jpg', 'OTTIMO PC', 'venditore3'),
(default, 'portatile', 20, 30, '../../M3/img/portatile.jpeg', 'OTTIMO PORTATILE', 'venditore4'),
(default, 'tastiera', 20, 30, '../../M3/img/tastiera.jpg', 'OTTIMA TASTIERA', 'venditore5');

INSERT INTO SALDO (ID, SALDO)
VALUES 
(default, 1552.3), (default, 152.3),(default, 552.3), (default, 155.3), (default, 15.3),
(default, 52.3), (default, 12.3), (default, 15523.69), (default, 2.43), (default, 152.3);