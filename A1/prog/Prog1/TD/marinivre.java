    public static boolean arivobato( int l , int L )
    {
	int avancx;
	int avancy;
	avancx= L/2;
	avancy=0;
	Random rand = new Random();
	int N= 1 + rand.nextInt(100);
	while( avancx>=0 && avancx<=L-1 && avancy !=l ){
	    if( 1<= N && N<= 50 )
		avancy= avancy + 1;
	    if( 51 <= N && N<= 70)
		avancx= avancx-1;
	    if( 71<=N && N<=90)
		avancx= avancx+1;
	    if(91<=N && N<=100)
		avancy=avancy-1; 
	    if( avancy < 0 )
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

    public static void affichePlanche( int l , int L) {
	repeteCar( 6 , ' ' );
	repeteCar( L , '_');
	Ut.afficher( " \n " );
	for( int i=1 ; i<l ; i++){
	    repeteCar( 4 , ' ');
	    Ut.afficher( '|' );
	    repeteCar( L , ' ');
	    Ut.afficher( '|' );
	    Ut.afficher( " \n " );
	}
	repeteCar( 4 , ' ');
	Ut.afficher( '|' );
	repeteCar( L , '_');
	Ut.afficher( "| \n" );
	
	
	
