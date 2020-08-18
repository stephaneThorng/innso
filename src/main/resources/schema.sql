-- Création des structures de données

CREATE TABLE dossier_client (
	uuid UUID PRIMARY KEY,
	nom VARCHAR(255) NOT NULL,
	reference VARCHAR(100) NULL,
	created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP

);

CREATE TABLE message (
	uuid UUID PRIMARY KEY,
	dossier_uuid UUID,
	auteur VARCHAR(255) NOT NULL,
	contenu VARCHAR(255) NOT NULL,
	canal VARCHAR(20) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP,
	FOREIGN KEY (dossier_uuid) REFERENCES dossier_client(uuid)
);

