TP45 



14. 
-- Sans curseur 

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


-- Avec curseur

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



16. 

-- Sans curseur 

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


-- Avec curseur

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



24. 

CREATE or REPLACE PROCEDURE affichageResEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

begin

DBMS_OUTPUT.PUT_LINE('Résultat : ' || valideSemestre(p_idEtudiant, p_idSemestre)); 
DBMS_OUTPUT.PUT_LINE('Classement : ' || classementEtudiantSemestre(p_idEtudiant, p_idSemestre)); 

end; 



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



29. 

CREATE OR REPLACE PROCEDURE affichageAbsEtudiantSemestre(
	p_idEtudiant IN Etudiants.idEtudiant%TYPE,
	p_idSemestre IN Semestres.idSemestre%TYPE) IS 

begin 

DBMS_OUTPUT.PUT_LINE('Nombre de demi-journées d''absence non justifiées : ' || nbDemiJourneesNonJustifiees(p_idEtudiant, p_idSemestre)); 
DBMS_OUTPUT.PUT_LINE('Moyenne avec les absences : ' || moyenneEtudiantSemestreAvecAbs(p_idEtudiant, p_idSemestre)); 

end;



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
