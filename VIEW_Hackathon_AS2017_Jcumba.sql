----- VISTAS -----

----- Usuario -----
CREATE VIEW vw_listUser AS
SELECT nom_usua, ape_usua, dni_usua, fef_nac_usua 
FROM USUARIO 
WHERE estado_usua 
like 'A'
GO

SELECT * FROM vw_listUser
GO

----- Servicios -----

CREATE VIEW vw_listServ AS
SELECT * FROM SERVICIOS 
WHERE estado_servic like 'A'
GO

SELECT * FROM vw_listServ ORDER BY cod_servic
GO

----- Sucursal -----

CREATE VIEW vw_listSucursal AS
SELECT cod_sucur,nom_sucur FROM Sucursal 
WHERE estado_surc like 'A'
GO

SELECT * FROM vw_listSucursal ORDER BY cod_sucur
GO

----- Pasajero -----

CREATE VIEW vw_listPasajero AS
SELECT cod_pasaj ,nom_pasaj, ape_pasaj, tipdocu_pasaj, docu_pasaj FROM Pasajero 
WHERE estado_pasaj like 'A'
GO

SELECT * FROM vw_listPasajero ORDER BY cod_pasaj
GO
