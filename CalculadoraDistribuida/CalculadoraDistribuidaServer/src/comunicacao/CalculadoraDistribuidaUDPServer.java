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
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class CalculadoraDistribuidaUDPServer extends CalculadoraDistribuidaServer {

    // Alocando request.
    private DatagramPacket request;

    /**
     * Obtém a requisicão recebida do cliente.
     *
     * @return a requisicão recebida do cliente
     */
    protected Requisicao obtenhaRequisicao() throws IOException {
        byte[] buffer = new byte[1024];
        request = new DatagramPacket(buffer, buffer.length);
        obtenhaConexaoUDP(port).receive(request);

        byte[] bytes = request.getData();
        String conteudoRequisicao = new String(bytes);
        return ConversorParametros.obtenhaRequisicao(conteudoRequisicao);
    }

    /**
     * Envia a resposta para o cliente.
     *
     * @param resposta a resposta a ser enviada para o cliente
     */
    protected void envieResposta(Resposta resposta) throws IOException {
        String msgResposta = resposta.toString();
        DatagramPacket reply = new DatagramPacket(msgResposta.getBytes(),
                msgResposta.length(),
                request.getAddress(),
                port);

        obtenhaConexaoUDP(port).send(reply);
    }

    /**
     * Cria e obtém uma instância de Closeable associada à conexão.
     *
     * @param port a porta da aplicacão no servidor
     * @return uma instância de Closeable associada à conexão
     */
    protected Closeable obtenhaConexao(int port) throws SocketException {
        return obtenhaConexaoUDP(port);
    }

    /**
     * Cria e obtém uma instância de DatagramSocket associada à conexão.
     *
     * @param port a porta da aplicacão no servidor
     * @return uma instância de DatagramSocket associada à conexão
     * @throws SocketException
     */
    private DatagramSocket obtenhaConexaoUDP(int port) throws SocketException {
        return conexao != null ? (DatagramSocket) conexao : new DatagramSocket(port);
    }
}
