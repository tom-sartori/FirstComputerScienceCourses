public class TD2 {
	public static void main (String [] args) {
		int []t = {1, 4, 3, 12, 9, 2, 11, 6, 5}; 

		System.out.println(pivot(t, 0, t.length -2)); 
	}


	public static int puissRapide (int x, int n) {
		if (n == 0) 
			return 1; 
		else 
			return (int)Math.pow(x, n/2) * (int)Math.pow(x, n/2);
	}


	public static int pivotAux (int []t, int i, int j, int p) {
		if (i == j && t.length %2 == 0) {
			t[t.length -1] = t[i +1]; 
			t[i] = p; 
			return i +1;
		}
		if (i == j) {
			t[t.length -1] = t[i]; 
			t[i] = p; 
			return i; 
		}
		else if (t[i] <= p)
			return pivotAux (t, i +1, j, p); 
		else {
			int x = t[j]; 
			t[j] = t[i]; 
			t[i] = x; 
			return pivotAux(t, i, j-1, p); 
		}

	}

	public static int pivot (int []t, int i, int j) {
		int p = t[t.length -1]; 

		for (int a = 0; a < t.length; a++)
			System.out.print(" " + t[a] + " ");
		System.out.println(' '); 

		int c = pivotAux(t, i, j, p); 

		for (int a = 0; a < t.length; a++)
			System.out.print(" " + t[a] + " ");
		System.out.println(' '); 

		return c; 
	}
}