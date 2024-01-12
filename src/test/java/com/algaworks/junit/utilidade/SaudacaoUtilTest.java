package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


// precisa ter o sufixo Test, algumaCoisaTeste
class SaudacaoUtilTest {

        @Test
        public void saudar() {
            String saudacao = SaudacaoUtil.saudar(9);
            //System.out.println(saudacao);
            Assertions.assertTrue(saudacao.equals("Bom dia"));
        }



}