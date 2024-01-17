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