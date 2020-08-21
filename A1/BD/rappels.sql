Date (en juillet) : 
datedebut<='31/07/2017' and datefin>='01/07/2017'

Nombre de fois dans quelque chose (ex : campings)
Pas oublier distinct 

Ordre lexicographique
Order by nom, prenom

Pour chacun d une table par rapport à une autre 
Left Outer Join

Dernier client 
datefin = (select max(datefin))

Au moins n jours
where (datefin - datedebut) > n); 

L un ou l autre mais pas les deux 
select avec or puis minus intersect

"tous" = division

order by 3 desc[1, 2, 3] asc[3, 2, 1]

select count(truc) as "nb truc"