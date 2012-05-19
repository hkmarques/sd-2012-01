/*
 * Copyright © 2012 Herick Oliveira <mailto:hkmarques@gmail.com>
 *
 * This file is part of CalculadoraDistribuidaServer.
 * CalculadoraDistribuidaServer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CalculadoraDistribuidaServer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * See <http://www.gnu.org/licenses/> if no copy of the GNU General
 * Public License was made available along with this copy of CalculadoraDistribuidaServer.
 */

import comunicacao.CalculadoraDistribuidaServer;
import comunicacao.CalculadoraDistribuidaTCPServer;
import comunicacao.CalculadoraDistribuidaUDPServer;
import comunicacao.EnumTipoProtocolo;
import utils.ConversorParametros;

import java.io.IOException;

public class Main {

    // A porta da aplicacão no servidor.
    protected final static int port = 15000;

    /**
     * Ponto de entrada principal.
     *
     * @param args parâmetros recebidos a partir da linha de comando
     */
    public static void main(String[] args) throws IOException {

        if (ConversorParametros.parametrosInvalidos(args)) {
            System.out.println("Sintaxe: java -jar <nome_do_jar> <TCP|UDP>");
            return;
        }

        // Instanciando servidor do tipo apropriado.
        EnumTipoProtocolo protocolo = ConversorParametros.obtenhaProtocolo(args[0]);
        CalculadoraDistribuidaServer server = protocolo == EnumTipoProtocolo.UDP
                ? new CalculadoraDistribuidaUDPServer()
                : new CalculadoraDistribuidaTCPServer();

        // Iniciando servidor.
        server.init(port);
    }
}
