
package termostatoControlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import termostatoModelo.TermostatoModelo;
import termostatoVista.TermostatoVista;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *Clase donde reside la mayor parte del codigo funcional del termostato.
 * 
 * 
 * @author juatorr
 * @author hectori
 */
public class TermostatoControlador {
    
    private TermostatoVista miVista;
    private TermostatoModelo miModelo;
    
    /**
     * Constructor del Controlador
     * 
     * @param miVista
     * @param miModelo
     * */
    public TermostatoControlador(TermostatoVista miVista, TermostatoModelo miModelo){
        this.miModelo = miModelo;
        this.miVista = miVista;
    }
    
    /**
     * Metodo que se lanza al iniciar el ejecutable, donde solo aparecera el boton de encendido/apagado para poder sel pulsado.
     * 
     **/
    public void initComponents(){
        miVista.getModoManual().setVisible(false);
        miVista.getModoEditar().setVisible(false);
        miVista.getA().setVisible(false);
        miVista.getTemporizador().setVisible(false);
        setBotones(false);
        
        
        

    }
    /**
     * Metodo que prepara la interfaz para el modo manual. Se activa el panel de dicho metodo con su respectivo JSpinner y boton. 
     * 
     * @param valor boolean. Si es falso se pone en no visible el panel con sus componentes.
     **/
    public void manualButton(boolean valor){
        miVista.getA().setVisible(false);
        miVista.getModoManual().setVisible(true);
        miVista.getModoEditar().setVisible(false);
        miVista.getdocetresButton().setEnabled(false);
        miVista.getcuatroSieteButton().setEnabled(false);
        miVista.getochoOnceButton().setEnabled(false);
        miVista.getdoceQuinceButton().setEnabled(false);
        miVista.getdiciseisDiecinueveButton().setEnabled(false);
        miVista.getveinteVeintresButton().setEnabled(false);
        miVista.getTemporizador().setVisible(false);
    }
    
    /**
     * Metodo que prepara la interfaz para el modo editar. Se vuelven visibles los dos JSpinner para seleccionar temperatura maxima y minima.
     * 
     * @param valor boolean. Si es falso el panel del modo editar junto con sus componentes se vuelven no visibles.
     **/
    public void editarButton(boolean valor){
        miVista.getA().setVisible(false);
        miVista.getModoManual().setVisible(false);
        miVista.getModoEditar().setVisible(true);
        miVista.getdocetresButton().setEnabled(valor);
        miVista.getcuatroSieteButton().setEnabled(valor);
        miVista.getochoOnceButton().setEnabled(valor);
        miVista.getdoceQuinceButton().setEnabled(valor);
        miVista.getdiciseisDiecinueveButton().setEnabled(valor);
        miVista.getveinteVeintresButton().setEnabled(valor);
        miVista.getTemporizador().setVisible(false);
        miVista.getMinima().setEnabled(true);
        miVista.getMaxima().setEnabled(true);
    }
    /**
     * Metodo que prepara la interfaz para el modo automatico. Se vuelven invisibles los paneles de los modo manual y modo editar, junto con sus respectivos 
     * componentes. Se vuelve visible una etiqueta con un icono de una A indicando la activacion de dicho mod (automatico). Se muestra de fondo los botones
     * de seleccion de intervalos de horas junto con las temperaturas maxima y minima, pero no estan disponibles para su edicion.
     * 
     * @param valor boolean. Si es verdadero, los paneles de modo editar y de modo manual se vuelven no visibles.
     *
     **/
    public void autoButton(boolean valor){
        miVista.getA().setVisible(true);
        miVista.getModoManual().setVisible(false);
        miVista.getModoEditar().setVisible(true);
        miVista.getMinima().setEnabled(false);
        miVista.getMaxima().setEnabled(false);
        miVista.getdocetresButton().setEnabled(valor);
        miVista.getcuatroSieteButton().setEnabled(valor);
        miVista.getochoOnceButton().setEnabled(valor);
        miVista.getdoceQuinceButton().setEnabled(valor);
        miVista.getdiciseisDiecinueveButton().setEnabled(valor);
        miVista.getveinteVeintresButton().setEnabled(valor);
        miVista.getTemporizador().setVisible(false);
    }
    
