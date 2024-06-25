public class Stadt {
    
    private String name;
    private int einwohnerzahl;
    private Sehenswürdigkeit [] sehenswürdigkeitenliste;
    
    public Stadt(String s, int ez){
        name = s;
        einwohnerzahl = ez;
        sehenswürdigkeitenliste = new Sehenswürdigkeit[6];
    }   
    
    public void attraktionEinfuegen(Sehenswürdigkeit s){
        for(int i=0; i<6;i++){
         if(sehenswürdigkeitenliste [i]== null){
            sehenswürdigkeitenliste[i] = s;
         }
        }
    }
    public Sehenswürdigkeit [] attraktionGeben(){
           return sehenswürdigkeitenliste;
    }       
    public int einwohnerzahlGeben(){
        return einwohnerzahl;
    }    
    public String nameGeben(){
        return name;
    }
    
}
