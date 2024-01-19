package com.algaworks.junit.utilidade;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaBancariaTest {

    private static final String MENSAGEM_ERRO_VALUE = "Valor inválido";
    private static final String MENSAGEM_ERRO_SALDO = "Saldo insuficiente";

    @Test
    public void saldoContaNaoPodeSerNulo() {

        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null) );
        assertEquals(MENSAGEM_ERRO_VALUE, illegalArgumentException.getMessage());

    }

    @Test
    public void saldoContaPodeSerZero() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(0));
        assertEquals(new BigDecimal(0), conta.saldo());
    }

    @Test
    public void saldoContaPodeSerNegativo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(-100));
        assertEquals(new BigDecimal(-100), conta.saldo());
    }

    @Test
    public void saqueNaoPodeSerNulo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(100));
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> conta.saque(null));

        assertEquals(MENSAGEM_ERRO_VALUE, illegalArgumentException.getMessage());
    }


    @Test
    public void saqueNaoPodeSerNegativo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(100));
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> conta.saque(new BigDecimal(-100)) );

        assertEquals(MENSAGEM_ERRO_VALUE, illegalArgumentException.getMessage());
    }

    @Test
    public void saqueDeveSubtrairValorSaldo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(100));
        conta.saque(new BigDecimal(100));
        assertEquals(BigDecimal.ZERO, conta.saldo());
    }

    @Test
    public void saqueSaldoInsuficiente() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(100));
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> conta.saque(new BigDecimal(101)));

        assertEquals(MENSAGEM_ERRO_SALDO, runtimeException.getMessage());
    }


    //deposito
    @Test
    public void depositoNaoPodeSerNulo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(100));
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> conta.deposito(null));

        assertEquals(MENSAGEM_ERRO_VALUE, illegalArgumentException.getMessage());
    }


    @Test
    public void depositoNaoPodeSerNegativo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(100));
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> conta.deposito(new BigDecimal(-100)) );

        assertEquals(MENSAGEM_ERRO_VALUE, illegalArgumentException.getMessage());
    }


    @Test
    public void saqueDeveAdicionarValorSaldo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(100));
        conta.deposito(new BigDecimal(100));
        assertEquals(new BigDecimal(200), conta.saldo());
    }

    @Test
    public void verificaSaldo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(100));
        assertEquals(new BigDecimal(100), conta.saldo());
    }

}