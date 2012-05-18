// Copyright © 2011 Herick Oliveira <mailto:hkmarques@gmail.com>
//
// This file is part of CalculadoraDistribuidaClient.
// CalculadoraDistribuidaClient is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// CalculadoraDistribuidaClient is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// See <http://www.gnu.org/licenses/> if no copy of the GNU General
// Public License was made available along with this copy of CalculadoraDistribuidaClient.

package negocio;

import java.util.UUID;

/**
 * Classe representativa da resposta a uma requisicão/operacão.
 */
public class Resposta {

    // O identificador da requisicão.
    private final UUID IDRequisicao;

    // O resultado da operacão/requisicão associada.
    private final double resultado;

    /**
     * Construtor da classe Requisicao.
     *
     * @param idRequisicao o identificador da requisicão associada
     * @param resultado    o resultado da requisicao
     */
    public Resposta(UUID idRequisicao, double resultado) {
        this.IDRequisicao = idRequisicao;
        this.resultado = resultado;
    }

    /**
     * Sobrescreve o método toString padrão.
     *
     * @return uma string representativa do resultado da requisicão associada
     */
    public String toString() {
        return Double.toString(resultado);
    }

    // ----------------------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------------------
    // ----------------------------------------- GETTERS / SETTERS ----------------------------------------------
    // ----------------------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------------------

    public UUID getIDRequisicao() {
        return IDRequisicao;
    }

    public double getResultado() {
        return resultado;
    }
}
