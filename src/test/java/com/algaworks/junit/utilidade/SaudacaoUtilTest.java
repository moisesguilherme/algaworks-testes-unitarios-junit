package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;

class SaudacaoUtilTest {

        @Test
        public void saudarComBomDia() {
            int horaValida = 9;
            String saudacao = saudar(horaValida);
            assertEquals("Bom dia", saudacao);
        }


        @Test
        public void saudarComBomDiaApartir5h() {
            int horaValida = 5;
            String saudacao = saudar(horaValida);
            assertEquals("Bom dia", saudacao);
        }



    @Test
    public void saudarComBoaNoite4h() {
        int horaValida = 4;
        String saudacao = saudar(horaValida);
        assertEquals("Boa noite", saudacao);
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