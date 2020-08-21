http://orainfo.iutmontp.univ-montp2.fr:5560/isqlplus/login.uix

R11: 	select nomemploye, prenomemploye 
	from employes
	where salaireemploye > 2000

R12 : 	select nomcamping 
	from campings
	where villecamping = 'Palavas' and nbetoilescamping = 5

R13 : 	select nomemploye, prenomemploye 
	from employes e join campings c on e.idcamping = c.idcamping 
	where nomcamping = 'Les Flots Bleus'
	order by salaireemploye

R14 : 	select nomemploye, prenomemploye 
	from employes 
	where idemployechef in (
		select idemploye 
		from employes
		where nomemploye = 'Alizan' and prenomemploye = 'Gaspard')

R15 : 	select nomclient, prenomclient
	from clients c
	join locations l on c.idclient = l.idclient 
	join bungalows b on l.idbungalow = b.idbungalow
	join campings on b.idcamping = campings.idcamping 
	where nomcamping = 'Les Flots Bleus' and dateDebut < '14/07/2017' and dateFin > '14/07/2017'


R16 : le nom et le prénom des clients qui ont été dans le camping ‘Les Flots Bleus’ en juillet 2017.	
select distinct nomclient, prenomclient 
from clients c 
join locations l on c.idclient = l.idclient 
join bungalows b on l.idbungalow = b.idbungalow 
join campings on b.idcamping = campings.idcamping  
where nomcamping = 'Les Flots Bleus' and datedebut <= '31/07/2017' and datefin >= '01/07/2017'


R17 :	le nom et le prénom des clients qui habitent dans une ville où il y a un camping.
select distinct nomclient, prenomclient 
from clients  
where villeclient in (
	select villecamping
	from campings)
 

R18 : le nombre de services proposés par le bungalow ‘Le Titanic’.	
select count (p.idservice) 
from proposer p
join bungalows b on p.idbungalow = b.idbungalow 
where nombungalow = 'Le Titanic'


R19 : le salaire de l’employé le mieux payé du camping ‘Les Flots Bleus’.
select max (salaireemploye) 
from employes e join campings c on e.idcamping = c.idcamping
where nomcamping='Les Flots Bleus'


R20 : le nombre de campings dans lesquels la cliente Agathe Zeblouse a séjourné.
select count (distinct c.idcamping) as nb_Campings
from campings c 
join bungalows b on c.idcamping = b.idcamping 
join locations l on b.idbungalow = l.idbungalow 
join clients on  l.idclient = clients.idclient
where nomclient = 'Zeblouse' and prenomclient = 'Agathe'


R21 : le nom du plus grand bungalow.
select nombungalow 
from bungalows
where superficiebungalow = 
	(select max (superficiebungalow)
	from bungalows)


R22 : le nom et prénom de l’employé le plus mal payé du camping ‘Les Flots Bleus’.
select nomemploye, prenomemploye 
from employes e
join campings c on e.idcamping = c.idcamping 
where nomcamping = 'Les Flots Bleus' and salaireemploye in (
	select min(salaireemploye)
	from employes e
	join campings c on e.idcamping = c.idcamping 
	where nomcamping = 'Les Flots Bleus')


R23 : le nom des bungalows qui ne proposent pas de service.
select nombungalow 
from bungalows 
where idbungalow in (
	(select idbungalow 
	from bungalows)
	minus 
	(select idbungalow 
	from proposer))


R24 : le nom et prénom des employés qui n’ont pas de subordonné.
select nomemploye, prenomemploye 
from employes 
where idemploye in ((
	select idemploye
	from employes )
	minus 
	(select idemployechef		
	from employes))


R25 :	(bug) le nom des bungalows qui ne proposent ni le service ‘Climatisation’ ni le service ‘TV’	
select nombungalow 
from bungalows b join proposer p on b.idbungalow = p.idbungalow 
join services s on p.idservice = s.idservice 
where nomservice not in 
	(select nomservice
	from services
	where nomservice = 'Climatisation' )
	intersect
	(select nomservice
	from services
	where nomservice = 'TV' )


