http://orainfo.iutmontp.univ-montp2.fr:5560/isqlplus/login.uix

Salaries(*codeSalarie*, nomSalarie, prenomSalarie, nbTotalJourneesTravail); 
Equipes(*codeEquipe*, nomEquipe, codeSalarieChef+); 
Projets(*codeProjet*, nomProjet, villeProjet, codeEquipe+); 
EtreAffecte(*codeSalarie+ *, *codeEquipe+ *); 
Travailler(*codeSalarie+ *, *dateTravail*, codeProjet+); 


4. 

CREATE OR REPLACE PROCEDURE AjouterJourneeTravail (
	p_codeSalarie Travailler.codeSalarie%TYPE, 
	p_codeProjet Travailler.codeProjet%TYPE, 
	p_dateTravail Travailler.dateTravail%TYPE) IS

BEGIN 

INSERT INTO Travailler VALUES(p_codeSalarie, p_dateTravail, p_codeProjet); 

UPDATE Salaries SET nbTotalJourneesTravail = nbTotalJourneesTravail + 1
WHERE codeSalarie = p_codeSalarie; 

END; 

/
Show Errors


CALL AjouterJourneeTravail('S2', 'P3', '10/01/2014'); 

SELECT nbTotalJourneesTravail
FROM salaries 
WHERE codesalarie = 'S2'



5. 

CREATE OR REPLACE PROCEDURE AffecterSalarieEquipe (
	p_codeSalarie EtreAffecte.codesalarie%TYPE, 
	p_codeEquipe EtreAffecte.codeEquipe%TYPE) IS 

nbAffectation NUMBER;

BEGIN 

SELECT COUNT(*) INTO nbAffectation 
FROM EtreAffecte 
WHERE codesalarie = p_codeSalarie;  

IF (nbAffectation >= 3) THEN 
RAISE_APPLICATION_ERROR(-20001, 'Le salarié est déjà affecté à au moins trois équipes'); 
ELSE 
INSERT INTO EtreAffecte VALUES (p_codeSalarie, p_codeEquipe); 

END IF; 

end; 

/
Show Errors	

CALL AffecterSalarieEquipe('S1', 'E3'); 

SELECT *
FROM EtreAffecte 
WHERE codesalarie = 'S1'
AND codeEquipe = 'E3'; 


CALL AffecterSalarieEquipe('S8', 'E1'); 

SELECT *
FROM EtreAffecte 
WHERE codesalarie = 'S8'
AND codeEquipe = 'E1'; 


6. 
// Clé d''inclusion entre deux associations

ALTER TABLE Equipes ADD CONSTRAINT 
fk_Equipes_ChefAffecte FOREIGN KEY (codeEquipe, codeSalarieChef)
REFERENCES EtreAffecte(codeEquipe, codeSalarie); 




8. 

CREATE OR REPLACE TRIGGER tr_nbTotalJourneesTravail 
AFTER INSERT ON Travailler 
FOR EACH ROW 

BEGIN

UPDATE Salaries 
SET nbTotalJourneesTravail = nbTotalJourneesTravail +1
WHERE codeSalarie = :NEW.codeSalarie; 

END; 

/
Show Errors

INSERT INTO Travailler VALUES ('S1', '10/01/2014', 'P1'); 

SELECT nbTotalJourneesTravail
FROM Salaries 
WHERE codeSalarie = 'S1'; 


9. 

CREATE OR REPLACE TRIGGER tr_insertSalarie 
BEFORE INSERT ON EtreAffecte 
FOR EACH ROW 

DECLARE 

nb NUMBER; 

BEGIN 

SELECT COUNT(*) INTO nb 
FROM EtreAffecte 
WHERE codeSalarie = :NEW.codeSalarie; 

IF (nb >= 3) THEN 
RAISE_APPLICATION_ERROR(-20001, 'Le salarié est déjà affecté à au moins trois équipes'); 
END IF; 

end; 

/
Show Errors

INSERT INTO EtreAffecte VALUES ('S2', 'E4'); 

SELECT * 
FROM EtreAffecte 
WHERE codeSalarie = 'S2' 
AND codeEquipe = 'E4'; 


