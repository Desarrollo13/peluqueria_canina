
package peluqueriacanina.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import peluqueriacanina.logica.Dueño;
import peluqueriacanina.logica.Mascota;
import peluqueriacanina.persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    DueñoJpaController dueñojpa= new DueñoJpaController();
    MascotaJpaController mascotajpa = new MascotaJpaController();

    public void guardar(Dueño dueño, Mascota mascota) {
        //crear en la BD el Dueño
        dueñojpa.create(dueño);
        //crear en la BD el Mascota
        mascotajpa.create(mascota);
    }

    public List<Mascota> traerMascotas() {
        return mascotajpa.findMascotaEntities();
        
    }

    public void borrarMascota(int num_cliente) throws NonexistentEntityException {
        mascotajpa.destroy(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
       return mascotajpa.findMascota(num_cliente);
        
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotajpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Dueño traerDueño(int id_duenio) {
        return dueñojpa.findDueño(id_duenio);
    }

    public void modificarDueño(Dueño dueño) {
        try {
            dueñojpa.edit(dueño);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
