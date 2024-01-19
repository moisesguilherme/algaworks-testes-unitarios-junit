package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo) {
        //TODO 1 - validar saldo: não pode ser nulo, caso seja deve lançar uma IllegalArgumentException
        //TODO 2 - pode ser zero ou negativo

        if(saldo == null)
            throw new IllegalArgumentException("Valor inválido");

        this.saldo = saldo;
    }

    public void saque(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo ou menor que zero, caso seja deve lançar uma IllegalArgumentException
        //TODO 2 - Deve subtrair o valor do saldo
        //TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException
        if(valor == null || valor.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor inválido");

        if(valor.compareTo(saldo) > 0)
            throw new RuntimeException("Saldo insuficiente");

        this.saldo = saldo.subtract(valor);
    }

    public void deposito(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo ou menor ue zero uma IllegalArgumentException
        //TODO 2 - Deve adicionar o valor ao saldo
        //TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException

        if(valor == null || valor.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor inválido");

        this.saldo = saldo.add(valor);
    }

    public BigDecimal saldo() {
        //TODO 1 - retornar saldo
        return this.saldo;
    }
}
