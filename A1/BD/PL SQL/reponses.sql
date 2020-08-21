PL SQL 

SET SERVEROUTPUT ON

Commence par begin et fini par end

DECLARE
variables
begin
...
end



if 
then 
else
end if 


BOOLEAN : 
select count(*) into v_existe
from campings 
where idcamping = '&s_idcamping'

ou
select idcamping into v_existe
from campings 
where idcamping = '&s_idcamping'

exception 
when NO_DATA_FOUND then 
DBMS_OUT.PUT_LINE('Existe pas'); 




FONCTIONS 

/
show errors

select fonction (...)
from Dual;



PROCEDURE

CALL procedure




CURSEUR

DECLARE
CURSOR curs_nom IS
Select ...

ligne curs_nom%ROWTYPE

begin
OPEN curs_nom;
FETCH curs_nom into ligne
WHILE (curs_nom%FOUND) LOOP
	--Affichage...
	FETCH curs_nom into ligne; 
END LOOP; 
CLOSE curs_nom

end; 

---------------

DECLARE
CURSOR curs_nom IS
Select ...

begin
FOR ligne IN curs_nom LOOP
	--Affichage
END LOOP; 

end; 

----------------

begin
FOR ligne IN (select ...) LOOP
	--Affichage
END LOOP; 

end; 







SELECT * FROM USER_OBJECTS WHERE object_type='PROCEDURE' OR object_type='FUNCTION'





PARTIE 1 : 

1. 
SET SERVEROUTPUT ON
Declare 
nombre number; 
groupe Groupes.idgroupe%type; 

begin 
groupe :='Q1'; 
select count(*) into nombre
from etudiants 
where idgroupe=groupe; 

DBMS_output.put_line('Il y a ' || nombre || ' étudiants dans le groupe ' || groupe); 

end;


2. 
SET SERVEROUTPUT ON

accept groupe prompt 'groupe : '; 

Declare 
nombre number; 
--groupe Groupes.idgroupe%type; 

begin 
select count(*) into nombre
from etudiants 
where idgroupe = '&groupe'; 

DBMS_output.put_line('Il y a ' || nombre || ' étudiants dans le groupe ' || '&groupe'); 

end;


4.
SET SERVEROUTPUT ON

accept groupe prompt 'groupe : '; 

Declare 
nombre number; 
test groupes.idgroupe%type; 

begin 

select idgroupe into test
from groupes
where idgroupe = '&groupe'; 

select count(*) into nombre
from etudiants 
where idgroupe = '&groupe'; 

DBMS_output.put_line('Il y a ' || nombre || ' étudiants dans le groupe ' || '&groupe'); 

Exception 
when NO_DATA_FOUND then
DBMS_output.put_line('Il n''y a pas de groupe ' || '&groupe');

end;


5. 
SET SERVEROUTPUT ON

DECLARE
rty_etudiants etudiants%ROWTYPE; 

begin 

select * into rty_etudiants
from etudiants
where idetudiant = 'E1'; 

DBMS_output.put_line('id : ' || rty_etudiants.idEtudiant); 
DBMS_output.put_line('nom : ' || rty_etudiants.nomEtudiant);
DBMS_output.put_line('prenom : ' || rty_etudiants.prenomEtudiant);
DBMS_output.put_line('sexe : ' || rty_etudiants.sexeEtudiant);
DBMS_output.put_line('date naissance : ' || rty_etudiants.dateNaissanceEtudiant);
DBMS_output.put_line('groupe : ' || rty_etudiants.idGroupe);

end; 


6. 
CREATE or REPLACE FUNCTION nbEtudiantsParGroupe(p_idGroupe IN Groupes.idGroupe%TYPE) RETURN NUMBER IS
nombre number; 
test Groupes.idGroupe%type; 

begin 

select idGroupe into test
from groupes
where idGroupe = p_idGroupe; 

select count(idetudiant) into nombre
from etudiants
where idgroupe = p_idGroupe; 

