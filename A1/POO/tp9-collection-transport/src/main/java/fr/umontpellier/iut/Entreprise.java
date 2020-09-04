package fr.umontpellier.iut;

import java.time.LocalDate;
import java.util.*;

public class Entreprise {
    private double bonusTotal;
    private Collection<Employe> lePersonnel;

    public Entreprise() {
        lePersonnel = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "bonusTotal=" + bonusTotal +
                ", lePersonnel=" + lePersonnel +
                '}';
    }

    public void embaucher (Employe e, LocalDate dateEmbauche) {
        e.setDateEmbauche(dateEmbauche);
        lePersonnel.add(e);
    }

    public void licencier(Employe e) {
        lePersonnel.remove(e);
    }

    public Collection<Employe> getEmployesOrdonnes() {
        return new TreeSet<>(lePersonnel);
    }

    public Collection<Employe> getEmployesDansDesordre() {
        return new HashSet<>(lePersonnel);
    }

    public void setBonusTotal(double bonusTotal) {
        this.bonusTotal = bonusTotal;
    }

    public void distribuerBonus() {
        PriorityQueue<Employe> queue = new PriorityQueue<>(new ordreAnciennete());
        queue.addAll(lePersonnel);
        int bonus = 0;
        Employe employe;

        while (bonusTotal > 0 && !queue.isEmpty()) {
            employe = queue.poll();
            bonus = employe.getMoisAnciennete() * 3;
            if (bonus >= bonusTotal) {
                employe.setBonus(bonusTotal);
                bonusTotal = 0;
            }
            else {
                employe.setBonus(bonus);
                bonusTotal = bonusTotal - bonus;
            }
        }
    }

    public void remercier(int n) {
        PriorityQueue<Employe> listRemercier = new PriorityQueue<>(new ordreAnciennete().reversed());
        listRemercier.addAll(lePersonnel);
        Employe employe;
        int i = 0;
        while (!listRemercier.isEmpty() && i < n) {
            employe = listRemercier.poll();
            System.out.println("test" + employe);
            i++;
        }
        lePersonnel = new ArrayList<>(listRemercier);
    }
}
