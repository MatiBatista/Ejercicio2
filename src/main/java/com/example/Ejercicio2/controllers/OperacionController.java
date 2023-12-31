package com.example.Ejercicio2.controllers;

import com.example.Ejercicio2.dtos.request.MarcaEImporteRequest;
import com.example.Ejercicio2.dtos.response.OperacionResponse;
import com.example.Ejercicio2.dtos.response.TasaOperacionResponse;
import com.example.Ejercicio2.services.IOperacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OperacionController {

    private final IOperacionServicio operacionServicio;

    @GetMapping(value="/operacion/{idOperacion}")
    public ResponseEntity<OperacionResponse> getOperacion(@PathVariable long idOperacion){

        return ResponseEntity.status(HttpStatus.OK).body(operacionServicio.getInformacionOperacion(idOperacion));
    }

    @GetMapping(value="/operacion/tasaOperacion")
    public ResponseEntity<TasaOperacionResponse> getTasaOperacion(@RequestBody MarcaEImporteRequest marcaEImporteRequest){

        return ResponseEntity.status(HttpStatus.OK).body(operacionServicio.getTasaDeOperacion(marcaEImporteRequest));
    }
}
