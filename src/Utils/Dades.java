/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.DispositivoElectronico;
import Models.Electrodomestico;
import Models.Usuari;
import Models.Usuaris;

/**
 *
 * @author polfr
 */
public class Dades {
    //CREO ESTE CONSTRUCTOR PARA QUE EN OTROS ARCHIVOS PUEDA SER UTILIZADO
    public Dades(){}
    
    public static Usuari[] cargarDatos(){
        //DATOS QUE SE CARGAN, USUARIOS Y DEMAS
        Electrodomestico electrodomestico = new Electrodomestico("Samsung-Cold","Samsung","Nevera","B");
        DispositivoElectronico[] dispElec = {electrodomestico};
        Usuari usuari1 = new Usuari("Pol","AA1",true);
        Usuari usuari2 = new Usuari("Angel","AA2");
        Usuari usuari3 = new Usuari("Miguel","AA3",false,dispElec);
        Usuari usuari4 = new Usuari("Ana","AA4");
        Usuari usuari5 = new Usuari("Alex","AA5");
        Usuari[] arrayAux = {usuari1,usuari2,usuari3,usuari4,usuari5};
        
        return arrayAux;
    }    
}
