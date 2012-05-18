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

package comunicacao;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CalculadoraDistribuidaTCPClient extends CalculadoraDistribuidaClient {

    /**
     * Cria e obtém uma instância de Closeable associada à conexão.
     *
     * @param host o nome do servidor
     * @param port a porta da aplicacão no servidor
     * @return uma instância de Closeable associada à conexão
     */
    protected Closeable obtenhaConexao(String host, int port) throws IOException {
        return new Socket(host, port);
    }

    /**
     * Envia uma requisicão ao servidor a partir dos parâmetros recebidos.
     *
     * @param host               o nome do servidor
     * @param port               a porta da aplicacão no servidor
     * @param conteudoRequisicao o conteúdo da requisicão
     * @throws java.io.IOException
     */
    protected void envieRequisicao(String host, int port, String conteudoRequisicao) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(obtenhaConexaoTCP().getOutputStream());
        outputStream.writeUTF(conteudoRequisicao);
    }

    /**
     * Lê a resposta do servidor.
     *
     * @return a resposta do servidor
     */
    protected String leiaRespostaDoServidor() throws IOException {
        DataInputStream inputStream = new DataInputStream(obtenhaConexaoTCP().getInputStream());
        return inputStream.readUTF();
    }

    /**
     * Obtém a instância de Socket associada à conexão.
     *
     * @return a instância de Socket associada à conexão
     */
    private Socket obtenhaConexaoTCP() {
        return ((Socket)conexao);
    }
}
