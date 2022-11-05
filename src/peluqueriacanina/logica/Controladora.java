
package peluqueriacanina.logica;

import peluqueriacanina.persistencia.ControladoraPersistencia;


public class Controladora {
    
   ControladoraPersistencia controladorPersistencia= new ControladoraPersistencia() ;

    public void guardar(String nombreMasco, String raza, String color, String nombredueño, String observaciones, String celdueño, String alergico, String atencioesp) {
        
        Dueño dueño= new Dueño();
        //Creamos el dueños y asignamos sus valores
        dueño.setNombre(nombredueño);
        dueño.setCelDuenio(celdueño);
        Mascota mascota= new Mascota();
        //Creamos la mascota y asignamos sus valores
        mascota.setNombre(nombreMasco);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atencioesp);
        mascota.setObservacion(observaciones);
        mascota.setUnDueño(dueño);
        //creamos en la base de datos los objetos
        controladorPersistencia.guardar(dueño,mascota);
        
        
  }
    
}
