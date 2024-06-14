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
