public class MainCombat {

    public static void main(String[] args) {

	Arene a1, a2;

	a1 = new Arene(10);
	a2 = new Arene(10); 

	System.out.println(a1.bataille().toString());
	System.out.println(a2.bataille().toString());


    }
}
	
