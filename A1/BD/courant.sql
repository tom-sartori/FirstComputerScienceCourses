

















select nompharmacie 
from pharmacies p 
where not exists (
	select categoriemedicament
	from medicament
	minus
	select categoriemedicament
	from medicament m 
	join vendre v on m.idmedicament = v.idmedicament
	where p.idpharmacie = v.idpharmacie)











select nomauteur, prenomauteur, count(idlivre)
from auteurs a 
left outer join ecrire e on a.idauteur = e.idauteur 
group by nomauteur, prenomauteur, a.idauteur
order by 3 desc







select nomclient, prenomclient
from clients cl 
join commandes co on cl.idclient = co.idclient
join lignecommande l on co.idcommande = l.idcommande
group by nomclient, prenomclient, cl.idclient
having count(*) = (
	select max(count(*))
	from produits p
	group by p.idproduit
	)







select nomjoueur, prenomjoueur
from joueurs j 
join participer p on j.idjoueur = p.idjoueur
group by nomjoueur, prenomjoueur, j.idjoueur
having count(idtournoi) > 1








select nomtypeassurance 
from typeassurance t 
where not exists (
	select s.idsinistre
	from sinistres s
	minus
	select c.idsinistre
	from couvrir c 
	where t.idtypeassurance = c.idtypeassurance
	);








select nomtypeassurance
from typeassurance t
where not exists 
	(
		select idsinistre 
		from couvrir c1
		join typeassurance t1 on c1.idtypeassurance = t1.idtypeassurance
		where nomtypeassurance = 'Assurance Tout Risque'
	minus
		select idsinistre
		from couvrir c2 
		where c2.idtypeassurance = t.idtypeassurance
	)
	and not exists
	(
		select idsinistre
		from couvrir c2 
		where c2.idtypeassurance = t.idtypeassurance
	minus
		select idsinistre 
		from couvrir c1
		join typeassurance t1 on c1.idtypeassurance = t1.idtypeassurance
		where nomtypeassurance = 'Assurance Tout Risque'
	);









select nomacteur, prenomacteur 
from acteurs 
where sexeacteur = 'Homme' and datenaissanceacteur = (
	select max(datenaissanceacteur)
	from acteurs
	where sexeacteur = 'Homme'
	);









select nomeleve, prenomeleve
from eleves e
where not exists (
	select *
	from noter n 
	join matieres m on n.idmatiere = m.idmatiere 
	where nommatiere = 'BD' and e.ideleve = n.ideleve
	);














create or replace view ClientsEtEmprunts (idclient, nomclient, prenomclient, datenaissanceclient, nbEmprunts) as 
	select idclient, nomclient, prenomclient, datenaissanceclient, count(idemprunt)
	from clients c
	left outer join emprunts e on c.idclient = e.idclient






select count(idclient) as "nb clients sans emprunts"
from ClientsEtEmprunts
where nbEmprunts = 0













































