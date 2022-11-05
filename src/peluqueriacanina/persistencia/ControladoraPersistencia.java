
package peluqueriacanina.persistencia;

import peluqueriacanina.logica.Dueño;
import peluqueriacanina.logica.Mascota;


public class ControladoraPersistencia {
    DueñoJpaController dueñojpa= new DueñoJpaController();
    MascotaJpaController mascotajpa = new MascotaJpaController();

    public void guardar(Dueño dueño, Mascota mascota) {
        //crear en la BD el Dueño
        dueñojpa.create(dueño);
        //crear en la BD el Mascota
        mascotajpa.create(mascota);
    }
    
}
