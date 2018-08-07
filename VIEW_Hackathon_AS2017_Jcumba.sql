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
