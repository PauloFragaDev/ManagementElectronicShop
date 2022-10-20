/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Menus.MenuUsuaris;
import static Models.Usuaris.usuaris;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author polfr
 */

//CLASE DISPOSITIVO ELECTRONICO
public class DispositivoElectronico {
    //ATRIBUTOS DE ESTA CLASE, NO ESTAN EN PRIVADO PORQUE SON UTILIZADOS POR 
    //LAS CLASES HIJAS
    String nom;
    String marca;
    String tipus;
    //ESTADO DEL PRODUCTO QUE SOLO PODRA SER CAMBIADO POR UN ADMIN
    public String estado = "Pendiente";
    
    //SCANNER PARA LOS METODOS QUE LO NECESITEN
    private final Scanner input = new Scanner(System.in);
    
    //METODO PARA SABER QUE PRODUCTO QUIERE AÑADIR EL CLIENTE
    //SE LE SOLICITA EL TIPO DE PRODUCTO Y LA POSICION DE L'ARRAY DE USUARIOS
    //EN LA QUE SE ENCUENTRA ESTE CLIENTE
    public void añadirProductoACliente(int seleccion, int i){   
        switch(seleccion){
        //DEPENDIENDO QUE ESCOJA SE INICIARA DIFERENTES METODOS
            case 1:
                añadirElectrodomestico(i);
                break;
            case 2:
                añadirOfimatica(i);
                break;
            case 3:
                añadirMultimedia(i);
                break;          
        }
    
    }
    
    //METODO PARA AÑADIR UN OBJETO DE LA CLASE ELECTRODOMESTICO
    public void añadirElectrodomestico(int i){
        //SE CREA UN OBJETO DE LA CLASE USUARIS PARA PODER UTILIZAR METODOS SUYOS
        Usuaris user = new Usuaris();
        //SE LE SOLICITAN DIFERENTES DATOS AL USUARIO, QUE SON LOS ATRIBUTOS QUE
        //TENDRAN ESTOS OBJETOS
        System.out.println("Indique el nombre del producto");
        String nombreRegistrado = input.next();
        System.out.println("Indique la marca del producto");
        String marcaRegistrado = input.next();
        System.out.println("Indique el tipo de producto");
        String tipoRegistrado = input.next();
        System.out.println("Indique la energia del producto");
        String energiaRegistrado = input.next();
        
        
        //DEPENDIENDO CUANTAS POSICIONES TENGA EL ARRAY ENTRADA EN UN ARRAY
        //O EN OTRO
        if (user.usuaris[i].getDispositivos().length == 1){
            DispositivoElectronico[] arrayAux = new DispositivoElectronico[user.usuaris[i].getDispositivos().length];
            for (int j = 0; i < usuaris[i].getDispositivos().length;j++){
                arrayAux[j] = usuaris[i].getDispositivos()[j];
            }
            //SE CREA EL OBJETO PARA LUEGO INCORPORARLO EN EL ARRAY
            Electrodomestico electrodomestico = new Electrodomestico(nombreRegistrado, marcaRegistrado, tipoRegistrado, energiaRegistrado);
            //SE INDICA EN QUE POSICION SE GUARDARA EL OBJETO
            arrayAux[0] = electrodomestico;
            //SE ESTABLECE EL NUEVO ARRAY EN EL ARRAY DISPOSITIVOS DEL USUARIO
            usuaris[i].setDispositivos(arrayAux);
        }
        else {
            DispositivoElectronico[] arrayAux = new DispositivoElectronico[user.usuaris[i].getDispositivos().length + 1];
            for (int j = 0; i < usuaris[i].getDispositivos().length - 1;j++){
                arrayAux[j] = usuaris[i].getDispositivos()[j];
            }
            //SE CREA EL OBJETO PARA LUEGO INCORPORARLO EN EL ARRAY
            Electrodomestico electrodomestico = new Electrodomestico(nombreRegistrado, marcaRegistrado, tipoRegistrado, energiaRegistrado);
            //SE INDICA EN QUE POSICION SE GUARDARA EL OBJETO
            arrayAux[arrayAux.length -1] = electrodomestico;
            //SE ESTABLECE EL NUEVO ARRAY EN EL ARRAY DISPOSITIVOS DEL USUARIO
            usuaris[i].setDispositivos(arrayAux);
        }
    }
    
