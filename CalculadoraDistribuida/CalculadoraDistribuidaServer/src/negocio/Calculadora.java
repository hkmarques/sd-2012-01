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

/**
 * Classe contendo as operacões da Calculadora Distribuída.
 */
public class Calculadora {

    /**
     * Obtém uma resposta para a requisicão recebida.
     *
     * @param requisicao a requisicão recebida
     * @return resposta com o resultado da operacão
     */
    public static Resposta calculeResposta(Requisicao requisicao) {
        double resultado = 0;
        switch (requisicao.getOperacao()) {
            case SOMA:
                resultado = requisicao.getOperando1() + requisicao.getOperando2();
                break;
            case SUBTRACAO:
                resultado = requisicao.getOperando1() - requisicao.getOperando2();
                break;
            case MULTIPLICACAO:
                resultado = requisicao.getOperando1() * requisicao.getOperando2();
                break;
            case DIVISAO:
                resultado = requisicao.getOperando1() / requisicao.getOperando2();
                break;
        }

        return new Resposta(requisicao.getID(), resultado);
    }
}
