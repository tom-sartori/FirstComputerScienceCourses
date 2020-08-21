public class TD02 {
    public static void main (String[] args) {

	int x;

	Ut.afficher("Exo numéro : ");
	x=Ut.saisirEntier();

	if (x==7) {
	    exo7();}

	if (x==9) {
	    exo9(); }

	if (x==10) {
	    exo10(); }
    }


    public static void exo7() {
	double a, b, c, d, x, y;
	Ut.afficher("a= ");
	a = Ut.saisirReel();
	Ut.afficher("b= ");
	b = Ut.saisirReel();
	Ut.afficher("c= ");
	c = Ut.saisirReel();
	d = (b*b)-4*a*c;
	Ut.afficher("d= " + d + "\n" );
	if (d >= 0){
	    if (d == 0){
		x = (-b)/(2*a);
		Ut.afficher("1 sol réelle : " + x + "\n");
	    }
	    else
		{
		    Ut.afficher("2 sol réelles " + (-b-Math.sqrt(d))/(2*a) + " et " + (-b+Math.sqrt(d))/(2*a) + "\n");
		}}
	else {
	    Ut.afficher("Pas de solutuin réelle. " + "\n");
	}
    }

    public static void exo9()
    {
	int nb, x, y, i;
	double dif;
	
	Ut.afficher("Saisir nb : ");
	nb = Ut.saisirEntier();
	x=0;
	y=0;
	i=0;
		
	while (x<nb) {
	    i=i+1;
	    y=x;
	    x=x+i; }
	
	dif = x-y;
	
	if (y+(dif/2) >= nb) {
	    Ut.afficher(y + " est le plus proche" + "\n"); }
	else {
	    Ut.afficher(x + " est le plus proche" + "\n"); }


    }

    public static void exo10()
    {
	int a;

	Ut.afficher("année : ");
	a = Ut.saisirEntier();

	if (a%4 == 0) {
	    if (a%100!=0 | an%400==0) {
		Ut.afficher(a + " est une année bissextile. " + "\n"); }}
	else {
	    Ut.afficher(a + " n'est pas une année bissextile" + "\n"); }
    }



}
