INSERT INTO RESTAURANTES (id, nombre, ubicacion) VALUES
	(1,'Colecta main Restaurant','cra 4 # 16-15'),
	(2,'Cafeteria publica Exito','cra 14 calle 53'),
	(3,'Albergue sur Bogotá','Carrera 10 #1 - 59 Sur'),
	(4,'Cafeteria parque Simón Bolivar', 'Av. Calle 53 y Av. Esmeralda');
	
INSERT INTO RECETAS (id, nombre, precio, imagen) VALUES
	(1,'Sandwich',2500,'http://localhost:3000/images/Sandwich.jpg'),
	(2,'Tacos mexicanos', 6000, 'http://localhost:3000/images/Tacos mexicanos.jpg'),
	(3,'Bebidas', 2000, 'http://localhost:3000/images/Bebidas.jpg'),
	(4,'Hamburguesa', 5000, 'http://localhost:3000/images/Hamburguesa.jpg'),
	(5,'Perro Caliente', 5000, 'http://localhost:3000/images/Perro Caliente.jpg'),
	(6,'Pizza', 3000, 'http://localhost:3000/images/Pizza.jpg'),
	(7,'Nuggets de Pollo', 10000, 'http://localhost:3000/images/Nuggets de Pollo.jpg'),
	(8,'Papas Fritas', 3500, 'http://localhost:3000/images/Papas Fritas.jpg'),
	(9,'Café', 1500, 'http://localhost:3000/images/Café.jpg'),
	(10,'Donas', 3500, 'http://localhost:3000/images/Donas.jpg');
	
INSERT INTO PRODUCTOS (id, cantidad, receta_id, restaurante_id) VALUES
	--Sandwiches
	(1, 8, 1, 1),
	(2, 7, 1, 2),
	(3, 15, 1, 3),
	--Tacos
	(4, 3, 2, 1),
	(5, 3, 2, 2),
	(6, 2, 2, 3),
	(7, 2, 2, 4),
	--Bebidas
	(8, 14, 3, 1),
	(9, 1, 3, 2),
	(10, 25, 3, 3),
	--Hamburguesa
	(11, 3, 4, 1),
	(12, 6, 4, 2),
	(13, 16, 4, 3),
	--Perro
	(14, 25, 5, 1),
	(15, 14, 5, 2),
	(16, 19, 5, 3),
	--Pizza
	(17, 5, 6, 1),
	(18, 6, 6, 2),
	(19, 13, 6, 3),
	--Nuggets
	(20, 18, 7, 1),
	(21, 11, 7, 2),
	(22, 16, 7, 3),
	--Papas
	(23, 13, 8, 1),
	(24, 20, 8, 2),
	(25, 27, 8, 2),
	--Café
	(26, 9, 9, 1),
	(27, 27, 9, 2),
	(28, 19, 9, 3),
	--Donas
	(29, 26, 10, 1),
	(30, 29, 10, 2),
	(31, 11, 10, 3);

INSERT INTO RECETAS_PRODUCTOS (receta_id, productos_id) VALUES
	--Sandwiches
	(1,1),
	(1,2),
	(1,3),
	--Tacos
	(2,4),
	(2,5),
	(2,6),
	(2,7),
	--Bebidas
	(3,8),
	(3,9),
	(3,10),
	--Hamburguesa
	(4,11),
	(4,12),
	(4,13),
	--Perro
	(5,14),
	(5,15),
	(5,16),
	--Pizza
	(6,17),
	(6,18),
	(6,19),
	--Nuggets
	(7,20),
	(7,21),
	(7,22),
	--Papas
	(8,23),
	(8,24),
	(8,25),
	--Café
	(9,26),
	(9,27),
	(9,28),
	--Donas
	(10,29),
	(10,30),
	(10,31);

	
INSERT INTO RESTAURANTES_PRODUCTOS (restaurante_id, productos_id) VALUES
	--Sandwiches
	(1,1),
	(2,2),
	(3,3),
	--Tacos
	(1,4),
	(2,5),
	(3,6),
	(4,7),
	--Bebidas
	(1,8),
	(2,9),
	(3,10),
	--Hamburguesa
	(1,11),
	(2,12),
	(3,13),
	--Perro
	(1,14),
	(2,15),
	(3,16),
	--Pizza
	(1,17),
	(2,18),
	(3,19),
	--Nuggets
	(1,20),
	(2,21),
	(3,22),
	--Papas
	(1,23),
	(2,24),
	(3,25),
	--Café
	(1,26),
	(2,27),
	(3,28),
	--Donas
	(1,29),
	(2,30),
	(3,31);