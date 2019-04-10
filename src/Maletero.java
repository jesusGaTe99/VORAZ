
public class Maletero {
    

    private int largo;
    private int ancho;

    public Maletero(int largo,int ancho){
        this.largo=largo;
        this.ancho=ancho;
    }
    public int get_Largo(){return largo;}
    public int get_Ancho(){return ancho;}
    public int get_Espacio(){return ancho*largo;}
}
