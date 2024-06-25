public class Stadt {
    
    private String name;
    private int einwohnerzahl;
    private Sehensw�rdigkeit [] sehensw�rdigkeitenliste;
    
    public Stadt(String s, int ez){
        name = s;
        einwohnerzahl = ez;
        sehensw�rdigkeitenliste = new Sehensw�rdigkeit[6];
    }   
    
    public void attraktionEinfuegen(Sehensw�rdigkeit s){
        for(int i=0; i<6;i++){
         if(sehensw�rdigkeitenliste [i]== null){
            sehensw�rdigkeitenliste[i] = s;
         }
        }
    }
    public Sehensw�rdigkeit [] attraktionGeben(){
           return sehensw�rdigkeitenliste;
    }       
    public int einwohnerzahlGeben(){
        return einwohnerzahl;
    }    
    public String nameGeben(){
        return name;
    }
    
}
