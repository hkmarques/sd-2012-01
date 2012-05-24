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

package utils;

import comunicacao.EnumTipoProtocolo;
import negocio.EnumOperacao;
import negocio.Requisicao;

import java.util.UUID;

/**
 * Classe contendo conversões para parâmetros recebidos na linha de comando.
 */
public class ConversorParametros {

    /**
     * Verifica a validade dos parâmetros recebidos pela linha de comando.
     *
     * @param args os parâmetros recebidos
     * @return {@code true} caso os parâmetros recebidos sejam válidos, {@code false} caso contrário
     */
    public static boolean parametrosInvalidos(String[] args) {
        return args == null || args.length < 1;
    }

    /**
     * Obtém o tipo de protocolo (UDP/TCP) a partir de uma string.
     *
     * @param protocolo o nome do tipo de protocolo
     * @return o tipo de protocolo
     */
    public static EnumTipoProtocolo obtenhaProtocolo(String protocolo) {
        return EnumTipoProtocolo.valueOf(protocolo.toUpperCase());
    }

    /**
     * Obtém o tipo de operacão a partir de uma string.
     *
     * @param operacao a operacão (string)
     * @return a operacão
     */
    public static EnumOperacao obtenhaOperacao(String operacao) {
        EnumOperacao enumOperacao;
        try {
            enumOperacao = EnumOperacao.valueOf(operacao.toUpperCase());
        } catch (IllegalArgumentException e) {
            EnumOperacao resultadoConversor = ConversorOperacao.obtenhaOperacao(operacao);
            enumOperacao = resultadoConversor != null ? resultadoConversor : EnumOperacao.SOMA;
        }

        return enumOperacao;
    }

    /**
     * Obtém uma instância de Requisicao a partir dos dados informados.
     *
     * @param id        identificador da requisicão
     * @param operando1 primeiro operando
     * @param operando2 segundo operando
     * @param operacao  a operacão
     * @return uma instância de Requisicão
     */
    public static Requisicao obtenhaRequisicao(String id, String operando1, String operando2, String operacao) {
        UUID uuid = UUID.fromString(id);
        double op1 = Double.parseDouble(operando1);
        double op2 = Double.parseDouble(operando2);
        EnumOperacao op = obtenhaOperacao(operacao);
        Requisicao requisicao = new Requisicao(uuid, op1, op2, op);

        return requisicao;
    }

    /**
     * Obtém uma instância de Requisicao a partir do conteúdo da requisicão (string).
     *
     * @param conteudoRequisicao o conteúdo (string) da requisicão
     * @return uma instância de Requisicao
     */
    public static Requisicao obtenhaRequisicao(String conteudoRequisicao) {
        String[] dados = conteudoRequisicao.trim().split(" ");
        return obtenhaRequisicao(dados[0], dados[1], dados[3], dados[2]);
    }
}