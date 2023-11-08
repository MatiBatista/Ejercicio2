package com.example.Ejercicio2.repositories;

import com.example.Ejercicio2.models.Operacion;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Long> {

    Operacion findOperacionById(long id);
}
