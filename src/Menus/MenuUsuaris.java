/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Models.DispositivoElectronico;
import Models.Usuaris;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author polfr
 */

//CLASE MENU USUARIS
public class MenuUsuaris {
    
    //SE CREA UN SCANNER PARA PODER UTILIZARLO EN LOS METODOS REQUERIDOS
    private final Scanner input = new Scanner(System.in);
    
    //ESTE EL MENU QUE TIENE EL CLIENTE
    public void menuCliente(String nombreUsuario, int posicion){
        
        //CREO ESTOS OBJETOS DE ESTAS CLASES PARA PODER UTILZIAR SUS METODOS
        DispositivoElectronico dispElec = new DispositivoElectronico();
        Usuaris usuari = new Usuaris();
        //CREO UN BOOLEAN PARA EL MENU
        boolean menu = true;
        
        //SE LE DA LA BIENVENIDA AL USUARIO CON SU NOMBRE, SE LE DA A ESCOGER
        //ENTRE DIFERENTES OPCIONES LO QUE DESA HACER
        System.out.println("-------------------------------------------------");
        System.out.println("\tBienvenido: " + nombreUsuario);
        do{
        System.out.println("-------------------------------------------------");
        System.out.println("1. Añadir producto");
        System.out.println("2. Ver estado de los productos");
        System.out.println("3. Recoger producto arreglado");
        System.out.println("4. Cerrar Sesion ");
        System.out.println("0. Cerrar Aplicacion");
        
        //CON ESTE INT RECOJO LA SOLICITUD
        int opcion = input.nextInt();
        
        //CON EL SWITCH SE ESCOGERA LA OPCION
        //DEPENDIENDO DE QUE SE ESCOJA SE LLAMARA A UN METODO DIFERENTE
        switch (opcion){
            case 1:
                seleccionDeProductoAAñadir(posicion);
                break;
            case 2:
                estadoProducto(posicion);
                break;
            case 3:
                dispElec.eliminarProductoCliente(posicion);
                break;
            case 4:
                menu = false;
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
        
        }
        }while(menu);
    }
    
    //ESTE EL MENU QUE TIENE EL ADMIN
    public void menuAdministrador(String nombreUsuario, int posicion){
        
        //CREO ESTE OBJETO DE ESTA CLASE PARA PODER UTILZIAR SUS METODOS
        Usuaris usuari = new Usuaris();
        
        //CREO UN BOOLEAN PARA EL MENU
        boolean menu = true;
        
        //SE LE DA LA BIENVENIDA AL USUARIO CON SU NOMBRE, SE LE DA A ESCOGER
        //ENTRE DIFERENTES OPCIONES LO QUE DESA HACER
        System.out.println("-------------------------------------------------");
        System.out.println("\tBienvenido administrador: " + nombreUsuario);
        do{
        System.out.println("-------------------------------------------------");
        System.out.println("1. Ver usuarios registrados");
        System.out.println("2. Crear un nuevo usuario Administrador o Cliente");
        System.out.println("3. Eliminar usuario");
        System.out.println("4. Ver producto de un cliente");
        System.out.println("5. Cerrar Sesion");
        System.out.println("0. Cerrar Aplicacion");
        
        //CON ESTE INT RECOJO LA SOLICITUD
        int opcion = input.nextInt();
        
        //CON EL SWITCH SE ESCOGERA LA OPCION
        //DEPENDIENDO DE QUE SE ESCOJA SE LLAMARA A UN METODO DIFERENTE
        switch (opcion){
            case 1:
                usuari.listarUsuarios();
                break;
            case 2:
                seleccionDeUsuario();
                break;
            case 3:
                escogerUsuarioAEliminar();
                break;
            case 4:
                productoCliente();
                break;
            case 5:
                menu = false;
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
        
        }
        }while(menu);
    }
    
    //METODO PARA ELIMINAR UN USUARIO
    public void escogerUsuarioAEliminar(){
        //CREO ESTE OBJETO DE ESTA CLASE PARA PODER UTILZIAR SUS METODOS
        Usuaris usuari = new Usuaris();
        
        //SOLICITO EL NOMBRE Y EL DNI PARA EL USUARIO A ELIMINAR
        System.out.println("-------------------------------------------------");
        System.out.println("\tIndique el usuario a eliminar");
        usuari.listarUsuarios();
        System.out.println("-------------------------------------------------");
        System.out.println("Introduce tu usuario: "); 
        String usuarioRegistrado = input.next();
        System.out.println("Introduce tu DNI: ");
        String dniRegistrado = input.next();
        
        //SE LLAMA A UN METODO DONDE SE LE ENTRGARAN LAS SIGUIENTES VARIABLES 
        usuari.eliminarUsuario(usuarioRegistrado, dniRegistrado);
        
    }
    
