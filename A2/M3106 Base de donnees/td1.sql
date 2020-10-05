4. 

CREATE OR REPLACE PROCEDURE AjouterJourneeTravail (
	p_codeSalarie Travailler.codeSalarie%TYPE, 
	p_codeProjet Travailler.codeProjet%TYPE, 
	p_dateTravail Travailler.dateTravail%TYPE) IS

BEGIN 

INSERT INTO Travailler VALUES(p_codeSalarie, p_dateTravail, p_codeProjet); 

UPDATE Salaries set nbTotalJourneesTravail = nbTotalJourneesTravail + 1
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

begin 

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
// Contrainte clé etrangere