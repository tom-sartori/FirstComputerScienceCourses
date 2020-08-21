public class TD05 {
    public static void main (String[]args) {
	int x;
	Ut.afficher ("Exercice : ");
	x = Ut.saisirEntier();

	if (x == 1) {
	    int n;
	    Ut.afficher ("n = ");
	    n = Ut.saisirEntier();
	    multiplication(n);
	}
	if (x == 2) {
	    chiffresRomains();
	}
	    

    }

    public static void multiplication (int n) {
	int x;

	x = 1;
	while (x <= 10) {
	    Ut.afficher(x);
	    if (x/10 <= 0) 
		Ut.afficher(' ');
	    Ut.afficher(" * " + n + "  =  ");
	    if ((x*n)/10 <= 0)
		Ut.afficher(' ');
	    Ut.afficher(x*n + "\n");
	    x = x+1;
	}
    }

    public static void chiffreUnites (int nb) {
	if (nb == 1)
	    Ut.afficher("I");
	else if (nb == 2)
	    Ut.afficher("II");
	else if (nb == 3)
	    Ut.afficher("III");
	else if (nb == 4)
	    Ut.afficher("IV");
	else if (nb == 5)
	    Ut.afficher("V");
	else if (nb == 6)
	    Ut.afficher("VI");
	else if (nb == 7)
	    Ut.afficher("VII");
	else if (nb == 8)
	    Ut.afficher("VIII");
	else if (nb == 9)
	    Ut.afficher("IX");
    }

    public static void chiffreDizaines (int nb) {
	if (nb == 1)
	    Ut.afficher("X");
	else if (nb == 2)
	    Ut.afficher("XX");
	else if (nb == 3)
	    Ut.afficher("XXX");
	else if (nb == 4)
	    Ut.afficher("XL");
	else if (nb == 5)
	    Ut.afficher("L");
	else if (nb == 6)
	    Ut.afficher("LX");
	else if (nb == 7)
	    Ut.afficher("LXX");
	else if (nb == 8)
	    Ut.afficher("LXXX");
	else if (nb == 9)
	    Ut.afficher("XC");
    }

    public static void chiffreCentaines (int nb) {
	if (nb == 1)
	    Ut.afficher("C");
	else if (nb == 2)
	    Ut.afficher("CC");
	else if (nb == 3)
	    Ut.afficher("CCC");
	else if (nb == 4)
	    Ut.afficher("CD");
	else if (nb == 5)
	    Ut.afficher("D");
	else if (nb == 6)
	    Ut.afficher("DC");
	else if (nb == 7)
	    Ut.afficher("DCC");
	else if (nb == 8)
	    Ut.afficher("DCCC");
	else if (nb == 9)
	    Ut.afficher("CM");
    }

    public static void chiffreMilliers (int nb) {
	if (nb == 1)
	    Ut.afficher("M");
	else if (nb == 2)
	    Ut.afficher("MM");
	else if (nb == 3)
	    Ut.afficher("MMM");
    }

    public static void afficherEnChiffresRomain (int nb) {
	int a, b, c, d, rang;

	a = 0;
	b = 0;
	c = 0;
	d = 0;
	rang = 0;

	while (nb > 0) {
	    if (rang == 0)
		d = nb %10;
	    else if (rang == 1)
		c = nb % 10;
	    else if (rang == 2)
		b = nb %10;
	    else if (rang == 3)
		a = nb %10;
	    
	    nb = nb /10;
	    rang = rang +1;

	}
	chiffreMilliers(a);
	chiffreCentaines(b);
	chiffreDizaines(c);
	chiffreUnites(d);
	Ut.afficher("\n");

    }
    
    public static void chiffresRomains () {
	int nb;
	
	Ut.afficher ("Chiffre : ");
	nb = Ut.saisirEntier();
	afficherEnChiffresRomain(nb);
    }
	
}


    
