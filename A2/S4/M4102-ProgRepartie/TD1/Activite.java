package TD1;

public class Activite {
    private int id; // un identifiant
    private int delai;
    private int duree;
    private static char[] S1 = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '
            ,' ',' ',' ',' ',' ',' ',' '};
    private String B; // pour affichage

    // constructeur
    Activite (int nb, int pause, int lng) {
        id = nb;
        delai = pause;
        duree = lng;
        B = new String(S1,0,id); // la longueur de B est proportionnelle a id
    }

    public void faire() {
        double f = 1.3333; // une valeur arbitraire
        for (int nombre=1; nombre <duree; nombre++) {
            System.out.println("T" + id + " \t|" + B + 'x'); // on laisse une trace
            for (int i=1; i <10000000; i++) f *= 1.000001; // pour consommer le temps
            try {
                Thread.sleep(delai); // pause en milliseconds
            }
            catch (InterruptedException e) {
            }
        }
        System.out.println("Fin activite T" + id);
    }
}