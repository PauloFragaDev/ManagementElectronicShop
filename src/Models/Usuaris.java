/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;



import Menus.MenuUsuaris;
import Utils.Dades;
import static Utils.Dades.cargarDatos;
import java.util.Scanner;

/**
 *
 * @author polfr
 */
//CLASE USUARIS
public class Usuaris {
    //CREO ESTE OBJETO DE LA CLASE MENU USUARIS PARA PODER UTILIZAR SUS METODOS
    MenuUsuaris menUsu = new MenuUsuaris();
    
    //CREO ESTE OBJETO DE LA CLASE DADES PARA PODER LLAMAR AL METODO DONDE SE
    //CARGAN LOS DATOS DE LOS USUARIOS
    Dades dades = new Dades();
    
    //DECLARO UN SCANNER COMO INPUT Y FINAL
    private final Scanner input = new Scanner(System.in);
    
    //CREO EL ARRAY DE USUARIOS, AUTOMATICAMENTE SE CARGAN LOS DATOS DE ESTOS
    public static Usuari[] usuaris = cargarDatos();
    
    //METODO PARA AGREGAR USUARIOS, SOLICITO UN BOOLEAN ADMIN QUE DEPENDIENDO
    //DE DONDE SE LLAMA ESTE METODO SE LE DA VALOR FALSE O TRUE A ADMIN
    public void afegirUsuaris(boolean admin){
        //SOLICITO UN NOMBRE Y SE ALMACENA EN LA VARIABLE STRING NOMBRE
        System.out.println("Introduzca su nombre:");
        String nombre = input.next();
        
        //SOLICITO EL DNI Y SE ALMACENA EN LA VARIABLE STRING DNI
        System.out.println("Introduzca su DNI:");
        String dniIn = input.next();
        
        //CREO UN FOR PARA COMPROBAR SI DENTRO DEL ARARY USUARIOS, DENTRO DE UN
        //OBJETO HAY UN NOMBRE Y DNI IDENTICOS A LOS YA INTRODUCIDOS
        for (int i = 0; i < usuaris.length;i++){    
            if (usuaris[i].getNom().equals(nombre) && usuaris[i].getDni().equals(dniIn)){
                //INDICO QUE EL USUARIO YA EXISTE
                System.out.println("El usuario ya existe.");
                //CON EL RETURN HAGO QUE SE SALGA DEL METODO
                return;
            }
        }
        //EN CASO DE NO HABER UN USUARIO CON ESE MISMO NOMBRE Y DNI SE CREARA UN
        //ARRAY AUXILIAR CON LA MISMA LONGITUD +1 DEL ARRAY USUARIS
        Usuari[] arrayAux = new Usuari[usuaris.length + 1];
        
        //RECORRO EL ARRAY USUARIS Y EN CADA POSICION DE ESTE VOY GUARDANDO SUS
        //DATOS EN EL ARRAY AUXILIAR
        for (int j = 0; j < usuaris.length;j++){
            arrayAux[j] = usuaris[j];
        }
        
        //UNA VEZ GUARDADO LOS DATOS EN EL NUEVO ARRAY, CREO AL NUEVO USUARIO
        Usuari usuari = new Usuari(nombre, dniIn, admin);
        
        //CREADO EL NUEVO USUARIO, ESTABLEZCO LA POSICION DONDE SE GUARDARA
        arrayAux[arrayAux.length - 1] = usuari;
        
        //ACABADO CON LO ANTERIOR HAGO QUE EL ARRAY DE USUARIOS OBTENGA TODO DE
        //EL ARRAY AUXILIAR
        usuaris = arrayAux;
        
    }
    
    //METODO PARA LISTAR A LOS USUARIOS
    public void listarUsuarios(){
        //CREO UN FOR EACH PARA RECORRER EL ARRAY DE USUARIOS
        for (Usuari usuari : usuaris) {
            //UTILIZO EL OBJETO USUARI PARA EXTRAER CADA OBJETO DEL ARRAY Y 
            //MEDIANTE UN METODO DE LA CLASE USUARIO IMPRIMO LOS VALORES DE ESTOS
            //POR PANTALLA
            usuari.imprimirUsuario();
        }
    
    }
    
