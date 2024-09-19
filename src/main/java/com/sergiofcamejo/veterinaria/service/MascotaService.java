package com.sergiofcamejo.veterinaria.service;

import com.sergiofcamejo.veterinaria.dto.MascotaDTO;
import com.sergiofcamejo.veterinaria.dto.MascotaNuevaDTO;
import com.sergiofcamejo.veterinaria.model.Duenio;
import com.sergiofcamejo.veterinaria.model.Mascota;
import com.sergiofcamejo.veterinaria.repository.IDuenioRepository;
import com.sergiofcamejo.veterinaria.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascoRepo;

    @Autowired
    private IDuenioRepository duenioRepo;

    @Override
    public List<Mascota> getMascotas() {
        return this.mascoRepo.findAll();
    }

    @Override
    public void saveMascota(MascotaNuevaDTO mascotaNuevaDTO) {
        // Se verifica que el dueño exista
        Duenio duenio = this.duenioRepo.findById(mascotaNuevaDTO.getDuenioId())
                .orElseThrow(() -> new RuntimeException("No se encontró a la mascota con el id " +  mascotaNuevaDTO.getDuenioId() + "."));
        // Una vez verificado el dueño, se crea a la mascota
        Mascota mascotaNueva = new Mascota();
        mascotaNueva.setNombre(mascotaNuevaDTO.getNombre());
        mascotaNueva.setRaza(mascotaNuevaDTO.getRaza());
        mascotaNueva.setEspecie(mascotaNuevaDTO.getEspecie());
        mascotaNueva.setColor(mascotaNuevaDTO.getColor());
        mascotaNueva.setDuenio(duenio);
        this.mascoRepo.save(mascotaNueva);

    }

    @Override
    public void editMascota(Long id, MascotaDTO mascotaDTO) {
        Mascota mascotaAEditar = this.finMascota(id);
        if (mascotaDTO.getNombre() != null){
            mascotaAEditar.setNombre(mascotaDTO.getNombre());
        }
        if (mascotaDTO.getEspecie() != null){
            mascotaAEditar.setEspecie(mascotaDTO.getEspecie());
        }
        if (mascotaDTO.getRaza() != null){
            mascotaAEditar.setRaza(mascotaDTO.getRaza());
        }
        if (mascotaDTO.getColor() != null){
            mascotaAEditar.setColor(mascotaDTO.getColor());
        }
        this.mascoRepo.save(mascotaAEditar);
    }

    @Override
    public void deleteMAscota(Long id) {
        this.mascoRepo.deleteById(id);

    }

    @Override
    public Mascota finMascota(Long id) {
        return this.mascoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró a la mascota con el id " +  id + "."));
    }
}
