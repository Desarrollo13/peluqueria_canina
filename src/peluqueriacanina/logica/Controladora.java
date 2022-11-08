
package peluqueriacanina.logica;

import java.util.List;
import peluqueriacanina.persistencia.ControladoraPersistencia;
import peluqueriacanina.persistencia.exceptions.NonexistentEntityException;


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

    public List<Mascota> traerMascotas() {
        return controladorPersistencia.traerMascotas();
        
    }

    public void borrarMascota(int num_cliente) throws NonexistentEntityException {
        controladorPersistencia.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
       return controladorPersistencia.traerMascota(num_cliente);
        
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String nombredueño, String observaciones, String celdueño, String alergico, String atencioesp) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setObservacion(observaciones);
        masco.setAtencion_especial(atencioesp);
        //modifico la mascota
        controladorPersistencia.modificarMascota(masco);
        //seto nuevos valores del dueño
        Dueño dueño= this.buscarDueño(masco.getUnDueño().getId_duenio());
        dueño.setCelDuenio(celdueño);
        dueño.setNombre(nombredueño);
        //llamar al modificar Dueños
        this.modificarDueño(dueño);
        
        
        
    }

    private Dueño buscarDueño(int id_duenio) {
        return controladorPersistencia.traerDueño(id_duenio);
       
    }

    private void modificarDueño(Dueño dueño) {
        controladorPersistencia.modificarDueño(dueño);
    }
    
}