R26 : le nom des services qui sont proposés dans le camping ‘La Décharge Monochrome’ et 
qui sont également proposés dans le camping ‘The White Majestic’.
select nomservice 
from services 
where idservice in (
	(select s.idservice 
	from services s 
	join proposer p on s.idservice = p.idservice 
	join bungalows b on p.idbungalow = b.idbungalow 
	join campings c on b.idcamping = c.idcamping
	where nomcamping = 'La Décharge Monochrome')
	intersect 
	(select s.idservice 
	from services s 
	join proposer p on s.idservice = p.idservice 
	join bungalows b on p.idbungalow = b.idbungalow 
	join campings c on b.idcamping = c.idcamping 
	where nomcamping ='The White Majestic')); 


R27 : le nom et le prénom des clients qui ont effectué une location (au moins) dans le camping 
The White Majestic’ ou une location (au moins) dans le camping ‘La Décharge Monochrome’. 
Les clients doivent être classés dans l’ordre lexicographique de leur nom (et de leur prénom 
s’ils ont le même nom)

select nomclient, prenomclient
from clients 
where idclient in ((
	select c.idclient 
	from clients c
	join locations l on c.idclient = l.idclient 
	join bungalows b on l.idbungalow = b.idbungalow 
	join campings ca on b.idcamping = ca.idcamping 
	where nomcamping = 'The White Majestic')
union
	(select c.idclient 
	from clients c
	join locations l on c.idclient = l.idclient 
	join bungalows b on l.idbungalow = b.idbungalow 
	join campings ca on b.idcamping = ca.idcamping 
	where nomcamping = 'La Décharge Monochrome'))
order by nomclient, prenomclient


R28 :	pour chacun des employés de la table Employés, le nom, le prénom de l’employé ainsi 
que le nom du camping dans lequel il travaille. Les employés doivent être classés par ordre 
lexicographique de leur nom.

select nomemploye, prenomemploye, nomcamping
from employes e 
left outer join campings c on e.idcamping = c.idcamping 
order by nomemploye, prenomemploye
 

R29 : le nom et le prénom des clients qui ont pu croiser Judas Bricot dans un camping (c est à dire que pendant 
au moins une journée, ils ont eu une location dans le même camping que Judas Bricot).

select distinct cx.nomclient, cx.prenomclient 
from clients cx
join locations lx on cx.idclient = lx.idclient 
join bungalows bx on lx.idbungalow = bx.idbungalow 
join bungalows bb on bb.idcamping = bx.idcamping
join locations lb on lb.idbungalow = bb.idbungalow 
join clients cb on cb.idclient = lb.idclient 
where cb.nomclient = 'Bricot' and cb.prenomclient = 'Judas' and lb.datedebut <= lx.datefin 		and lb.datefin >= lx.datedebut and cx.idclient != cb.idclient 



R30 : le nom des bungalows qui n’ont jamais été loués.
select nombungalow
from bungalows 
where idbungalow not in (
	select idbungalow
	from locations)

ou 

select nombungalow
from bungalows 
where idbungalow in (
	(select idbungalow
	from bungalows)
	minus
	(select idbungalow
	from locations )); 

ou 

select nombungalow
from bungalows b 
where not exists (
	select *
	from locations l
	where b.idbungalow = l.idbungalow)


R31 : le nom des campings qui n’ont pas d’employé.
select c.nomcamping
from campings c
where not exists (
	select * 
	from employes e
	where e.idcamping = c.idcamping)

ou 

select c.nomcamping
from campings c
where c.idcamping in (
	(select idcamping
	from campings)
	minus 
	(select idcamping 
	from employes));

ou 

select c.nomcamping
from campings c
where c.idcamping not in (
	select e.idcamping 
	from employes e
	where c.idcamping = e.idcamping); 


