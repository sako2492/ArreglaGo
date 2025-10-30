DROP DATABASE IF EXISTS arregla_go;

-- Creamos la base de datos con soporte UTF-8 completo
CREATE DATABASE arregla_go 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

USE arregla_go;

-- ============================
-- TABLAS BÁSICAS
-- ============================

-- distritos 
CREATE TABLE distrito (
    id_distrito INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    provincia VARCHAR(100),
    departamento VARCHAR(100),
    estado BIT NOT NULL
) ENGINE=InnoDB;

-- tipos de documentos
CREATE TABLE tipoDocumento (
    id_tipoDocumento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    estado BIT NOT NULL
) ENGINE=InnoDB;

-- roles 
CREATE TABLE rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    estado BIT NOT NULL
) ENGINE=InnoDB;

-- categorias (oficios)
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(300) NOT NULL,
    estado BIT NOT NULL
) ENGINE=InnoDB;

-- ============================
-- USUARIOS Y EXTENSIONES
-- ============================

-- usuarios (base para login)
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidoPaterno VARCHAR(100) NOT NULL,
    apellidoMaterno VARCHAR(100) NOT NULL,
    correo VARCHAR(150) UNIQUE NOT NULL,
    telefono CHAR(9) NOT NULL,
    direccion VARCHAR(300) NOT NULL,
    nro_documento CHAR(20) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    clave VARCHAR(100) NOT NULL, -- usar hash (BCrypt/Argon2)
    foto_perfil VARCHAR(255) NULL COMMENT 'Ruta relativa o URL de la foto de perfil',
    estado BIT NOT NULL DEFAULT 1,
    id_distrito INT NOT NULL,
    id_rol INT NOT NULL,
    id_tipoDocumento INT NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id_distrito) REFERENCES distrito(id_distrito),
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol),
    FOREIGN KEY (id_tipoDocumento) REFERENCES tipoDocumento(id_tipoDocumento)
) ENGINE=InnoDB;

-- clientes (extienden usuario)
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT UNIQUE NOT NULL,
    estado BIT NOT NULL  DEFAULT 1,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;

-- proveedores (extienden usuario con más datos)
CREATE TABLE proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT UNIQUE NOT NULL,
    experiencia VARCHAR(300) NOT NULL,
    descripcion TEXT NOT NULL,
    id_categoria INT NOT NULL,
	estado BIT NOT NULL  DEFAULT 1,

    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
) ENGINE=InnoDB;

-- ============================
-- FUNCIONALIDAD
-- ============================

-- servicios publicados por proveedores
CREATE TABLE servicio (
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descripcion TEXT NOT NULL,
    estado BIT NOT NULL DEFAULT 1,
    fecha_publicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
) ENGINE=InnoDB;

-- contrataciones (reservas de clientes a servicios)
CREATE TABLE contratacion (
    id_contratacion INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_servicio INT NOT NULL,
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(20) NOT NULL DEFAULT 'pendiente',
    
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio)
) ENGINE=InnoDB;

-- valoraciones (basadas en contrataciones reales)
CREATE TABLE valoracion (
    id_valoracion INT AUTO_INCREMENT PRIMARY KEY,
    id_contratacion INT NOT NULL,
    puntuacion TINYINT CHECK (puntuacion BETWEEN 1 AND 5),
    comentario VARCHAR(300),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	estado BIT NOT NULL  DEFAULT 1,
    
    FOREIGN KEY (id_contratacion) REFERENCES contratacion(id_contratacion)
) ENGINE=InnoDB;

-- suscripciones de proveedores
CREATE TABLE suscripcion (
    id_suscripcion INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    estado VARCHAR(20) NOT NULL DEFAULT 'pendiente',
    monto DECIMAL(10,2),
    metodo_pago VARCHAR(50),
    
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
) ENGINE=InnoDB;

-- galeria de fotos para los proveedores 
CREATE TABLE galeriaproveedor (
    id_imagen INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT NOT NULL,
    url_imagen VARCHAR(255) NOT NULL COMMENT 'Ruta o URL pública de la imagen',
    descripcion VARCHAR(200) NULL,
    fecha_subida TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT NOT NULL,

    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Ver dónde se almacenan los logs
-- SHOW VARIABLES LIKE 'general_log%';

-- Activar el log general (registra todas las consultas)
-- SET GLOBAL general_log = 'ON';

-- Desactivarlo cuando ya no sea necesario
-- SET GLOBAL general_log = 'OFF';
select * from tipoDocumento
