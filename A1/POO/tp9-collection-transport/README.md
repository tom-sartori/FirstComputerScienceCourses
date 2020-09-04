# ![](ressources/logo.jpeg) Bases de la programmation orientée objet 

### IUT Montpellier-Sète – Département Informatique

* **Cours:** [M2103](http://cache.media.enseignementsup-recherche.gouv.fr/file/25/09/7/PPN_INFORMATIQUE_256097.pdf) - support [ici](https://github.com/IUTInfoMontp-M2103/Ressources)
* **Enseignants:** [Marin Bougeret](mailto:marin.bougeret@umontpellier.fr), [Sébastien Gagné](mailto:sebastien.gagne@umontpellier.fr), [Sophie Nabitz](mailto:sophie.nabitz@univ-avignon.fr), [Jérôme Palaysi](mailto:jerome.palaysi@umontpellier.fr), [Victor Poupet](mailto:victor.poupet@umontpellier.fr), [Petru Valicov](mailto:petru.valicov@umontpellier.fr)
* Le [forum Piazza](https://piazza.com/class/k52c8w685w3210) de ce cours pour poser vos questions
* [Email](mailto:petru.valicov@umontpellier.fr) pour une question d'ordre privée concernant le cours.
* Le [sujet du TP](https://gitprint.com/IUTInfoMontp-M2103/TP9) en format .pdf téléchargeable et imprimable.

Avant de démarrer le TP, vérifiez que vous n'avez pas atteint votre quota d'espace de stockage autorisé :

* placez-vous dans votre `$HOME` et utilisez les commandes suivantes :
    * `du -sh` pour voir combien d'espace vous avez déjà utilisé
    * `du -sh *` pour voir combien d'espace vous avez déjà utilisé pour chaque fichier (sans fichiers cachés)
    * `du -sch .[!.]* *` pour voir combien d'espace vous avez déjà utilisé pour chaque fichier, y compris les fichiers cachés
* Supprimez les fichiers inutiles.
* Pour éviter des problèmes durant vos TPs d'informatique, vous devriez toujours **garder 300-400 Mo d'espace libre**.


### Consignes
- Vous respecterez les différents principes de programmation vues dans le cours et les TPs précédents
- Toutes vos classes doivent résider dans le paquetage `fr.umontpellier.iut`
- Les signatures des méthodes et les noms des classes qui vous sont données doivent rester inchangés.


## TP9 : _utilisation des collections Java_

Cliquez sur le lien ci-dessous pour faire votre fork privé du TP :

https://classroom.github.com/a/6KBidiMb

Date limite de rendu de votre code sur le dépôt GitHub : **Dimanche 26 avril à 23h00**

Reprenons la classe `Employe` du [TP5](https://github.com/IUTInfoMontp-M2103/TP5). Pour vous faciliter la tâche, nous l'avons directement écrite et simplifié en enlevant les attributs inutiles pour ce TP. Un attribut `dateEmbauche` avec accesseur et modifieur ont été ajoutés à la classe `Employe`. Le but de ce TP est de proposer différentes organisations des employés dans l'entreprise en fonction des besoins du client. 

### Exercice 1 - mise en place

1. Ajoutez comme attribut à la classe `Entreprise` une collection d'employés (la plus générale possible) que l'on va appeler `lePersonnel`. Ajoutez un constructeur sans paramètres instanciant cette collection en tant que `ArrayList`.

2. Ajoutez à `Entreprise` les méthodes `void embaucher(Employe e, LocalDate dateEmbauche)` et `void licencier(Employe e)` pour mettre à jour la liste d'employés de manière correspondante.

3. Redéfinissez la méthode `String toString()` de la classe `Entreprise` pour afficher ses informations.

4. Vérifiez votre programme en créant dans la classe principale (`GestionEmployes`) une entreprise et en embauchant plusieurs employés. Vous afficherez l'état de l'entreprise après chacune des opérations.


### Exercice 2 - organisation des employés

L'entreprise souhaite mieux organiser ses employés. On remarque que la collection `lePersonnel` peut contenir le même employé plusieurs fois si cette personne occupe des postes différents. Et donc il ne faut surtout pas changer cela.

1. Redéfinissez les méthodes `equals(Object o)` et `hashCode()` de la classe `Employe` afin de distinguer deux employés en fonction de leur numéro INSEE (de type `String`). Vous pouvez utiliser la méthode `hashCode()` de la classe `String`. Dorénavant deux employés seront considérés comme des doublons s'ils ont le même numéro INSEE.

2. Maintenant l'entreprise souhaite pouvoir retrouver l'ensemble de ses employés sans les doublons. De plus, pour une meilleure lisibilité, il serait souhaitable de pouvoir récuperer l'ensemble des employés dans l'ordre. L'ordre choisi est l'ordre _croissant_ suivant le nom et qui en cas d'égalité, applique l'ordre _décroissant_ suivant le numéro INSEE.
    
    Écrivez le corps de la méthode `Collection<Employe> getEmployesOrdonnes()` qui, à partir de la collection `lePersonnel`, retourne une autre collection respectant ces contraintes et ce **sans invoquer explicitement une méthode ou algorithme de tri, ni un algorithme de recherche de doublons**.

   **Attention** : Pas de modifications du code précédemment écrit (et donc de l'attribut `lePersonnel`).

3. Écrivez maintenant le corps de la méthode `Collection<Employe> getEmployesDansDesordre()`. À partir de la collection `lePersonnel`, elle devra retourner une autre collection (différente de celle de la question précédente) en enlevant tous les doublons. Naturellement, comme dans la question précédente, **il ne faut pas écrire ou invoquer explicitement un algorithme de recherche de doublons**.
    
    **Remarque** : les deux fonctions  `getEmployesDansDesordre()` et `getEmployesOrdonnes()` doivent être totalement indépendantes et ne doivent pas s'appeler entre elles.

4. Ecrivez plusieurs tests unitaires vérifiant la fonctionnalité programmée. Voici le scénario à appliquer dans chaque test :
    * créer une entreprise
    * créer plusieurs employés (au moins 4) avec des noms différents et/ou numéros INSEE différents
    * vérifiez avec des _assertions_ (`assertEquals(...)`, `assertNotEquals(...)`, `assertTrue(...)`, `assertFalse(...)` etc.) que la méthode `getEmployesOrdonnes()` fonctionne correctement. Vous vérifierez notamment que les collections retournées par `getEmployesOrdonnes()` et `getEmployesDansDesordre()` sont de même tailles (et contiennent les mêmes employés). Pour la liste exhaustive des assertions en _Junit 5_ :
        * un tutoriel en ligne : https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-assertions-with-junit-5-api/
        * l'API de la classe `Assertions` : https://junit.org/junit5/docs/5.4.0/api/org/junit/jupiter/api/Assertions.html


### Exercice 3 - priorité aux anciens

L'entreprise souhaite distribuer des bonus à ses employés en fonction de la date d'embauche. Le problème est que cette somme est évidemment limitée, donc on risque de ne pas pouvoir distribuer des bonus à chaque employé... Cette somme est représentée par l'attribut `double bonusTotal` de la classe `Entreprise`. Un _setter_ permet à l'utilisateur de fixer à tout moment la somme d'argent disponible pour distribuer un bonus aux employés.

L'attribut `double bonus` de la classe `Employe` permet de définir la quantité de bonus qu'un employé va recevoir. Les méthode _setter_ et _getter_ permettent la gestion de ce bonus. 
 
1. Ajoutez à la classe `Employe` une méthode `int getMoisAnciennete()` qui renvoie le nombre de mois correspondant à l'intervalle de temps entre la date d'embauche et maintenant. L'ancienneté est calculée sur le nombre de mois **complets** depuis la date d'embauche (un mois complet est compté du 1er au 30/31).
    
    **Astuce :** pour calculer l'ancienneté vous pouvez utiliser la classe `ChronoUnit` qui permet d'effectuer des calculs en fonction de différentes unités temporelles (jours, mois, années etc.). Voici un exemple de code qui permet de calculer le nombre de mois entre la date d'embauche et la date d'aujourd'hui :
 
    ```java
    import java.time.LocalDate;
 
    class GestionEmployes {
        public static void main(String args[]) {
            LocalDate dateEmbauche = LocalDate.of(2019, Month.JANUARY, 28);
            long nbMois = ChronoUnit.MONTHS.between(dateEmbauche, LocalDate.now());
        }
    }
    ```
 
2. Ecrivez plusieurs tests unitaires vérifiant le bon fonctionnement de la méthode `int getMoisAnciennete()` de la classe `Employe`. Vérifiez notamment que deux personnes étant embauchées le même mois de la même année mais à des dates différentes, aient la même ancienneté.

3. Le patron a décidé de donner la priorité aux anciens pour la distribution du bonus. Ainsi, le bonus sera distribué aux employés suivant leurs dates d'embauche : de la plus ancienne, à la plus récente. Le bonus qu'un employé va recevoir est égal à `3*ancienneté`. Écrivez le corps de la méthode `void distribuerBonus()` qui effectue cette tâche **sans utiliser explicitement** un algorithme de tri et sans modifier la classe `Employe`. Écrivez des tests unitaires pour vous assurer que l'employé a bien reçu le bon bonus.

    **Remarque importante:**  Pour simplifier, vous supposerez que les employés se font embaucher à des dates différentes.

4. Modifiez la méthode `toString()` de `Employe` afin qu'elle affiche également le bonus que l'employé a reçu.

5. L'entreprise traverse une période de crise et décide de se séparer d'une partie de ses employés. Afin de fidéliser les anciens employés, ce qui a été décidé c'est de licencier les employés ayant travaillé le moins longtemps dans l'entreprise. Sans modifier le code précédemment écrit, ajoutez dans la classe `Entreprise` une méthode `void remercier(int n)` qui permet de licencier `n` employés ayant été embauchés le plus tard.

### Exercice 4 - indemnités de transport

On souhaite maintenant pouvoir calculer les indemnités de transport pour chaque employé en fonction de la distance entre sa ville de résidence (une donnée de type `String`) et les locaux de l'entreprise.
L'attribut `String adresse` de la classe `Employe` correspond à sa ville de résidence. Le _getter_ et le _setter_ permettent la gestion de cet attribut.

1. Écrivez une classe `GestionDistances` qui initialise et gère une collection statique faisant correspondre une distance (un entier) à une ville. Une ville ne peut être associée qu'à une unique distance, mais une même distance peut être associée à plusieurs villes. À titre d'exemple vous stockerez dans la collection les données suivantes :
    * Montpellier &rightarrow; 0
    * Sète &rightarrow; 36
    * Sommières &rightarrow; 30
    * Nîmes &rightarrow; 58
    * Lunel &rightarrow; 30
    * Béziers &rightarrow; 80

2. Proposez une méthode statique `int getDistance(String ville)` dans la classe `GestionDistances` qui retourne la distance associée à la ville passée en paramètres.
 
3. Écrivez le corps de la méthode `double getIndemniteTransport()` de la classe `Employe`. Elle doit retourner l'indemnité qui est dûe à l'employé. La formule de calcul de cette indemnité est `distance  * base`.

4. Écrivez des tests unitaires pour vérifier le bon fonctionnement de la méthode `double getIndemniteTransport()`.
