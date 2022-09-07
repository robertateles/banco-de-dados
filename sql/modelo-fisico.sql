create database travelairlines;

use travelairlines;

create table Passageiro(
id_passageiro int primary key auto_increment,
nome_passageiro varchar(50),
cpf_passageiro varchar(14),
email_passageiro varchar(40),
senha_passageiro varchar(10),
telefone_passageiro varchar(12)
);

create table Compra(
id_compra int primary key auto_increment,
data_compra date,
valor_compra decimal(5,2),
id_passageiro int,
foreign key(id_passageiro) references Passageiro(id_passageiro)
);

create table Destino(
id_destino int primary key auto_increment,
nome_destino varchar(50)
);

create table Veiculo(
id_veiculo int primary key auto_increment,
qtdLugar_veiculo varchar(2),
placa_veiculo varchar(10)
);

create table Viagem(
id_viagem int primary key auto_increment,
preco_viagem decimal(5,2),
partida_viagem date,
id_compra int,
foreign key(id_compra) references Compra(id_compra),
id_destino int,
foreign key(id_destino) references Destino(id_destino),
id_veiculo int,
foreign key(id_veiculo) references Veiculo(id_veiculo)
);