R32 : le nom des services qui sont dans la catégorie Loisir ou bien qui ne sont proposés dans 
aucun bungalow du camping ‘The White Majestic’.
select nomservice 
from services  
where idservice in ((
	select idservice 
	from services 
	where categorieservice = 'Loisir')
	union 
	(select idservice
	from services
	where idservice not in ( 
		select s.idservice
		from services s
		join proposer p on s.idservice = p.idservice
		join bungalows b on p.idbungalow = b.idbungalow 
		join campings c on b.idcamping = c.idcamping
		where c.nomcamping = 'The White Majestic'))); 


R33 : le nom des clients qui n’ont réalisé que des locations dans des bungalows de plus de 58m2.
select nomclient
from clients cl
join locations lo on cl.idclient = lo.idclient
where cl.idclient not  in (
	select c.idclient 
	from clients c
	join locations l on c.idclient = l.idclient 
	join bungalows b on l.idbungalow = b.idbungalow 
	where b.superficiebungalow <= 58); 

ou 

select nomclient
from clients c
join locations l on c.idclient = l.idclient
where not exists (
	select *
	from bungalows b
	join locations l on b.idbungalow = l.idbungalow
	where b.superficiebungalow <= 58
	and c.idclient = l.idclient); 


R34 : le nom des clients montpelliérains qui n’ont jamais réalisé de location dans un 
bungalow qui ne propose pas de service.
select c.nomclient 
from clients c 
where c.villeclient = 'Montpellier' and not exists (
	select * 
	from bungalows b
	join locations l on b.idbungalow = l.idbungalow
	where c.idclient = l.idclient and b.idbungalow not in (
		select idbungalow 
		from proposer));


R40 : l’identifiant, le nom et le prénom des clients qui ont réalisé une location 
(au moins) dans un camping qui se trouve dans la ville où ils habitent.

select distinct c.idclient, nomclient, prenomclient 
from clients c 
join locations l on c.idclient = l.idclient 
join bungalows b on l.idbungalow = b.idbungalow 
join campings ca on b.idcamping = ca.idcamping
where villeclient = villecamping


R41 : le nom des employés qui ne sont pas affectés à un camping.
select nomemploye
from employes e
where not exists (
	select * 
	from campings c 
	where e.idcamping = c.idcamping); 


R42 : le nombre de bungalows du camping ‘La Décharge Monochrome’ qui ont été loués par 
le client Agathe Zeblouse.
select count (distinct b.idbungalow) as "Nb bungalows loués par Agathe"
from bungalows b 
join campings c on b.idcamping = c.idcamping 
join locations l on b.idbungalow = l.idbungalow 
join clients cl on l.idclient = cl.idclient 
where nomcamping = 'La Décharge Monochrome' and nomclient = 'Zeblouse' and prenomclient = 'Agathe'


R43 : le nom et prénom des clients qui n’ont jamais réalisé de location dans le camping ‘Les Flots Bleus’.
select nomclient, prenomclient 
from clients cl 
where not exists (
	select * 
	from campings c
	join bungalows b on c.idcamping = b.idcamping 
	join locations l on b.idbungalow = l.idbungalow 
	where nomcamping = 'Les Flots Bleus' and cl.idclient = l.idclient);


R44 : le nom et le prénom des employés dont un des subordonnés (au moins) possède 
lui même un ou plusieurs subordonnés.
select nomemploye, prenomemploye 
from employes 
where idemploye in (
	select idemployechef
	from employes
	where idemploye in (
		select idemployechef
		from employes)); 


R45 : le numéro de la location du camping ‘The White Majestic’ qui a duré le plus de temps.
select idlocation 
from locations l
join bungalows b on l.idbungalow = b.idbungalow
join campings c on b.idcamping = b.idcamping 
where nomcamping='The White Majestic' and (datefin - datedebut) =
	(select max(datefin - datedebut) 
	from locations l
	join bungalows b on l.idbungalow = b.idbungalow
	join campings c on b.idcamping = b.idcamping 
	where nomcamping='The White Majestic')


