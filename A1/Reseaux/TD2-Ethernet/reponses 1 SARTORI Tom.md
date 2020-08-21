TD2 - Ethernet

[Bonjour, j'ai trouvé ainsi que certains membres de la classe, ce tp assez difficile. Sans avoir eu le cours d'amphi avant, il est très difficile de suivre, et même du coup de poser des questions pendant le tp. De plus, étant donné qu'il y a beaucoup de calculs dans ce tp, je n'arrive jamais à être sur de mon résultat et donc savoir si mon résultat est bon ou pas. Je ne vous demande évidemment pas de faire un cours similaire à celui d'amphi, mais vous informe qu'il peut être difficile de procéder de cette manière pour une bonne partie de la classe, je pense. 
Bonne journée à vous.]


Exercice 1 : 

1. Structure sur 6 octets
	3 premiers octets : 
		Diffusion : Unicast(0) ou multicast / broadcast
		Adressage local ou universonlle
		type d'adresse et de constructeur
	3 derniers octets : 
		Adresse unique constructeur


2. Il existe d'autres adresses MAC 


A) 1C-A9-35-E2-11-04
	1 : diffusion donc ici multicast ou broadcast
	C : adresse locale
	A9-35 : adresse constructeur
	E2-11-04 : adresse unique

B) 40-00-00-03-F5-38
	4 = diffusion broadcast
	0 : adresse universelle
	00-00 : adresse locale
	03-F5-38 adresse constructeur


Unicast : diffusion d'un message sur un reseau local à une seule machine. 
Multicast : diffusion d'un message sur un reseau local à plusieures machines. 
Broadcast : diffusion d'un message sur un reseau local à toutes les machines (diffusion totale). 



Exercice 2 : 

1. les hubs (max 4 soit 2,5km), les répéteurs, les cables. 

2. On ne modifie pas la taille des trames mais on modifie le macanisme de transmition en mettant plusieures trames à la suite pour que le mécanisme de detection des colisions puisse détecter une éventuelle colision. 

3. Trame minimale : 64 bits soit 6,4e-5 Mb donc pour une vitesse de 10 Mb/s, il faut environ 6,4e-6 secondes soit 0,0000064 secondes

4. Trame max : 1518 bits soit 0,001518 Mb donc 1,518e-4 secondes soit 0,000152 secondes


Q) On peut detecter une collision lorsqu'on recoie le message de l'autre utilisateur et qu'il a du coup subi des perturbations. C'est la source et la destination qui subissent ces perturbations. [Je n'ai pas bien compris ce processus]



Exercice 3 : 

Q) 45,20 Ko soit 0,3616 Mb. Il faut donc 240 trames maximales de 1500 octets. Une trame max met 0,000152 secondes donc 240 trames mettent 0,03648 secondes théoriquement. 

Q) La différénce de temps avec 0,16 s est de 0,12352. Le temps réel est donc presque le double que le temps théorique. 
