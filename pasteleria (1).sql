-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 28-05-2024 a las 18:47:54
-- Versión del servidor: 8.0.17
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pasteleria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Id` int(11) NOT NULL,
  `Persona` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Id`, `Persona`) VALUES
(1, 5),
(2, 7),
(3, 9),
(4, 12),
(5, 20),
(6, 22),
(7, 24),
(8, 25),
(9, 27),
(10, 28),
(11, 32),
(12, 34),
(13, 37);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `Id` int(11) NOT NULL,
  `Persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`Id`, `Persona`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 6),
(6, 8),
(7, 10),
(8, 11),
(9, 14),
(10, 15),
(11, 17),
(12, 21),
(13, 26),
(14, 31),
(15, 38);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE `materiales` (
  `Id` int(11) NOT NULL,
  `precio` float DEFAULT NULL,
  `Cantidad` int(11) NOT NULL,
  `Nombre` varchar(20) DEFAULT NULL,
  `Proveedores` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`Id`, `precio`, `Cantidad`, `Nombre`, `Proveedores`) VALUES
(2, 11, 10, 'Lechera', 1),
(4, 25.5, 2, 'Harina', 2),
(5, 36, 5, 'Carnation 100gr', 1),
(6, 23, 20, 'Azúcar', 3),
(7, 56.5, 8, 'Condensada 200g', 4),
(8, 93, 2, 'Chocolate 500g', 3),
(9, 105.5, 85, 'Condensada1kg', 4),
(10, 52, 1, 'Harina de trigo', 3),
(11, 12, 56, 'Corina100gr', 8),
(12, 12.5, 10, 'Lechera10gr', 9),
(13, 12, 20, 'Condensada 120gr', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `Id` int(11) NOT NULL,
  `Tipo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`Id`, `Tipo`) VALUES