    //METODO PARA AÑADIR UN OBJETO DE LA CLASE OFIMATICA
    public void añadirOfimatica(int i){
        //SE CREA UN BOOLEAN PARA EL MENU
        boolean menu = true;
        
        //SE CREA UN BOOLEAN PARA INDICAR SI TIENE PANTALLA O NO ESTE
        //DISPOSITIVO ELECTRONICO
        boolean pantallaRegistrada = false;
        
        //SE CREA UN OBJETO DE LA CLASE USUARIS PARA PODER UTILIZAR METODOS SUYOS
        Usuaris user = new Usuaris();
        
        //SE LE SOLICITAN DIFERENTES DATOS AL USUARIO, QUE SON LOS ATRIBUTOS QUE
        //TENDRAN ESTOS OBJETOS
        System.out.println("Indique el nombre del producto");
        String nombreRegistrado = input.next();
        System.out.println("Indique la marca del producto");
        String marcaRegistrado = input.next();
        System.out.println("Indique el tipo de producto");
        String tipoRegistrado = input.next();
        //EN EL SIGUIENTE BUCLE SE INDICA SI TIENE PANTALLA O NO
        //DEPENDIENDO QUE SE MARQUE TENDRA DIFERENTE VALOR
        do{
        System.out.println("Tiene pantalla?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int opcion = input.nextInt();
        switch (opcion){
            case 1:
                pantallaRegistrada = true;
                menu = false;
                break;
            case 2:
                pantallaRegistrada = false;
                menu = false;
                break;
            default:
                System.out.println("Opcion no valida");
        
        }
        }while(menu);
        
        
        if (user.usuaris[i].getDispositivos().length == 1){
            DispositivoElectronico[] arrayAux = new DispositivoElectronico[user.usuaris[i].getDispositivos().length];
            for (int j = 0; i < usuaris[i].getDispositivos().length;j++){
                arrayAux[j] = usuaris[i].getDispositivos()[j];
            }
            //SE CREA EL OBJETO PARA LUEGO INCORPORARLO EN EL ARRAY
            Ofimatica ofimatica = new Ofimatica(nombreRegistrado, marcaRegistrado, tipoRegistrado, pantallaRegistrada);
            //SE INDICA EN QUE POSICION SE GUARDARA EL OBJETO
            arrayAux[0] = ofimatica;
            //SE ESTABLECE EL NUEVO ARRAY EN EL ARRAY DISPOSITIVOS DEL USUARIO
            usuaris[i].setDispositivos(arrayAux);
        }
        else {
            DispositivoElectronico[] arrayAux = new DispositivoElectronico[user.usuaris[i].getDispositivos().length + 1];
            for (int j = 0; i < usuaris[i].getDispositivos().length - 1;j++){
                arrayAux[j] = usuaris[i].getDispositivos()[j];
            }
            //SE CREA EL OBJETO PARA LUEGO INCORPORARLO EN EL ARRAY
            Ofimatica ofimatica = new Ofimatica(nombreRegistrado, marcaRegistrado, tipoRegistrado, pantallaRegistrada);
            //SE INDICA EN QUE POSICION SE GUARDARA EL OBJETO
            arrayAux[arrayAux.length -1] = ofimatica;
            //SE ESTABLECE EL NUEVO ARRAY EN EL ARRAY DISPOSITIVOS DEL USUARIO
            usuaris[i].setDispositivos(arrayAux);
        }
    
    }
    
    //METODO PARA AÑADIR UN OBJETO DE LA CLASE MULTIMEDIA
    public void añadirMultimedia(int i){
    
        Usuaris user = new Usuaris();
        System.out.println("Indique el nombre del producto");
        String nombreRegistrado = input.next();
        System.out.println("Indique la marca del producto");
        String marcaRegistrado = input.next();
        System.out.println("Indique el tipo de producto");
        String tipoRegistrado = input.next();
        System.out.println("Indique la energia del producto");
        int bateriaRegistrada = input.nextInt();
        
        
        
        if (user.usuaris[i].getDispositivos().length == 1){
            DispositivoElectronico[] arrayAux = new DispositivoElectronico[user.usuaris[i].getDispositivos().length];
            for (int j = 0; i < usuaris[i].getDispositivos().length;j++){
                arrayAux[j] = usuaris[i].getDispositivos()[j];
            }
            //SE CREA EL OBJETO PARA LUEGO INCORPORARLO EN EL ARRAY
            Multimedia multimedia = new Multimedia(nombreRegistrado, marcaRegistrado, tipoRegistrado, bateriaRegistrada);
            //SE INDICA EN QUE POSICION SE GUARDARA EL OBJETO
            arrayAux[0] = multimedia;
            //SE ESTABLECE EL NUEVO ARRAY EN EL ARRAY DISPOSITIVOS DEL USUARIO
            usuaris[i].setDispositivos(arrayAux);
        }
        else {
            DispositivoElectronico[] arrayAux = new DispositivoElectronico[user.usuaris[i].getDispositivos().length + 1];
            for (int j = 0; i < usuaris[i].getDispositivos().length - 1;j++){
                arrayAux[j] = usuaris[i].getDispositivos()[j];
            }
            //SE CREA EL OBJETO PARA LUEGO INCORPORARLO EN EL ARRAY
            Multimedia multimedia = new Multimedia(nombreRegistrado, marcaRegistrado, tipoRegistrado, bateriaRegistrada);
            //SE INDICA EN QUE POSICION SE GUARDARA EL OBJETO
            arrayAux[arrayAux.length -1] = multimedia;
            //SE ESTABLECE EL NUEVO ARRAY EN EL ARRAY DISPOSITIVOS DEL USUARIO
            usuaris[i].setDispositivos(arrayAux);
        }
    
    }
    
    //METODO PARA ESTABLECER EL ESTADO DE UN PRODUCTO
    public void cambiarEstadoObjeto(String nombreUsuario, String dniUsuario){
        MenuUsuaris menUs = new MenuUsuaris();
        Usuaris usuari = new Usuaris();
        boolean menu = true;
        boolean menu2 = true;
        
        for (int i = 0; i < usuaris.length; i++){   
            if(nombreUsuario.equals(usuaris[i].getNom()) && dniUsuario.equals(usuaris[i].getDni())){
                DispositivoElectronico[] arrayAux = Arrays.copyOf(usuari.usuaris[i].getDispositivos(), usuari.usuaris[i].getDispositivos().length, DispositivoElectronico[].class);
                for (int j = 0; j < arrayAux.length; j++) {
                    System.out.println(arrayAux[j].imprimirDispositivo());
                    if (arrayAux[j].estado == "Pendiente"){
                        do{
                        System.out.println("Desea cambiar el estado del producto?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        int opcion = input.nextInt();
                        switch (opcion){
                        
                            case 1:
                                do{
                                System.out.println("Seleccione el estado a aplicar:");
                                System.out.println("1. Arreglado");
                                System.out.println("2. Pendiente");
                                int opcion2 = input.nextInt();
                                switch (opcion2){
                                
                                    case 1:
                                        arrayAux[j].setEstado("Arreglado");
                                        menu2 = false;
                                        break;
                                    case 2:
                                        arrayAux[j].setEstado("Pendiente");
                                        menu2 = false;
                                        break;
                                    default:
                                        System.out.println("Opcion no valida");
                                
                                }
                                }while(menu2);
                                menu = false;
                                break;
                            case 2:
                                menu = false;
                                break;
                            default:
                                System.out.println("Opcion Invalida");
                        
                        }
                        }while(menu);
                    }
                }
            }
        }
    }
    
    //CREACION DE METODO PARA ELIMINAR EL PRODUCTO DEL CLIENTE
    public void eliminarProductoCliente(int i){
        
        //CREO UN OBJETO DE LA CLASE USUARIS PARA PODER SOLICITAR METODOS
        Usuaris usuari = new Usuaris();  
        //ARRAY PARA RECORRER USUARIS
        for (int k = 0; k < usuaris.length; k++){
            
            //GUARDO LOS DATOS DE LOS DISPOSITIVOS QUE SE ELINARAN Y LOS DEVUELVO AL ARRAY
            DispositivoElectronico[] arrayAux = Arrays.copyOf(usuari.usuaris[i].getDispositivos(), usuari.usuaris[i].getDispositivos().length, DispositivoElectronico[].class);
            DispositivoElectronico[] arrayAux2 = new DispositivoElectronico[arrayAux.length];
            usuaris[i].setDispositivos(arrayAux2);
        }
    }
    
    //DEFINO UN METODO PARA PODER IMPRIMIR LOS ATRIBUTOS DE LA CLASE
    //DISPOSITIVO ELECTRONICO, ESTE METODO TAMBIEN PUEDE SER UTILIZADO POR LAS 
    //CLASES HIJOS: OFIMATICA & ELECTRODOMESTICOS & MULTIMEDIA
    public String imprimirDispositivo() {
        System.out.println("-------------------------------------------------");
        return "Nombre: " + this.nom + "\nMarca: " + this.marca + "\nTipo: " + this.tipus + "\nEstado: " + this.estado;
    }
    
    // GET & SET DE LOS ATRIBUTOS DE LA CLASE DISPOSITIVO ELECTRONICO
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getTipus() {
        return tipus;
    }
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }  
}
