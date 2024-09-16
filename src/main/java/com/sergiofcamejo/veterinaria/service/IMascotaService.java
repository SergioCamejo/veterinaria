package com.sergiofcamejo.veterinaria.service;

import com.sergiofcamejo.veterinaria.dto.MascotaDTO;
import com.sergiofcamejo.veterinaria.dto.MascotaNuevaDTO;
import com.sergiofcamejo.veterinaria.model.Mascota;

import java.util.List;

public interface IMascotaService {

    public List<Mascota> getMascotas();
    public void saveMascota(MascotaNuevaDTO mascotaNuevaDTO);
    public void editMascota(Long id, MascotaDTO mascotaDTO);
    public void deleteMAscota(Long id);
    public Mascota finMascota(Long id);
}