RETURN nombre; 


exception
when NO_DATA_FOUND then 
RETURN NULL; 

end; 

/
show errors


7. 
CREATE or REPLACE function nbEtudiantsParPromotion (p_idPromotion IN Promotions.idPromotion%TYPE)
RETURN NUMBER IS 

nombre number; 

begin 

select nbEtudiantsParGroupe(idGroupe) into nombre
from Groupes g
where g.idPromotion = p_idPromotion; 

return nombre; 

end; 

/
show errors



8. 
SET SERVEROUTPUT ON

CREATE or REPLACE PROCEDURE affichageInfosEtudiant(p_idEtudiant IN Etudiants.idEtudiant%TYPE) is

rty_etudiants Etudiants%ROWTYPE; 

begin

select * into rty_etudiants
from etudiants
where idetudiant = p_idEtudiant;

DBMS_output.put_line('Identifiant étudiant : ' || rty_etudiants.idEtudiant); 
DBMS_output.put_line('Nom étudiant : ' || rty_etudiants.nomEtudiant);
DBMS_output.put_line('Prenom étudiant : ' || rty_etudiants.prenomEtudiant);
DBMS_output.put_line('Sexe étudiant : ' || rty_etudiants.sexeEtudiant);
DBMS_output.put_line('Date naissance étudiant : ' || rty_etudiants.dateNaissanceEtudiant);
DBMS_output.put_line('Groupe étudiant : ' || rty_etudiants.idGroupe);

end; 

/
show errors


call affichageInfosEtudiant('E1');


9. 
CREATE or REPLACE PROCEDURE miseAJourCoefficientModules IS

begin 

update MODULES mo
SET coefficientModule = (
	select sum(coefficientMatiere)
	from matieres m
	where mo.idmodule = m.idmodule); 
end; 

/ 
show errors



call miseAJourCoefficientModules(); 



10. 
CREATE or REPLACE procedure affichageNotesEtudiant (p_idEtudiant IN Etudiants.idEtudiant%TYPE) IS 

Cursor curs_etu IS
	select nomMatiere, note 
	from notes n 
	join matieres m on n.idmatiere = m.idmatiere
	where idEtudiant = p_idEtudiant; 

ligne curs_etu%rowtype; 

begin 
OPEN curs_etu;
FETCH curs_etu into ligne; 
while (curs_etu%FOUND) LOOP 
	DBMS_OUTPUT.put_line(ligne.nomMatiere || ' ' || ligne.note);
	FETCH curs_etu into ligne; 
END LOOP; 

CLOSE curs_etu; 

end; 

/
show errors


SET SERVEROUTPUT ON
call affichageNotesEtudiant('E1'); 


---------------------------------------------------------------------


CREATE or REPLACE procedure affichageNotesEtudiant (p_idEtudiant IN Etudiants.idEtudiant%TYPE) IS 

Cursor curs_etu IS
	select nomMatiere, note 
	from notes n 
	join matieres m on n.idmatiere = m.idmatiere
	where idEtudiant = p_idEtudiant; 

ligne notes%rowtype;

begin 

FOR ligne in curs_etu LOOP
	DBMS_OUTPUT.put_line(ligne.nomMatiere || ' ' || ligne.note);
END LOOP; 

end; 


SET SERVEROUTPUT ON
call affichageNotesEtudiant('E1'); 


---------------------------------------------------------------------


CREATE or REPLACE procedure affichageNotesEtudiant (p_idEtudiant IN Etudiants.idEtudiant%TYPE) IS 

begin 

FOR ligne in (
	select nomMatiere, note 
	from notes n 
	join matieres m on n.idmatiere = m.idmatiere
	where idEtudiant = p_idEtudiant) 
	LOOP 
		DBMS_OUTPUT.put_line(ligne.nomMatiere || ' ' || ligne.note);
END LOOP; 

end; 


SET SERVEROUTPUT ON
call affichageNotesEtudiant('E1'); 



