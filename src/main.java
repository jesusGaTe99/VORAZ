
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String [] args){
     Equipaje [] equipaje=datos("src/prueba.txt");
     Maletero maletero=CrearMaletero();
     String matriz[][] = new String[maletero.get_Largo()][maletero.get_Ancho()];
     OrdenarImportancia(equipaje);
     OrdenarTamaño(equipaje);
     Rellenar_Maletero(matriz);
     voraz(matriz,equipaje);


    }
    public static Equipaje[] datos(String path){

        try{
            Scanner sc=new Scanner (new File(path));
            int n=sc.nextInt();
            int contador =0;
            Equipaje[] matriz_equipajes=new Equipaje[n];
            while(sc.hasNext()){
                String id = sc.next();
                int ancho = sc.nextInt();
                int largo = sc.nextInt();
                int importancia = sc.nextInt();
                Equipaje equipaje = new Equipaje(id, largo, ancho, importancia);
               matriz_equipajes[contador]=equipaje;
               contador++;
            }
            return matriz_equipajes;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static Maletero CrearMaletero(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca la capacidad del maletero");
        System.out.printf("Introduzca el largo\n");
        int largo=sc.nextInt();
        System.out.printf("Introduzca el ancho\n");
        int ancho=sc.nextInt();

        Maletero m =new Maletero(largo,ancho);
        return m;
    }
    
    public static void OrdenarImportancia(Equipaje equipaje[] ){ // importancia entre 5-0 
        
      
        for (int i =0 ; i<equipaje.length; i++){
             
            for (int j=0 ; j<equipaje.length; j++ ){
               
                if (equipaje[i].get_Importancia()> equipaje[j].get_Importancia()) {

                    Equipaje aux = equipaje[i];
                    equipaje[i] = equipaje[j];
                    equipaje[j] = aux;
                }
                
            }
        }

    }
    public static void OrdenarTamaño(Equipaje equipaje[]){
        for (int i = 0; i < equipaje.length; i++) {
            for (int j = 0; j < equipaje.length; j++) {
                if (equipaje[i].get_Importancia() == equipaje[j].get_Importancia()) {
                    if (equipaje[j].get_Ancho() * equipaje[j].get_Largo() < equipaje[j].get_Ancho() * equipaje[j].get_Largo()) {
                        Equipaje aux = equipaje[i];
                        equipaje[i] = equipaje[j];
                        equipaje[j] = aux;
                    }
                }
            }
        }
    }
    public static void Rotar_Objeto(Equipaje equipaje){
        int aux_largo =equipaje.get_Largo();
        int aux_ancho = equipaje.get_Ancho();
        equipaje.setAncho(aux_ancho);
        equipaje.setLargo(aux_largo);
    }
    public static void Rellenar_Maletero(String matriz[][]){
        
        for (int i =0; i<matriz.length;i++){
            for (int j=0; j<matriz[i].length;j++){
                
                matriz[i][j]="";
            }
        }
    }

    public static boolean Comprobar(String[][] matriz, int largo, int ancho , Equipaje equipaje ) {
        int countx = 0, county = 0, i = largo, j = ancho;
        boolean limit = false;
        // comprobamos las filas a 0 hasta la primera ocupada
        while (i < matriz.length && !limit) {
            if (matriz[i++][ancho] != "") {
                countx = 0;
                limit = true;
            } else
                countx++;
        }
        // comprobamos las columnas a 0 hasta la primera ocupada
        limit = false;
        while (j < matriz[largo].length && !limit) {
            if (matriz[largo][j++] != "") {
                county = 0;
                limit = true;
            } else
                county++;
        }
        return (countx >= equipaje.get_Largo() && county >= equipaje.get_Ancho());
    }

    public static void Colocar_Equipaje(String[][] matriz, int x, int y, Equipaje equipaje) {
        for (int i=x;i<x+equipaje.get_Largo();i++)
            for (int j=y;j<y+equipaje.get_Ancho();j++)
                matriz[i][j]=equipaje.get_Identificador();
    }

    public static void voraz(String[][] matriz, Equipaje[] equipaje) {
        for (int k=0;k<equipaje.length;k++) {
            for (int i=0;i<matriz.length;i++) {
                for (int j=0;j<matriz[i].length;j++) {
                    if (matriz[i][j]=="" && Comprobar(matriz,i,j,equipaje[k]) && equipaje[k].get_Colocado()==false){
                        Colocar_Equipaje(matriz,i,j,equipaje[k]);
                        equipaje[k].setColocado(true);
                    }
                }
            }
        }

        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                if(matriz[i][j]==""){
                    System.out.print("00"+" ");
                }else
                    System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }



    }
}

