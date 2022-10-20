/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author polfr
 */
//OFIMATICA ES UNA CLASE HIJA DE DISPOSITIVOS ELECTRONICOS
public class Ofimatica extends  DispositivoElectronico{
    //LE ESTABLEZCO UN ATRIBUTO UNICO PARA ESTA CLASE
    private boolean pantalla = false;
    //CONSTRUCTOR SIN EL ATRIBUTO UNICO
    public Ofimatica(String nomIn, String marcaIn, String tipusIn){
    
        super.nom = nomIn;
        super.marca = marcaIn;
        super.tipus = tipusIn;
    
    }
    //CONSTRUCTOR CON ATRIBUTO UNICO
    public Ofimatica(String nomIn, String marcaIn, String tipusIn, boolean pantallaIn){
    
        super.nom = nomIn;
        super.marca = marcaIn;
        super.tipus = tipusIn;
        this.pantalla = pantallaIn;
    
    }
    //GET Y SET DEL ATRIBUTO UNICO (PANTALLA)
    public boolean isPantalla() {
        return pantalla;
    }
    public void setPantalla(boolean pantalla) {
        this.pantalla = pantalla;
    }
    
}
