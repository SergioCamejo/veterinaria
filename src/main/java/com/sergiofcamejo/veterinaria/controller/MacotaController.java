package com.sergiofcamejo.veterinaria.controller;

import com.sergiofcamejo.veterinaria.dto.MascotaDTO;
import com.sergiofcamejo.veterinaria.dto.MascotaNuevaDTO;
import com.sergiofcamejo.veterinaria.model.Mascota;
import com.sergiofcamejo.veterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MacotaController {

    @Autowired
    private IMascotaService mascoServ;

    @GetMapping("/traer")
    public List<Mascota> getMAscotas(){
        return this.mascoServ.getMascotas();
    }

    @GetMapping("/traer/{id}")
    public Mascota getMascota(@PathVariable Long id){
        return this.mascoServ.finMascota(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> saveMascota(@RequestBody MascotaNuevaDTO mascotaNuevaDTO){
        String mensaje;
        HttpStatus status;
        try {
            this.mascoServ.saveMascota(mascotaNuevaDTO);
            mensaje = "Se dio de alta a la mascota " + mascotaNuevaDTO.getNombre() + ".";
            status = HttpStatus.OK;
        } catch (IllegalArgumentException e){
            mensaje = e.getMessage();
            status = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(status).body(mensaje);
    }

    @PutMapping("/editar/{id}")
    public Mascota editMascota(@PathVariable Long id, @RequestBody MascotaDTO mascotaDTO){
        this.mascoServ.editMascota(id, mascotaDTO);
        return this.mascoServ.finMascota(id);
    }

    @DeleteMapping("/borrar/{id}")
    public void deleteMascota(@PathVariable Long id){
        this.mascoServ.deleteMAscota(id);
    }
}
