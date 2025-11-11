
INSERT INTO categoria (nombre, descripcion, estado, activo) VALUES
('Electrónica', 'Productos tecnológicos y gadgets', 'NORMAL', 1),
('Ropa', 'Vestimenta para todas las edades', 'DESTACADO', 1),
('Hogar', 'Artículos para el hogar y cocina', 'NORMAL', 1),
('Juguetes', 'Juguetes para niños de todas las edades', 'NORMAL', 1),
('Deportes', 'Equipos y accesorios deportivos', 'NORMAL', 1),
('Belleza', 'Cosméticos y productos de cuidado personal', 'DESTACADO', 1),
('Librería', 'Artículos de papelería y libros', 'NORMAL', 1),
('Mascotas', 'Productos para animales domésticos', 'NORMAL', 1),
('Automotriz', 'Accesorios y repuestos para autos', 'NORMAL', 1),
('Jardinería', 'Herramientas y accesorios para el jardín', 'NORMAL', 1);


INSERT INTO producto (nombre, idCategoria, precioCompra, precioVenta, stock, estado, activo) VALUES
('Smartphone X10', 1, 250.00, 399.99, 50, 'DISPONIBLE', 1),
('Televisor 50”', 1, 400.00, 599.99, 30, 'DISPONIBLE', 1),
('Pantalón Jeans', 2, 20.00, 45.00, 80, 'DISPONIBLE', 1),
('Camiseta Deportiva', 2, 10.00, 25.00, 100, 'DISPONIBLE', 1),
('Batidora 500W', 3, 35.00, 60.00, 40, 'DISPONIBLE', 1),
('Pelota de Fútbol', 5, 15.00, 30.00, 60, 'DISPONIBLE', 1),
('Perfume Floral', 6, 25.00, 50.00, 25, 'DISPONIBLE', 1),
('Libro “El Principito”', 7, 5.00, 12.00, 70, 'DISPONIBLE', 1),
('Collar para Perro', 8, 3.00, 8.00, 120, 'DISPONIBLE', 1),
('Aceite para Motor', 9, 10.00, 20.00, 40, 'DISPONIBLE', 1);


INSERT INTO cliente (nombre, apellido, dni, telefono, email, direccion, estado, activo) VALUES
('Juan', 'Pérez', '12345678', '1122334455', 'juanp@gmail.com', 'Av. Siempre Viva 123', 'ACTIVO', 1),
('María', 'Gómez', '23456789', '1144556677', 'mariag@gmail.com', 'Calle Luna 45', 'ACTIVO', 1),
('Carlos', 'Ramírez', '34567890', '1133221100', 'carlosr@hotmail.com', 'Calle Sol 89', 'ACTIVO', 1),
('Laura', 'Fernández', '45678901', '1199887766', 'lauraf@yahoo.com', 'Av. Mitre 150', 'DEUDOR', 1),
('Andrés', 'López', '56789012', '1177445599', 'andresl@gmail.com', 'Av. San Martín 400', 'ACTIVO', 1),
('Lucía', 'Martínez', '67890123', '1166332211', 'luciam@gmail.com', 'Calle Río Negro 12', 'SUSPENDIDO', 1),
('Diego', 'Santos', '78901234', '1155667788', 'diegos@gmail.com', 'Calle Rivadavia 980', 'ACTIVO', 1),
('Camila', 'Torres', '89012345', '1144778899', 'camilat@gmail.com', 'Av. Belgrano 350', 'ACTIVO', 1),
('Marta', 'Suárez', '90123456', '1133557799', 'martas@hotmail.com', 'Calle Liniers 270', 'INACTIVO', 1),
('Pedro', 'Méndez', '01234567', '1122446688', 'pedrom@gmail.com', 'Calle Rosales 15', 'ACTIVO', 1);


INSERT INTO factura (idCliente, fecha, total, estado, metodoPago) VALUES
(1, '2025-11-01', 250.00, 'PAGADO', 'EFECTIVO'),
(2, '2025-11-02', 480.00, 'PAGADO', 'TARJETA_CREDITO'),
(3, '2025-11-03', 120.00, 'PENDIENTE', 'EFECTIVO'),
(4, '2025-11-04', 300.00, 'PAGADO', 'TRANSFERENCIA'),
(5, '2025-11-05', 90.00, 'CANCELADO', 'MERCADO_PAGO'),
(6, '2025-11-06', 600.00, 'PENDIENTE', 'EFECTIVO'),
(7, '2025-11-07', 75.00, 'PAGADO', 'TARJETA_DEBITO'),
(8, '2025-11-08', 150.00, 'PENDIENTE', 'EFECTIVO'),
(9, '2025-11-09', 200.00, 'PAGADO', 'TARJETA_CREDITO'),
(10, '2025-11-10', 180.00, 'PENDIENTE', 'EFECTIVO');


INSERT INTO detalleFactura (idProducto, idFactura, cantidad, precioUnitario, subTotal) VALUES
(1, 1, 1, 399.99, 399.99),
(3, 1, 2, 45.00, 90.00),
(2, 2, 1, 599.99, 599.99),
(5, 3, 2, 60.00, 120.00),
(6, 4, 3, 30.00, 90.00),
(7, 5, 1, 50.00, 50.00),
(8, 6, 5, 12.00, 60.00),
(9, 7, 4, 8.00, 32.00),
(10, 8, 2, 20.00, 40.00),
(4, 9, 3, 25.00, 75.00);