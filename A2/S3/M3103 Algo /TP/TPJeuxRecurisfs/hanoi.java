class hanoi {

	private static int nb = 1; 

	public static void main(String args[]) {
		resoudre(4); 
	}

	public static void resoudre(int n) {
		if (n == 0)
			System.out.println("Blaireau");
		else {
			resoudreAux(n, 1, 3); 
			int y = incr(n);
			System.out.println(y); 
		}
	}

	public static void resoudreAux(int n, int i, int j) {
		resoudreAuxAux(n, i, j, 6-i-j); 
	}


	public static void resoudreAuxAux(int n, int dep, int arr, int aux) {
		if (n == 1) {
			System.out.println(dep + " -> " + arr); 
			return; 
		}
		else {
			resoudreAuxAux(n-1, dep, aux, arr); 
			System.out.println(dep + " -> " + arr); 
			resoudreAuxAux(n-1, aux, arr, dep); 
		}
	}

	public static void incremente() {
		nb++; 
	}

	public static int incr(int n) {
		if (n == 1) 
			return 1; 
		else 
			return 2 * incr(n-1)+1;
	}
}
