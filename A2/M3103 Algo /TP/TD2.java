public class TD2 {
	public static void main (String [] args) {
		int []t = {1, 4, 3, 12, 9, 2, 11, 6, 5, 7, 10}; 
		int []u = {8, 10, 7, 2}; 

		//System.out.println(pivot(t, 0, t.length -2)); 
		for (int a = 0; a < u.length; a++)
			System.out.print(" " + u[a] + " ");
		System.out.println(' '); 

		quickSortAux(u, 0, 1); 
		
		for (int a = 0; a < u.length; a++)
			System.out.print(" " + u[a] + " ");
		System.out.println(' '); 
	}


	public static int puissRapide (int x, int n) {
		if (n == 0) 
			return 1; 
		else 
			return (int)Math.pow(x, n/2) * (int)Math.pow(x, n/2);
	}


	public static int pivotAux (int []t, int i, int j, int p) {
		if (i == j) {
			if (t[i] > p) {
			t[t.length -1] = t[i]; 
			t[i] = p; 
			return i; 
			}
			else {
				t[t.length -1] = t[i +1]; 
				t[i +1] = p; 
				return i +1; 
			}
		}
		else if (t[i] <= p) {
			return pivotAux (t, i +1, j, p); 
		}
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
	} //clean jusqu'ici

	public static void quickSortAux (int []t, int i, int j) {
		if (i == j) {
			for (int a = 0; a < t.length; a++)
				System.out.print(" " + t[a] + " ");
			System.out.println(' '); 
			if (t[i -1] > t[j]) {
				int memoire = t[i];
				t[i] = t[j]; 
				t[j] = memoire; 
			}
			return; 
		}
		else if (j == t.length -1) {
			if (t[i] > t[j]) {
				int memoire = t[i];
				t[i] = t[j]; 
				t[j] = memoire; 
			}	
			//else if (i +1 == t.length -1) 
			//	quickSortAux(t, i +1, i +1);  
			else
				quickSortAux(t, i +1, i +2);
		}
		else if (t[i] <= t[j]) 
			quickSortAux(t, i, j +1); 
		else if (t[i] > t[j]) {
			int memoire = t[i];
			t[i] = t[j]; 
			t[j] = memoire; 
			quickSortAux(t, i, i +1);  
		}
		else 
			System.out.println("probleme"); 
		
	}

} 






















