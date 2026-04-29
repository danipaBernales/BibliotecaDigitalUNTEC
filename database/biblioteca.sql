CREATE DATABASE biblioteca_untec;

USE biblioteca_untec;

CREATE TABLE usuarios (

    id INT AUTO_INCREMENT PRIMARY KEY,

    nombre VARCHAR(100),

    correo VARCHAR(100),

    password VARCHAR(100)

);

CREATE TABLE libros (

    id INT AUTO_INCREMENT PRIMARY KEY,

    titulo VARCHAR(150),

    autor VARCHAR(100),

    disponible BOOLEAN

);

CREATE TABLE prestamos (

    id INT AUTO_INCREMENT PRIMARY KEY,

    usuario_id INT,

    libro_id INT,

    fecha_prestamo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (usuario_id)
        REFERENCES usuarios(id),

    FOREIGN KEY (libro_id)
        REFERENCES libros(id)

);

INSERT INTO usuarios
(nombre, correo, password)
VALUES
('Daniela', 'admin@untec.com', '1234');

INSERT INTO libros
(titulo, autor, disponible)
VALUES
('Java Fundamentals', 'Oracle', true),
('Clean Code', 'Robert Martin', true),
('Spring Boot', 'Pivotal', true);
