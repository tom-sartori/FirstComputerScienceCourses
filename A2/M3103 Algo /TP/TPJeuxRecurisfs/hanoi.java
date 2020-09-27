class hanoi {

	public static void main(String args[]) {
		resoudre(100); 
	}

	public static void resoudre(int n) {
		resoudreAux(n, 1, 3); 
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
}
