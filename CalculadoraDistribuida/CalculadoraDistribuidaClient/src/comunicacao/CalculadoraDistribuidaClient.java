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

import negocio.Requisicao;
import negocio.Resposta;
import utils.ConversorOperacao;
import utils.ConversorParametros;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Classe contendo os comportamentos compartilhados entre os clientes UDP e TCP.
 */
public abstract class CalculadoraDistribuidaClient {

    // A instância de Closeable associada à conexão.
    protected Closeable conexao;

    // A resposta do servidor.
    protected Resposta resposta;

    /**
     * Envia a requisicão ao servidor, lê a resposta recebida e exibe-a, a partir dos parâmetros recebidos.
     *
     * @param host       o nome do servidor
     * @param port       a porta da aplicacão no servidor
     * @param requisicao a requisicão a ser enviada
     * @return a resposta do servidor
     */
    public Resposta gerencieRequisicao(String host, int port, Requisicao requisicao) {

        try {

            // Cria e obtém a conexão.
            conexao = obtenhaConexao(host, port);

            // Enviando requisicão.
            System.out.printf("Enviando requisição %s\n", requisicao);
            envieRequisicao(host, port, requisicao.toString());

            // Lendo resposta do servidor.
            String resp = leiaRespostaDoServidor();
            resposta = ConversorParametros.obtenhaResposta(resp);

        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException:" + e);
        } catch (SocketException soex) {
            System.out.println("SocketException: " + soex);
        } catch (EOFException e) {
            System.out.println("EOFException:" + e);
        } catch (IOException ioex) {
            System.out.println("IOException: " + ioex);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            if (conexao != null) {
                try {

                    // Fechando conexão.
                    conexao.close();

                } catch (IOException ioex) {
                    System.out.println("IOException ao tentar fechar a conexão: " + ioex);
                }
            }
        }

        // Retornando a resposta do servidor.
        return resposta;
    }

    /**
     * Cria e obtém uma instância de Closeable associada à conexão.
     *
     * @param host o nome do servidor
     * @param port a porta da aplicacão no servidor
     * @return uma instância de Closeable associada à conexão
     */
    protected abstract Closeable obtenhaConexao(String host, int port) throws IOException;

    /**
     * Envia uma requisicão ao servidor a partir dos parâmetros recebidos.
     *
     * @param host               o nome do servidor
     * @param port               a porta da aplicacão no servidor
     * @param conteudoRequisicao o conteúdo da requisicão
     * @throws IOException
     */
    protected abstract void envieRequisicao(String host, int port, String conteudoRequisicao) throws IOException;

    /**
     * Lê a resposta do servidor.
     *
     * @return a resposta do servidor
     */
    protected abstract String leiaRespostaDoServidor() throws IOException;
}
