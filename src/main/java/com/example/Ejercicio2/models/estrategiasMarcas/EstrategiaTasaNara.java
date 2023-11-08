package com.example.Ejercicio2.models.estrategiasMarcas;

import com.example.Ejercicio2.models.EstrategiasTasa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public class EstrategiaTasaNara implements EstrategiasTasa {

    // Implementa el cálculo de la tasa para NARA
    @Override
    public float calcularTasa() {
        LocalDate currentDate = LocalDate.now();
        int dia = currentDate.getDayOfMonth();
        return dia*0.5F;
    }



}
