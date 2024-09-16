package com.sergiofcamejo.veterinaria.controller;

import com.sergiofcamejo.veterinaria.dto.DuenioDTO;
import com.sergiofcamejo.veterinaria.exception.DuenioSinMascotaException;
import com.sergiofcamejo.veterinaria.model.Duenio;
import com.sergiofcamejo.veterinaria.service.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duenios")
public class DuenioController {

    @Autowired
    private IDuenioService duenioServ;

    @GetMapping("/traer")
    public List<Duenio> getDuenios(){
        return this.duenioServ.getDuenios();
    }

    @GetMapping("/traer/{id}")
    public Duenio getDuenio(@PathVariable Long id){
        return this.duenioServ.findDuenio(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> saveDuenio(@RequestBody DuenioDTO duenioDTO) {
        String mensaje;
        HttpStatus status;
        try{
            this.duenioServ.saveDuenio(duenioDTO);
            mensaje = "Dado de alta a " + duenioDTO.getNombre() + " " + duenioDTO.getApellido()
                    + " con su mascota " + duenioDTO.getMascota().getNombre() + ".";
            status = HttpStatus.OK;
        } catch (DuenioSinMascotaException | IllegalArgumentException e) {
            mensaje = e.getMessage();
            status = HttpStatus.BAD_REQUEST;
        }
        return  ResponseEntity.status(status).body(mensaje);
    }

    @PutMapping("/editar/{id}")
    public Duenio editDuenio(@PathVariable Long id, @RequestBody DuenioDTO duenioDTO){
        this.duenioServ.editDuenio(id, duenioDTO);
        return this.duenioServ.findDuenio(id);
    }

    @DeleteMapping("/borrar/{id}")
    public void deleteDuenio(@PathVariable Long id){
        this.duenioServ.deteleDuenio(id);
    }

}