INSERT INTO EtreAffecte VALUES ('S7', 'E4'); 

SELECT * 
FROM EtreAffecte 
WHERE codeSalarie = 'S7' 
AND codeEquipe = 'E4'; 


10. 

CREATE OR REPLACE TRIGGER tr_nbTotalJourneesTravail 
AFTER INSERT OR UPDATE OF codeSalarie OR DELETE ON Travailler 
FOR EACH ROW 

BEGIN

IF (INSERTING OR UPDATING) THEN
UPDATE Salaries 
SET nbTotalJourneesTravail = nbTotalJourneesTravail +1
WHERE codeSalarie = :NEW.codeSalarie; 
END IF; 

IF (DELETING OR UPDATING) THEN 
UPDATE Salaries
SET nbTotalJourneesTravail = nbTotalJourneesTravail -1
WHERE codeSalarie = :OLD.codeSalarie; 
END IF; 


END; 

/
Show Errors


UPDATE Travailler 
SET codeSalarie = 'S5'
WHERE codeSalarie = 'S1'
AND dateTravail = '10/01/2014'; 

SELECT nbTotalJourneesTravail 
FROM Salaries 
WHERE codeSalarie = 'S1'; 

SELECT nbTotalJourneesTravail 
FROM Salaries 
WHERE codeSalarie = 'S5'; 


DELETE Travailler 
WHERE codeSalarie = 'S5' 
AND dateTravail  ='10/01/2014'; 

SELECT nbTotalJourneesTravail 
FROM Salaries 
WHERE codeSalarie = 'S5'; 



12. 

CREATE OR REPLACE VIEW Affectations AS 

SELECT s.codeSalarie, nomSalarie, prenomSalarie, e.codeEquipe, nomEquipe
FROM Salaries s
JOIN EtreAffecte ef on s.codeSalarie = ef.codeSalarie
JOIN Equipes e on ef.codeEquipe = e.codeEquipe; 

INSERT INTO Affectations 
VALUES ('S9', 'Zétofrais', 'Mélanie', 'E5', 'INDIGO'); 
// ORA-01779: impossible de modifier une colonne correspondant à une table non protégée par Clé



13. 

CREATE OR REPLACE TRIGGER tr_Affectations 
INSTEAD OF INSERT ON Affectations 
FOR EACH ROW 

BEGIN 

INSERT INTO Salaries
VALUES (:NEW.codeSalarie, :NEW.nomSalarie, :NEW.prenomSalarie, 0); 

INSERT INTO Equipes 
VALUES (:NEW.codeEquipe, :NEW.nomEquipe, NULL); 

INSERT INTO EtreAffecte
VALUES (:NEW.codeSalarie, :NEW.codeEquipe); 

END; 


INSERT INTO Affectations 
VALUES ('S9', 'Zétofrais', 'Mélanie', 'E5', 'Indigo'); 

INSERT INTO Affectations 
VALUES ('S9', 'Zétofrais', 'Mélanie', 'E4', 'Mars'); 

INSERT INTO Affectations 
VALUES ('S5', 'Umule', 'Jacques', 'E6', 'Europa'); 

INSERT INTO Affectations 
VALUES ('S10', 'Zeblouse', 'Agathe', 'E7', 'Galileo'); 

SELECT * 
FROM EtreAffecte





13 bis. 

SET SERVEROUTPUT ON; 

CREATE OR REPLACE TRIGGER tr_Affectations 
INSTEAD OF INSERT ON Affectations 
FOR EACH ROW 


BEGIN 


IF ( (verifSalarie(:NEW.codeSalarie, :NEW.nomSalarie, :NEW.prenomSalarie) = 1) AND (verifEquipe(:NEW.codeEquipe, :NEW.nomEquipe) = 1)) THEN

	INSERT INTO Salaries
	VALUES (:NEW.codeSalarie, :NEW.nomSalarie, :NEW.prenomSalarie, 0); 

	INSERT INTO Equipes 
	VALUES (:NEW.codeEquipe, :NEW.nomEquipe, NULL); 

	INSERT INTO EtreAffecte
	VALUES (:NEW.codeSalarie, :NEW.codeEquipe); 

