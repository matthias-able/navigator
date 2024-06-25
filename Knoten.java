public class Knoten {
	
	private Stadt inhalt;
	private boolean markierung;
	private Knoten vorg�nger;
	private int pfadgewicht;

	public Knoten(Stadt s){
	    inhalt = s;
		markierung = false;
	}
	
	public Stadt inhaltGeben(){
		return inhalt;
	}
	
		public void markierungSetzen(boolean markierung){
	   markierung = true;
	}
	
	public boolean markierungGeben(){
	   return markierung;
	}  
	  
	public Knoten vorg�ngerGeben() {
	    return vorg�nger;
	}
	
	public void vorg�ngerSetzen(Knoten v) {
	    vorg�nger = v;
	   }
	   
	public int pfadgewichtGeben() {
	    return pfadgewicht;
	}
	
	public void pfadgewichtSetzen(int gewicht) {
	    pfadgewicht = gewicht;
	}
}
