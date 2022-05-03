-- HUGO ES UN MARIKA
DROP DATABASE IF EXISTS TPV;
CREATE DATABASE TPV CHARACTER SET utf8mb4;
USE TPV;

CREATE TABLE USUARIOS (
    dni CHAR(9) NOT NULL PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(60) NOT NULL,
    login VARCHAR(30) DEFAULT 'New User',
    pass VARCHAR(16) NOT NULL, -- Contraseña da error x la ñ
    correo VARCHAR(200) NOT NULL,
    rutaimg TEXT NULL
);

CREATE TABLE CLIENTES (
    dni CHAR(9) NOT NULL PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(60) NOT NULL,
	pass VARCHAR(16) NOT NULL, -- Contraseña da error x la ñ
    correo VARCHAR(200) NOT NULL,
    rutaimg TEXT NULL
);

CREATE TABLE PEDIDOS (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Si no se aplica fecha en el codigo se aplicara automaticamente la actual en ese momento. (probado) :3
    formaPago VARCHAR(100) NOT NULL,
    estadoPago BOOLEAN NULL DEFAULT false,
    cliente CHAR(9) NOT NULL,
    FOREIGN KEY (cliente) REFERENCES CLIENTES(dni)
    ON DELETE RESTRICT ON UPDATE CASCADE -- Informacion sobre RESTRICT "https://stackoverflow.com/questions/6720050/foreign-key-constraints-when-to-use-on-update-and-on-delete"
);

CREATE TABLE FAMILIAS (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
    notas TEXT NULL
);

CREATE TABLE ARTICULOS (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT NULL,
    marca VARCHAR(300) NULL,
    PVP decimal(6, 2) DEFAULT 0,
    stock int DEFAULT 0, -- Por si no lo especifican pero tienen un programa para q vaya incrementando el stock segun lleguen y no de error por ser "NULL"
    familia int NULL,
    rutaimg TEXT NULL,
    FOREIGN KEY (familia) REFERENCES FAMILIAS(id)
    ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE OFERTAS (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) DEFAULT 'Tu Descuento',
    descripcion TEXT NULL,
    fechaIni TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fechaFin date NOT NULL,
    VIP BOOLEAN DEFAULT false -- Requiere estar registrado o no (Por defecto no)
);

CREATE TABLE CONTIENE (
	articulosId int NOT NULL,
    pedidosId int NOT NULL,
    cantidad int DEFAULT 1,
    precio decimal(6, 2) DEFAULT 0,
    PRIMARY KEY (articulosId, pedidosId),
    FOREIGN KEY (articulosId) REFERENCES ARTICULOS(id)
    ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (pedidosId) REFERENCES PEDIDOS(id)
    ON DELETE RESTRICT ON UPDATE CASCADE -- Restrict evita que se borre un pedido si esta usandose aqui
);

CREATE TABLE APLICAN (
	ofertasId int NOT NULL,
    articulosId int NOT NULL,
    descuento int DEFAULT 0, -- Yo no entiendo si es % o como multiplicar * 1 Ej(20% de 100€ o 0.8 * 100) yo en lo personal prefiero la multiplicacion ya q es mas directa pero como qrais
    cantidad int DEFAULT 0, -- Cantidad minima a comparar para aplicar
    FOREIGN KEY (ofertasId) REFERENCES OFERTAS(id)
    ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (articulosId) REFERENCES ARTICULOS(id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

/*
-- Tabla llegadas por si la queremos implementar al final
CREATE TABLE LLEGADAS (
	ARTICULOS_ID int NOT NULL PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_llegada date NULL,
    precio decimal(6, 2) DEFAULT 0,
    cantidad int DEFAULT 1;
    estado BOOLEAN DEFAULT false,
    FOREIGN KEY (ARTICULOS_ID) REFERENCES ARTICULOS(id)
    ON DELETE SET NULL ON UPDATE CASCADE 
);
*/
