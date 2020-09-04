package fr.umontpellier.iut;

public class Technicien extends Employe {
    public Technicien(String nrINSEE, String nom, int echelon, double base, double nbHeures) {
        super(nrINSEE, nom, echelon, base, nbHeures);
    }

    public void effectuerTacheTechnique() {
        System.out.println("J'effectue une tache technique. ");
    }

    @Override
    public double getSalaireBrut () {
        return super.getSalaireBrut() + (this.getEchelon() * 100);
    }
}
