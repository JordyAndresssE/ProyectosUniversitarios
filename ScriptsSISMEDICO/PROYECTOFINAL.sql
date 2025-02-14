-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2025-01-03 10:09:30 COT
--   sitio:      Oracle Database 21c
--   tipo:      Oracle Database 21c

CREATE TABLE sis_med_citas (
    cit_id                   NUMBER(4) NOT NULL,
    cit_fecha_hora           TIMESTAMP NOT NULL,
    cit_estado               VARCHAR2(20) NOT NULL,
    usu_id                   NUMBER(4) NOT NULL,
    per_id                   NUMBER(4) NOT NULL,
    per_id2                  NUMBER(4) NOT NULL
);

COMMENT ON COLUMN sis_med_citas.cit_id IS
    'Identificador unico de la cita';

COMMENT ON COLUMN sis_med_citas.cit_fecha_hora IS
    'Fecha y hora  de la cita';

COMMENT ON COLUMN sis_med_citas.cit_estado IS
    'Estado de la cita';

ALTER TABLE sis_med_citas ADD CONSTRAINT pk_citas PRIMARY KEY ( cit_id );

CREATE TABLE sis_med_detalle_facturas (
    det_fac_id                NUMBER(4) NOT NULL,
    det_fac_cantidad          NUMBER(4) NOT NULL,
    det_fac_precio_unitario   NUMBER(6, 2) NOT NULL,
    det_fac_subtotal          NUMBER(6, 2) NOT NULL,
    det_fac_iva               NUMBER(5, 2) NOT NULL,
    det_fac_total             NUMBER(8, 2) NOT NULL,
    fac_id                    NUMBER(4) NOT NULL,
    serv_id                   NUMBER(4) NOT NULL
);

COMMENT ON COLUMN sis_med_detalle_facturas.det_fac_id IS
    'Identificador unico del detalle de la factura';

COMMENT ON COLUMN sis_med_detalle_facturas.det_fac_cantidad IS
    'Cantidad de servicios en el detalle de la factura';

COMMENT ON COLUMN sis_med_detalle_facturas.det_fac_precio_unitario IS
    'Precio unitario en el detalle de la factura';

COMMENT ON COLUMN sis_med_detalle_facturas.det_fac_subtotal IS
    'Subtotal en el detalle de la factura';

COMMENT ON COLUMN sis_med_detalle_facturas.det_fac_iva IS
    'Valor del iva en el detalle de la factura';

COMMENT ON COLUMN sis_med_detalle_facturas.det_fac_total IS
    'Total a pagar en el detalle de la factura';

ALTER TABLE sis_med_detalle_facturas ADD CONSTRAINT pk_detalle_facturas PRIMARY KEY ( det_fac_id );

CREATE TABLE sis_med_facturas (
    fac_id                  NUMBER(4) NOT NULL,
    fac_numero              NUMBER(4) NOT NULL,
    fac_fecha_emision       DATE NOT NULL,
    fac_subtotal            NUMBER(6, 2) NOT NULL,
    fac_iva                 NUMBER(5, 2) NOT NULL,
    fac_total               NUMBER(8, 2) NOT NULL,
    usu_id                  NUMBER(4) NOT NULL,
    per_id                  NUMBER(4) NOT NULL
);

COMMENT ON COLUMN sis_med_facturas.fac_id IS
    'Identificador unico de la factura';

COMMENT ON COLUMN sis_med_facturas.fac_numero IS
    'Numero de la factura';

COMMENT ON COLUMN sis_med_facturas.fac_fecha_emision IS
    'Fecha de emision de la factura';

COMMENT ON COLUMN sis_med_facturas.fac_subtotal IS
    'Subtotal a pagar de la factura';

COMMENT ON COLUMN sis_med_facturas.fac_iva IS
    'Valor total del iva en la factura';

COMMENT ON COLUMN sis_med_facturas.fac_total IS
    'Total a pagar de la factura';

ALTER TABLE sis_med_facturas ADD CONSTRAINT pk_facturas PRIMARY KEY ( fac_id );

CREATE TABLE sis_med_personas (
    per_id        NUMBER(4) NOT NULL,
    per_cedula    VARCHAR2(11) NOT NULL,
    per_nombres   VARCHAR2(200) NOT NULL,
    per_apellidos VARCHAR2(200) NOT NULL,
    per_direccion VARCHAR2(300) NOT NULL,
    per_telefono  VARCHAR2(13) NOT NULL,
    per_correo    VARCHAR2(30) NOT NULL,
    per_tipo      CHAR(1) NOT NULL,
    per_empleado  CHAR(1),
    per_estado    CHAR(1) NOT NULL
);

COMMENT ON COLUMN sis_med_personas.per_id IS
    'Identificador unico de la persona';

COMMENT ON COLUMN sis_med_personas.per_cedula IS
    'Cedula de la persona';

COMMENT ON COLUMN sis_med_personas.per_nombres IS
    'Nombres de la persona';

COMMENT ON COLUMN sis_med_personas.per_apellidos IS
    'Apellidos de la persona';

COMMENT ON COLUMN sis_med_personas.per_direccion IS
    'Direccion de la persona';

COMMENT ON COLUMN sis_med_personas.per_telefono IS
    'Telefono de la persona';

COMMENT ON COLUMN sis_med_personas.per_correo IS
    'Correo de la persona';

COMMENT ON COLUMN sis_med_personas.per_tipo IS
    'Tipo de persona. ''P'' para paciente, ''E'' para empleado';