    /**
     * Metodo para cuando se pulsa el boton de inicion (boton de encendido/apagado). 
     * Si el boton está seleccionado el termostato estará encendido, dejando disponibles todas las opciones que tiene. Ademas si esta encendido se pone en rojo
     * el dia de la semana y la hora actual. Por defecto aparecera una temperatura de 19 grados celsius.
     * Si no esta seleccionado, el termostato aparecera como apagado, bloqueando todas las funcionalidades exceptuando la que permite volver a pulsar el boton
     * de inicio.
     * 
     * 
     **/
    public void inicioButton(){
        Date fecha = new Date();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                miVista.getDomingo().setForeground(Color.red);
                break;
            case 2:
                miVista.getLunes().setForeground(Color.red);
                break;
            case 3:
                miVista.getMartes().setForeground(Color.red);
                break;
            case 4:
                miVista.getMiercoles().setForeground(Color.red);
                break;
            case 5:
                miVista.getJueves().setForeground(Color.red);
                break;
            case 6:
                miVista.getViernes().setForeground(Color.red);
                break;
            case 7:
                miVista.getSabado().setForeground(Color.red);
                break;
            default:
                break;
        }
        if(miVista.getInicioButton().isSelected()){
            miVista.getModoManual().setVisible(false);
            miVista.getModoEditar().setVisible(false);
            setBotones(true);
            miVista.getdocetresButton().setEnabled(false);
            miVista.getcuatroSieteButton().setEnabled(false);
            miVista.getochoOnceButton().setEnabled(false);
            miVista.getdoceQuinceButton().setEnabled(false);
            miVista.getdiciseisDiecinueveButton().setEnabled(false);
            miVista.getveinteVeintresButton().setEnabled(false);
            DateTimeFormatter tipo = DateTimeFormatter.ofPattern("HH:mm:ss");
            String hora = tipo.format(LocalDateTime.now());
            miVista.getHora().setText(hora + " h");
            reloj.start();
        }else{
            miVista.getModoManual().setVisible(false);
            miVista.getModoEditar().setVisible(false);
            miVista.getButtonGroup1().clearSelection();
            miVista.getA().setVisible(false);
            miVista.getTemporizador().setVisible(false);
            setBotones(false);
            reloj.stop();
            miVista.getHora().setText("00:00:00");
            miVista.getLunes().setForeground(Color.BLACK);
            miVista.getMartes().setForeground(Color.BLACK);
            miVista.getMiercoles().setForeground(Color.BLACK);
            miVista.getJueves().setForeground(Color.BLACK);
            miVista.getViernes().setForeground(Color.BLACK);
            miVista.getSabado().setForeground(Color.BLACK);
            miVista.getDomingo().setForeground(Color.BLACK);
        }
    }
    /**
     * Timer para mostrar la hora actual en el termostato.
     * 
     * 
     **/
    Timer reloj = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                DateTimeFormatter tipo = DateTimeFormatter.ofPattern("HH:mm:ss");
                String hora = tipo.format(LocalDateTime.now());
                miVista.getHora().setText(hora + " h");
                }
        });
    
   /**
    * Metodo para controlar la gran parte de los botones del termostato. Se pasa como parametro un booleano, si este toma el valor false los botones
    * se bloquearan, y si toma el valor true, podran ser utilizados. Estos botones son los 6 de seleccion de intervalos de horas, los 3 de seleccion de modo
    * (automatico,manual y editar). Asi mismo funciona para el boton de seleccion de programas y los de hora y temperatura.
    * 
    * @param valor booleano.
    **/
    
    public void setBotones(boolean valor){
        miVista.getManualButton().setEnabled(valor);
        miVista.getAutoButton().setEnabled(valor);
        miVista.getEditButton().setEnabled(valor);
        miVista.getdocetresButton().setEnabled(valor);
        miVista.getcuatroSieteButton().setEnabled(valor);
        miVista.getochoOnceButton().setEnabled(valor);
        miVista.getdoceQuinceButton().setEnabled(valor);
        miVista.getdiciseisDiecinueveButton().setEnabled(valor);
        miVista.getveinteVeintresButton().setEnabled(valor);
        miVista.getprogramaCombobox().setEnabled(valor);
        miVista.getHora().setEnabled(valor);
        miVista.getTemperatura().setEnabled(valor);
    }
    
    /**
     * Metodo para la seleccion de programa. Cuando se interactua con el comboBox de seleccion de programas, dependiendo de que programa sea, 
     * se muestran los intervalos de horas seleccionados y temperaturas minima y maxima seleccionadas. Para ello utilizan seis arrays, tres de tipo boolean 
     * que almacena en cada posicion el estado de los botones de seleccion de intervalo de horas y otros tres que guardan en cada posicion la temperatura maxima
     * y minima. 
     * 
     * 
     **/
    public void SelProg(){
        switch (miVista.getProgramaComboBox().getSelectedIndex()) {
            case 0:
                {
                    boolean [] array = miModelo.getPrograma0();
                    for(int i = 0; i<array.length; i++){
                        getBoton(i, array[i]);
                        
                    }       int [] arrayTemp = miModelo.getPrograma0T();
                    miVista.getMinima().setValue(arrayTemp[0]);
                    miVista.getMaxima().setValue(arrayTemp[1]);
                    break;
                }
            case 1:
                {
                    boolean [] array = miModelo.getPrograma1();
                    for(int i = 0; i<array.length; i++){
                        getBoton(i, array[i]);
                        
                    }       int [] arrayTemp1 = miModelo.getPrograma1T();
                    miVista.getMinima().setValue(arrayTemp1[0]);
                    miVista.getMaxima().setValue(arrayTemp1[1]);
                    break;
                }
            case 2:
                {
                    boolean [] array = miModelo.getPrograma2();
                    for(int i = 0; i<array.length; i++){
                        getBoton(i, array[i]);
                        
                    }       int [] arrayTemp2 = miModelo.getPrograma2T();
                    miVista.getMinima().setValue(arrayTemp2[0]);
                    miVista.getMaxima().setValue(arrayTemp2[1]);
                    break;
                }
        }
    }
    
    /**
     * Metodo para cambiar el estado de uno de los 6 botones de los intervalos de horas.
     * 
     * @param n int. Indica que boton se quiere cambiar.
     * @param estado boolean. Indica a que estado cambia. Si es true se mostrara como seleccionado el boton.
     **/
    private void getBoton(int n, boolean estado){
        switch (n) {
            case 0:
                miVista.getdocetresButton().setSelected(estado);
                break;
            case 1:
                miVista.getcuatroSieteButton().setSelected(estado);
                break;
            case 2:
                miVista.getochoOnceButton().setSelected(estado);
                break;
            case 3:
                miVista.getdoceQuinceButton().setSelected(estado);
                break;
            case 4:
                miVista.getdiciseisDiecinueveButton().setSelected(estado);
                break;
            case 5:
                miVista.getveinteVeintresButton().setSelected(estado);
                break;
        }
    }
    
    /**
     * Metodo para cuando se selecciona un boton de los intervalos de horas. Se analiza en que estado esta, y se cambia al contrario. Esto se hace comprobando
     * un array de tipo booleano el cual amacena por cada posicion el valor de dichos botones.
     * 
     * 
     * @param n int. Indica a que posicion del array acceder.
     **/
    public void setBoton(int n){
        switch (miVista.getProgramaComboBox().getSelectedIndex()) {
            case 0:
                if(!miModelo.getBotonP0(n)){
                    miModelo.setBotonP0(n, true);
                }
                else{
                    miModelo.setBotonP0(n, false);
                }   break;
            case 1:
                if(!miModelo.getBotonP1(n)){
                    miModelo.setBotonP1(n, true);
                }
                else{
                    miModelo.setBotonP1(n, false);
                }   break;
            case 2:
                if(!miModelo.getBotonP2(n)){
                    miModelo.setBotonP2(n, true);
                }
                else{
                    miModelo.setBotonP2(n, false);
                }   break;
        }
    }
    
    /**
     * Metodo para actualizar la temperatura minima. Se actualizan los tres array de tipo int, donde se almacenan las temperaturas minimas de cada programa.
     * 
     **/
    public void setMinima(){
        switch (miVista.getProgramaComboBox().getSelectedIndex()) {
            case 0:
                miModelo.getPrograma0T()[0] = Integer.parseInt(miVista.getMinima().getValue().toString());
                break;
            case 1:
                miModelo.getPrograma1T()[0] = Integer.parseInt(miVista.getMinima().getValue().toString());
                break;
            case 2:
                miModelo.getPrograma2T()[0] = Integer.parseInt(miVista.getMinima().getValue().toString());
                break;
        }
    }
    
    /**
     * Metodo para actualizar la temperatura maxima. e actualizan los tres array de tipo int, donde se almacenan las temperaturas maximas de cada programa.
     * 
     **/
    public void setMaxima(){
        switch (miVista.getProgramaComboBox().getSelectedIndex()) {
            case 0:
                miModelo.getPrograma0T()[1] = Integer.parseInt(miVista.getMaxima().getValue().toString());
                break;
            case 1:
                miModelo.getPrograma1T()[1] = Integer.parseInt(miVista.getMaxima().getValue().toString());
                break;
            case 2:
                miModelo.getPrograma2T()[1] = Integer.parseInt(miVista.getMaxima().getValue().toString());
                break;
        }
    }
    
    /**
     * Metodo para mostrar un icono de un reloj. Se vuelve visible cuando el boton iniciar del modo manual es activado.
     * 
     **/
    public void iniciarManual(){
            miVista.getTemporizador().setVisible(true);
    }
    
}
