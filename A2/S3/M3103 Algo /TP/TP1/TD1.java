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



	public static boolean pair (int n) {
		if (n == 0) 
			return true; 
		else if (n == 1)
			return false; 
		else
			return pair(n - 2); 		
	}



	public static int sommeImpairs (int n) {
		if (n == 1) 
			return n; 
		else 
			return n + sommeImpairs(n-2); 

	}


	public static int puiss (int x, int n) {
		if (n == 0)
			return 1; 
		else if (n == 1) 
			return x; 
		else 
			return x * puiss(x, n-1); 
	}


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


	public static boolean estPalindromeAux (char []t, int i, int j) {
		if (i == j) 
			return true; 
		if (i + 1 == j) {
			if (t[i] == t[j])
				return true; 
			else 
				return false;
		} 
		if (t[i] != t[j])
			return false; 
		else 
			return estPalindromeAux(t, i + 1, j - 1); 

	}


	public static boolean estPalindrome (char []t) {
		if (t.length == 0)
			return; 
		else
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
