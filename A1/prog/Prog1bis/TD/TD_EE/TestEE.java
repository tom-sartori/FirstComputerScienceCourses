public class TestEE {
    
    public static void main(String[] args) {

	EE e1, e2, e3;

	e1 = new EE (50, "1 2 3 6 7");
	e3 = new EE (50, "1 2 3 4 5" );
	
	int [] tab2 = {1, 321};
	e2 = new EE (20, tab2);

	System.out.println(e1.toString());
	System.out.println(e3.toString());

    }
}