(1, 'Efectivo'),
(2, 'Transferencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(20) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `pago` int(11) DEFAULT NULL,
  `cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`Id`, `Nombre`, `usuario`, `pago`, `cliente`) VALUES
(1, 'Pepitas', 10, 2, 2),
(2, 'Azulito', 10, 2, 4),
(3, 'Rositas', 11, 1, 3),
(4, 'Cumpleaños', 10, 1, 4),
(5, 'Funeral', 9, 1, 2),
(6, 'Tardado', 9, 1, 5),
(7, 'Festejo', 10, 1, 3),
(8, 'Oscarin', 1, 1, 8),
(9, 'Tripleu', 1, 1, 7),
(10, 'Osiris', 12, 1, 5),
(11, 'Frida', 1, 1, 1),
(12, 'Frire', 12, 1, 3),
(13, '', 1, 1, 1),
(14, 'Chubasco', 10, 1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidopostres`
--

CREATE TABLE `pedidopostres` (
  `Id` int(11) NOT NULL,
  `Pedido` int(11) DEFAULT NULL,
  `Postres` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `pedidopostres`
--

INSERT INTO `pedidopostres` (`Id`, `Pedido`, `Postres`) VALUES
(1, 3, 9),
(2, 4, 9),
(3, 5, 7),
(4, 6, 10),
(5, 7, 12),
(6, 8, 8),
(7, 9, 9),
(8, 10, 12),
(9, 11, 1),
(10, 12, 11),
(11, 13, 1),
(12, 14, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `Id` int(11) NOT NULL,
  `Nombres` varchar(20) NOT NULL,
  `ApePat` varchar(20) NOT NULL,
  `ApeMat` varchar(20) NOT NULL,
  `FechaDeNacimiento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`Id`, `Nombres`, `ApePat`, `ApeMat`, `FechaDeNacimiento`) VALUES
(1, 'Alejandro', 'Perez', 'Martinez', '2000-01-22'),
(2, 'Daniel', 'Rocha', 'Morelos', '1998-05-14'),
(3, 'Pedro ', 'Rodriguez', 'Alvarez', '1996-01-25'),
(4, 'Diego', 'Romo', 'Vazquez', '2001-02-18'),
(5, 'Mauricio ', 'Ramirez', 'Cerda', '1997-03-20'),
(6, 'Alfredo', 'Jimenez', 'Ordáz', '2001-01-23'),
(7, 'Alan', 'Ruiz', 'Diaz', '2000-02-28'),
(8, 'Emilio', 'Loy', 'Barrón', '2004-05-05'),
(9, 'Eric', 'Ascencio', 'Arriaga', '2001-02-23'),
(10, 'Diego', 'Rodrigez', 'Alatorre', '2001-02-12'),
(11, 'Francisco', 'López', 'Arriaga', '1999-02-15'),
(12, 'Juan', 'Reyes', 'León', '2001-02-26'),
(13, 'Alonso', 'Herrera', 'Alameda', '1991-03-28'),
(14, 'Alfredo', 'Fernandez', 'Rocha', '1998-01-23'),
(15, 'Francisco Javier', 'López', 'Arriaga', '2004-01-05'),
(16, 'Felipe Salvador', 'Fernández', 'Gómez', '1989-01-05'),
(17, 'Héctor', 'Sepúlveda', 'Gómez', '2001-08-26'),
(18, 'Benjamín', 'Hurtado', 'Ruíz', '1996-02-25'),
(19, 'Leonel Federico', 'Mendez', 'Pérez', '1995-06-21'),
(20, 'Hugo Fernando', 'Olmos', 'Olvera', '1997-02-13'),
(21, 'Zuridiana Sulem', 'Fuentes', '', '2001-05-01'),
(22, 'Froylan Jesús', 'Acevedo', 'Tejeda', '0205-05-02'),
(23, 'Armando', 'Paredes', 'Solís', '1996-02-25'),
(24, 'Ernesto Emilio', 'Loy', 'Barrón', '2004-05-05'),
(25, 'Frausto', 'Rodriguez', 'Olivares', '1998-02-03'),
(26, 'Alondra', 'Jimenez', 'Salazar', '1998-02-05'),
(27, 'Jonathan', 'Tabarez', 'Mares', '1997-02-05'),
(28, 'Everardo', 'Enriquez', 'Melendres', '1995-02-03'),
(29, 'Israel', 'Alatorre', 'Dominguez', '1996-02-26'),
(30, 'Gustavo Alfredo', 'Cerati', 'Torres', '1993-01-29'),
(31, 'Raimundo', 'Guzmán', 'Puerto', '1991-01-28'),
(32, 'Ricardo', 'Melendrez', 'Falcón', '2001-02-05'),
(33, 'Hurado', 'Gomez', 'Perez', '1997-02-25'),
(34, 'Luis', 'Alonso', 'Aguayo', '1995-11-25'),
(35, 'Diego', 'Solis', 'Perez', '1995-02-01'),
(36, 'Román', 'Serratos', 'Limón', '1992-02-01'),
(37, 'julio', 'Cepeda', 'Cerda', '1998-01-03'),
(38, 'Federico', 'Villalobos', 'Fernández', '1995-01-05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `postres`
--

CREATE TABLE `postres` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Precio` float DEFAULT NULL,
  `Inventario` int(11) DEFAULT NULL,
  `Materiales` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `postres`
--

INSERT INTO `postres` (`Id`, `Nombre`, `Precio`, `Inventario`, `Materiales`) VALUES
(1, 'Pay de queso', 13.5, 12, NULL),
(7, 'Galletas de avena', 23.5, 15, NULL),
(8, 'Pay de fresa', 15, 10, NULL),
(9, 'Pastel tres leches', 23, 12, NULL),
(10, 'Galletas mantequilla', 23.5, 12, NULL),
(11, 'Pan de elote', 17, 14, NULL),
(12, 'Pan de arroz', 16, 10, NULL),
(13, 'Pay de queso', 26.5, 12, NULL),
(14, 'Empanada de vainilla', 23, 14, NULL),
(15, 'Pay de limón', 23.5, 12, NULL),
(16, 'Pay de vainilla', 12.5, 10, NULL),
(17, 'Galletas de chocolate', 12.5, 10, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `Id` int(11) NOT NULL,
  `Distribuidora` varchar(20) DEFAULT NULL,
  `Persona` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`Id`, `Distribuidora`, `Persona`) VALUES
(1, 'Merza', 13),
(2, 'Salber', 16),
(3, 'Arandense', 18),
(4, 'Los altos', 19),
(5, 'Lobos', 23),
(6, 'Coronado', 29),
(7, 'Froebel', 30),
(8, 'Pablito', 33),
(9, 'Aurrera', 35),
(10, 'Sosa', 36);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Descripcion` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`Id`, `Nombre`, `Descripcion`) VALUES
(1, 'Administrador', 'Acceso unico autoriz'),
(2, 'Empleado', 'Acceso restringido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(20) DEFAULT NULL,
  `Contrasena` int(11) DEFAULT NULL,
  `rol` int(11) DEFAULT NULL,
  `empleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Id`, `Nombre`, `Contrasena`, `rol`, `empleado`) VALUES
(1, 'Admin', 2901, 1, NULL),
(9, 'Fred', 1234, 2, 9),
(10, 'Fran', 1111, 2, 10),
(11, 'Hector', 7894, 2, 11),
(12, 'Zuri', 4567, 2, 12),
(13, 'Alo', 5656, 2, 13),
(14, 'Rai', 1245, 2, 14);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Persona` (`Persona`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Person` (`Persona`);

--
-- Indices de la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `proveedores` (`Proveedores`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `usuario` (`usuario`),
  ADD KEY `pago` (`pago`),
  ADD KEY `cliente` (`cliente`);

--
-- Indices de la tabla `pedidopostres`
--
ALTER TABLE `pedidopostres`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Pedido` (`Pedido`),
  ADD KEY `Postres` (`Postres`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `postres`
--
ALTER TABLE `postres`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `materailes` (`Materiales`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Persone` (`Persona`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `rol` (`rol`),
  ADD KEY `bei` (`empleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `materiales`
--
ALTER TABLE `materiales`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `pedidopostres`
--
ALTER TABLE `pedidopostres`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `postres`
--
ALTER TABLE `postres`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `Persona` FOREIGN KEY (`Persona`) REFERENCES `persona` (`Id`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `Person` FOREIGN KEY (`Persona`) REFERENCES `persona` (`Id`);

--
-- Filtros para la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD CONSTRAINT `proveedores` FOREIGN KEY (`Proveedores`) REFERENCES `proveedores` (`Id`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `cliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`Id`),
  ADD CONSTRAINT `pago` FOREIGN KEY (`pago`) REFERENCES `pago` (`Id`),
  ADD CONSTRAINT `usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`Id`);

--
-- Filtros para la tabla `pedidopostres`
--
ALTER TABLE `pedidopostres`
  ADD CONSTRAINT `Pedido` FOREIGN KEY (`Pedido`) REFERENCES `pedido` (`Id`),
  ADD CONSTRAINT `Postres` FOREIGN KEY (`Postres`) REFERENCES `postres` (`Id`);

--
-- Filtros para la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD CONSTRAINT `Persone` FOREIGN KEY (`Persona`) REFERENCES `persona` (`Id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `bei` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`Id`),
  ADD CONSTRAINT `rol` FOREIGN KEY (`rol`) REFERENCES `rol` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
