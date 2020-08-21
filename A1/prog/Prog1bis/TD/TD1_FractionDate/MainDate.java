import java.util.Scanner;
import java.lang.*;

class MainDate {

    public static void main(String args[]) {

	Date d1, d2;
	d1 = new Date (12, 7, 2000);
	d2 = new Date (31, 5, 2000);
	
	System.out.println(d1.toStringLettre());


	System.out.println(d1.incrementation().toStringLettre());
	System.out.println(d1.toStringLettre());

	System.out.println(d2.toStringLettre());


	if (d1.dateEgale(d2)) //date égales
	    System.out.println("Les dates sont les memes ");
	else {
	    System.out.println("Les dates sont differentes ");

	    if (d1.dateAnterieure(d2)) {
		System.out.println("d1 anterieure à d2");
		System.out.println("diff est de : " + d1.dateDifference(d2));
	    }
	    
	    else
		System.out.println("d1 supérieur à d2");
	    System.out.println("diff est de : " + d2.dateDifference(d1));

	}
    }
}
