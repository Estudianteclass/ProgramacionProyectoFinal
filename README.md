Proyecto en grupo realizado por Gabriel,Gregorio y Raúl.


/////////////////////////////////////////////////////////

Script para la creacion de la base de datos con xampp


create database gimnasio;
use gimnasio;

create table clientes(
dni varchar(9) primary key,
nombre varchar(30),
apellidos varchar(50),
direccion varchar(200),
fechaAlta date,
monitor varchar(40),
clase varchar(30)

);

//sentencias insert

INSERT INTO clientes (dni, nombre, apellidos, direccion, fechaAlta, monitor, clase) 
VALUES 
('12345678A', 'Carlos', 'García López', 'Calle Mayor, 10, Madrid', '2023-05-01', 'Ana Martínez', 'Yoga'),
('23456789B', 'María', 'Fernández Ruiz', 'Avenida de la Constitución, 45, Sevilla', '2023-06-15', 'Luis Pérez', 'Pilates'),
('34567890C', 'Juan', 'Martínez Gómez', 'Plaza de España, 12, Barcelona', '2023-07-20', 'Carlos Sánchez', 'Zumba'),
('45678901D', 'Ana', 'González Hernández', 'Calle del Sol, 22, Valencia', '2023-08-05', 'María Jiménez', 'Crossfit'),
('56789012E', 'Lucía', 'Rodríguez Morales', 'Avenida de América, 56, Málaga', '2023-09-10', 'Javier Torres', 'Spinning');