R46 : les villes dans lesquelles résident des clients mais où il n’y a pas de camping.
select distinct villeclient
from clients
where villeclient not in (
	select villecamping 
	from campings); 

ou 

select distinct villeclient
from clients cl
where not exists (
select * 
from campings c
where cl.villeclient = c.villecamping); 


R47 : le nom et le prénom du dernier client qui a loué le bungalow ‘La Poubelle’.
select nomclient, prenomclient 
from clients 
where idclient in (
	select c.idclient 
	from clients c 
	join locations l on c.idclient = l.idclient 
	join bungalows b on l.idbungalow = b.idbungalow
	where nombungalow = 'La Poubelle' 
	and datefin = (
		select max (datefin)
		from locations loc 
		join bungalows bun on loc.idbungalow = bun.idbungalow
		where nombungalow = 'La Poubelle')); 

ou

select nomclient, prenomclient 
from clients c 
join locations l on c.idclient = l.idclient 
and datefin = (
	select max (datefin)
	from locations loc 
	join bungalows bun on loc.idbungalow = bun.idbungalow
	where nombungalow = 'La Poubelle'); 


R48 : le nom et le prénom des clients pour lesquels toutes les locations ont duré au moins 10 jours.
select nomclient, prenomclient
from clients 
where idclient in (
	select c.idclient 
	from clients c 
	join locations l on c.idclient = l.idclient 
	where (datefin - datedebut) > 10); 


R49 : le nom et le prénom des clients qui ont effectué une location (au moins) dans le 
camping ‘Les Flots Bleus’ ou une location (au moins) dans le camping ‘La Décharge Monochrome’ 
mais pas dans les deux.

select nomclient, prenomclient 
from clients
where idclient in ((
	select c1.idclient 
	from clients c1 
	join locations l1 on c1.idclient = l1.idclient 
	join bungalows b1 on l1.idbungalow = b1.idbungalow 
	join campings ca1 on b1.idcamping = ca1.idcamping
	where ca1.nomcamping = 'La Décharge Monochrome' or ca1.nomcamping = 'Les Flots Bleus')
	
	minus 
	
	(select idclient 
	from clients
	where idclient in((
		select c2.idclient 
		from clients c2
		join  locations l2 on c2.idclient = l2.idclient 
		join bungalows b2 on l2.idbungalow = l2.idbungalow 
		join campings ca2 on b2.idcamping = ca2.idcamping
		where ca2.nomcamping = 'Les Flots Bleus')
		
		intersect 
		
		(select c3.idclient 
		from clients c3 
		join locations l3 on c3.idclient = l3.idclient 
		join bungalows b3 on l3.idbungalow = b3.idbungalow 
		join campings ca3 on b3.idcamping = ca3.idcamping
		where ca3.nomcamping = 'La Décharge Monochrome')))); 


R5A : pour chaque catégorie de service, le nombre de services.
select categorieservice, count(idservice)
from services
group by categorieservice


R5B : le nom des villes pour lesquelles on a au moins trois clients.
select villeclient 
from clients 
group by villeclient
having count (idclient) >= 3


R50 : pour chacun des clients qui a réalisé au moins une location, indiquer son nom, son prénom et 
le nombre de ses locations (les clients doivent être classées par ordre décroissant du nombre de 
locations). Il n’est pas demandé de faire apparaître les clients qui n’ont pas réalisé de location.

select nomclient, prenomclient, count(idlocation) as "Nb Locations"
from clients c 
join locations l on c.idclient = l.idclient
group by nomclient, prenomclient, c.idclient
order by 3 desc


R51 : pour chacun des campings pour lesquels on a au moins un employé, indiquer le salaire moyen 
des employés qui travaillent dans le camping.

select nomcamping, avg(salaireemploye) as "Salaire moyen"
from campings c
join employes e on e.idcamping = c.idcamping 
group by nomcamping


R52 : le nom des campings qui possèdent plus de 3 employés.
select nomcamping
from campings c
join employes e on c.idcamping = e.idcamping 
group by c.idcamping, nomcamping
having count(idemploye) >3


