package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// precisa ter o sufixo Test, algumaCoisaTeste
class SaudacaoUtilTest {

        @Test
        public void saudar() {
            String saudacao = SaudacaoUtil.saudar(9);
            //System.out.println(saudacao);
            //Assertions.assertTrue(saudacao.equals("Bom dia"));
            assertEquals("Bom dia", saudacao, "Saudacão incorreta!");
        }

        @Test
        public void deveLancarException() {
            //SaudacaoUtil.saudar(-10); // erro
            IllegalArgumentException illegalArgumentException =
                    assertThrows(IllegalArgumentException.class,
                    () -> SaudacaoUtil.saudar(-10));

            assertEquals("Hora inválida", illegalArgumentException.getMessage());
        }


        @Test
        public void naoDeveLancarException() {
            assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
        }

}