11. 
CREATE or REPLACE PROCEDURE affichageNotesEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

begin 

FOR ligne in (
	select nomMatiere, note 
	from notes n 
	join matieres m on m.idmatiere = n.idmatiere 
	join modules mo on m.idmodule = mo.idmodule
	join Semestres s on mo.idsemestre = s.idSemestre
	where idEtudiant = p_idEtudiant and s.idsemestre = p_idSemestre) 
	LOOP
		DBMS_OUTPUT.put_line(ligne.nomMatiere || ' ' || ligne.note); 
END LOOP; 

end; 


SET SERVEROUTPUT ON 
call affichageNotesEtudiantSemestre('E1', 'S2'); 
 

---------------------------------------------------------------------


CREATE or REPLACE PROCEDURE affichageNotesEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

Cursor curseur is (
	select nomMatiere, note 
	from notes n 
	join matieres m on m.idmatiere = n.idmatiere 
	join modules mo on m.idmodule = mo.idmodule
	join Semestres s on mo.idsemestre = s.idSemestre
	where idEtudiant = p_idEtudiant and s.idsemestre = p_idSemestre); 

ligne curseur%ROWTYPE; 

begin 

OPEN curseur; 
FETCH curseur into ligne; 
while (curseur%FOUND) LOOP
	DBMS_OUTPUT.put_line(ligne.nomMatiere || ' ' || ligne.note); 
	FETCH curseur into ligne; 
END LOOP; 

CLOSE curseur; 

end; 


SET SERVEROUTPUT ON 
call affichageNotesEtudiantSemestre('E1', 'S2'); 



12. 
CREATE or REPLACE PROCEDURE affichageToutEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

rty_etudiants Etudiants%rowtype; 

begin 

select * into rty_etudiants
from Etudiants
where idEtudiant = p_idEtudiant; 

DBMS_OUTPUT.put_line('Idendifiant : ' || rty_etudiants.idEtudiant); 
DBMS_OUTPUT.put_line('Nom : ' || rty_etudiants.nomEtudiant);
DBMS_OUTPUT.put_line('Prenom : ' || rty_etudiants.prenomEtudiant);
DBMS_OUTPUT.put_line('Sexe : ' || rty_etudiants.sexeEtudiant);
DBMS_OUTPUT.put_line('Date de naissance : ' || rty_etudiants.dateNaissanceEtudiant);
DBMS_OUTPUT.put_line('Groupe : ' || rty_etudiants.idGroupe);

affichageNotesEtudiantSemestre(p_idEtudiant, p_idSemestre); 

end; 




Set SERVEROUTPUT ON
call affichageToutEtudiantSemestre('E10', 'S3');



13. 
CREATE or REPLACE PROCEDURE affichageAbsencesParPromotion(
p_idPromotion IN Promotions.idPromotion%TYPE) IS 

begin 

FOR ligne in (
	select idgroupe, nbEtudiantsParGroupe(idGroupe) as nbEtudiants 
	from groupes 
	where idpromotion = p_idPromotion
	order by 1) 
	LOOP
		DBMS_OUTPUT.put_line('Groupe : ' || ligne.idgroupe || ' (' || ligne.nbEtudiants || ' étudiants)'); 
		FOR ligne2 in (
			select nometudiant, prenomEtudiant, count(idabsence) as nbAbsences
			from etudiants e 
			left outer join absences a on e.idEtudiant = a.idEtudiant
			where idgroupe = ligne.idGroupe
			group by e.idEtudiant, nometudiant, prenomEtudiant
			order by 3 desc, 1)
			LOOP
				DBMS_OUTPUT.put_line('-----> ' || ligne2.nomEtudiant || ' ' || ligne2.prenomEtudiant || ' a été absent ' || ligne2.nbAbsences || ' fois. '); 
			
		END LOOP; 
	END LOOP; 
end; 

/
show errors


set SERVEROUTPUT on 
call affichageAbsencesParPromotion('A1'); 











