package com.sergiofcamejo.veterinaria.service;

import com.sergiofcamejo.veterinaria.dto.DuenioDTO;
import com.sergiofcamejo.veterinaria.model.Duenio;

import java.util.List;

public interface IDuenioService {

    public List<Duenio> getDuenios();
    public void saveDuenio (DuenioDTO duenioDTO);
    public void editDuenio(Long id, DuenioDTO DuenioDTO);
}
