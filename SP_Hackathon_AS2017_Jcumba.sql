
---- SERVICIOS ----

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
EXEC sp_regservicio ?,?
GO



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
EXEC sp_actservicio ?
GO



---- CLIENTE ----

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


EXEC sp_regusuario ?,?,?,?,'A'
GO




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

EXEC sp_actusuario ?,?,?,?
GO