TP 45

14. 
CREATE OR REPLACE FUNCTION moyenneEtudiantModule(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idModule IN Modules.idModule%TYPE) 
RETURN NUMBER IS

diviseur number; 
moyenne number; 

begin 

moyenne := 0; 
diviseur := 0; 

FOR ligne in (
	select note, coefficientMatiere
	from notes n 
	join Matieres m on n.idMatiere = m.idMatiere
	where idEtudiant = p_idEtudiant and idModule = p_idModule)
	LOOP
		moyenne := moyenne + (ligne.note * ligne.coefficientMatiere);
		diviseur := diviseur + ligne.coefficientMatiere; 
	END LOOP; 

IF (diviseur = 0) THEN 
	return NULL; 
ELSE 
	return moyenne / diviseur; 
END IF; 

end; 


/
show errors


SELECT moyenneEtudiantModule('E6', 'M112') FROM DUAL ;

------------------------------------------------------------------------------


CREATE OR REPLACE FUNCTION moyenneEtudiantModule(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idModule IN Modules.idModule%TYPE) 
RETURN NUMBER IS

totalNotes number; 

begin 
	
select sum(note * coefficientMatiere) / sum(coefficientMatiere) into totalNotes
from notes n 
join Matieres m on n.idMatiere = m.idMatiere
where idEtudiant = p_idEtudiant and idModule = p_idModule; 

return totalNotes;  

end; 

/
show errors






15. 
CREATE OR REPLACE FUNCTION valideEtudiantModule(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idModule IN Modules.idModule%TYPE)
RETURN NUMBER IS 

moyenne number; 

begin 

IF (moyenneEtudiantModule(p_idEtudiant, p_idModule) >= 8) THEN 
	return 1; 
ELSE 
	return 0;
END IF; 

end;

/
show errors



16. 
CREATE OR REPLACE FUNCTION moyenneEtudiantSemestreSansAbs (
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) 
RETURN NUMBER IS 

moyenne number; 
diviseur number; 

begin 

moyenne := 0; 
diviseur := 0; 

for ligne in (
	select moyenneEtudiantModule(p_idEtudiant, idmodule) as moyenneModule, coefficientModule
	from Modules 
	where idSemestre = p_idSemestre)
	LOOP 
		moyenne := moyenne + (ligne.moyenneModule * ligne.coefficientModule); 
		diviseur := diviseur + ligne.coefficientModule; 
	END LOOP; 

IF (diviseur = 0) THEN 
	return NULL; 
ELSE 
	return moyenne / diviseur; 
END IF; 

end; 

/ 
show errors



-------------------------------------------------------------------------------------


CREATE OR REPLACE FUNCTION moyenneEtudiantSemestreSansAbs (
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) 
RETURN NUMBER IS 

moyenne number; 

begin 

select sum(moyenneEtudiantModule(p_idEtudiant, idModule) * coefficientModule) / sum(coefficientModule) into moyenne 
from modules 
where idSemestre = p_idSemestre; 

return moyenne; 

end; 

/ 
show errors


SELECT moyenneEtudiantSemestreSansAbs('E1', 'S1') FROM DUAL ;
SELECT moyenneEtudiantSemestreSansAbs('E3', 'S2') FROM DUAL ;
SELECT moyenneEtudiantSemestreSansAbs('E3', 'S3') FROM DUAL ;



17. 
CREATE OR REPLACE PROCEDURE affichageMoyEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE, 
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 


begin 

affichageInfosEtudiant(p_idEtudiant); 

for ligneModule in (
	select nomModule, idModule
	from Modules 
	where idSemestre = p_idSemestre) 
	LOOP 
		for ligneNote in (
			select nomMatiere, note 
			from Matieres m 
			join notes n on m.idmatiere = n.idmatiere 
			where idModule = ligneModule.idModule and idEtudiant = p_idEtudiant)
			LOOP 
				DBMS_OUTPUT.put_line(ligneNote.nomMatiere || ' : ' || ligneNote.note); 
			END LOOP; 
		DBMS_OUTPUT.put_line('Moyenne module ' || ligneModule.nomModule || ' : ' || moyenneEtudiantModule(p_idEtudiant, ligneModule.idModule)); 
	END LOOP; 
