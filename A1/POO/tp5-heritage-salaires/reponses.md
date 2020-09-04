**E1 Q5 :** Il faudra faire un unique changement dans `getSalaireBrut()`. 


**E2 Q5 :** La méthode `fabriquerProduit()` n'est pas accessible car l'objet est de type `Employe`. 
En tant que `Fabricant`, il aurait été possible d'appeler cette fonction mais elle est moins général. 

**E2 Q6 :** Pour augmenter le salaire de toutes les classes, il suffira de modifier le code de `getSalaireBrut()` dans `Employe` et `Commercial`. 


**E3 Q4 :** Pour `Vendeur` le fait de ne pas avoir à créer un nouveau `getSalaireBrut()` simplifie le code et nous assure de récupérer la fonction de la class mere. 

Pour `Representant`, cela crée un lien avec `Technicien` qui n'était pas forcément souhaité au début. 