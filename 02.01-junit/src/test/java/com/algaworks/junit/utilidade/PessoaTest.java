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

        //Executa os dois teste
        //Não é interessante ter muita asserções em um único teste.
        //Avaliar apenas um único cenário
        assertAll("Asserções de pessoas",
                () -> assertEquals("Moisés", pessoa.getNome()),
                () -> assertEquals("Guilherme", pessoa.getSobrenome()));

        }
}