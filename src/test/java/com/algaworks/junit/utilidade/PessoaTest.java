package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void assercaoAgrupada() {
        Pessoa pessoa = new Pessoa("Moisés", "Guilherme");

        // Falha no primeiro não executa o segundo
        //assertEquals("Moisés", pessoa.getNome());
        //assertEquals("Guilherme", pessoa.getSobrenome());

        //Executa os dois
        assertAll("Asserções de pessoas",
                () -> assertEquals("Moisés", pessoa.getNome()),
                () -> assertEquals("Guilherme", pessoa.getSobrenome()));

        }
}