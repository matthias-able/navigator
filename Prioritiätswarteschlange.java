public class Prioriti�tswarteschlange {
    Knoten [] warteschlange;
    int anzahl;
    int maxAnzahl;

    public Prioriti�tswarteschlange(int m) {
        maxAnzahl = m;
        anzahl = 0;
    }

    /*  void knotenEinf�gen
     *  @params: einzuf�gender Knoten k
     */ 
    public void knotenEinf�gen(Knoten k) {
        if (anzahl == 0) {
            warteschlange[0] = k;
            anzahl++;
        }
        if(anzahl + 1 <= maxAnzahl) {
            warteschlange[anzahl] = k;
            java.util.Arrays.sort(warteschlange);
            anzahl++;
        }
    }
    
    public boolean istLeer() {
        if (anzahl == 0) {
            return true;
        }
        return false;
    }
    
    public Knoten firstOut() {
        return warteschlange[0];
    }
}