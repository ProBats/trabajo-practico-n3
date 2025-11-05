USE sql10803820;

-- Inserts 
INSERT INTO categorias (nombre, descripcion, estado, activo) VALUES
('Electrónica', 'Productos electrónicos', 'NORMAL', 1),
('Ropa', 'Ropa para adultos', 'DESTACADO', 1),
('Alimentos', 'Productos alimenticios', 'NORMAL', 1);

INSERT INTO productos (nombre, idCategorias, precioCompra, precioVenta, stock, estado, activo) VALUES
('Celular A1', 1, 150.00, 200.00, 10, 'DISPONIBLE', 1),
('Auriculares X', 1, 20.00, 35.00, 50, 'DISPONIBLE', 1),
('Remera Nike', 2, 8.00, 15.00, 100, 'DISPONIBLE', 1),
('Pan Lactal', 3, 1.00, 2.00, 200, 'DISPONIBLE', 1);

INSERT INTO clientes (nombre, apellido, dni, telefono, email, direccion, estado, activo) VALUES
('Juan', 'Perez', '30111222', '1144556677', 'juan@mail.com', 'Calle 1', 'ACTIVO', 1),
('Ana', 'Garcia', '27222444', '1144556688', 'ana@mail.com', 'Calle 2', 'ACTIVO', 1);

INSERT INTO facturas (idCliente, fecha, total, estado, metodoPago) VALUES
(1, '2025-01-01', 235.00, 'PAGADO', 'EFECTIVO'),
(2, '2025-01-02', 17.00, 'PENDIENTE', 'TARJETA');

INSERT INTO detalleFacturas (idProducto, idFactura, cantidad, precioUnitario, subTotal) VALUES
(1, 21, 1, 200.00, 200.00),
(2, 21, 1, 35.00, 35.00),
(3, 22, 1, 15.00, 15.00),
(4, 22, 1, 2.00, 2.00);


-- JOINS
-- LISTAR TODAS LAS FACTURAS CON LOS NOMBRES DE LOS CLIENTES

SELECT f.idFactura, c.nombre, c.apellido, f.total, f.fecha, f.estado
FROM facturas f
JOIN clientes c ON f.idCliente = c.idCliente;

-- DETALLE COMPLETO DE UNA FACTURA

SELECT f.idFactura, c.nombre AS Cliente, p.nombre AS Producto, d.cantidad, d.precioUnitario, d.subTotal
FROM detalleFacturas d
JOIN facturas f ON d.idFactura = f.idFactura
JOIN clientes c ON f.idCliente = c.idCliente
JOIN productos p ON d.idProducto = p.idProductos
WHERE f.idFactura = 1;

-- LISTAR PRODUCTOS POR SU CATEGORIA

SELECT p.nombre AS Producto, p.stock, p.precioVenta, c.nombre AS Categoria
FROM productos p
JOIN categorias c ON p.idCategorias = c.idCategorias;


-- OTRAS CONSULTAS
-- PRODUCTOS SIN STOCK

SELECT * FROM productos WHERE stock = 0;

-- TOTAL VENDIDO POR PRODUCTO

SELECT p.nombre, SUM(d.cantidad) AS total_vendido
FROM detalleFacturas d
JOIN productos p ON d.idProducto = p.idProductos
GROUP BY p.idProductos;

-- FACTURACION TOTAL

SELECT SUM(total) AS total_vendido
FROM facturas
WHERE estado = 'PAGADO';

-- TESTEO DE RESTRICCIONES

-- INTENTAR ELIMINAR UN CLIENTE QUE TENGA FACTURAS (DEBERIA FALLAR POR ON DELETE RESTRICT)

-- DELETE FROM clientes WHERE idCliente = 1;

-- ELIMINAR UNA FACTURA
DELETE FROM facturas WHERE idFactura = 2;

-- REVISAR SI LOS DETALLES DE LA FACTURA DESAPARECIERON

SELECT * FROM detalleFacturas WHERE idFactura = 2;

-- MODIFICAR idFactura o idProducto Y VER  EL CASCADE

UPDATE facturas SET idFactura = 100 WHERE idFactura = 1;


-- ACTUALIZAR STOCK DESPUES DE UNA VENTA

UPDATE productos SET STOCK = STOCK - 3 WHERE idProductos = 1;