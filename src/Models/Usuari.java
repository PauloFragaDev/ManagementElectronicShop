/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author polfr
 */
//CLASE USUARIO
public class Usuari {
    //ATRIBUTOS DE UN USUARIO
    private String nom;
    private String dni;
    //SE CREA ESTE BOOLEAN PARA IDENTIFICAR A UN USUARIO SI ES ADMIN O CLIENTE
    private boolean admin = false;
    //CREO UN ARRAY DISPOSITIVO ELECTRONICO DONDE DENTRO SE GUARDAN LOS DISPOSITIVOS
    //DE CADA USUARIO, DENTRO DE ESTE ARRAY SE PUEDEN INTRODUCIR OBJETOS COMO:
    //ELECTRODOMESTICOS & MULTIMEDIA & OFIMATICA
    private DispositivoElectronico[] dispositivos = new DispositivoElectronico[0];
    
    //CONSTRUCTOR VACIO
    public Usuari(){}
    
    //CONSTRUCTOR SOLO CON NOMBRE Y DNI
    public Usuari(String nomIn, String dniIn){
        this.nom = nomIn;
        this.dni = dniIn;
    }
    //CONSTRUCTOR CON NOMBRE & DNI & BOOLEAN ADMIN PARA DETERMINAR AL USUARIO
    public Usuari(String nomIn, String dniIn, boolean adminIn){
        this.nom = nomIn;
        this.dni = dniIn;
        this.admin = adminIn;
    }
    //CONSTRUCTOR COMPLETO CON TODOS SUS ATRIBUTOS
    public Usuari(String nomIn, String dniIn,boolean adminIn,DispositivoElectronico[] dispositivosIn){
        this.nom = nomIn;
        this.dni = dniIn;
        this.admin = adminIn;
    }
    
    //METODO PARA IMPRIMIR LOS DATOS DE UN USUARIO
    public void imprimirUsuario() {
        System.out.println("-------------------------------------------------");
        System.out.println("Nom: " + this.nom + "\nDni: " + this.dni + "\nAdmin: " + this.admin);
    }

    //GET & SET DE TODOS LOS ATRIUTOS DE LA CLASE USUARI
    public String getNom() {
        return nom;
    }
    public void setNom(String aNom) {
        nom = aNom;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String aDni) {
        dni = aDni;
    }
    public DispositivoElectronico[] getDispositivos() {
        return dispositivos;
    }
    public void setDispositivos(DispositivoElectronico[] dispositivos) {
        this.dispositivos = dispositivos;
    }
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }   
}
