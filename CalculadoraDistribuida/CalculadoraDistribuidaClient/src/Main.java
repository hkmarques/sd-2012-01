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

import comunicacao.CalculadoraDistribuidaClient;
import comunicacao.CalculadoraDistribuidaTCPClient;
import comunicacao.CalculadoraDistribuidaUDPClient;
import comunicacao.EnumTipoProtocolo;
import negocio.Requisicao;
import negocio.Resposta;
import utils.ConversorParametros;

public class Main {

    // Identificando o servidor.
    static String host = "HERICKNB";

    // A porta da aplicaćão no servidor.
    static int port = 15000;

    /**
     * Ponto de entrada principal.
     *
     * @param args parâmetros recebidos pela linha de comando
     */
    public static void main(String[] args) {

        if (ConversorParametros.parametrosInvalidos(args)) {
            System.out.println("Sintaxe: java -jar <nome_do_jar> <TCP|UDP> <operando1> <operacao> <operando2>");
            return;
        }

        // Instanciando requisicão.
        Requisicao requisicao = ConversorParametros.obtenhaRequisicao(args[1], args[3], args[2]);

        // Instanciando cliente do tipo apropriado.
        EnumTipoProtocolo tipoClient = ConversorParametros.obtenhaProtocolo(args[0]);
        CalculadoraDistribuidaClient cliente = tipoClient == EnumTipoProtocolo.UDP
                ? new CalculadoraDistribuidaUDPClient()
                : new CalculadoraDistribuidaTCPClient();

        // Enviando requisicão e obtendo resposta do servidor.
        Resposta resposta = cliente.gerencieRequisicao(host, port, requisicao);

        if (resposta != null) {
            System.out.printf("Resposta do servidor (Requisição %s): %s = %.3f\n", requisicao.getID().toString().toUpperCase(), requisicao.toString().substring(requisicao.toString().indexOf(' ')), resposta.getResultado());
        }
    }
}
