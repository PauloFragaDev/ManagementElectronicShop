/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;
import Models.Usuaris;
import java.util.Scanner;

/**
 *
 * @author polfr
 */
public class Login {
    //CONSTRUCTOR DE LOGIN PARA PODER LLAMAR AL OBJETO DESDE OTRO ARCHIVO
    public Login(){}
    //SCANNER PARA UTILIZARLO EN LOS METODOS
    private Scanner input = new Scanner(System.in);
    //CREO UN OBJETO DE LA CLASE USUARIOS PARA PODER LLAMAR A SUS METODOS DESDE AQUI
    Usuaris usuaris = new Usuaris();
    //METODO QUE SE UTILIZA EN TiendaElectronica PARA EL LOGIN DE LA APLICACION
    public void LoginUsuaris(){
        //BOOLEAN PARA EL MENU
        boolean menu = true;
        do{
        //SE LE DA AL USUARIO QUE ESCOJA ENTRE DIFERENTES OPCIONES MEDIANTE UN SWITCH
        System.out.println("\t Indique una opcion:\n 1. Acceder\n 2. Registrarse\n 0. Salir");
        int opcion = input.nextInt();
        
        switch(opcion){        
            case 1:
                //LLAMA A UNA FUNCION INTERNA DE EL ARCHIVO
                validacionUsuario();
                break;
            case 2:
                //LLAMA A UNA FUNCION INTERNA DE EL ARCHIVO
                nuevoUsuario();
                break;
            case 0:
                //SALE DE ESTE MENU PARA ACABAR DE EJECUTARSE LA APLICACION
                menu = false;
                break;
            default:
                //SI NO INDICA UNA OPCION CORRECTA APARECE ESTO
                System.out.println("Opcion incorrecta");
                break;
        }        
        }while(menu);
    }
    
    public void nuevoUsuario(){
        //ESTABLEZCO UN BOOLEAN PARA INDICAR QUE EL USUARIO QUE SE CREA ES CLIENTE
        //LOS USUARIOS QUE SE CREAN EN ESTE METODO SOLO SERAN CLIENTE
        //LA UNICA FORMA DE CREAR UN USUARIO ADMIN ES ENTRANDO CON UN USUARIO ADMIN Y DESDE AHI EN UNA DE LAS OPCIONES
        boolean user = false;
        //SE LLAMA A UN METODO DE LA CLASE USUARIS MEDIANTE UN NOBJETO
        //ESTE METODO ES PARA CREAR UN USUARIO
        usuaris.afegirUsuaris(user);
    }
    
    public void validacionUsuario(){
        //SE LLAMA A UN METODO DE LA CLASE USUARIS MEDIANTE UN OOBJETO
        //ESTE METODO ES PARA ACCEDER AL MENU, VALIDA AL USUARIO SI ES QUE EXISTE EN EL ARRAY
        usuaris.accederCuenta();
    }

}
