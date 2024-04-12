-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-10-2023 a las 03:50:41
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_sistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `id` int(10) NOT NULL,
  `usuario` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `clave` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefono` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`id`, `usuario`, `correo`, `clave`, `nombre`, `apellido`, `telefono`) VALUES
(1, 'david030', 'thebigmasterx32@gmail.com', 'admin', 'jose', 'mejia vilca', '936137204');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id` int(10) NOT NULL,
  `name` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dni` int(9) DEFAULT NULL,
  `email` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sexo` varchar(70) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fechadn` varchar(70) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefono` int(10) DEFAULT NULL,
  `perfil` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `name`, `apellido`, `dni`, `email`, `direccion`, `password`, `sexo`, `fechadn`, `telefono`, `perfil`) VALUES
(5, 'DAVID', 'MEJIA VILCA', 75678180, 'davidmejiavilca123@gmail.com', 'Rio Vilcanota 178', '8641', 'Femenino', '10/04/1999', 962783540, 'Imagen1.png'),
(10, 'DAVID', 'VASQUEZ', 564545, 'davidmejiavilca076@gmail.com', 'los alisos', '1254', 'Femenino', '05/01/2023', 944545541, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivocalifica`
--

CREATE TABLE `archivocalifica` (
  `id` int(10) NOT NULL,
  `nombre` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ruta` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `archivocalifica`
--

INSERT INTO `archivocalifica` (`id`, `nombre`, `ruta`) VALUES
(1, 'bg.jpg', 'http://localhost/WebEscuela/src/main/webapp/caimagen/bg.jpg'),
(2, 'adminlogin.png', 'http://localhost/WebEscuela/src/main/webapp/caimagen/adminlogin.png'),
(4, 'cielo.jpg', 'http://localhost/WebEscuela/src/main/webapp/caimagen/cielo.jpg'),
(5, 'bg3.jpg', 'http://localhost/WebEscuela/src/main/webapp/caimagen/bg3.jpg'),
(7, 'fgdsffs.png', 'http://localhost/WebEscuela/src/main/webapp/caimagen/fgdsffs.png'),
(8, 'fgdsffs.png', 'http://localhost/WebEscuela/src/main/webapp/caimagen/fgdsffs.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivomaterial`
--

CREATE TABLE `archivomaterial` (
  `id` int(10) NOT NULL,
  `nombre` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ruta` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `archivomaterial`
--

INSERT INTO `archivomaterial` (`id`, `nombre`, `ruta`) VALUES
(16, 'filmora.png', 'http://localhost/WebEscuela/src/main/webapp/maimagen/filmora.png'),
(17, 'Banner_Canal.png', 'http://localhost/WebEscuela/src/main/webapp/maimagen/Banner_Canal.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivotarea`
--

CREATE TABLE `archivotarea` (
  `id` int(10) NOT NULL,
  `nombre` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ruta` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `archivotarea`
--

INSERT INTO `archivotarea` (`id`, `nombre`, `ruta`) VALUES
(9, 'logo del canal oficial navideño.png', 'http://localhost/WebEscuela/src/main/webapp/taimagen/logo del canal oficial navideño.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `id` int(10) NOT NULL,
  `nombre` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `clase` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `materia` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `seccion` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tipoasistencia` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fechade` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hora` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`id`, `nombre`, `apellido`, `clase`, `materia`, `seccion`, `tipoasistencia`, `fechade`, `hora`) VALUES
(54, 'JOSE', 'VILCA', 'IV NIVEL', 'FISICA', 'SECUNDARIA', 'ausente', '10/10/2023', '17:28:15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacion`
--

CREATE TABLE `calificacion` (
  `id` int(10) NOT NULL,
  `titulo` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(120) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `archivo` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nivel` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `materia` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tema` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nota` int(4) NOT NULL,
  `fechade` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hora` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `calificacion`
--

INSERT INTO `calificacion` (`id`, `titulo`, `descripcion`, `archivo`, `nivel`, `materia`, `name`, `tema`, `nota`, `fechade`, `hora`) VALUES
(1, 'Tarea 1', 'realizarlo antes del fin de semana', 'adminlogin.png', 'III NIVEL', 'QUIMICA', 'DAVID MEJIA', 'Clase 1', 12, '2023-10-10', '15:54');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `changepassword`
--

CREATE TABLE `changepassword` (
  `id` int(10) NOT NULL,
  `oldpassword` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `changepassword`
--

INSERT INTO `changepassword` (`id`, `oldpassword`) VALUES
(1, '7567');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clases`
--

CREATE TABLE `clases` (
  `id` int(10) NOT NULL,
  `clase` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `seccion` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `materia` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `aula` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `clases`
--

INSERT INTO `clases` (`id`, `clase`, `seccion`, `materia`, `aula`) VALUES
(1, 'III NIVEL', 'PRIMARIA', 'QUIMICA', '5-A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE `docentes` (
  `id` int(10) NOT NULL,
  `usuario` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `clave` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `perfil` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `direccion` varchar(70) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sexo` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fechadn` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefono` int(10) DEFAULT NULL,
  `dni` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`id`, `usuario`, `correo`, `clave`, `nombre`, `apellido`, `perfil`, `direccion`, `sexo`, `fechadn`, `telefono`, `dni`) VALUES
(5, 'david076', 'davidmejiavilca123@gmail.com', '12545', 'jose', 'VASQUEZ', NULL, 'los alisos', 'Masculino', '18/01/2023', 1445454545, 75678180),
(6, 'david020', 'davidmejiavilca076@gmail.com', '12545', 'david', 'VASQUEZ', NULL, 'los alisos', 'Masculino', '17/01/2023', 1445454545, 75678180);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fotoperfil`
--

CREATE TABLE `fotoperfil` (
  `id` int(10) NOT NULL,
  `nombre` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ruta` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `fotoperfil`
--

INSERT INTO `fotoperfil` (`id`, `nombre`, `ruta`) VALUES
(1, 'cielo.jpg', 'http://localhost/WebEscuela/src/main/webapp/perfilimagen/cielo.jpg'),
(2, 'Imagen1.png', 'http://localhost/WebEscuela/src/main/webapp/perfilimagen/Imagen1.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fotoperfildocente`
--

CREATE TABLE `fotoperfildocente` (
  `id` int(10) NOT NULL,
  `nombre` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ruta` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `fotoperfildocente`
--

INSERT INTO `fotoperfildocente` (`id`, `nombre`, `ruta`) VALUES
(1, 'logo de mi empresa.png', 'http://localhost/WebEscuela/src/main/webapp/perfildoimagen/logo de mi empresa.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `id` int(10) NOT NULL,
  `titulo` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(120) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `archivo` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nivel` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `materia` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tema` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`id`, `titulo`, `descripcion`, `archivo`, `nivel`, `materia`, `name`, `tema`) VALUES
(4, 'Exposicion', 'grabacion', 'Banner_Canal.png', 'IV NIVEL', 'QUIMICA', 'DAVID MEJIA VILCA', 'Clase 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

CREATE TABLE `tarea` (
  `id` int(10) NOT NULL,
  `titulo` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(120) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `archivo` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nivel` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `materia` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tema` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nota` int(4) NOT NULL,
  `fechade` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hora` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`id`, `titulo`, `descripcion`, `archivo`, `nivel`, `materia`, `name`, `tema`, `nota`, `fechade`, `hora`) VALUES
(1, 'tarea 1', 'gdgdfgf', 'filmora.png', 'III NIVEL', 'QUIMICA', 'DAVID MEJIA VILCA', 'Clase 1', 20, '08/10/2023', '00:44');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temas`
--

CREATE TABLE `temas` (
  `id` int(10) NOT NULL,
  `tema` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `temas`
--

INSERT INTO `temas` (`id`, `tema`) VALUES
(1, 'Clase 1'),
(2, 'Clase 2'),
(3, 'Clase 4');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `archivocalifica`
--
ALTER TABLE `archivocalifica`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `archivomaterial`
--
ALTER TABLE `archivomaterial`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `archivotarea`
--
ALTER TABLE `archivotarea`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `changepassword`
--
ALTER TABLE `changepassword`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `docentes`
--
ALTER TABLE `docentes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `fotoperfil`
--
ALTER TABLE `fotoperfil`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `fotoperfildocente`
--
ALTER TABLE `fotoperfildocente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `temas`
--
ALTER TABLE `temas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `archivocalifica`
--
ALTER TABLE `archivocalifica`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `archivomaterial`
--
ALTER TABLE `archivomaterial`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `archivotarea`
--
ALTER TABLE `archivotarea`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `clases`
--
ALTER TABLE `clases`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `docentes`
--
ALTER TABLE `docentes`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `fotoperfil`
--
ALTER TABLE `fotoperfil`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `fotoperfildocente`
--
ALTER TABLE `fotoperfildocente`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tarea`
--
ALTER TABLE `tarea`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `temas`
--
ALTER TABLE `temas`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