    //METODO PARA VERIFICAR AL USUARIO ANTES DE ACCEDER A DICHOS MENUS
    public void accederCuenta(){
        //CREO UN BOOLEAN PARA HACER UNA COMPROBACION / TAMBIEN CREO DIFERENTES
        //STRING'S PARA GUARDAR DATOS PARA LA VALIDACION
        boolean comprobacion = true;
        String usuarioRegistrado;
        String dniRegistrado;
        
        //EL USUARIO INTRODUCE EL NOMBRE
        System.out.println("Introduce tu usuario: "); 
        usuarioRegistrado = input.next();
        
        //EL USUARIO INTRODUCE UN DNI
        System.out.println("Introduce tu DNI: ");
        dniRegistrado = input.next();
        
        //DENTRO DE ESTE FOR VERIFICO QUE EL USUARIO EXISTA EN EL ARRAY
        for (int i = 0; i < usuaris.length; i++) {
            //CON EL SIGUIENTE IF EXTRAIGO EL ATRIBUTO NOM DE CADA OBJETO
            //Y CON EL EQUALS VERIFICO SI SON IDENTICOS, EN CASO QUE SI ENTRA
            //DENTRO DEL IF (EXTRAIGO EL NOMBRE Y DNI)
            if (usuarioRegistrado.equals(usuaris[i].getNom()) && dniRegistrado.equals(usuaris[i].getDni())) {
                //CON EL SIGUIENTE IF VERIFICO SI ES ADMIN DE LA MISMA MANERA QUE ANTES
                if (usuaris[i].isAdmin() == true) {
                    //EN CASO QUE SEA LLAMO A UN METODO DE LA CLASE MENUS USUARIS
                    //EN ESTE METODO LE PASO EL NOMBRE DEL USUARIO Y LA POSICION
                    //EN LA CUAL SE ENCUENTRA EN EL ARRAY PARA AHORRARME CODIGO
                    menUsu.menuAdministrador(usuarioRegistrado, i);
                    //ESTE BOOLEAN LO MARCO EN FALSO PARA QUE LUEGO CUANDO SALGA
                    //DE ESTE MENU NO ENTRE EN OTRO IF
                    comprobacion = false;
                    break;
                }
                //EN CASO QUE NO HAYA ENTRADO EN EL ANTERIOR IF SIGNIFICARA QUE
                //EL USUARIO ES CLIENTE, ENTONCES ACCEDERA A OTRO MENU SOLO PARA
                //CLIENTES, TAMBIEN SE LE PASARAN LOS MISMOS VALORES QUE EN ADMIN
                menUsu.menuCliente(usuarioRegistrado, i);
                comprobacion = false;
                break;
            }
        }
        
        //EN CASO QUE SE HAYA HECHO EL FOR Y EL VALOR DEL BOOLEAN SIGUE EN TRUE
        //ACCEDERA A ESTE IF DONDE SE DARA A MOSTRAR QUE EL USUARIO O LA CONTRASEÑA
        //QUE HA INTRODUCIDO NO ES VALIDA
        if(comprobacion){
            System.out.println("Usuario o DNI incorrectos");
        }
    }
    
    //METODO PARA ELIMINAR USUARIOS, SE SOLICITA EL NOMBRE Y DNI
    public void eliminarUsuario(String nombreUsuario, String dniUsuario){
        
        //SE CREA UN ARRAY MENOS UNA POSICION
        Usuari[] arrayAux = new Usuari[usuaris.length - 1];
        
        //SE RECORRERA EL ARRAY PARA IR GUARDANDO LOS DATOS
        for (int i = 0; i < usuaris.length; i++){   
            
            //CON EL IF INDICAMOS DE QUE MIENTRAS EL NOMBRE QUE SE SOLICITA NO SEA
            //IGUAL AL ATRIBUTO NOMBRE DEL OBJETO QUE SE META Y GUARDE ESE OBJETO EN EL OTRO ARRAY
            //ESTO SE APLICA CON DNI TAMBIEN
            if(!nombreUsuario.equals(usuaris[i].getNom()) && !dniUsuario.equals(usuaris[i].getDni())){
                arrayAux[i] = usuaris[i];
            }
        }
        
        //UNA VEZ SE HAYAN GUARDADO LOS DATOS ESTABLECEREMOS LAS CARACTERISTICAS
        //DE ARRAY AUXILIAR EN EL ARRAY USUARIS
        usuaris = arrayAux;
    }   
}
