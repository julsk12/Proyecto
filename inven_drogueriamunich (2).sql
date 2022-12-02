-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-12-2022 a las 01:06:55
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inven_drogueriamunich`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar` (IN `id` INT(11), IN `nom` VARCHAR(250), IN `pre` DOUBLE, IN `prexc` DOUBLE, IN `can` INT(11), IN `fven` DATE, IN `lot` VARCHAR(250))  UPDATE inven_drogueriamunich.productos
SET nombre = nom,precioxund= pre, precioxcaja= prexc, cantidad =  can, fecha_vencimiento =  fven, lote =lot
WHERE id_pro = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Actualizarinven` (IN `cant` INT(11), IN `id` INT(11))  UPDATE productos 
SET productos.cantidad = (productos.cantidad - cant)
WHERE productos.id_pro = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addDetaProd` (IN `precom` DOUBLE, IN `canpro` INT(11), IN `idprod` INT(11), IN `idprov` INT(11))  INSERT INTO deta_prod (precio_compraxprod, cantidad_prod, id_pro, id_proveedor) VALUES (precom, canpro, idprod, idprov)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addDetaVen` (IN `fven` DATE, IN `toven` DOUBLE, IN `canpro` INT(11), IN `idv` INT(11), IN `idpv` INT(11))  INSERT INTO deta_ventas (fecha_venta, total_venta, cantidad_productos, id_ventas, id_pro) VALUES (fven, toven, canpro, idv, idpv)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addproducto` (IN `id` INT(11), IN `nom` VARCHAR(200), IN `pre` DOUBLE, IN `prexc` DOUBLE, IN `can` INT(11), IN `fven` DATE, IN `lot` VARCHAR(200))  INSERT INTO productos(id_pro, nombre, precioxund, precioxcaja, cantidad, fecha_vencimiento, lote)VALUES(id, nom, pre, prexc, can,  fven,  lot)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addproveedor` (IN `nom` VARCHAR(200), IN `num` INT(11), IN `dir` VARCHAR(250))  INSERT INTO proveedores(nombre, numero, direccion)VALUES(nom, num, dir)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addventas` (IN `idv` INT(11), IN `totalventa` INT(11), IN `totalprov` INT(11))  INSERT INTO ventas(id_ventas, Total_vendido, totalprod_vendidios)VALUES(idv, totalventa, totalprov)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `allstock` ()  SELECT productos.id_pro, productos.nombre AS Producto, productos.precioxund, deta_ventas.total_venta, deta_ventas.fecha_venta FROM productos
INNER JOIN deta_ventas
ON productos.id_pro = deta_ventas.id_pro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarproducto` (IN `id` INT)  SELECT * FROM productos
WHERE id = id_pro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarproveedor` (IN `id` INT(11))  SELECT * FROM proveedores
WHERE id = id_proveedor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarventa` (IN `id` INT)  SELECT * FROM ventas
WHERE id = id_ventas$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDetaProd` (IN `idp` INT(11))  DELETE FROM deta_prod
WHERE id_deta_prod = (SELECT id_deta_prod FROM deta_prod
                      WHERE deta_prod.id_pro = idp)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteproducto` (IN `id` INT(11))  DELETE FROM productos 
WHERE id = id_pro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteproveedor` (IN `id` INT)  DELETE FROM proveedores
WHERE id = id_proveedor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteventas` (IN `id` INT)  DELETE FROM ventas
WHERE id = id_ventas$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Masvendidos` ()  SELECT DISTINCT productos.id_pro, productos.nombre, SUM(deta_ventas.cantidad_productos) AS Totalvendidos, SUM(deta_ventas.total_venta) AS ganancias, deta_ventas.fecha_venta FROM productos INNER JOIN deta_ventas ON productos.id_pro = deta_ventas.id_pro GROUP BY productos.id_pro ORDER BY Totalvendidos DESC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modDetaprod` (IN `com` DOUBLE, IN `canpro` INT(11), IN `idprod` INT(11))  UPDATE deta_prod
SET precio_compraxprod = com, cantidad_prod = canpro
WHERE id_pro = idprod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modproducto` (IN `id` INT(11), IN `nom` VARCHAR(200), IN `pre` DOUBLE, IN `prexc` DOUBLE, IN `can` INT(11), IN `fven` DATE, IN `lot` VARCHAR(200))  UPDATE productos
SET nombre = nom,precioxund= pre, precioxcaja= prexc, cantidad =  can, fecha_vencimiento =  fven, lote =lot
WHERE id_pro = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modprov` (IN `nom` VARCHAR(200), IN `num` INT(11), IN `dir` VARCHAR(200), IN `id` INT(11))  UPDATE proveedores
SET nombre = nom, numero = num, direccion = dir
WHERE id_proveedor = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modventa` (IN `id` INT(11), IN `totalventa` INT(11), IN `totalprov` INT(11))  UPDATE ventas
SET Total_vendido = totalventa, totalprod_vendidios	= totalprov
WHERE id = id_ventas$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarprod` ()  SELECT * FROM inven_drogueriamunich.productos$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarprov` ()  SELECT * FROM proveedores$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarventa` ()  SELECT id_ventas, productos.nombre, cantidad_productos, total_venta, fecha_venta FROM deta_ventas 
INNER JOIN productos ON deta_ventas.id_pro=productos.id_pro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `prodagotandose` ()  SELECT deta_prod.id_pro, productos.nombre AS Producto, deta_prod.cantidad_prod, productos.precioxcaja, proveedores.nombre AS Proveedor FROM deta_prod
INNER JOIN productos
ON deta_prod.id_pro = productos.id_pro
INNER JOIN proveedores
ON proveedores.id_proveedor = deta_prod.id_proveedor
WHERE cantidad_prod <= 10$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `prodVenci` ()  SELECT deta_prod.id_pro, productos.nombre AS Producto, deta_prod.cantidad_prod, productos.precioxund, productos.fecha_vencimiento FROM deta_prod INNER JOIN productos ON deta_prod.id_pro = productos.id_pro WHERE fecha_vencimiento <= LOCALTIMESTAMP$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `verificarusuario` (IN `users` VARCHAR(200), IN `contra` VARCHAR(200))  SELECT * FROM login
WHERE usuario = users AND contrasena = contra$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deta_prod`
--

