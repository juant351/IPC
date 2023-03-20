
package termostatoModelo;

import java.util.Arrays;
import termostatoControlador.TermostatoControlador;
import termostatoVista.TermostatoVista;

/**
 *Clase que almacena variables globales del programa, es decir que se utilizan en las diferentes funciones del programa.
 * 
 * Dichas varibales son: 3 arrays de tipo boolean que almacenan los estados de los botones de intervalos de horas. Un array para cada programa.
 * 3 arrays de tipo int. La primera posicion almacena la temperatura minima y la segunda la temperatura maxima. Un array para cada programa.
 * 
 * @author juatorr
 * @author hectori
 */
public class TermostatoModelo {
    
    private TermostatoVista miVista;
    private TermostatoControlador miControlador;
    
    public TermostatoModelo(TermostatoVista miVista, TermostatoControlador miControlador){
        this.miControlador = miControlador;
        this.miVista = miVista;
    }
    
    private boolean []Programa0 = new boolean[6];
    private boolean []Programa1 = new boolean[6];
    private boolean []Programa2 = new boolean[6];
    private int []Programa0T = new int[2];
    private int []Programa1T = new int[2];
    private int []Programa2T = new int[2];   private int horas;

    public void setPrograma0(boolean[] Programa0) {
        this.Programa0 = Programa0;
    }

    public void setPrograma1(boolean[] Programa1) {
        this.Programa1 = Programa1;
    }

    public void setPrograma2(boolean[] Programa2) {
        this.Programa2 = Programa2;
    }

    public boolean[] getPrograma0() {
        return Programa0;
    }

    public boolean[] getPrograma1() {
        return Programa1;
    }

    public boolean[] getPrograma2() {
        return Programa2;
    }
    
    public void setBotonP0(int n, boolean estado){
        Programa0[n] = estado;
    }
    public void setBotonP1(int n, boolean estado){
        Programa1[n] = estado;
    }
    public void setBotonP2(int n, boolean estado){
        Programa2[n] = estado;
    }
    public boolean getBotonP0(int n){
        return Programa0[n];
    }
    public boolean getBotonP1(int n){
        return Programa1[n];
    }
    public boolean getBotonP2(int n){
        return Programa2[n];
    }

    public void setPrograma0T(int[] Programa0T) {
        this.Programa0T = Programa0T;
    }

    public void setPrograma1T(int[] Programa1T) {
        this.Programa1T = Programa1T;
    }

    public void setPrograma2T(int[] Programa2T) {
        this.Programa2T = Programa2T;
    }

    public int[] getPrograma0T() {
        return Programa0T;
    }

    public int[] getPrograma1T() {
        return Programa1T;
    }

    public int[] getPrograma2T() {
        return Programa2T;
    }

   
     
    
}
