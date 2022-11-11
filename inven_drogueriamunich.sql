-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-11-2022 a las 05:28:00
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deta_prod`
--

CREATE TABLE `deta_prod` (
  `id_deta_prod` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `precio_compraxprod` double NOT NULL,
  `cantidad_prod` int(11) NOT NULL,
  `id_pro` int(11) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deta_ventas`
--

CREATE TABLE `deta_ventas` (
  `id_deta` int(11) NOT NULL,
  `fecha_venta` date NOT NULL,
  `precio_prod` double NOT NULL,
  `cantidad_prod` int(11) NOT NULL,
  `id_ventas` int(11) DEFAULT NULL,
  `id_pro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id_usu` int(11) NOT NULL,
  `usuario` varchar(250) NOT NULL,
  `contraseña` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  MODIFY `id_deta_prod` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `deta_ventas`
--
ALTER TABLE `deta_ventas`
  MODIFY `id_deta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id_usu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_pro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_ventas` int(11) NOT NULL AUTO_INCREMENT;

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
