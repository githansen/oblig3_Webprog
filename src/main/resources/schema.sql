CREATE TABLE Billett (
    id INTEGER AUTO_INCREMENT NOT NULL,
    Film VARCHAR(255) NOT NULL,
    Fornavn VARCHAR(255) NOT NULL,
    Etternavn VARCHAR(255) NOT NULL,
    Telefonnr INTEGER(255) NOT NULL,
    Epost VARCHAR NOT NULL,
    PRIMARY KEY (id)
);