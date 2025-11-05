DROP DATABASE IF EXISTS sql10803820;
CREATE DATABASE IF NOT EXISTS sql10803820;
USE sql10803820;

-- -----------------------------------------------------
-- Table categorias
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categorias (
idCategorias INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
descripcion VARCHAR(100) NULL,
estado ENUM('NORMAL','DESTACADO','ELIMINADO') DEFAULT 'NORMAL',
activo TINYINT DEFAULT 1
);


-- -----------------------------------------------------
-- Table productos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS productos (
idProductos INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
idCategorias INT NOT NULL,
precioCompra DECIMAL(10,2) NOT NULL,
precioVenta DECIMAL(10,2) NOT NULL,
stock INT NOT NULL DEFAULT 0,
estado ENUM('DISPONIBLE','SIN_STOCK','DESCONTINUADO') DEFAULT 'DISPONIBLE',
activo TINYINT DEFAULT 1,
CONSTRAINT fk_Producto_categoria
    FOREIGN KEY (idCategorias)
    REFERENCES categorias (idCategorias)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);


-- -----------------------------------------------------
-- Table clientes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS clientes (
idCliente INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
apellido VARCHAR(100) NOT NULL,
dni VARCHAR(11) NULL,
telefono VARCHAR(30) NULL,
email VARCHAR(150) NULL,
direccion VARCHAR(100) NULL,
estado ENUM('ACTIVO','INACTIVO','SUSPENDIDO','DEUDOR') DEFAULT 'ACTIVO',
activo TINYINT DEFAULT 1
);


-- -----------------------------------------------------
-- Table facturas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS facturas (
idFactura INT AUTO_INCREMENT PRIMARY KEY,
idCliente INT NOT NULL,
fecha DATE NOT NULL,
total DECIMAL(10,2) NULL,
estado ENUM('PENDIENTE','PAGADO','CANCELADO') DEFAULT 'PENDIENTE',
metodoPago VARCHAR(45) NULL,
CONSTRAINT fk_Factura_Cliente1
    FOREIGN KEY (idCliente)
    REFERENCES clientes (idCliente)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table detalleFacturas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS detalleFacturas (
idProducto INT NOT NULL,
idFactura INT NOT NULL,
cantidad INT NOT NULL,
precioUnitario DECIMAL(10,2) NOT NULL,
subTotal DECIMAL(10,2) NULL,
PRIMARY KEY (idProducto, idFactura),
CONSTRAINT fk_Producto_has_Factura_Producto1
    FOREIGN KEY (idProducto)
    REFERENCES productos (idProductos)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
CONSTRAINT fk_Producto_has_Factura_Factura1
    FOREIGN KEY (idFactura)
    REFERENCES facturas (idFactura)
    ON DELETE CASCADE
    ON UPDATE CASCADE);