R53 : le nom des campings dont le salaire moyen des employés est supérieur à 1 400€.
select nomcamping
from campings c
join employes e on c.idcamping = e.idcamping 
group by c.idcamping, nomcamping
having avg(salaireemploye) > 1400


R54 : la liste des campings, classés par rapport au nombre de bungalows de moins de 
le nom des campings où tous les employés ont un salaire supérieur ou égal à 1 000 €.le nom des 
campings où tous les employés ont un salaire supérieur ou égal à 1 000 €.le nom des campings 
où tous les employés ont un salaire supérieur ou égal à 1 000 €.le nom des campings où tous 
les employés ont un salaire supérieur ou égal à 1 000 €.65 m2 qu’ils possèdent (de celui qui 
en a le moins à celui qui en a le plus).

select nomcamping
from campings c 
join bungalows b on c.idcamping = b.idcamping 
where superficiebungalow < 65
group by nomcamping, c.idcamping
order by count(idbungalow) asc


R55 : le nom des campings où tous les employés ont un salaire supérieur ou égal à 1 000 €.
select distinct nomcamping 
from campings c 
join employes e on c.idcamping = e.idcamping
where not exists (
	select * 
	from employes e1 
	where c.idcamping = e1.idcamping and salaireemploye < 1000)


R56 : le nom des bungalows qui proposent le même nombre de services que le bungalow qui se 
nomme ‘Le Royal’ (il n’y a qu’un seul Bungalow ‘Le Royal’).
select nombungalow
from bungalows b
join proposer p on b.idbungalow = p.idbungalow
group by nombungalow 
having count(idservice) = (
	select count (idservice)
	from proposer p1 
	join bungalows b1 on p1.idbungalow = b1.idbungalow
	where nombungalow = 'Le Royal')


R57 : le nombre de services proposés par chacun des bungalows ; on veut également afficher 
les bungalows qui ne proposent pas de service. Les bungalows doivent être classés par rapport 
au nombre de services proposés.

select nombungalow, count (idservice) 
from bungalows b
left outer join proposer p  on b.idbungalow = p.idbungalow 
group by nombungalow, b.idbungalow
order by count(idservice) desc


R58 : le nom de bungalow – avec le nom du camping dans lequel il se trouve – de tous les 
bungalows qui ont été loués plus de deux fois en juin 2017.

select nombungalow, c.nomcamping
from bungalows b 
join campings c on b.idcamping = c.idcamping
join locations l on b.idbungalow = l.idbungalow
where datedebut <= '30/06/2017' and datefin >= '01/06/2017'
group by nombungalow, nomcamping
having count (b.idbungalow) > 2


R59 : le bungalow qui propose le plus de services.
SELECT nomBungalow
FROM Bungalows b
JOIN Proposer p ON b.idBungalow = p.idBungalow
GROUP BY b.idBungalow, nomBungalow
HAVING COUNT(*) = (
	SELECT MAX(COUNT(*))
	FROM Proposer p
	GROUP BY idBungalow);


R60 : le nom des bungalows qui n’ont pas été loués en aout 2017.
select distinct nombungalow
from bungalows 
where idbungalow in (
	(select idbungalow 
	from bungalows)
	minus
	(select b.idbungalow 
	from bungalows b
	join locations l on b.idbungalow = l.idbungalow
	where datedebut <= '31/08/2017' and datefin >= '01/08/2017')); 

ou 

select nombungalow
from bungalows b
where not exists (
	select * 
	from locations l 
	where datedebut <= '31/08/2017' and datefin >= '01/08/2017' and l.idbungalow = b.idbungalow)


R61 : pour chacun des campings où il y a des employés, indiquer le nom et le prénom de l’employé 
le mieux payé.
select nomcamping, nomemploye, prenomemploye
from campings c 
join employes e on c.idcamping = e.idcamping 
where (salaireemploye, c.idcamping) in (
	select max(salaireemploye), idcamping 
	from employes 
	group by idcamping)



