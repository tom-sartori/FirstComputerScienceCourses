package fr.umontpellier.iut;

public class GestionEmployes {

    public static void main(String[] args) {

        Employe e1 = new EmployeBuilder()
                .setBase(10)
                .setNbHeures(35)
                .setNom("Jean")
                .createEmploye();

        Employe e2 = new EmployeBuilder()
                .setNom("Jordan")
                .setBase(21)
                .setEchelon(1)
                .setNbHeures(5)
                .createEmploye();

        System.out.println(e1);
        System.out.println(e2);

        Fabricant f1 = new FabricantBuilder().setNrINSEE("456").setNom("Dos Santos").setEchelon(5).setBase(22).setNbHeures(30).setNbUnitesProduites(3).setTauxCommissionUnite(60).createFabricant();
        f1.fabriquerProduit();

        Technicien t1 = new TechnicienBuilder().setNrINSEE("789").setNom("David").setEchelon(7).setBase(6).setNbHeures(200).createTechnicien();
        t1.effectuerTacheTechnique();

        Employe e3 = new FabricantBuilder().setNrINSEE("789").setNom("Val").setEchelon(9).setBase(27).setNbHeures(50).setNbUnitesProduites(42).setTauxCommissionUnite(16).createFabricant();
        e3.getSalaireBrut();
        e3.getSalaireNet();

        Representant r1 = new RepresentantBuilder().setBase(6).setNbHeures(200).setEchelon(7).createRepresentant();

        System.out.println(t1.getSalaireBrut() == r1.getSalaireBrut());

    }

}
