-- -----------------------------------------------------
-- JOINS
-- -----------------------------------------------------

-- LISTAR TODAS LAS FACTURAS CON LOS NOMBRES DE LOS CLIENTES
SELECT f.idFactura, c.nombre, c.apellido, f.total, f.fecha, f.estado
FROM facturas f
JOIN clientes c ON f.idCliente = c.idCliente;

-- DETALLE COMPLETO DE UNA FACTURA
SELECT 
    f.idFactura, 
    c.nombre AS Cliente, 
    p.nombre AS Producto, 
    d.cantidad, 
    d.precioUnitario, 
    d.subTotal
FROM detalleFacturas d
JOIN facturas f ON d.idFactura = f.idFactura
JOIN clientes c ON f.idCliente = c.idCliente
JOIN productos p ON d.idProducto = p.idProducto
WHERE f.idFactura = 1;

-- LISTAR PRODUCTOS POR SU CATEGORIA
SELECT 
    p.nombre AS Producto, 
    p.stock, 
    p.precioVenta, 
    c.nombre AS Categoria
FROM productos p
JOIN categoria c ON p.idCategoria = c.idCategoria
ORDER BY c.nombre;

-- -----------------------------------------------------
-- OTRAS CONSULTAS
-- -----------------------------------------------------

-- PRODUCTOS SIN STOCK
SELECT * 
FROM productos 
WHERE stock = 0;

-- TOTAL VENDIDO POR PRODUCTO
SELECT 
    p.nombre, 
    SUM(d.cantidad) AS total_vendido
FROM detalleFacturas d
JOIN producto p ON d.idProducto = p.idProducto
GROUP BY p.idProducto;

-- FACTURACIÓN TOTAL
SELECT 
    SUM(total) AS total_vendido
FROM facturas
WHERE estado = 'PAGADO';

-- -----------------------------------------------------
-- TESTEO DE RESTRICCIONES
-- -----------------------------------------------------

-- INTENTAR ELIMINAR UN CLIENTE QUE TENGA FACTURAS (DEBERÍA FALLAR POR ON DELETE RESTRICT)
-- DELETE FROM clientes WHERE idCliente = 1;

-- ELIMINAR UNA FACTURA
DELETE FROM facturas WHERE idFactura = 2;

-- REVISAR SI LOS DETALLES DE LA FACTURA DESAPARECIERON
SELECT * FROM detalleFacturas WHERE idFactura = 2;

-- MODIFICAR idFactura o idProducto Y VER EL CASCADE
UPDATE facturas SET idFactura = 100 WHERE idFactura = 1;

-- ACTUALIZAR STOCK DESPUÉS DE UNA VENTA
UPDATE productos
SET stock = stock - 3 
WHERE idProducto = 1;