R70 : le nom des bungalows qui proposent tous les services (c''est-à-dire tous les services qui 
sont dans la table Services).
select nombungalow 
from bungalows b
join proposer p on b.idbungalow = p.idbungalow 
group by nombungalow
having count (idservice) in (
	select count(idservice)
	from services)

ou 

select nombungalow 
from bungalows b
where not exists (
	(select idservice 
	from services)
	minus
	(select p1.idservice 
	from proposer p1 
	where p1.idbungalow = b.idbungalow)); 


R71 : le nom des bungalows qui proposent tous les services de la catégorie ‘Luxe’.
select nombungalow 
from bungalows b 
join proposer p on b.idbungalow = p.idbungalow 
join services s on p.idservice = s.idservice
where categorieservice = 'Luxe'
group by b.idbungalow, nombungalow 
having count (s.idservice) in 
	(select count(idservice )
	from services 
	where categorieservice like 'Luxe');

ou

select nombungalow 
from bungalows b 
where not exists (
	(select idservice 
	from services 
	where categorieservice = 'Luxe')
	minus
	(select idservice 
	from proposer p 
	where p.idbungalow = b.idbungalow))


R72 : e nom des bungalows qui proposent tous les services proposés par le bungalow qui se 
nomme ‘La Poubelle’.
select nombungalow 
from bungalows b 
where not exists (
	(select idservice 
	from proposer p1
	join bungalows b1 on p1.idbungalow = b1.idbungalow 
	where nombungalow = 'La Poubelle') 
	minus 
	(select idservice 
	from proposer p2
	where p2.idbungalow = b.idbungalow)); 


R73 : le nom des clients qui ont réalisé au moins une location dans toutes les villes pour 
lesquelles il y a des campings.
select nomclient 
from clients c
where not exists (
	(select villecamping 
	from campings )
	minus 
	(select villecamping 
	from locations l 
	join bungalows b on l.idbungalow = b.idbungalow 
	join campings c1 on b.idcamping = c1.idcamping
	where l.idclient = c.idclient)); 


R74 : le nom des clients qui ont loué tous les bungalows loués par la cliente Agathe Zeblouse.
select nomclient 
from clients cli
where not exists(
	(select b.idbungalow
	from bungalows b 
	join locations l on b.idbungalow = l.idbungalow 
	join clients c on l.idclient = c.idclient 
	where nomclient = 'Zeblouse' and prenomclient = 'Agathe')
	minus
	(select b1.idbungalow 
	from bungalows b1
	join locations l1 on b1.idbungalow = l1.idbungalow 
	where l1.idclient = cli.idclient));


R75 : le nom et le prénom des clients qui ont sont allés exactement dans les mêmes campings 
que la cliente Agathe Zeblouse.

select nomclient, prenomclient
from clients c
where not exists 
		(
		select c1.idcamping 
		from campings c1
		join bungalows b1 on c1.idcamping = b1.idcamping
		join locations l1 on b1.idbungalow = l1.idBungalow
		join clients cl1 on l1.idclient = cl1.idclient 
		where nomclient = 'Zeblouse' and prenomclient = 'Agathe'
	minus 
		select c2.idcamping 
		from campings c2
		join bungalows b2 on c2.idcamping = b2.idcamping
		join locations l2 on b2.idbungalow = l2.idBungalow
		where l2.idclient = c.idclient
		)
	and not exists 
		(
		select c3.idcamping 
		from campings c3
		join bungalows b3 on c3.idcamping = b3.idcamping
		join locations l3 on b3.idbungalow = l3.idBungalow
		where l3.idclient = c.idclient
	minus 
		select c4.idcamping 
		from campings c4
		join bungalows b4 on c4.idcamping = b4.idcamping
		join locations l4 on b4.idbungalow = l4.idBungalow
		join clients cl4 on l4.idclient = cl4.idclient 
		where nomclient = 'Zeblouse' and prenomclient = 'Agathe'
		)



