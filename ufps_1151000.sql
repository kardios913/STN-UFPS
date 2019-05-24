CREATE TABLE estudiante(
    codigo        integer(),
    nombre      character(100),
    email         character(100),
    password   character(15),
   PRIMARY KEY(codigo)
);
CREATE TABLE materia(
    codigo        integer(),
    nombre      character(100),
   PRIMARY KEY(codigo)
);
CREATE TABLE matexestu(
    codmate        integer(),
    codestu        integer(),
  CONSTRAINT mate_estu PRIMARY KEY(codmate,codestu)
);

CREATE TABLE nota(
    codmate        integer(),
    codestu        integer(),
    id        integer(),
    nota        real(),
  CONSTRAINT nota PRIMARY KEY(codmate,codestu,id)
);