COMMENT ON COLUMN sis_med_personas.per_empleado IS
    'Tipo de persona empleado. ''M'' para medico, ''A'' para atencion al paciente';

COMMENT ON COLUMN sis_med_personas.per_estado IS
    'Estado de vigencia de la persona en el registro. ''S'' para activo, ''N'' para inactivo';

ALTER TABLE sis_med_personas ADD CONSTRAINT pk_personas PRIMARY KEY ( per_id );

ALTER TABLE sis_med_personas ADD CONSTRAINT un_per_cedula UNIQUE ( per_cedula );

ALTER TABLE sis_med_personas ADD CONSTRAINT un_per_correo UNIQUE ( per_correo );

ALTER TABLE sis_med_personas ADD CONSTRAINT un_per_telefono UNIQUE ( per_telefono );

CREATE TABLE sis_med_servicios (
    serv_id        NUMBER(4) NOT NULL,
    serv_codigo    NUMBER(4) NOT NULL,
    serv_nombre    VARCHAR2(100) NOT NULL,
    serv_precio    NUMBER(6, 2) NOT NULL,
    serv_aplicaiva CHAR(1) NOT NULL,
    serv_estado    CHAR(1) NOT NULL
);

COMMENT ON COLUMN sis_med_servicios.serv_id IS
    'Identificador unico del servicio';

COMMENT ON COLUMN sis_med_servicios.serv_codigo IS
    'Codigo del servicio';

COMMENT ON COLUMN sis_med_servicios.serv_nombre IS
    'Nombre del servicio';

COMMENT ON COLUMN sis_med_servicios.serv_precio IS
    'Precio del servicio';

COMMENT ON COLUMN sis_med_servicios.serv_aplicaiva IS
    'Confirmacion del IVA.  ''S'' si aplica, ''N'' si no aplica';

COMMENT ON COLUMN sis_med_servicios.serv_estado IS
    'Estado del servicio.  ''S'' para activo, ''N'' para inactivo';

ALTER TABLE sis_med_servicios ADD CONSTRAINT pk_servicios PRIMARY KEY ( serv_id );

ALTER TABLE sis_med_servicios ADD CONSTRAINT un_serv_codigo UNIQUE ( serv_codigo );

CREATE TABLE sis_med_usuarios (
    usu_id                  NUMBER(4) NOT NULL,
    usu_nombre              VARCHAR2(30) NOT NULL,
    usu_contrasena          VARCHAR2(20) NOT NULL,
    usu_rol                 CHAR(1) NOT NULL,
    usu_estado              CHAR(1) NOT NULL,
    per_id                  NUMBER(4) NOT NULL
);

COMMENT ON COLUMN sis_med_usuarios.usu_id IS
    'Identificador unico del usuario';

COMMENT ON COLUMN sis_med_usuarios.usu_nombre IS
    'Nombre del usuario';

COMMENT ON COLUMN sis_med_usuarios.usu_contrasena IS
    'Contrasena del usuario';

COMMENT ON COLUMN sis_med_usuarios.usu_rol IS
    'Rol del usuario.  ''A'' para administrador, ''G'' para general';

COMMENT ON COLUMN sis_med_usuarios.usu_estado IS
    'Estado del usuario.  ''S'' para activo, ''N'' para inactivo';

ALTER TABLE sis_med_usuarios ADD CONSTRAINT pk_usuarios PRIMARY KEY ( usu_id );

ALTER TABLE sis_med_usuarios ADD CONSTRAINT un_usu_nombre UNIQUE ( usu_nombre );

ALTER TABLE sis_med_citas
    ADD CONSTRAINT fk_citas_medico FOREIGN KEY ( per_id_medico )
        REFERENCES sis_med_personas ( per_id );

ALTER TABLE sis_med_citas
    ADD CONSTRAINT fk_citas_paciente FOREIGN KEY ( per_id_paciente )
        REFERENCES sis_med_personas ( per_id );
 
ALTER TABLE sis_med_citas
    ADD CONSTRAINT fk_citas_usuarios FOREIGN KEY ( usu_id )
        REFERENCES sis_med_usuarios ( usu_id );

ALTER TABLE sis_med_detalle_facturas
    ADD CONSTRAINT fk_detalle_facturas_facturas FOREIGN KEY ( fac_id )
        REFERENCES sis_med_facturas ( fac_id );
 
ALTER TABLE sis_med_detalle_facturas
    ADD CONSTRAINT fk_detalle_facturas_servicios FOREIGN KEY ( serv_id )
        REFERENCES sis_med_servicios ( serv_id );

ALTER TABLE sis_med_facturas
    ADD CONSTRAINT fk_facturas_personas FOREIGN KEY ( per_id )
        REFERENCES sis_med_personas ( per_id );
 
ALTER TABLE sis_med_facturas
    ADD CONSTRAINT fk_facturas_usuarios FOREIGN KEY ( usu_id )
        REFERENCES sis_med_usuarios ( usu_id );

ALTER TABLE sis_med_usuarios
    ADD CONSTRAINT fk_usuarios_personas FOREIGN KEY ( per_id )
        REFERENCES sis_med_personas ( per_id );
        
        
        
ALTER TABLE sis_med_citas
    ADD CONSTRAINT fk_citas_medico FOREIGN KEY ( per_id )
        REFERENCES sis_med_personas ( per_id );

ALTER TABLE sis_med_citas
    ADD CONSTRAINT fk_citas_paciente FOREIGN KEY ( per_id2 )
        REFERENCES sis_med_personas ( per_id );
