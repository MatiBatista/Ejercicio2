package com.example.Ejercicio2.models.estrategiasMarcas;

import com.example.Ejercicio2.models.EstrategiasTasa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public class EstrategiaTasaAmex implements EstrategiasTasa {

    // Implementa el cálculo de la tasa para AMEX
    @Override
    public float calcularTasa() {
        LocalDate currentDate = LocalDate.now();
        int mes = currentDate.getMonthValue();
        return mes*0.1F;
    }


}