ELSE
	DBMS_output.put_line('Données fausses'); 
END IF; 

END; 

/
Show Errors

INSERT INTO Affectations 
VALUES ('S9', 'Ouzy', 'Jacques', 'E6', 'Europa'); 

INSERT INTO Affectations 
VALUES ('S9', 'Zétofrais', 'Mélanie', 'E6', 'Galileo'); 




CREATE OR REPLACE FUNCTION verifSalarie (
	v_codeSalarie Salaries.codeSalarie%TYPE, 
	v_nomSalarie Salaries.nomSalarie%TYPE, 
	v_prenomSalarie Salaries.prenomSalarie%TYPE) 
RETURN NUMBER IS

nb NUMBER; 
r_salarie Salaries%ROWTYPE; 

BEGIN

SELECT COUNT(*) INTO nb 
FROM Salaries 
where codeSalarie = v_codeSalarie;

IF (nb = 0) THEN 
	return 1; 
END IF; 

SELECT * INTO r_salarie 
FROM Salaries 
where codeSalarie = v_codeSalarie;

IF ((r_salarie.nomSalarie = v_nomSalarie) AND (r_salarie.prenomSalarie = v_prenomSalarie) ) THEN 
	return 1; 
END IF; 

return 0; 

end; 

/
Show Errors 


CREATE OR REPLACE FUNCTION verifEquipe (
	v_codeEquipe Equipes.codeEquipe%TYPE, 
	v_nomEquipe Equipes.nomEquipe%TYPE) 
RETURN NUMBER IS

nb NUMBER; 
r_equipe Equipes%ROWTYPE; 

BEGIN

SELECT COUNT(*) INTO nb 
FROM Equipes 
where codeEquipe = v_codeEquipe;

IF (nb = 0) THEN 
	return 1; 
END IF; 

SELECT * INTO r_equipe 
FROM Equipes
where codeEquipe = v_codeEquipe;

IF (r_equipe.nomEquipe = v_nomEquipe) THEN 
	return 1; 
END IF; 

return 0; 

end; 

/
Show Errors 




TP 10. 

SET TIMING ON 
SET AUTOTRACE ON 
SET AUTOTRACE TRACEONLY; 

2. 

SELECT sexeClient, villeClient
FROM Clients 
WHERE nomClient = 'Palleja'; 


3.a 

SELECT * 
FROM Clients 
WHERE idClient = 1000; 

3.b 

SELECT /*+ no_index(Clients pk_Clients) */ *
FROM Clients 
WHERE idClient = 1000; 

3.c 

SELECT * 
FROM Clients 
WHERE idClient != 1000; 


3.c bis 

SELECT /*+ index(Clients pk_Clients) */ *
FROM Clients 
WHERE idClient != 1000; 


3.d

SELECT * 
FROM Commandes 
WHERE idCommande > 60000; 



4.b 

SELECT * 
FROM Clients 
WHERE nomClient = 'Claude'; 


4.c 

CREATE INDEX idx_nomClient ON Clients(nomClient); 



5.a

UPDATE Commandes 
SET montantCommande = montantCommande + 10;


5.b 

CREATE INDEX idx_Commandes_MontantCommandes ON Commandes (montantCommande); 


5.c

UPDATE Commandes 
SET montantCommande = montantCommande - 10;



6.a 

SELECT * 
FROM Commandes 
WHERE montantCommande/3 > 3500; 


6.b 

SELECT * 
FROM Commandes 
WHERE montantCommande > 3500*3; 


7.a 

SELECT * 
FROM Clients 
WHERE villeClient = 'Marseille' AND prenomClient = 'Pierre'; 


7.b 

CREATE INDEX idx_Clients_prenomClient ON Clients(prenomClient); 
CREATE INDEX idx_Clients_villeClient ON Clients(villeClient); 


7.c 

DROP INDEX idx_Clients_prenomClient ; 
DROP INDEX idx_Clients_villeClient ; 


7.d 

SELECT * 
FROM Clients 
WHERE prenomClient = 'Xavier'; 


7.e 

SELECT * 
FROM Clients 
WHERE villeClient = 'Montpellier'; 


