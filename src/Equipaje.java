
public class Equipaje {
    private String identificador;
    private int ancho, largo, importancia ;
    private boolean colocado;

    public Equipaje(String identificador,int largo, int ancho, int importancia){
        this.identificador=identificador;
        this.ancho=ancho;
        this.largo=largo;
        this.importancia=importancia;
        this.colocado=false;

    }
    public String get_Identificador(){return identificador;}
    public int get_Ancho(){return ancho;}
    public int get_Largo(){return largo;}
    public int get_Importancia(){return importancia;}
    public boolean get_Colocado(){return  colocado;}

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
    public void setColocado(boolean colocado){ this.colocado=colocado;}





}
