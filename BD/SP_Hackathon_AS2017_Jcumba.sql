--------------------------------------------- SERVICIOS ---------------------------------------------------

--REGISTRAR--
CREATE PROCEDURE sp_regservicio
    @NOMBRE VARCHAR(50),
    @ESTADO CHAR(1)
AS
BEGIN
    INSERT INTO SERVICIOS
        (nom_servic,estado_servic) 
    VALUES
        (UPPER(@NOMBRE), UPPER(@ESTADO))
END
GO
--JAVA--
EXEC sp_regservicio ?,'A'
GO


--ACTUALIZAR--
CREATE PROCEDURE sp_actservicio
    @NOMBRE VARCHAR(50),
    @CODIGO INT
AS
BEGIN
UPDATE SERVICIOS 
SET nom_servic = @NOMBRE  
WHERE cod_servic = @CODIGO
END
GO
--JAVA--
EXEC sp_actservicio ?,?
GO

--------------------------------------------- CLIENTE ---------------------------------------------------

--REGISTRAR--
CREATE PROCEDURE sp_regusuario
    @NOMBRE VARCHAR(50),
    @APELLIDO VARCHAR(50),
    @DNI VARCHAR(50),
    @FECHA date,
    @ESTADO CHAR(1)
AS
BEGIN
    INSERT INTO USUARIO
        (nom_usua,ape_usua,dni_usua,fef_nac_usua,estado_usua)
    VALUES
        (UPPER(@NOMBRE),UPPER(@APELLIDO),@DNI,@FECHA, UPPER(@ESTADO))
END
GO
--JAVA--
EXEC sp_regusuario ?,?,?,?,'A'
GO



--ACTUALIZAR--
CREATE PROCEDURE sp_actusuario
    @NOMBRE VARCHAR(50),
    @APELLIDO VARCHAR(50),
    @DNI VARCHAR(8),
    @FECHA date,
    @CODIGO INT
AS
BEGIN
UPDATE USUARIO 
SET nom_usua = @NOMBRE, 
ape_usua = @APELLIDO,
dni_usua = @DNI,
fef_nac_usua = @FECHA
WHERE cod_usua = @CODIGO
END
GO
--JAVA--
EXEC sp_actusuario ?,?,?,?
GO

--------------------------------------------- PASAJERO ---------------------------------------------------

--REGISTRAR--
CREATE PROCEDURE sp_regpasajero
    @NOMBRE VARCHAR(50),
    @APELLIDO VARCHAR(50),
    @TIPDOC VARCHAR(50),
    @DOCUMENTO VARCHAR(50),
    @ESTADO CHAR(1)
AS
BEGIN
    INSERT INTO PASAJERO
        (nom_pasaj,ape_pasaj,tipdocu_pasaj,docu_pasaj,estado_pasaj) 
    VALUES
        (UPPER(@NOMBRE),UPPER(@APELLIDO),UPPER(@TIPDOC),@DOCUMENTO, UPPER(@ESTADO))
END
GO
--JAVA--
EXEC sp_regpasajero ?,?,?,?,'A'
GO


--ACTUALIZAR--
CREATE PROCEDURE sp_actpasajero
    @NOMBRE VARCHAR(50),
    @APELLIDO VARCHAR(50),
    @TIPDOC VARCHAR(50),
    @DOCUMENTO VARCHAR(50),
    @CODIGO INT
AS
BEGIN
UPDATE PASAJERO 
SET nom_pasaj = @NOMBRE,
    ape_pasaj = @APELLIDO,
    tipdocu_pasaj = @TIPDOC,
    docu_pasaj = @DOCUMENTO
WHERE cod_pasaj = @CODIGO
END
GO
--JAVA--
EXEC sp_actpasajero ?,?,?,?,?
GO

-------------------------------------------------SUCURSAL----------------------------------------------

--REGISTRAR--
CREATE PROCEDURE sp_regsucursal
    @NOMBRE VARCHAR(70),
    @ESTADO CHAR(1)
AS
BEGIN
    INSERT INTO SUCURSAL
        (nom_sucur,estado_surc) 
    VALUES
        (UPPER(@NOMBRE),UPPER(@ESTADO))
END
GO
--JAVA--
EXEC sp_regsucursal ?,'A'
GO


--ACTUALIZAR--
CREATE PROCEDURE sp_actsucursal
    @NOMBRE VARCHAR(50),
    @CODIGO INT
AS
BEGIN
UPDATE SUCURSAL 
SET nom_sucur = @NOMBRE
WHERE cod_sucur = @CODIGO
END
GO
--JAVA--
EXEC sp_actsucursal ?,?
GO