7.f 

SELECT villeClient
FROM Clients 
WHERE prenomClient = 'Xavier'; 


8.a 

SELECT * 
FROM Commandes 
WHERE dateCommande IS NULL; 

	488, lit toute la table. 


8.b 

CREATE INDEX idx_Commandes_dateCommande ON Commandes(dateCommande); 

	488, lit toute la table. 


8.c 

SELECT /*+ index(Commandes idx_Commandes_dateCommande) */ * 
FROM Commandes 
WHERE dateCommande IS NULL; 

	488, l''index n''a pas été utilisé car ne fonctinne pas sur les NULL. 


8.d 

CREATE INDEX idx_Commandes_Id_dateCommande ON Commandes(dateCommande, idCommande); 

SELECT /*+ index(Commandes idx_Commandes_Id_dateCommande) */ * 
FROM Commandes 
WHERE dateCommande IS NULL; 

	337 alors que l''index était pas utilisé sans le hint. 


9.a 

SELECT nomProduit 
FROM Produits p
JOIN LignesCommande l ON p.idProduit = l.idProduit 
JOIN Commandes co ON l.idCommande = co.idCommande 
JOIN Clients cl ON co.idClient = cl.idClient 
WHERE nomClient = 'Palleja'; 

ou 

SELECT nomProduit 
FROM Clients c
JOIN Commandes co ON c.idClient = co.idClient 
JOIN LignesCommande l ON co.idCommande = l.idCommande
JOIN Produits p ON l.idProduit = p.idProduit
WHERE nomClient = 'Palleja'; 

	1060, 00.03


9.b 

SELECT nomProduit 
FROM Produits
WHERE idProduit IN (
	SELECT idProduit 
	FROM LignesCommande
	WHERE idCommande IN (
		SELECT idCommande
		FROM Commandes 
		WHERE idClient IN (
			SELECT idClient
			FROM Clients
			WHERE nomClient = 'Palleja'))); 

	499, 00.01, Les IN ont été transformés en JOIN par Oracle. 


9.c 

SELECT /*+ NO_QUERY_TRANSFORMATION */ nomProduit 
FROM Produits
WHERE idProduit IN (
	SELECT idProduit 
	FROM LignesCommande
	WHERE idCommande IN (
		SELECT idCommande
		FROM Commandes 
		WHERE idClient IN (
			SELECT idClient
			FROM Clients
			WHERE nomClient = 'Palleja'))); 

	1013410, 01.00, Si sur un SGBD sans transformation de jointures, alors faire des JOIN. 


10.a 

SELECT nomProduit 
FROM Produits p
JOIN LignesCommande l ON p.idProduit = l.idProduit 
JOIN Commandes co ON l.idCommande = co.idCommande 
JOIN Clients cl ON co.idClient = cl.idClient 
WHERE nomClient = 'Palleja'; 

	Meme résultat que pour la 9.a, Oracle ordonne les jointures. 


10.b 

SELECT /*+ ORDERED */ nomProduit 
FROM Produits p
JOIN LignesCommande l ON p.idProduit = l.idProduit 
JOIN Commandes co ON l.idCommande = co.idCommande 
JOIN Clients cl ON co.idClient = cl.idClient 
WHERE nomClient = 'Palleja'; 

	1060, 00.13

ou 

SELECT /*+ ORDERED */ nomProduit 
FROM Clients c
JOIN Commandes co ON c.idClient = co.idClient 
JOIN LignesCommande l ON co.idCommande = l.idCommande
JOIN Produits p ON l.idProduit = p.idProduit
WHERE nomClient = 'Palleja'; 

	1060, 00.03


11.a 

SELECT nomClient 
FROM Clients 
WHERE idClient NOT IN (
	SELECT idClient 
	FROM Commandes); 

	570, 00.01 


SELECT nomClient 
FROM Clients 
WHERE idClient IN (
	(SELECT idClient 
	FROM Clients) 
	MINUS 
	(SELECT idClient
	FROM Commandes)); 

	609, 00.06


SELECT nomClient
FROM Clients cl
WHERE NOT EXISTS (
	SELECT * 
	FROM Commandes co
	WHERE co.idClient = cl.idClient); 

	570, 00.01


