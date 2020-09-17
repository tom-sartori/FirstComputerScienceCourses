public class TD1 { 

	public static void main (String[] args) {

		int []t = {1, 10, 20}; 

		System.out.println(croissants(t));
	}

	public static int factorielle (int n) {
		if (n == 0)
			return 1; 
		else 
			return n * factorielle(n - 1); 
	}

/*
	public static int factorielle2 (int n) { 
		int res = 1; 

		for (int i = n; i > 1; i--)
			res = res * i; 
		return res; 
	}
*/

	public static boolean pair (int n) {
		if (n == 0) 
			return true; 
		else if (n == 1)
			return false; 
		else
			return pair(n - 2); 		
	}

/*
	public static boolean pair2 (int n) {
		if (n % 2 == 0)
			return true; 
		else 
			return false; 
	}
*/


	public static int sommeImpairs (int n) {
		if (n == 1) 
			return n; 
		else 
			return n + sommeImpairs(n-2); 

	}

/*
	public static int sommeImpairs2 (int n) {
		int res = 0;

		for (int i = 0; i <= (n-1)/2; i++)  
			res = res + 2 * i + 1; 
		return res; 
	}
*/


	public static int puiss (int x, int n) {
		if (n == 0)
			return 1; 
		else if (n == 1) 
			return x; 
		else 
			return x * puiss(x, n-1); 
	}

/*
	public static int puiss2 (int x, int n) {
		if (n == 0)
			return 1;

		int res = x;

		for (int i = 1; i < n; i++) 
			res = res * x; 
		return res; 
	}
*/


	public static int nbOccAux (int x, int []t, int i) {
		if (i == t.length)
			return 0; 
		else if (t[i] == x) 
			return 1 + nbOccAux(x, t, i + 1); 
		else 
			return nbOccAux(x, t, i + 1); 
	}


	public static int nbOcc (int x, int []t) {
		return nbOccAux(x, t, 0); 
	}


	public static boolean estPalindromeAux (char []t, int g, int d) {
		if (g == d) 
			return true; 
		else if (g + 1 == d)
			if (t[g] == t[d])
				return true; 
			else 
				return false; 
		else if (t[g] != t[d])
			return false; 
		else 
			return estPalindromeAux(t, g + 1, d - 1); 

	}

	public static boolean estPalindrome (char []t) {
		return estPalindromeAux(t, 0, t.length -1); 
	}


	public static boolean croissantsAux (int []t, int i) {
		if (i == t.length -1)
			return true; 
		else if (t[i] <= t[i +1])
			return croissantsAux(t, i +1); 
		else return 
			false; 
	}

	public static boolean croissants (int []t) {
		return croissantsAux(t, 0); 
	}

}



