CREATE TABLE `deta_prod` (
  `id_deta_prod` int(11) NOT NULL,
  `precio_compraxprod` double NOT NULL,
  `cantidad_prod` int(11) NOT NULL,
  `id_pro` int(11) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `deta_prod`
--

INSERT INTO `deta_prod` (`id_deta_prod`, `precio_compraxprod`, `cantidad_prod`, `id_pro`, `id_proveedor`) VALUES
(1, 49000, 10, 267, 9),
(2, 40000, 40, 234, 4),
(4, 30000, 6, 4564, 7),
(7, 43000, 19, 456, 7),
(8, 45060, 26, 567, 8),
(11, 30000, 10, 908, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deta_ventas`
--

CREATE TABLE `deta_ventas` (
  `id_deta` int(11) NOT NULL,
  `fecha_venta` date NOT NULL,
  `total_venta` double NOT NULL,
  `cantidad_productos` int(11) NOT NULL,
  `id_ventas` int(11) DEFAULT NULL,
  `id_pro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `deta_ventas`
--

INSERT INTO `deta_ventas` (`id_deta`, `fecha_venta`, `total_venta`, `cantidad_productos`, `id_ventas`, `id_pro`) VALUES
(4, '2022-11-28', 6000, 6, 123, 456),
(5, '2022-11-25', 7200, 6, 456, 567),
(6, '2022-11-25', 7200, 6, 789, 567),
(7, '2022-09-20', 10000, 10, 1011, 456),
(8, '2020-09-20', 2000, 2, 989, 456),
(9, '2020-05-12', 8400, 7, 8909, 567),
(10, '2020-09-12', 1200, 3, 7890, 234),
(11, '2022-12-01', 7000, 5, 2345, 267),
(12, '2022-12-01', 7000, 5, 9002, 267),
(13, '2022-12-01', 7000, 5, 9023, 267),
(14, '2022-12-01', 7000, 5, 4567, 267),
(15, '2022-12-01', 4000, 6, 97678, 4564);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id_usu` int(11) NOT NULL,
  `usuario` varchar(250) NOT NULL,
  `contrasena` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id_usu`, `usuario`, `contrasena`) VALUES
(1, 'admin', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_pro` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `precioxund` double NOT NULL,
  `precioxcaja` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `lote` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_pro`, `nombre`, `precioxund`, `precioxcaja`, `cantidad`, `fecha_vencimiento`, `lote`) VALUES
(234, 'Dolex', 500, 40000, 40, '2023-12-11', 'ASAJSJJA'),
(267, 'Lumbal', 1400, 49000, 10, '2023-09-20', 'GDSDE'),
(456, 'Acetaminofen', 1000, 43000, 19, '2023-09-20', 'AJJAJAJA'),
(567, 'Buscapina', 1200, 45060, 26, '2023-08-30', 'ASDEF'),
(908, 'iosina', 2000, 30000, 10, '2022-12-01', 'JJJHHHH'),
(4564, 'Asawin', 300, 30000, 6, '2022-11-27', 'ASDew4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `numero` int(11) NOT NULL,
  `direccion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id_proveedor`, `nombre`, `numero`, `direccion`) VALUES
(4, 'Manolo', 3546798, 'cra12n45b'),
(7, 'rosa', 7574774, 'calle 20c'),
(8, 'Ale', 736457, '563452'),
(9, 'Ross', 364772, 'Carrevdb'),
(10, 'desss', 55667899, 'Cdrtyky'),
(11, 'Isacc', 345678, 'Junto a fredogodofredo'),
(12, 'Gonuvv', 5678899, 'Cllgrduv'),
(14, 'ddffg', 3456789, 'calle1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_ventas` int(11) NOT NULL,
  `Total_vendido` int(11) NOT NULL,
  `totalprod_vendidios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_ventas`, `Total_vendido`, `totalprod_vendidios`) VALUES
(123, 6000, 6),
(456, 7200, 6),
(789, 7200, 6),
(989, 2000, 2),
(1011, 10000, 10),
(2345, 7000, 5),
(4567, 7000, 5),
(7890, 1200, 3),
(8909, 8400, 7),
(9002, 7000, 5),
(9023, 7000, 5),
(97678, 4000, 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `deta_prod`
--
ALTER TABLE `deta_prod`
  ADD PRIMARY KEY (`id_deta_prod`),
  ADD KEY `fk_p_d_p` (`id_pro`),
  ADD KEY `fk_pv_d_p` (`id_proveedor`);

--
-- Indices de la tabla `deta_ventas`
--
ALTER TABLE `deta_ventas`
  ADD PRIMARY KEY (`id_deta`),
  ADD KEY `fk_v_d_v` (`id_ventas`),
  ADD KEY `fk_p_d_v` (`id_pro`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_usu`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_pro`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_ventas`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `deta_prod`
--
ALTER TABLE `deta_prod`
  MODIFY `id_deta_prod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `deta_ventas`
--
ALTER TABLE `deta_ventas`
  MODIFY `id_deta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id_usu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `deta_prod`
--
ALTER TABLE `deta_prod`
  ADD CONSTRAINT `fk_p_d_p` FOREIGN KEY (`id_pro`) REFERENCES `productos` (`id_pro`),
  ADD CONSTRAINT `fk_pv_d_p` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`);

--
-- Filtros para la tabla `deta_ventas`
--
ALTER TABLE `deta_ventas`
  ADD CONSTRAINT `fk_p_d_v` FOREIGN KEY (`id_pro`) REFERENCES `productos` (`id_pro`),
  ADD CONSTRAINT `fk_v_d_v` FOREIGN KEY (`id_ventas`) REFERENCES `ventas` (`id_ventas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
