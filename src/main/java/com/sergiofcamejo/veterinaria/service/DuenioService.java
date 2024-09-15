package com.sergiofcamejo.veterinaria.service;

import com.sergiofcamejo.veterinaria.dto.DuenioDTO;
import com.sergiofcamejo.veterinaria.model.Duenio;
import com.sergiofcamejo.veterinaria.model.Mascota;
import com.sergiofcamejo.veterinaria.repository.IDuenioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DuenioService implements IDuenioService {

    @Autowired
    private IDuenioRepository duenioRepo;

    @Override
    public List<Duenio> getDuenios() {
        return List.of();
    }

    public void saveDuenio(DuenioDTO duenioDTO) {
        // Se verifica que el dueño no exista
        this.verificarDni(duenioDTO.getDni());
        // Se da de alta primero al dueño que trae a la mascota
        Duenio duenio = new Duenio();
        duenio.setDni(duenioDTO.getDni());
        duenio.setNombre(duenioDTO.getNombre());
        duenio.setApellido(duenioDTO.getApellido());
        duenio.setCelular(duenioDTO.getCelular());
        // Se le da de alta a la mascota, no se reciben mascotas sin dueño
        Mascota mascota = new Mascota();
        mascota.setNombre(duenioDTO.getMascota().getNombre());
        mascota.setEspecie(duenioDTO.getMascota().getEspecie());
        mascota.setRaza(duenioDTO.getMascota().getRaza());
        mascota.setColor(duenioDTO.getMascota().getColor());
        // Se asocia la mascota al dueño
        mascota.setDuenio(duenio);
        // Se agrega a la mascota a la posible lista de mascotas que un dueño pueda tener
        duenio.setMascotas(List.of(mascota));
        // Guardar el dueño junto con la mascota
        this.duenioRepo.save(duenio);
    }

    @Override
    public void editDuenio(Long id, DuenioDTO DuenioDTO) {

    }

    private void verificarDni(String dni){
        for (Duenio duenio : this.duenioRepo.findAll()){
            if (duenio.getDni().equals(dni)){
                throw new IllegalArgumentException("La persona con el DNI "
                        + dni + "ya se encuentra registrada en el sistema");
            }
        }
    }
}
