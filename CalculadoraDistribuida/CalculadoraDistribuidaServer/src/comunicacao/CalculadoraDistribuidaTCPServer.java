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

package comunicacao;

import negocio.Requisicao;
import negocio.Resposta;
import utils.ConversorParametros;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraDistribuidaTCPServer extends CalculadoraDistribuidaServer {

    // Instância de Connection associada à conexão.
    private Connection connection;

    /**
     * Obtém a requisicão recebida do cliente.
     *
     * @return a requisicão recebida do cliente
     */
    protected Requisicao obtenhaRequisicao() throws IOException {
        Socket clientSocket = obtenhaConexaoTCP(port).accept();
        connection = new Connection(clientSocket);
        String dados = connection.leiaDados();

        System.out.printf("Requisição recebida: %s\n", dados);
        return ConversorParametros.obtenhaRequisicao(dados);
    }

    /**
     * Envia a resposta para o cliente.
     *
     * @param resposta a resposta a ser enviada para o cliente
     */
    protected void envieResposta(Resposta resposta) throws IOException {
        StringBuilder builder = new StringBuilder(resposta.getIDRequisicao().toString());
        builder.append(" ");
        builder.append(resposta.getResultado());

        connection.envieDados(builder.toString());
    }

    /**
     * Cria e obtém uma instância de Closeable associada à conexão.
     *
     * @param port a porta da aplicacão no servidor
     * @return uma instância de Closeable associada à conexão
     */
    protected Closeable obtenhaConexao(int port) throws IOException {
        return obtenhaConexaoTCP(port);
    }

    /**
     * Cria e obtém uma instância de ServerSocket associada à conexão.
     *
     * @param port a porta da aplicacão no servidor
     * @return uma instância de ServerSocket associada à conexão
     * @throws IOException
     */
    private ServerSocket obtenhaConexaoTCP(int port) throws IOException {
        return conexao != null ? (ServerSocket) conexao : new ServerSocket(port);
    }
}
