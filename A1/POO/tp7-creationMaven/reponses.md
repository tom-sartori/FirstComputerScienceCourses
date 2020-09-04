Q2. Le problème des ArrayList est que la suppression ou l'insertion d'un element 
est très couteux. De plus, pour savoir si cette liste contient ou non un element, 
c'est la méthode equals(Object o) qui est utilisée et qui doit parcourir 
l'intégralité de la liste ; ceci est donc très couteux. 

Dans certains de nos cas, la collection LinkedList pourrait être intéressante 
car la suppression et l'ajout d'éléments sont très rapides. 

Q3: La liste dejaVus va uniquement grandir et aucun element ne sera supprimé. 
De plus, chaque element de cette liste est unique. Ainsi, HashSet semble être 
la solution idéale dans ce cas. 

Après avoir utilisé HashSet et comparé avec le TP6, on voit que tout est 
beaucoup plus rapide avec HashSet. 