DBMS_OUTPUT.put_line('Moyenne semestre sans les absences : ' || moyenneEtudiantSemestreSansAbs(p_idEtudiant, p_idSemestre)); 
end; 



CALL affichageMoyEtudiantSemestre('E10', 'S3') ;



18. 
CREATE or REPLACE FUNCTION typeAbsence (
	p_idAbsence IN Absences.idAbsence%TYPE) 
RETURN VARCHAR IS 

boolean number; 

begin 

select count(idAbsence) into boolean
from Absences a
join JustificatifsAbsences j on j.idEtudiant = a.idEtudiant
where idAbsence = p_idAbsence and dateHeureDebutAbsence <= dateFinJustificatif and dateHeureFinAbsence >= dateDebutJustificatif; 


IF (boolean = 0) then 
	return 'A'; 
ELSE 
	return 'E'; 
END IF; 

end; 

/
show errors




19. 
CREATE or REPLACE FUNCTION nbAbsencesNonJustifiees(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE, 
	p_idSemestre IN Semestres.idSemestre%TYPE)
return NUMBER IS 

nombre number := 0; 

begin 

select count(idAbsence) into nombre 
from absences a 
join etudiants e on a.idEtudiant = e.idetudiant
join Groupes g on e.idGroupe = g.idGroupe
join Promotions p on g.idPromotion = p.idPromotion
join semestres s on p.idPromotion = s.idPromotion
where e.idEtudiant = p_idEtudiant and s.idSemestre = p_idSemestre and typeAbsence(a.idAbsence) = 'A' and dateHeureDebutAbsence <= dateFinSemestre and dateHeureFinAbsence >= dateDebutSemestre; 

return nombre; 

end; 

/
show errors


SELECT nbAbsencesNonJustifiees('E22', 'S1') FROM DUAL ;
SELECT nbAbsencesNonJustifiees('E11', 'S2') FROM DUAL ;



20. 
CREATE or REPLACE FUNCTION moyenneEtudiantSemestreAvecAbs(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) 
RETURN NUMBER IS 

nbAbsences number; 

begin 

nbAbsences := nbAbsencesNonJustifiees(p_idEtudiant, p_idSemestre); 

IF (nbAbsences <= 1) THEN
	return moyenneEtudiantSemestreSansAbs(p_idEtudiant, p_idSemestre); 
ELSE 
	return moyenneEtudiantSemestreSansAbs(p_idEtudiant, p_idSemestre) - (nbAbsences * 0.1);
END IF; 

end; 

/
show errors



21. 
CREATE OR REPLACE PROCEDURE affichageAbsEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

begin 

DBMS_OUTPUT.PUT_LINE('Nombre d''absences non justifiées : ' || nbAbsencesNonJustifiees(p_idEtudiant, p_idSemestre)); 
DBMS_OUTPUT.PUT_LINE('Moyenne avec les absences : ' || moyenneEtudiantSemestreAvecAbs(p_idEtudiant, p_idSemestre)); 

end; 




22. 
CREATE OR REPLACE FUNCTION valideSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE, 
	p_idSemestre IN Semestres.idSemestre%TYPE)
RETURN VARCHAR IS 

nbModules number; 
nbModulesValides number; 

begin 

select count(idModule) into nbModules
from modules 
where idSemestre = p_idSemestre; 

select count(idModule) into nbModulesValides
from modules 
where idSemestre = p_idSemestre and valideEtudiantModule(p_idEtudiant, idModule) = 1; 

IF (moyenneEtudiantSemestreAvecAbs(p_idEtudiant, p_idSemestre) >= 10) THEN
	IF (nbModules = nbModulesValides) THEN
		return 'O'; 
	END IF; 
