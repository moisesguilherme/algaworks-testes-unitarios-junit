package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class SimuladorEsperaTest {


    //@Disabled("Não é mais aplicável")
    //@EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
    @Test
    void deveEsperarENaoDarTimeout() {

        //System.setProperty("ENV", "PROD");
        //System.out.println("PROD".equals(System.getenv("ENV")));
        Assumptions.assumeTrue("PROD".equals(System.getenv("ENV")), () -> "Abortado teste: Não deve ser executado em PROD");
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1),
                () -> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }
}