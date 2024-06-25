public class Prioritiätswarteschlange {
    Knoten [] warteschlange;
    int anzahl;
    int maxAnzahl;

    public Prioritiätswarteschlange(int m) {
        maxAnzahl = m;
        anzahl = 0;
    }

    /*  void knotenEinfügen
     *  @params: einzufügender Knoten k
     */ 
    public void knotenEinfügen(Knoten k) {
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