R82 : le nom des services proposés par le bungalow le plus grand du camping ‘Les Flots Bleus’.
select nomservice 
from services s 
join proposer p on s.idservice = p.idservice
join bungalows b on p.idbungalow = b.idbungalow 
join campings c on b.idcamping = c.idcamping
where nomcamping = 'Les Flots Bleus' and superficiebungalow = 
	(select max (superficiebungalow) 
	from bungalows b1 
	join campings c1 on b1.idcamping = c1.idcamping 
	where nomcamping = 'Les Flots Bleus')



/////

TP6 : Vues

/////

R01 : 
create or replace view BungalowsLFB as
select idbungalow, nombungalow, superficiebungalow
from bungalows b
join campings c 
on b.idcamping = c.idcamping
where nomcamping='Les Flots Bleus'

select *
from Bungalowslfb

select count(*) as "NB Bungalows"
from bungalowslfb

R02 : 
create or replace view LocationsLFB as
select idlocation, c.idclient, nomclient, prenomclient, b.idbungalow, nombungalow
from bungalowslfb b
join locations l on b.idbungalow = l.idbungalow 
join clients c on l.idclient = c.idclient

select *
from locationslfb









Partie 6

create or replace view bungalowsetcampings (idB, nomB, superficie, idC, nomC) as 
select idbungalow, nombungalow, superficiebungalow, c.idcamping, nomcamping 
from bungalows b 
join campings c on b.idcamping = c.idcamping


select *
from bungalowsetcampings


update bungalowsetcampings 
set superficie =100
where idb='B2'



Partie 7 : 


create or replace view campingspalavas (id, nom, ville, etoiles) as
select idcamping, nomcamping, villecamping, nbetoilescamping
from campings
where villecamping='Palavas'
with check option [with read only]

select * 
from campingspalavas


insert into campingspalavas values ('CAMP9','Pas Top','Palavas',2)
insert into campingspalavas values ('CAMP8','Pas Top2','Mulhouse',2)




Partie 8 : 


grant select 
on clients
to public

select *
from paysj.clients


insert into clients values ('C20', 'Onette', 'Camille', 'Mulhouse')

commit

create synonym clientsjordan
for paysj.clients


revoke select 
on clients from public







create or replace view clientsmontpellierains as
select * 
from clients
where villeclient = 'Montpellier'
with check option

grant insert(idclient, nomclient, prenomclient, villeclient), select
on clientsmontpellierains 
to paysj




create or replace view locJuillet as
select l.idlocation, c.idclient, nomclient, prenomclient, b.idbungalow, nombungalow, nomcamping, datedebut, datefin, montantlocation
from locations l 
join clients c on l.idclient = c.idclient
join bungalows b on l.idbungalow = b.idbungalow 
join campings ca on b.idcamping = ca.idcamping
where datedebut <= '31/07/2017' and datefin >= '01/07/2017'
with check option




grant insert, select
on locjuillet
to paysj 
with grant option


insert into sartorit.locjuillet values
('L20','C20','Onette','Camille','B2','Le Palace','Les Flots Bleus','05/07/2017','10/07/2017',854)






R22 : 
Create or replace view employeslfb as
select idemploye, nomemploye, prenomemploye, salaireemploye
from employes e 
join campings c on e.idcamping = c.idcamping
where nomcamping = 'Les Flots Bleus'


select nomemploye, prenomemploye
from employeslfb
where salaireemploye = (
select min(salaireemploye)
from employeslfb)



R87 : 
create or replace view employesparcamping(nomCamping, nbEmployes) as 
select nomcamping, count(idemploye) 
from campings c 
left outer join employes e on c.idcamping = e.idcamping 
group by c.idcamping, nomcamping 


select * 
from employesparcamping
where nbemployes = (
	select max(nbemployes)
	from employesparcamping)


R 87B : 

select * 
from employesparcamping
where nbemployes = (
	select min(nbemployes)
	from employesparcamping)










































































