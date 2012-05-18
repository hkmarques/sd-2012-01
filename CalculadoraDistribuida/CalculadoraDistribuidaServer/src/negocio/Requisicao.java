// Copyright © 2011 Herick Oliveira <mailto:hkmarques@gmail.com>
//
// This file is part of CalculadoraDistribuidaServer.
// CalculadoraDistribuidaServer is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// CalculadoraDistribuidaServer is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// See <http://www.gnu.org/licenses/> if no copy of the GNU General
// Public License was made available along with this copy of CalculadoraDistribuidaServer.

package negocio;

import java.util.UUID;

/**
 * Classe representativa de uma requisicão/operacão a ser solicitada ao servidor da Calculadora Distribuída.
 */
public class Requisicao {

    // O identificador da requisićão.
    public final UUID ID;

    // O primeiro operando da operaćão.
    private double operando1;

    // O segundo operando da operaćão.
    private double operando2;

    // O tipo de operaćão.
    private EnumOperacao operacao;

    /**
     * Construtor da classe Requisicao.
     *
     * @param operando1 o primeiro operando da operacão
     * @param operando2 o segundo operando da operacão
     * @param operacao  o tipo de operacão
     */
    public Requisicao(double operando1, double operando2, EnumOperacao operacao) {
        this.ID = UUID.randomUUID();
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacao = operacao;
    }

    /**
     * Construtor da classe Requisicao.
     *
     * @param id        o identificador da requisicão
     * @param operando1 o primeiro operando da operacão
     * @param operando2 o segundo operando da operacão
     * @param operacao  o tipo de operacão
     */
    public Requisicao(UUID id, double operando1, double operando2, EnumOperacao operacao) {
        this.ID = id;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacao = operacao;
    }

    /**
     * Sobrescreve o método toString padrão.
     *
     * @return uma string representativa da operaćão associada
     */
    public String toString() {
        StringBuilder builder = new StringBuilder(ID.toString());
        builder.append(' ');
        builder.append(operando1);
        builder.append(' ');
        builder.append(operacao);
        builder.append(' ');
        builder.append(operando2);

        return builder.toString();
    }

    // ----------------------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------------------
    // ----------------------------------------- GETTERS / SETTERS ----------------------------------------------
    // ----------------------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------------------

    public UUID getID() {
        return ID;
    }

    public double getOperando1() {
        return operando1;
    }

    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    public double getOperando2() {
        return operando2;
    }

    public void setOperando2(double operando2) {
        this.operando2 = operando2;
    }

    public EnumOperacao getOperacao() {
        return operacao;
    }

    public void setOperacao(EnumOperacao operacao) {
        this.operacao = operacao;
    }
}
