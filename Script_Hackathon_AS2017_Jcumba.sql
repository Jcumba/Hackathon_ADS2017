-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-07-24 15:11:22.427
CREATE DATABASE BDHackathon;
USE BDHackathon;
-- tables
-- Table: BOLETA
CREATE TABLE BOLETA (
    cod_bolet int  NOT NULL IDENTITY,
    razsocial_bolet varchar(70)  NOT NULL,
    ruc_bolet varchar(11)  NOT NULL,
    PASAJERO_cod_pasaj int  NOT NULL,
    origen_bolet varchar(50)  NOT NULL,
    SUCURSALES_cod_sucur int  NOT NULL,
    fec_viaje_bolet datetime  NOT NULL,
    asiento_bolet int  NOT NULL,
    cant_bolet int  NOT NULL,
    precio_bolet varchar(15)  NOT NULL,
    fec_bolet date  NOT NULL,
    CONSTRAINT BOLETA_pk PRIMARY KEY  (cod_bolet)
);

-- Table: MANIFIESTO
CREATE TABLE MANIFIESTO (
    cod_manif int  NOT NULL IDENTITY,
    fec_manif date  NOT NULL,
    placa_manif varchar(20)  NOT NULL,
    SERVICIOS_cod_servic int  NOT NULL,
    USUARIO_cod_usua int  NOT NULL,
    CONSTRAINT MANIFIESTO_pk PRIMARY KEY  (cod_manif)
);

-- Table: PASAJERO
CREATE TABLE PASAJERO (
    cod_pasaj int  NOT NULL IDENTITY,
    nom_pasaj varchar(50)  NOT NULL,
    ape_pasaj varchar(50)  NOT NULL,
    tipdocu_pasaj varchar(50)  NOT NULL,
    docu_pasaj varchar(50)  NOT NULL,
    CONSTRAINT PASAJERO_pk PRIMARY KEY  (cod_pasaj)
);

-- Table: SERVICIOS
CREATE TABLE SERVICIOS (
    cod_servic int  NOT NULL IDENTITY,
    nom_servic varchar(50)  NOT NULL,
    estado_servic char(1)  NOT NULL,
    CONSTRAINT SERVICIOS_pk PRIMARY KEY  (cod_servic)
);

-- Table: SUCURSAL
CREATE TABLE SUCURSAL (
    cod_sucur int  NOT NULL IDENTITY,
    nom_sucur varchar(70)  NOT NULL,
    estado_surc char(1)  NOT NULL,
    CONSTRAINT SUCURSAL_pk PRIMARY KEY  (cod_sucur)
);

-- Table: USUARIO
CREATE TABLE USUARIO (
    cod_usua int  NOT NULL IDENTITY,
    nom_usua varchar(70)  NOT NULL,
    ape_usua varchar(70)  NOT NULL,
    dni_usua varchar(8)  NOT NULL,
    fef_nac_usua date  NOT NULL,
    estado_usua char(1)  NOT NULL,
    CONSTRAINT USUARIO_pk PRIMARY KEY  (cod_usua)
);

-- foreign keys
-- Reference: Boleta_PASAJERO (table: BOLETA)
ALTER TABLE BOLETA ADD CONSTRAINT Boleta_PASAJERO
    FOREIGN KEY (PASAJERO_cod_pasaj)
    REFERENCES PASAJERO (cod_pasaj);

-- Reference: Boleta_SUCURSALES (table: BOLETA)
ALTER TABLE BOLETA ADD CONSTRAINT Boleta_SUCURSALES
    FOREIGN KEY (SUCURSALES_cod_sucur)
    REFERENCES SUCURSAL (cod_sucur);

-- Reference: Manifiesto_SERVICIOS (table: MANIFIESTO)
ALTER TABLE MANIFIESTO ADD CONSTRAINT Manifiesto_SERVICIOS
    FOREIGN KEY (SERVICIOS_cod_servic)
    REFERENCES SERVICIOS (cod_servic);

-- Reference: Manifiesto_USUARIO (table: MANIFIESTO)
ALTER TABLE MANIFIESTO ADD CONSTRAINT Manifiesto_USUARIO
    FOREIGN KEY (USUARIO_cod_usua)
    REFERENCES USUARIO (cod_usua);

-- End of file.

