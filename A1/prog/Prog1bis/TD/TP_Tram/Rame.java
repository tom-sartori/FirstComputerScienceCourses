public class Rame {

    private int numStt;
    private int sens;

    public Rame (int num, int s) {
	this.numStt = num;
	this.sens = s;
    }

    public String toStringRame() {
	String ch;
	ch = "Num stt : " + this.numStt;
	return ch;
    }

    public void avance () {
	if (this.sens == 1)
	    this.numStt++;
	else if (this.sens == -1)
	    this.numStt--;
    }
}
