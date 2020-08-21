1. 
Ecrire un bloc PL/SQL qui, grâce au paquetage DBMS_OUTPUT, affiche le nombre
d’étudiants qui se trouvent dans le groupe qui a pour identifiant ‘Q1’.

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
En s’inspirant du bloc PL/SQL écrit lors de la question précédente, écrire un nouveau 
bloc qui affiche le nombre d’étudiants d’un groupe dont l’identifiant a été saisi au 
clavier.
Pour cela on utilisera les variables de substitution vues en cours. On rappelle qu’à 
l’intérieur du BEGIN ... END, les variables de substitution qui font référence à une 
chaîne de caractères doivent être encadrées par des ‘quotes’. Par exemple, '&s_idGroupe'

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


3. 
Dans la question précédente il y a un léger problème. En effet, si l’utilisateur 
saisit un identifiant d’un groupe qui n’existe pas (par exemple le Q5), il est indiqué 
qu’il y a 0 étudiant dans le groupe en question. Et on aurait eu la même réponse si on 
avait saisi l’identifiant d’un groupe qui existe bien mais qui n’a aucun étudiant 
affecté (le Q4).
En s’inspirant du bloc PL/SQL écrit lors de la question précédente, écrire un nouveau 
bloc qui indiquerait le cas échéant qu’aucun groupe ne possède l’identifiant qui a 
été saisi au clavier.
Pour cela, vous utiliserez la structure de contrôle (IF ... THEN ... ELSE ... END IF)



4. Ecrire un nouveau bloc PL/SQL qui fait exactement la même chose que la question 
précédente mais en utilisant cette fois-ci la section EXCEPTION à la place de la 
structure de contrôle IF.
On pourra utiliser l’exception prédéfinie NO_DATA_FOUND qui est levée automatiquement 
lorsque une requête SELECT ... INTO ne retourne rien (il est à noter que si la requête 
retourne plusieurs lignes, c’est alors l’exception TOO_MANY_ROWS qui est levée).

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


5. Ecrire un bloc PL/SQL qui permet d’afficher toutes les informations nominatives de 
la table Etudiants qui concernent l’étudiant E1.
Pour se simplifier la tâche, et pour faciliter les éventuelles futures maintenances 
de l’application, on récupèrera les données qui concernent l’étudiant E1 dans une 
variable %ROWTYPE.

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
En vous inspirant de ce que vous avez écrit lors des questions 3 ou 4, écrire une 
fonction stockée nbEtudiantsParGroupe qui retourne le nombre d’étudiants qui 
appartiennent au groupe dont l’identifiant p_idGroupe est passé en paramètre. 
Cette fonction doit avoir la signature suivante :
FUNCTION nbEtudiantsParGroupe(p_idGroupe IN Groupes.idGroupe%TYPE) RETURN NUMBER
Si on passe en paramètre de cette fonction un identifiant de groupe qui n’existe 
pas, on souhaite que la fonction retourne NULL (et non pas 0).
Si lors de la création de votre fonction, vous avez une erreur de compilation 
(Warning: Function created with compilation errors) vous pouvez demander à Oracle 
de vous afficher la liste des erreurs grâce à l’instruction SHOW ERRORS.
On rappelle que sous Oracle, pour tester une fonction stockée, on peut utiliser 
la pseudo-table DUAL.

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
Ecrire une fonction stockée nbEtudiantsParPromotion qui retourne le nombre 
d’étudiants qui appartiennent à une promotion dont l’identifiant p_idPromotion est
passé en paramètre. Cette fonction doit avoir la signature suivante :
FUNCTION nbEtudiantsParPromotion(
p_idPromotion IN Promotions.idPromotion%TYPE)
RETURN NUMBER
Dans le corps de cette fonction, on pourra appeler la fonction qui a été 
réalisée à la question précédente (nbEtudiantsParGroupe). Cette fonction pourra 
être appelée dans le SELECT d’une requête !
On ne vous demande pas de gérer explicitement le cas où l’identifiant de promotion 
qui est passé en paramètre n’existe pas, ou bien le cas où la promotion existe mais 
qu’elle n’a pas de groupe (dans ces cas là, votre fonction devrait retourner NULL 
par défaut sans que vous soyez obligé de le programmer).

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
En vous inspirant de ce que vous avez écrit lors de la question 5, écrire une 
procédure stockée affichageInfosEtudiant qui affiche toutes les informations 
nominatives qui concernent l’étudiant dont l’identifiant p_idEtudiant est passé 
en paramètre. Cette procédure doit avoir la signature suivante :
PROCEDURE affichageInfosEtudiant(
p_idEtudiant IN Etudiants.idEtudiant%TYPE)
On rappelle que sous Oracle, on peut appeler une procédure stockée avec 
l’instruction CALL.

SET SERVEROUTPUT ON

CREATE or REPLACE PROCEDURE affichageInfosEtudiant(p_idEtudiant IN Etudiants.idEtudiant%TYPE) is

rty_etudiants Etudiants%ROWTYPE; 

begin

select * into rty_etudiants
from etudiants
where idetudiant = p_idEtudiant;

DBMS_output.put_line('id : ' || rty_etudiants.idEtudiant); 
DBMS_output.put_line('nom : ' || rty_etudiants.nomEtudiant);
DBMS_output.put_line('prenom : ' || rty_etudiants.prenomEtudiant);
DBMS_output.put_line('sexe : ' || rty_etudiants.sexeEtudiant);
DBMS_output.put_line('date naissance : ' || rty_etudiants.dateNaissanceEtudiant);
DBMS_output.put_line('groupe : ' || rty_etudiants.idGroupe);

end; 

/
show errors


call affichageInfosEtudiant('E1');


9. 
Ecrireuneprocédurestockéequimetàjourl’attributcoefficientModuledetoutes les 
lignes de la table Modules. Le coefficient d’un module doit être égal à la somme 
des coefficients des matières qui sont incluses dans le module. Cette procédure 
doit avoir la signature suivante :
     PROCEDURE miseAJourCoefficientModules

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
Ecrire une procédure stockée affichageNotesEtudiant qui affiche toutes les notes 
obtenues par un étudiant dont l’identifiant p_idEtudiant est passé en
paramètre. Cette procédure doit avoir la signature suivante :
PROCEDURE affichageNotesEtudiant(
p_idEtudiant IN Etudiants.idEtudiant%TYPE)

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


ou


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


ou


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
En vous inspirant de ce que vous avez fait à la question précédente, écrire une 
procédure stockée affichageNotesEtudiantSemestre qui affiche toutes les notes 
obtenues par un étudiant p_idEtudiant au cours du semestre p_idSemestre donnés en 
paramètre. Cette procédure doit avoir la signature suivante :
PROCEDURE affichageNotesEtudiantSemestre(
p_idEtudiant IN Etudiants.idEtudiant%TYPE,
p_idSemestre IN Semestres.idSemestre%TYPE)

SET SERVEROUTPUT ON 
call affichageNotesEtudiantSemestre('E1', 'S2'); 




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






















































