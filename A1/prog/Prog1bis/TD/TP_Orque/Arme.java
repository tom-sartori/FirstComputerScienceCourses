public class Arme {

    private String type;

    private int degat;

    private int touch;

    
    private static String [] tabType = {"Hache", "Epée", "Matraque"};

    private static int [] tabDegat = {80, 60, 20};

    private static int [] tabTouch = {70, 50, 20};

    
    public Arme () {

	int x;
	x = Ut.randomMinMax(0, tabType.length -1);
	
	this.type = tabType[x];
	this.degat = tabDegat[x];
	this.touch = tabTouch[x]; 
    }

    public int getDegat () {
	return this.degat;
    }

    public int getTouch () {
	return this.touch;
    }
}
    
