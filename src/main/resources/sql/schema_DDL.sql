DROP DATABASE IF EXISTS sql5807139;
CREATE DATABASE IF NOT EXISTS sql5807139;
USE sql5807139;

-- -----------------------------------------------------
-- Table categorias
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categoria (
    idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(100) NULL,
    estado ENUM('NORMAL','DESTACADO','ELIMINADO') DEFAULT 'NORMAL',
    activo BOOLEAN DEFAULT 1
);


-- -----------------------------------------------------
-- Table producto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS producto (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    idCategoria INT NOT NULL,
    precioCompra DECIMAL(10,2) NOT NULL,
    precioVenta DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    estado ENUM('DISPONIBLE','SIN_STOCK','DESCONTINUADO') DEFAULT 'DISPONIBLE',
    activo BOOLEAN DEFAULT 1,
    CONSTRAINT fk_Producto_categoria
        FOREIGN KEY (idCategoria)
        REFERENCES categoria (idCategoria)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);


-- -----------------------------------------------------
-- Table clientes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni CHAR(8) NULL,
    telefono VARCHAR(30) NULL,
    email VARCHAR(150) NULL,
    direccion VARCHAR(100) NULL,
    estado ENUM('ACTIVO','INACTIVO','SUSPENDIDO','DEUDOR') DEFAULT 'ACTIVO',
    activo BOOLEAN DEFAULT 1
);


-- -----------------------------------------------------
-- Table facturas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS factura (
    idFactura INT AUTO_INCREMENT PRIMARY KEY,
    idCliente INT NOT NULL,
    fecha DATE NOT NULL,
    total DECIMAL(10,2) NULL,
    estado ENUM('PENDIENTE','PAGADO','CANCELADO') DEFAULT 'PENDIENTE',
    metodoPago ENUM('EFECTIVO','TARJETA_CREDITO','TARJETA_DEBITO','TRANSFERENCIA','MERCADO_PAGO') DEFAULT 'EFECTIVO',
    CONSTRAINT fk_Factura_Cliente1
        FOREIGN KEY (idCliente)
        REFERENCES cliente (idCliente)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);


-- -----------------------------------------------------
-- Table detalleFacturas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS detalleFactura (
    idProducto INT NOT NULL,
    idFactura INT NOT NULL,
    cantidad INT NOT NULL,
    precioUnitario DECIMAL(10,2) NOT NULL,
    subTotal DECIMAL(10,2) NULL,
    PRIMARY KEY (idProducto, idFactura),
    CONSTRAINT fk_Producto_has_Factura_Producto1
        FOREIGN KEY (idProducto)
        REFERENCES producto (idProducto)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_Producto_has_Factura_Factura1
        FOREIGN KEY (idFactura)
        REFERENCES factura (idFactura)
        ON DELETE CASCADE
        ON UPDATE CASCADE
        );