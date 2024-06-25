public class Graph {
    
    /**
     * Graphen werden mithilfe einer Adjazenzmatrix implementiert.
     * Der Einfachheit halber wird ein Array verwendet, das dann allerdings einer Gr��enbeschr�nkung unterliegt!
     */
    
    /**
     * Entfernen von Knoten ist in dieser Version nicht vorgesehen. Das hei�t, dass man von einem 
     * gegebenen Graphen ausgeht, an dem keine oder kaum "Manipulationen" vorgenommen werden sollen. 
     * Lediglich f�r den Aufbau des Graphen bzw. kleinen �nderungen werden die Methoden 
     * knotenEinfuegen, kanteEinfuegen und kanteEntfernen ben�tigt.
     */
    
    /**
     * Die Identifizierung der Knoten erfolgt hier zumeist �ber den entsprechenden Index im Array knotenliste.
     */
        
        private Knoten[] knotenliste;             // Knoten                
        private int[][] adjazenzmatrix;           // Kanten                                           
        private int maxAnzahl;                    // maximale Anzahl von Knoten, die im Graphen Platz haben                    
        private int anzahl;                       // gibt den Index des ersten freien Platzes in der 
                                                  // Knotenliste bzw. die Anzahl der 
                                                  // enthaltenen Knoten an     
        private Graph ADJ;
        
        /**
         * Konstruktor
         * Parameter: m: gibt die maximale Anzahl von Knoten im Graphen an
         */      
        public Graph(int m){
            maxAnzahl = m;
            anzahl = 0;
            knotenliste = new Knoten[m];
            adjazenzmatrix = new int[m][m];
        }


        /**
         * f�gt einen Knoten in die Knotenliste des Graphen ein, falls dies m�glich ist
         */
        public void knotenEinfuegen(Knoten k){
            if (anzahl < maxAnzahl){
                boolean istEingefuegt = false;
                int index = 0;
                while ((index < maxAnzahl) && (!istEingefuegt)){
                    if (knotenliste[index] == null){
                        knotenliste[index] = k;
                        istEingefuegt = true;
                     } else {
                        index++;
                     }
                 }
                anzahl++;
            }
            else{
                System.out.println("Es kann dieser Knoten nicht mehr eingef�gt " +
                        "werden, da die maximale Anzahl an Knoten schon erreicht ist");
            }
        }
    
        public void kanteDefinierenSymmetrisch(String start, String ziel, int wert){
           int startNr = knotenIndexSuchen(start);
           int zielNr = knotenIndexSuchen(ziel);
           kanteEinfuegen(startNr, zielNr, wert);           
           kanteEinfuegen(zielNr, startNr, wert);           
        }
        /**
         * einf�gen einer (gerichteten) Kante zwischen zwei Knoten, falls dies m�glich ist
         * Knoten werden hierbei �ber den Knotenindex identifiziert.
         * Soll eine ungerichtete Kante zwischen i und j eingef�gt werden, so ist 
         * neben kanteEinfuegen(i,j) auch kanteEinfuegen(j,i) aufzurufen.
         * Parameter:
         *      i repr�sentiert den Knoten knotenliste[i] und j repr�sentiert den Knoten knotenliste[j]
         * gr��ter Index: maxAnzahl-1 bzw. anzahl-1
         */
        public void kanteEinfuegen(int i, int j, int wert){             
            if (i >= anzahl || j >= anzahl){
                System.out.println("Falscher Index - es gibt nicht so viele Knoten - Kante kann nicht eingef�gt werden!");
            }
            else{
                adjazenzmatrix[i][j] = wert;
            }
        }
        
        /**
         * entfernen einer (gerichteten) Kante zwischen zwei Knoten, falls dies m�glich ist
         * Knoten werden hierbei �ber den Knotenindex identifiziert.
         * Soll eine ungerichtete Kante zwischen i und j entfernt werden, so ist 
         * neben kanteEntfernen(i,j) auch kanteEntfernen(j,i) aufzurufen.
         * Parameter:
         *      i repr�sentiert den Knoten knotenliste[i] und j repr�sentiert den Knoten knotenliste[j]
         * gr��ter Index: maxAnzahl-1 bzw. anzahl-1
         */
        public void kanteEntfernen(int i, int j){
            if ((adjazenzmatrix[i][j]==0) || i >= anzahl || j >= anzahl){
                System.out.println("Es kann keine Kante entfernt werden, da hier keine vorhanden ist.");
            }
            else{
                adjazenzmatrix[i][j] = 0;
            }
        }

        /**
         * Zu einem gegebenen Knoten wird der zugeh�rige Index in der Knotenliste gesucht und, falls m�glich,
         * zur�ckgegeben.
         * Ist der Knoten nicht in der Knotenliste enthalten, so wird eine entsprechende Textmeldung ausgegeben.
         *
         **/
        public int knotenIndexSuchen(String name){
            int index = -1;
            int i = 0;
            while (index < 0 && i < knotenliste.length){
                if (knotenliste[i].inhaltGeben().nameGeben().equals(name)){
                    index = i;
                }
                else{
                    i++;
                }
            }
            if (index < 0){
                System.out.println("Knoten in der Liste nicht gefunden!");
            }
            return index;
        }    
        
        
        public void knotenLoeschen(String name){
            int knotenindex = knotenIndexSuchen(name); 
            for (int i = 0; i < anzahl; i++){
                adjazenzmatrix[knotenindex][i] = 0;
                adjazenzmatrix[i][knotenindex] = 0;
              }
            knotenliste[knotenindex] = null;
          } 
        
        /**
         * Ausgabe der Adjazenzmatrix auf der Konsole
         */
        public void adjazenzmatrixAusgeben(){                       
            System.out.print("    ");
            for (int i = 0; i < anzahl; i++){
                if (i < 10) {
                    System.out.print(i + "     ");
                }
                else {
                    System.out.print(i + "    ");
                }
            }
            System.out.println("  ");
            for (int i = 0; i < anzahl; i++){
                if (i < 10) {
                    System.out.print(i+"   ");
                }
                else {
                    System.out.print(i+"  ");
                }
                for (int j = 0; j < anzahl; j++){
                    if (adjazenzmatrix[i][j] < 10) {
                        System.out.print(adjazenzmatrix[i][j]+ "     ");
                    }
                    else if (adjazenzmatrix[i][j] < 100) {
                        System.out.print(adjazenzmatrix[i][j]+ "    ");
                    }
                    else if (adjazenzmatrix[i][j] < 1000) {
                        System.out.print(adjazenzmatrix[i][j]+ "   ");
                    }
                    else {
                        System.out.print(adjazenzmatrix[i][j]+ "  ");
                    }
                }
                System.out.println();
            }
        }
       
        public Knoten[] knotenlisteGeben(){
            return knotenliste;
        }
        
        public int anzahlGeben() {
            return anzahl;
        }
       
        public int [][] matrixGeben() {
            return adjazenzmatrix;
        }
                     
        public boolean existenz�berpr�fen(String startort,String zielort){
            if ( knotenIndexSuchen(startort) >= 0  && knotenIndexSuchen(zielort) >= 0 ){
                return true;
            } else{
                return false;
            }
            }
   
        }
    