END IF; 

return 'N';  

end; 



23. 

CREATE or REPLACE FUNCTION classementEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) 
RETURN NUMBER IS

classement number; 
egale number; 

begin 

select count(moyenneEtudiantSemestreAvecAbs(e.idEtudiant, s.idSemestre)) into classement
from etudiants e 
join groupes g on e.idGroupe = g.idGroupe
join Promotions p on g.idPromotion = p.idPromotion
join semestres s on p.idPromotion = s.idPromotion
where s.idSemestre = p_idSemestre and 
	moyenneEtudiantSemestreAvecAbs(p_idEtudiant, p_idSemestre) <= moyenneEtudiantSemestreAvecAbs(e.idEtudiant, s.idSemestre); 

select count (moyenneEtudiantSemestreAvecAbs(e.idEtudiant, s.idSemestre)) into egale
from etudiants e 
join groupes g on e.idGroupe = g.idGroupe
join Promotions p on g.idPromotion = p.idPromotion
join semestres s on p.idPromotion = s.idPromotion
where s.idSemestre = p_idSemestre and moyenneEtudiantSemestreAvecAbs(p_idEtudiant, p_idSemestre) = moyenneEtudiantSemestreAvecAbs(e.idEtudiant, s.idSemestre); 

return classement - egale + 1; 

end; 

SELECT classementEtudiantSemestre('E10', 'S3') FROM DUAL ; -- 1
SELECT classementEtudiantSemestre('E21', 'S2') FROM DUAL ; -- 6
SELECT classementEtudiantSemestre('E10', 'S4') FROM DUAL ; -- 1
SELECT classementEtudiantSemestre('E12', 'S2') FROM DUAL ; -- 13
SELECT classementEtudiantSemestre('E17', 'S2') FROM DUAL ; -- 8






------------------------------------------------------------------------------------------



24. 
CREATE or REPLACE PROCEDURE affichageResEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

begin

DBMS_OUTPUT.PUT_LINE('Résultat : ' || valideSemestre(p_idEtudiant, p_idSemestre)); 
DBMS_OUTPUT.PUT_LINE('Classement : ' || classementEtudiantSemestre(p_idEtudiant, p_idSemestre)); 

end; 


CALL affichageResEtudiantSemestre('E10', 'S3'); 



