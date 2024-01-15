package com.algaworks.junit.utilidade;

import java.time.Duration;

public class SimuladorEspera {

    private SimuladorEspera() {

    }

    public static void esperar(Duration duration) {
        try {
            System.out.println(duration.toMillis());
            Thread.sleep(duration.toMillis());
        } catch (Exception ignored) {

        }
    }

}
