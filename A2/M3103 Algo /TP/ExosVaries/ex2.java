class ex2 {

	public static void main(String[] args) {
		int [] tab = {1, 0, 1, 0, 1, 0, 0, 1}; 

		for (int i = 0; i < tab.length; i++)
			System.out.print(tab[i]);

		System.out.println('\n');

		System.out.println(drapeauBicolorAux(tab, 0)); 

		for (int i = 0; i < tab.length; i++)
			System.out.print(tab[i]);

		System.out.println('\n');
	}


	public static int drapeauBicolorAux2(int [] t, int i) {
		if (i == t.length) 
			return 0; 
		else if (i + 2 == t.length) {
			if (t[i] == 0) {
				if (t[i+1] == 0)
					return 1; 
				else
					return 0;  
			}
			else {
				if (t[i+1] == 1)
					return 0; 
				else {
					t[i] = 0; 
					t[i+1] = 1; 
					return 1; 
				}
			}
		}

		else {
			if (t[i] == 0) {
				if (t[i+1] == 0)
					return 1 + drapeauBicolorAux(t, i +1); 
				else 
					return drapeauBicolorAux(t, i+1);  
			}
			else {
				if (t[i+1] == 1)
					return drapeauBicolorAux(t, i+1); 
				else {
					t[drapeauBicolorAux(t, i)] = 0; 
					t[i+1] = 1; 
					return 1+ drapeauBicolorAux(t, i+1); 
				}
			}
		}
	}
	public static int drapeauBicolorAux(int [] t, int i) {
		if (i == t.length)
			return t.length; 
		else {
			int x = drapeauBicolorAux(t, i+1); 
			if (t[i] == 0)
				return x; 
			else if(x == i+1) 
				return i;
			else {
				t[i] = 0; 
				t[x -1] =1; 
				return x-1; 
			}  
		}
	}
}