11.b 

SELECT /*+ OPTIMIZER_FEATURES_ENABLE('10.2.0.4') */ nomClient 
FROM Clients 
WHERE idClient NOT IN (
	SELECT idClient 
	FROM Commandes); 

	501863, 04.37 


SELECT /*+ OPTIMIZER_FEATURES_ENABLE('10.2.0.4') */ nomClient 
FROM Clients 
WHERE idClient IN (
	(SELECT idClient 
	FROM Clients) 
	MINUS 
	(SELECT idClient
	FROM Commandes)); 

	609, 00.06


SELECT /*+ OPTIMIZER_FEATURES_ENABLE('10.2.0.4') */ nomClient
FROM Clients cl
WHERE NOT EXISTS (
	SELECT * 
	FROM Commandes co
	WHERE co.idClient = cl.idClient); 

	570, 00.01


12.a 

SELECT c.idCommande, dateCommande
FROM Commandes c
JOIN LignesCommande lc ON lc.idCommande = c.idCommande
GROUP BY c.idCommande, c.dateCommande
HAVING COUNT(lc.idProduit) = 
	(SELECT COUNT(*)
	 FROM Produits);     


SELECT idCommande, dateCommande
FROM Commandes c
WHERE NOT EXISTS (SELECT idProduit
                                FROM Produits
                                MINUS
                                SELECT idProduit
                                FROM LignesCommande
                                WHERE idCommande = c.idCommande); 


12.b 

SELECT idCommande, dateCommande
FROM Commandes 
WHERE idCommande NOT IN (
	SELECT idCommande
	FROM (
		SELECT idCommande, idProduit
		FROM Commandes
		CROSS JOIN Produits
		MINUS
		SELECT idCommande, idProduit
		FROM LignesCommande))

	1165, 02.47


13.a 

SELECT COUNT(*)
FROM Clients cl 
JOIN Commandes co on cl.idClient = co.idClient
WHERE prenomClient = 'Xavier' AND nomClient = 'Palleja';

SELECT SUM(montantCommande)
FROM Clients cl 
JOIN Commandes co on cl.idClient = co.idClient
WHERE prenomClient = 'Xavier' AND nomClient = 'Palleja';


13.b 

CREATE MATERIALIZED VIEW ClientsCA (idClient, nomClient, prenomClient, nbCommandes, CA)
ENABLE QUERY REWRITE

AS

SELECT cl.idClient, nomClient, prenomClient, COUNT(*), SUM(montantCommande)
FROM Clients cl 
JOIN Commandes co on cl.idClient = co.idClient
GROUP BY cl.idClient, nomClient, prenomClient; 


13.d 

INSERT INTO Commandes (idCommande, dateCommande, idClient, montantCommande)
VALUES (100001, '01/02/2014', 10001, 0);

COMMIT; 


14.a 

DROP MATERIALIZED VIEW ClientsCA; 


14.b 

CREATE MATERIALIZED VIEW LOG ON Clients WITH SEQUENCE ,ROWID(idClient, nomClient, prenomClient) INCLUDING NEW VALUES;
CREATE MATERIALIZED VIEW LOG ON Commandes WITH SEQUENCE ,ROWID(idClient, montantCommande) INCLUDING NEW VALUES;


14.c 

CREATE MATERIALIZED VIEW ClientsCA (idClient, nomClient, prenomClient, nbCommandes, CA)
REFRESH FAST ON COMMIT
ENABLE QUERY REWRITE

AS

SELECT cl.idClient, nomClient, prenomClient, COUNT(*), SUM(montantCommande)
FROM Clients cl 
JOIN Commandes co on cl.idClient = co.idClient
GROUP BY cl.idClient, nomClient, prenomClient; 


14.d 

SELECT COUNT(*)
FROM Clients cl 
JOIN Commandes co on cl.idClient = co.idClient
WHERE prenomClient = 'Xavier' AND nomClient = 'Palleja';


14.d 

INSERT INTO Commandes (idCommande, dateCommande, idClient, montantCommande)
VALUES (100002, '02/02/2014', 10001, 0);

COMMIT;


