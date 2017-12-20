connect system/password;

drop user Lise;

create user Lise identified by lise;
grant connect, resource to Lise;

connect Lise/lise;

CREATE TABLE employe (
  ID number(10)  constraint pk_employe primary key,
  login varchar(25),
  password varchar(10),
  nom varchar(30),
  prenom varchar(30),
  email varchar(30),
  role varchar(10)
);

INSERT INTO employe VALUES (1, 'douglas', 'objis', 'Mbiandou', 'Douglas', 'douglas.mbiandou@objis.com', 'employe');
INSERT INTO employe VALUES (2, 'mass', 'objis', 'Samb', 'Mass', 'mass.samb@objis.com', 'employe');
INSERT INTO employe VALUES (3, 'nassur', 'objis', 'Mhoumadi', 'Nassur', 'nassur.mhoumadi@objis.com', 'manager');

commit;