package com.example.Ejercicio2.services.impl;

import com.example.Ejercicio2.dtos.response.OperacionResponse;
import com.example.Ejercicio2.models.Marca;
import com.example.Ejercicio2.models.Operacion;
import com.example.Ejercicio2.models.estrategiasMarcas.EstrategiaTasaAmex;
import com.example.Ejercicio2.models.estrategiasMarcas.EstrategiaTasaNara;
import com.example.Ejercicio2.models.estrategiasMarcas.EstrategiaTasaVisa;
import com.example.Ejercicio2.repositories.OperacionRepository;
import com.example.Ejercicio2.services.IOperacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OperacionServicio implements IOperacionServicio {
    private final OperacionRepository operacionRepository;

    public OperacionResponse getInformacionOperacion(long idOperacion) {
        Operacion operacion = operacionRepository.findOperacionById(idOperacion);

        final float importeInicial=operacion.getMonto();

        Marca marca= operacion.getTarjeta().getMarca();

        marca.configurarEstrategia();

        final String nombreMarca=marca.getNombre();

        final float tasaMarca=marca.calcularTasa();

        final float montoFinal= operacion.calcularMontoFinal();

        return OperacionResponse.builder().nombreMarcaTarjeta(nombreMarca).importeInicial(importeInicial).importeFinal(montoFinal).tasaServicio(tasaMarca).build();
    }
}
