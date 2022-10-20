/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiendaelectronica;

import Menus.Login;
import Models.Usuaris;

/**
 *
 * @author polfr
 */
public class TiendaElectronica {
    
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //SE CREAR LA APP TIENDA ELECTRONICA QUE ES DONDE SE INCIARIA EL PROGRAMA
        TiendaElectronica app = new TiendaElectronica();
        
        app.Start();
        
        
    }

    private void Start() {
        //CREO UN OBJETO LOGIN PARA PODER UTILIZAR SUS METODOS
        Login login = new Login();
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------- Tienda Electronica ------------------------");
        System.out.println("----------------------------------------------------------------");
        //LLAMO AL METODO LOGIN
        login.LoginUsuaris();
        
    }
    
}
