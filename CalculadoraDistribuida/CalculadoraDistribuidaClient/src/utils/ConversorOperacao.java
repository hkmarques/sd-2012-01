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

package utils;

import negocio.EnumOperacao;

import java.util.HashMap;
import java.util.Map;

/**
 * Conversor de strings em EnumOperacao
 */
public class ConversorOperacao {

    private static Map<String, EnumOperacao> operacoesPorTipo = new HashMap<String, EnumOperacao>() {{
        put("+", EnumOperacao.SOMA);
        put("-", EnumOperacao.SUBTRACAO);
        put("/", EnumOperacao.DIVISAO);
        put(":", EnumOperacao.DIVISAO);
        put("*", EnumOperacao.MULTIPLICACAO);
        put(".", EnumOperacao.MULTIPLICACAO);
        put("x", EnumOperacao.MULTIPLICACAO);
    }};

    public static EnumOperacao obtenhaOperacao(String operacao) {
        EnumOperacao op = operacoesPorTipo.get(operacao);
        return op;
    }

}
