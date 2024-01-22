package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;
import com.algaworks.junit.blog.modelo.Ganhos;
import com.algaworks.junit.blog.modelo.Post;
import com.algaworks.junit.blog.utilidade.ProcessadorTextoSimples;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraGanhosTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Antes de todos os testes");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Antes de cada testee");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Depois de todos os testes");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Depois de cada teste");
    }


    @Test
    public void deveCalcularGanhos() {
        CalculadoraGanhos cacluladora = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);

        Editor autor = new Editor(1L, "Alex", "alex@gmail.com", new BigDecimal(5), true);

        Post post = new Post(1L, "Ecossistema Java", "O ecossistema do Java é muito maduro", autor, "ecossistema-java-abc123", null, false, false);

        Ganhos ganhos = cacluladora.calcular(post);

        assertEquals(new BigDecimal("45"), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());

    }

    @Test
    public void deveCalcularGanhosSemPremium() {
        CalculadoraGanhos cacluladora = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);

        Editor autor = new Editor(1L, "Alex", "alex@gmail.com", new BigDecimal(5), false);

        Post post = new Post(1L, "Ecossistema Java", "O ecossistema do Java é muito maduro", autor, "ecossistema-java-abc123", null, false, false);

        Ganhos ganhos = cacluladora.calcular(post);

        assertEquals(new BigDecimal("35"), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());

    }

}