25. 
CREATE or REPLACE PROCEDURE affichageReleveNotes(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

begin

affichageMoyEtudiantSemestre(p_idEtudiant, p_idSemestre); 
affichageAbsEtudiantSemestre(p_idEtudiant, p_idSemestre); 
affichageResEtudiantSemestre(p_idEtudiant, p_idSemestre); 

end; 



26. 
CREATE or REPLACE FUNCTION momentAbsence(p_idAbsence IN Absences.idAbsence%TYPE)
RETURN VARCHAR IS 

horaire Absences.dateHeureDebutAbsence%type; 

begin 

select dateHeureDebutAbsence into horaire
from Absences 
where idAbsence = p_idAbsence; 

IF (TO_CHAR(horaire, 'HH24') < '12') THEN
	return 'MATIN'; 
ELSE 
	return 'APREM'; 
END IF; 

end; 


27. 

CREATE or REPLACE FUNCTION nbDemiJourneesNonJustifiees(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE)
RETURN NUMBER IS 

nombre number; 

begin 

select count (distinct TO_CHAR(dateHeureDebutAbsence, 'DD/MON/YYYY') || momentabsence(idabsence)) into nombre
from absences a 
join etudiants e on a.idEtudiant = e.idetudiant
join Groupes g on e.idGroupe = g.idGroupe
join Promotions p on g.idPromotion = p.idPromotion
join semestres s on p.idPromotion = s.idPromotion
where  typeAbsence(idAbsence) = 'A' and dateHeureDebutAbsence <= dateFinSemestre and dateHeureFinAbsence >= dateDebutSemestre and e.idetudiant = p_idEtudiant and idsemestre = p_idSemestre;

return nombre; 

end; 

/
show errors


28. 
CREATE or REPLACE FUNCTION moyenneEtudiantSemestreAvecAbs(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) 
RETURN NUMBER IS 

nbAbsences number; 

begin 

nbAbsences := nbDemiJourneesNonJustifiees(p_idEtudiant, p_idSemestre); 

IF (nbAbsences <= 1) THEN
	return moyenneEtudiantSemestreSansAbs(p_idEtudiant, p_idSemestre); 
ELSE 
	return moyenneEtudiantSemestreSansAbs(p_idEtudiant, p_idSemestre) - (nbAbsences * 0.1);
END IF; 

end; 

/
show errors


29. 
CREATE OR REPLACE PROCEDURE affichageAbsEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

begin 

DBMS_OUTPUT.PUT_LINE('Nombre de demi-journées d''absence non justifiées : ' || nbDemiJourneesNonJustifiees(p_idEtudiant, p_idSemestre)); 
DBMS_OUTPUT.PUT_LINE('Moyenne avec les absences : ' || moyenneEtudiantSemestreAvecAbs(p_idEtudiant, p_idSemestre)); 

end;


30.

CALL affichageReleveNotes('E10', 'S4') ;

CALL affichageReleveNotes('E12', 'S2') ;

CALL affichageReleveNotes('E17', 'S2') ;



31. 
CREATE or REPLACE PROCEDURE affichagePV( 
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

begin 

FOR ligne IN (
	select idEtudiant, nomEtudiant, prenomEtudiant, idSemestre
	from Etudiants e 
	join Groupes g on e.idGroupe = g.idGroupe
	join Promotions p on g.idPromotion = p.idPromotion
	join semestres s on p.idPromotion = s.idPromotion
	where s.idSemestre = p_idSemestre
	order by valideSemestre(idEtudiant, p_idSemestre) desc, moyenneEtudiantSemestreAvecAbs(idEtudiant, p_idSemestre) desc)
	LOOP
		DBMS_OUTPUT.PUT(RPAD(UPPER(TRANSLATE(ligne.nomEtudiant, 'éè', 'ee')), 10) || ' ' || 
			LPAD(UPPER(TRANSLATE(ligne.prenomEtudiant, 'éè', 'ee')), 10)); 
		affichageNotesMoyModule(ligne.idEtudiant, ligne.idSemestre); 
		DBMS_OUTPUT.PUT(LPAD(moyenneEtudiantSemestreSansAbs(ligne.idEtudiant, p_idSemestre), 7)); 
		DBMS_OUTPUT.PUT(LPAD(nbAbsencesNonJustifiees(ligne.idEtudiant, p_idSemestre), 5)); 
		DBMS_OUTPUT.PUT(LPAD(moyenneEtudiantSemestreAvecAbs(ligne.idEtudiant, p_idSemestre), 7));
		DBMS_OUTPUT.PUT_LINE(LPAD(valideSemestre(ligne.idEtudiant, p_idSemestre), 5));
	END LOOP; 
end; 



CREATE or REPLACE PROCEDURE affichageNotesMoyModule (
		p_idEtudiant IN Etudiants.idEtudiant%type,
		p_idSemestre IN Semestres.idSemestre%type) IS 

begin 

FOR ligneModule in (
	select idmodule 
	from modules 
	where idSemestre = p_idSemestre)
	LOOP
		FOR ligneNote in (
			select note
			from notes n 
			join Matieres m on n.idMatiere = m.idMatiere
			where idEtudiant = p_idEtudiant and idModule = ligneModule.idModule)
			LOOP 	
				DBMS_OUTPUT.put(LPAD(ligneNote.note, 7)); 
			END LOOP; 
		DBMS_OUTPUT.put(LPAD(moyenneEtudiantModule(p_idEtudiant, ligneModule.idModule), 7)); 
	END LOOP;
end; 

/
show errors


















