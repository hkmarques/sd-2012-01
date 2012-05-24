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

import negocio.Calculadora;
import negocio.Requisicao;
import negocio.Resposta;

import java.io.Closeable;
import java.io.IOException;

public abstract class CalculadoraDistribuidaServer {

    // A instância de Closeable associada à conexão.
    Closeable conexao;

    // A porta da aplicacão
    int port;

    /**
     * Inicializa o servidor.
     *
     * @param port a porta da aplicacão
     */
    public void init(int port) throws IOException {

        this.port = port;

        // Obtendo conexão.
        conexao = obtenhaConexao(port);

        while (true) {

            // Obtendo requisicão.
            Requisicao requisicao = obtenhaRequisicao();

            // Calculando/obtendo resposta.
            Resposta resposta = obtenhaResposta(requisicao);

            // Enviando resposta para o cliente.
            envieResposta(resposta);

            System.out.printf("Resposta enviada (requisição %s): %.3f\n", requisicao.getID().toString().toUpperCase(), resposta.getResultado());
        }
    }

    /**
     * Cria e obtém uma instância de Closeable associada à conexão.
     *
     * @param port a porta da aplicacão no servidor
     * @return uma instância de Closeable associada à conexão
     */
    protected abstract Closeable obtenhaConexao(int port) throws IOException;

    /**
     * Obtém a requisicão recebida do cliente.
     *
     * @return a requisicão recebida do cliente
     */
    protected abstract Requisicao obtenhaRequisicao() throws IOException;

    /**
     * Calcula e retorna uma resposta para a requisicão recebida.
     *
     * @param requisicao a requisicão recebida
     * @return uma resposta com o resultado da operacão
     */
    protected Resposta obtenhaResposta(Requisicao requisicao) {
        return Calculadora.calculeResposta(requisicao);
    }

    /**
     * Envia a resposta para o cliente.
     *
     * @param resposta a resposta a ser enviada para o cliente
     */
    protected abstract void envieResposta(Resposta resposta) throws IOException;
}
