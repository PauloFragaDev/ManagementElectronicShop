/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author polfr
 */
//CLASE HIJA DE DISPOSITIVO ELECTRONICO
public class Multimedia extends  DispositivoElectronico{
    //ATRIBUTO UNICO DE ESTA CLASE
    private int bateria;
    //CONSTRUCTOR CON ATRIBUTO UNICO DE LA CLASE MULTIMEDIA
    public Multimedia(String nomIn, String marcaIn, String tipusIn, int bateriaIn){
        //UTILIZO SUPER PARA LLAMAR A LOS ATRIBUTOS DE LA CLASE PADRE
        //LA CLASE PADRE ES DISPOSITIVO ELECTRONICO
        super.nom = nomIn;
        super.marca = marcaIn;
        super.tipus = tipusIn;
        this.bateria = bateriaIn;
    
    }
    //GET & SET DE EL ATRIBUTO BATERIA
    public int getBateria() {
        return bateria;
    }
    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
}
