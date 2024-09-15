package com.sergiofcamejo.veterinaria.controller;

import com.sergiofcamejo.veterinaria.dto.DuenioDTO;
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

    @PostMapping("/crear")
    public ResponseEntity<String> saveDuenio(@RequestBody DuenioDTO duenioDTO) {
        String mensaje;
        HttpStatus status;
        try{
            this.duenioServ.saveDuenio(duenioDTO);
            mensaje = "Dado de alta a " + duenioDTO.getNombre() + " " + duenioDTO.getApellido()
                    + " con su mascota " + duenioDTO.getMascota().getNombre() + ".";
            status = HttpStatus.OK;
        } catch (IllegalArgumentException e) {
            mensaje = e.getMessage();
            status = HttpStatus.BAD_REQUEST;
        }
        return  ResponseEntity.status(status).body(mensaje);
    }

}
