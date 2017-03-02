CREATE TABLE Comida(
	Nome varchar(50) NOT NULL,
	Marca varchar(30) NOT NULL,
	Descrição varchar(50) NOT NULL,
	Kcal real NOT NULL,
	Carboidrato real NOT NULL,
	Proteina real NOT NULL,
	Gordura real NOT NULL,

	CONSTRAINT pk_comida PRIMARY KEY (Nome, Marca)
);