    //CON ESTE METODO SE SELECCIONARA QUE TIPO DE USUARIO SE QUEIRE CREAR
    //ESTE METODO SOLO SE PUEDE UTILIZAR EN EL MENU DE ADMIN
    public void seleccionDeUsuario(){
        
        //CREO ESTE OBJETO DE ESTA CLASE PARA PODER UTILZIAR SUS METODOS
        Usuaris usuari = new Usuaris();
        
        //CREO 3 BOOLEAN'S, UNO PARA EL MENU Y LOS OTROS DOS SON VARIABLES QUE 
        //SE ENTREGARAN PARA UNOS METODOS
        boolean menu = true;
        boolean cliente = false;
        boolean admin = true;
        
        //CON ESTE BUCLE SE INDICA QUE TIPO DE USUARIO SE CREARA
        do{
        System.out.println("Escoja el usuario a crear: ");
        System.out.println("1. Cliente");
        System.out.println("2. Administrador");
        int opcion = input.nextInt();
        
        switch(opcion){
            
            //SE LLAMA AL MISMO METODO PERO SE LE ENTREGA UN ATRIBUTO DIFERENTE
            //PARA INDICAR SI ES ADMIN O NO
            case 1: 
                usuari.afegirUsuaris(cliente);
                menu = false;
                break;
            case 2:
                usuari.afegirUsuaris(admin);
                menu = false;
                break;
            default:
                System.out.println("Opcion incorrecta!");
        }
        
        }while(menu);
    }
    
    //METODO PARA SELECCIONAR EL PRODUCTO QUE SE QUIERE AÑADIR
    public void seleccionDeProductoAAñadir(int posicion){
        
        //CREO ESTE OBJETO DE ESTA CLASE PARA PODER UTILZIAR SUS METODOS
        DispositivoElectronico dispElec = new DispositivoElectronico();
        
        //CREO ESTE BOOLEAN PARA EL MENU
        boolean menu = true;
        
        //SE LE PREGUNTA AL USUARIO QUE TIPO DE PRODUCTO QUIERE AÑADIR
        System.out.println("-------------------------------------------------");
        do{
        System.out.println("Indique que producto desea añadir:");
        System.out.println("1. Electrodomestico");
        System.out.println("2. Ofimatica");
        System.out.println("3. Multimedia");
        int opcion = input.nextInt();
        switch(opcion){
            //DEPENDIENDO QUE TIPO DE PRODUCTO ESCOJA SE LLAMARA A UN DIFERENTE
            //METODO Y SE LE DARAN DOS VARIABLES, UNA CON LA POSICION DEL USUARIO
            //Y OTRO CON EL NUMERO QUE HA PUESTO (EL NUMERO IDENTIFICA EL PRODUCTO)
            case 1:
                dispElec.añadirProductoACliente(opcion, posicion);
                menu = false;
                break;
            case 2:
                dispElec.añadirProductoACliente(opcion, posicion);
                menu = false;
                break;
            case 3:
                dispElec.añadirProductoACliente(opcion, posicion);
                menu = false;
                break;
            default:
                System.out.println("Seleccion no valida");
        }
        
        }while(menu);
    }
    
    //METODO PARA VER EL ESTADO DE UN PRODUCTO (ESTE METODO ES PARA CLIENTES)
    public void estadoProducto(int i){
        //CREO ESTE OBJETO DE ESTA CLASE PARA PODER UTILZIAR SUS METODOS
        DispositivoElectronico dispElec = new DispositivoElectronico();
        Usuaris usuari = new Usuaris();
        
        //CREO UN ARRAY PARA PODER RECORRER LOS OBJETOS
        DispositivoElectronico[] arrayAux = Arrays.copyOf(usuari.usuaris[i].getDispositivos(), usuari.usuaris[i].getDispositivos().length, DispositivoElectronico[].class);
        
        for (int j = 0; j < arrayAux.length; j++) {
            //SI EL VALOR DE ESA POSICION NO ES NULLO SE MOSTRARA LOS DATOS DEL
            //PRODCUTO
            if (arrayAux[j] != null){
                System.out.println(arrayAux[j].imprimirDispositivo());
            }else if(arrayAux[j] == null){ // SI ES NULO MOSTRARA ESTE MENSAJE
                System.out.println("-----------------------------------------");
                System.out.println("No hay producto asociado");
            }
                
        }
    }
    
    //METODO PARA VER LOS PRODUCTOS DE UN CLIENTE (ESTE METODO ES PARA ADMINS)
    public void productoCliente(){
        //CREO ESTE OBJETO DE ESTA CLASE PARA PODER UTILZIAR SUS METODOS
        Usuaris usuari = new Usuaris();
        DispositivoElectronico dispElec = new DispositivoElectronico();
        
        
        System.out.println("-------------------------------------------------");
        System.out.println("\tIndique el usuario para ver sus producto");
        usuari.listarUsuarios();
        System.out.println("-------------------------------------------------");
        System.out.println("Introduce tu usuario: "); 
        String usuarioRegistrado = input.next();
        System.out.println("Introduce tu DNI: ");
        String dniRegistrado = input.next();
        //CUANDO SE INDICA EL USUARIO LUEGO SE LLAMARA A ESTE METODO PARA CAMBIAR
        //EL ESTADO DEL PRODUCTO
        dispElec.cambiarEstadoObjeto(usuarioRegistrado, dniRegistrado);
    }
}
