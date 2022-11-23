INSERT INTO adresse(stadt, strasse, strassennummer, plz) VALUES ('DUE', 'Eller', '23', '34422');
INSERT INTO person(username, geburtsdatum, vorname, nachname, adresse_id) VALUES ('lea', '1990-12-12', 'Lea', 'Lion', 1);
INSERT INTO seminarraum(name, maximale_personenanzahl, ausstattung) VALUES ('Heinrich-Heine', 10, '​Flipchart; Whiteboard; 75"Display, Polycom Trio 8080 und Clickshare');
INSERT INTO seminarraum(name, maximale_personenanzahl, ausstattung) VALUES ('​Günter Grass', 10, '​Flipchart; Whiteboard; 75"Display, Polycom Trio 8080 und Clickshare');
INSERT INTO seminarraum(name, maximale_personenanzahl, ausstattung) VALUES ('Fritz Henkel - Interaction Room', 10, '​Flipchart; Whiteboard; 75"Display, Polycom Trio 8080 und Clickshare');

INSERT INTO seminar(seminar_title, beginn, ende, kursinhalt, Teilnehmeranzahl, voraussetzung, seminarraum, seminarleiter)
VALUES ('Spring Boot & Angular', '2022-01-12 11:00:00.000000', '2022-01-28 12:30:00.000000', 'kursinhalt', 0, 'Java & TypeScript', 1, 1);

INSERT INTO seminar(seminar_title, beginn, ende, kursinhalt, Teilnehmeranzahl, voraussetzung, seminarraum, seminarleiter)
VALUES ('Micro Services', '2022-02-13 09:00:00.000000', '2022-02-28 10:30:00.000000', 'Softwares Structure', 0, 'Softwarearchitekt', 2, 1);

INSERT INTO seminar(seminar_title, beginn, ende, kursinhalt, Teilnehmeranzahl, voraussetzung, seminarraum, seminarleiter)
VALUES ('Amazone web services', '2023-03-15 09:00:00.000000', '2022-04-14 10:30:00.000000', 'AWS Cloud', 0, 'Software Engineer', 2, 1);