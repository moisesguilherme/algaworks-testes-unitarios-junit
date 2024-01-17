package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

// precisa ter o sufixo Test, algumaCoisaTeste
class SaudacaoUtilTest {

        private static final String SAUDACAO_INCORRETA = "Saudação incorreta!";

        @Test
        public void deveSaudarBomDia() {
            Random faixaBomDia = new Random();
            int numeroAleatorioDentroDaFaixaBomDia = faixaBomDia.nextInt(12);
            String saudacao = SaudacaoUtil.saudar(numeroAleatorioDentroDaFaixaBomDia);
            System.out.println(">> " + numeroAleatorioDentroDaFaixaBomDia);
            assertEquals("Bom dia", saudacao, SAUDACAO_INCORRETA);
        }


        @Test
        public void deveSaudarBoaTarde() {
            String saudacao = SaudacaoUtil.saudar(12);
            assertEquals("Boa tarde", saudacao, "Saudação incorreta");
        }

        @Test
        public void deveSaudarBoaNoite() {
            String saudacao = SaudacaoUtil.saudar(18);
            assertEquals("Boa noite", saudacao, "Saudação incorreta");
        }


    @Test
        public void deveLancarException() {
            //SaudacaoUtil.saudar(-10); // erro
            //Executando o Debug com teste (Colocar o break point)
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