15.a 

EXECUTE DBMS_STATS.GATHER_SCHEMA_STATS('sartorit');


15.b 

SELECT COLUMN_NAME, NUM_DISTINCT, NUM_NULLS, DENSITY,
LAST_ANALYZED
FROM USER_TAB_COLUMNS
WHERE TABLE_NAME = 'COMMANDES';


15.d 

SELECT * 
FROM Commandes 
WHERE dateCommande IS NULL; 


15.e 

CREATE INDEX idx_Commandes_etatCommande ON Commandes(etatCommande); 


15.f 

EXECUTE DBMS_STATS.GATHER_SCHEMA_STATS('sartorit');


15.g

SET AUTOTRACE TRACEONLY; 


15.h 

SELECT * 
FROM Commandes 
WHERE etatCommande = 'Payée Liquide'; 

SELECT /*+ index(Commandes idx_Commandes_etatCommande) */ * 
FROM Commandes 
WHERE etatCommande = 'Payée Liquide'; 

15.i 

SELECT * 
FROM Commandes 
WHERE etatCommande = 'Payée CB'; 

SELECT * 
FROM Commandes 
WHERE etatCommande = 'Passée'; 


15.j 

SELECT * 
FROM Commandes 
WHERE etatCommande <> 'Payée CB'; 


SELECT * 
FROM Commandes 
WHERE etatCommande = 'Payée Liquide' OR etatCommande = 'Passée'; 


16.a 

SELECT * 
FROM Commandes 
WHERE etatCommande = 'Payée Liquide'; 


16.b 

UPDATE Commandes SET etatCommande = 'Payée Liquide'
WHERE '17/09/2014' <= dateCommande AND dateCommande <= '25/09/2014'; 


16.c 

L''index est utilisé mais il ne devrait pas l''être. 


16.d 

EXECUTE DBMS_STATS.GATHER_TABLE_STATS('sartorit', 'COMMANDES');


17.a 
-- a. Nombre de lignes de commande passées par chaque client (attention, l’exécution de la requête suivante peut prendre un certain de temps – plus de 3 minutes) :

SELECT nomClient, prenomClient, (SELECT COUNT(*)
                                 FROM Commandes co 
                                 JOIN LignesCommande lc ON
                                        co.idCommande = lc.idCommande 
                                 WHERE co.idClient = cl.idClient)
FROM Clients cl

10000 lignes 



SELECT nomClient, prenomClient, COUNT(*)
FROM Clients cl 
JOIN Commandes co on cl.idClient = co.idClient
JOIN LignesCommande l on co.idCommande = l.idCommande 
GROUP BY nomClient, prenomClient; 

8839 lignes 


17.b 
-- b. Liste des commandes qui n’ont pas à la fois un portable, un écran et une souris :

SELECT /*+ no_query_transformation */ DISTINCT idCommande, dateCommande
FROM Commandes
WHERE idCommande NOT IN (SELECT DISTINCT idCommande
                         FROM LignesCommande
                         WHERE idProduit IN (SELECT idProduit
                                             FROM Produits
                                             WHERE categorieProduit = 'Portable')
                          INTERSECT
                         SELECT DISTINCT idCommande
                         FROM LignesCommande
                         WHERE idProduit IN (SELECT idProduit
                                             FROM Produits
                                             WHERE categorieProduit = 'Ecran')
                          INTERSECT
                         SELECT DISTINCT idCommande
                         FROM LignesCommande
                         WHERE idProduit IN (SELECT idProduit
                                             FROM Produits
                                             WHERE categorieProduit = 'Souris'));

97745 lignes


SELECT DISTINCT c.idCommande, dateCommande
FROM Commandes c
JOIN LignesCommande l on c.idCommande = l.idCommande 
JOIN Produits p on l.idProduit = p.idProduit
WHERE NOT EXISTS (
	SELECT * 
	FROM Produits
	WHERE categorieProduit = 'Portable' AND categorieProduit = 'Ecran' AND categorieProduit = 'Souris'); 


avec 

CREATE INDEX idx_Commandes_Id_dateCommande ON Commandes(dateCommande, idCommande); 

99887 lignes













  







