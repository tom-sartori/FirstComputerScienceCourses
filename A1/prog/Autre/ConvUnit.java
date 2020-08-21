public class ConvUnit {
    static char tab1[]= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public static int conversionb10( String nombre, int l,  int base1)
    {

	int base10=0;
	if( base1 !=10)
	    {
     
		for( int i=0 ; i<l ; i++)
		    {
			int j=0; 
			while( nombre.charAt(i) != tab1[j] )
			    {
				j++;
			    }
			base10= base10*base1 + j;
		    }
	    }
	else
	    base10= Integer.parseInt(nombre);
	return base10;
    }

    public static String conversionb2( int nombre , int base2)
    {
	String res="";
	String newres="";
	int reste;
	while( nombre!=0)
	    {
		reste=nombre%base2;
		nombre= nombre/base2;
		res= res + tab1[reste];
	    }
	for( int i=1 ; i<=res.length() ; i++)
	    newres=newres+res.charAt(res.length()-i);

	return newres;
    }


    
    public static void main( String[] args)
    {
	System.out.println(conversionb2(conversionb10( "10110" , 5 , 2 ) , 13)); 
    }

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
