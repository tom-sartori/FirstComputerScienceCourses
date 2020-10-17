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


Salaries(*codeSalarie*, nomSalarie, prenomSalarie, nbTotalJourneesTravail); 
Equipes(*codeEquipe*, nomEquipe, codeSalarieChef+); 
EtreAffecte(*codeSalarie+ *, *codeEquipe+ *); 
















v_codeSalarie Salaries.codeSalarie%TYPE, 
v_nomSalarie Salaries.nomSalarie%TYPE, 
v_prenomSalarie Salaries.prenomSalarie%TYPE, 
v_codeEquipe Equipes.codeEquipe%TYPE, 
v_nomEquipe Equipes.nomEquipe%TYPE
