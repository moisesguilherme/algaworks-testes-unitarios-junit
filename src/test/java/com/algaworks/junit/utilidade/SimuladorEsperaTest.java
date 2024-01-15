package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

    @Test
    void deveEsperarENaoDarTimeout() {

        // Espera os 10 segundos
        //Assertions.assertTimeout(Duration.ofSeconds(1),
        //        () -> SimuladorEspera.esperar(Duration.ofSeconds(10)));

        // Não vai esperar os 10 segundos, se passar de 1 já vai dar erro
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1),
                () -> SimuladorEspera.esperar(Duration.ofMillis(10)));

        // FIRST -
        // Primeiro F (FAST)
        // Fast: Testes unitários deven ser rápidos (Rodar em segundos ou menos)

    }
}