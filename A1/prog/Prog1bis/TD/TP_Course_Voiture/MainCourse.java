public class MainCourse {

    public static void main(String[] args) {

	Voiture v1, voit2;

	v1 = new Voiture ("aba", 3);
	voit2 = new Voiture ("bab", 3);

	Course c1;

	c1 = new Course (v1, voit2, 25);

	System.out.println(c1.deroulement().leNom());


    }
}
