import java.util.Random;
public class TD03{
    public static void main (String[]args){

       
	int x, taille, i, h, n;
	char[]t;

	Ut.afficher("Exo numéro : ");
	x = Ut.saisirEntier();

	if (x==4) {
	    Ut.afficher("taille : ");
	    taille=Ut.saisirEntier();
	    
	    t = new char[taille];
	    
	    Ut.afficher("caractere : ");
	    for (i=0; i<taille; i++){
		t[i]=Ut.saisirCaractere(); }
	    Ut.afficher(exo4(t) + "\n");}

	if (x==5) {
	    Ut.afficher("h = ");
	    h = Ut.saisirEntier();
	    exo5(h); }

	if (x==9) {
	    Ut.afficher("n = ");
	    n = Ut.saisirEntier();
	    exo9(n);
	}
	if (x==20) {
	    Ut.afficher( " Veuillez entrer une largeur et une longueur \n " );
	    int largeur= Ut.saisirEntier();
	    int longueur= Ut.saisirEntier();
	    Ut.afficher(" Voulez vous voir l'évolution du marin sur la planche ? ( true or false )");
	    boolean trace= Ut.saisirBooleen();
	    arivobato( longueur , largeur , trace );
	    if( arivobato(longueur, largeur, trace)== true )
		Ut.afficher(" Le marin ivre est arrivé vivant à bord du bateau \n ");
	    else
		Ut.afficher(" ILESTTOMBEALO ");
	}
	if ( x==21)
	    {
		Ut.afficher( " Veuillez entrer une largeur et une longueur, et les positions x et y de votre marin sur la planche \n " );
		int largeur= Ut.saisirEntier();
		int longueur= Ut.saisirEntier();
		int posx=Ut.saisirEntier();
		int posy=Ut.saisirEntier();
		affichePlanche2( longueur, largeur, posx , posy );
	    }
		
		

    }

    public static boolean arivobato( int l , int L, boolean trace )
    {
	int avancx;
	int avancy;
	avancx= (L-1)/2;
	avancy=0;
	Random rand = new Random();
	int N= 1 + rand.nextInt(100);
	while( avancx>=0 && avancx<=L-1 && avancy !=l ){
	    Ut.afficher(" x=" + avancx + " y = " + avancy + "\n"); 

	    if(trace)
		affichePlanche2(l , L , avancx , avancy);

	    if( 1<= N && N<= 50 )
		avancy= avancy + 1;
	    else if( 51 <= N && N<= 70)
		avancx= avancx-1;
	    else if( 71<=N && N<=90)
		avancx= avancx+1;
	    else if(91<=N && N<=100)
		avancy=avancy-1; 
	    else if( avancy < 0 )
		avancy=0;
	    
	    N= 1 + rand.nextInt(100);
	}
	if(avancy==l)
	    return true;
	else
	    return false;
    }

    public static void repeteCar( int nb , char car )
    {
	for( int i=1 ; i<= nb ; i++)
	    Ut.afficher(car);
    }

    public static void affichePlanche( int l , int L , int posx , int posy) {
	repeteCar( 5 , ' ' );
	repeteCar( L , '_');
	Ut.afficher( "\n" );
	for( int i=1 ; i<=l-posy-1 ; i++){
	    repeteCar( 4 , ' ');
	    Ut.afficher( '|' );
	    repeteCar( L , ' ');
	    Ut.afficher( '|' );
	    Ut.afficher( "\n" );
	}
	repeteCar( 4 , ' ');
	Ut.afficher( '|' );
	if(posy!=0){
	if(posx==0){
	    Ut.afficher( 'o' );
	    repeteCar( L -1 , ' ');
	    Ut.afficher( '|' );
	}
	else if(posx==1){
	    Ut.afficher( ' ');
	    Ut.afficher( 'o' );
	    repeteCar( L - posx-1 ,' ');
	    Ut.afficher( '|');
	}
	else{
	    repeteCar( posx , ' ');
	    Ut.afficher( 'o' );
	    repeteCar( L-posx-1, ' ');
	    Ut.afficher( '|');
		}
	Ut.afficher( "\n" );
	for( int i=l-posy +2 ; i<l-1; i++)
	    {
		repeteCar(4, ' ');
		Ut.afficher('|');
		repeteCar( L , ' ');
		Ut.afficher( '|' );
		Ut.afficher( "\n" );
	    }
		repeteCar( 4 , ' ');
		Ut.afficher('|');
		repeteCar( L ,  '_');
		Ut.afficher('|');
		Ut.afficher("\n");
	}
	else if(posx==0){
	    Ut.afficher( 'o' );
	    repeteCar( L -1 , '_');
	    Ut.afficher( '|' );
	}
	else if(posx==1){
	    Ut.afficher( '_');
	    Ut.afficher( 'o' );
	    repeteCar( L - posx-1 ,'_');
	    Ut.afficher( '|');
	}
	else{
	    repeteCar( posx , ' ');
	    Ut.afficher( 'o' );
	    repeteCar( L-posx-1, ' ');
	    Ut.afficher( '|');
		}
	Ut.afficher("\n");
    }

    public static void affichePlanche2 (int l, int L, int posx, int posy) {
	int lon , lar ;
	lon = 0;
	lar = 0;
	Ut.afficher(' ');
	repeteCar( L , '_');
	Ut.afficher ("\n");
	while (lon < l-1) {
	    Ut.afficher("|");
	    if (posy == (l-lon-1)) {
		while (lar < L-1) {
		    if (lar == posx)
			Ut.afficher("o");
		    Ut.afficher (" ");
		    lar++;
			}
	    }
	    else {
		repeteCar(L , ' ');
	    }
	    lon++;
	    Ut.afficher ("| \n");
	}
	Ut.afficher('|');
	repeteCar ( L , '_');
	Ut.afficher('|');
	Ut.afficher("\n");
    }
	    
	    
	   
	
	    

	    public static boolean exo4(char[]t){

		boolean resu;
		int i, l;

		l = t.length;
		i = 0;
		resu = true;

		while (i < (l-i)) {
		    if (t[i] != t[l-i-1] & resu == true) {
			resu = false; }
		    i++; }
		return (resu);

	
	    }

	    public static void exo5(int h){

		int i, longueur, j;

		longueur = h*2 -1;
		i = 1;
		j = 1;
		while (i < longueur * 2) {
		    while (i < (longueur+1)/2) {
			Ut.afficher("+");
			i = i+2;
		    }
		    while ((j > (longueur+1)/2) & (j < (longueur+1)/2)) {
			Ut.afficher("*");
			j = j+2;
		    }
		    Ut.afficher("\n");
		    i = i+2;
		}
    
    }

    public static void exo9(int n) {

	int a, b, c, i, p, NbT, NMax;

	NbT = 0;
	NMax = n;
	for (n=0; n<=NMax; n++) {
	    for (c=5; c<(n-2); c++) {
		p = n-c;
		a = 1;
		for (i=0; i<p/2; i++) {
		    if ( ( ((a+i)*(a+i)) + ((p-(a+i))*(p-(a+i))) ) == (c*c) ) {
			NbT++;
		    }
		}
	    }}
	Ut.afficher(NbT + " triangles correspondants \n");
    }

	 


}
 
