package simcitree.forest;

public class Voisin {

    private final Arbre arbre1;
    private final Arbre arbre2;
    private final double tauxComp;

    public Voisin(Arbre arbre1, Arbre arbre2, double tauxComp) {

        this.arbre1 = arbre1;
        this.arbre2 = arbre2;
        this.tauxComp = tauxComp;

        arbre1.addVoisin(this);
        arbre2.addVoisin(this);
    }



    public double getTauxComp() {
        return tauxComp;
    }

    public void delete(Arbre arbreDelete) {

        if (arbre1 == arbreDelete)
            arbre2.deleteVoisin(this);
        else
            arbre1.deleteVoisin(this);
    }

    public Arbre getOtherArbre(Arbre arbre) {
        if (arbre1 == arbre) {
            return arbre2;
        } else
            return arbre1;
    }

}
