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

}