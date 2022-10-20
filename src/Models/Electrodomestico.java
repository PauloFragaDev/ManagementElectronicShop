/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author polfr
 */
//CLASE ELECTRODOMESTICO, EXTENDS DE DISPOSITIVOS ELECTRONICOS
public class Electrodomestico extends  DispositivoElectronico{
    //VARIABLE UNICA DE LA CLASE ELECTRODOMESTICOS
    private String energia;
    //CONSTRUCTOR DE LA CLASE ELECTRODOMESTICO
    public Electrodomestico(String nomIn, String marcaIn, String tipusIn ,String energiaIn){
        //ATRIBUTOS DE ESTA CLASE, 3 DE ELLAS COJEN LOS ATRIBUTOS DE SU PADRE
        //LA CLASE PADRE ES DISPOSITIVOS ELECTRONICOS
        super.nom = nomIn;
        super.marca = marcaIn;
        super.tipus = tipusIn;
        this.energia = energiaIn;
    
    }
    //GET Y SET DEL ATRIBUO PROPIO DE LA CLASE
    public String getEnergia() {
        return energia;
    }
    public void setEnergia(String energia) {
        this.energia = energia;
    }
    //CAMBIO EL TO STRING PARA QUE ME DEVUELVA CIERTAS COSAS QUE NECESITO
    @Override
    
    public String toString(){
    
        return "Nombre: " + getNom() + "\nMarca: " + getMarca() + "\nTipo: " + getTipus() + "\nEstado: " + getEstado();
    }
}
