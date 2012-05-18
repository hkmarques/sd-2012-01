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

package comunicacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {

    DataInputStream inputStream;
    DataOutputStream outputStream;
    Socket clientSocket;

    /**
     * Construtor da classe {@code Connection}.
     *
     * @param clientSocket instância de {@code Socket} associada à conexão com o cliente
     * @throws IOException
     */
    public Connection(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        inputStream = new DataInputStream(clientSocket.getInputStream());
        outputStream = new DataOutputStream(clientSocket.getOutputStream());
    }

    /**
     * Lê dados recebidos.
     *
     * @return os dados recebidos
     * @throws IOException
     */
    public String leiaDados() throws IOException {
        return inputStream.readUTF();
    }

    /**
     * Envia dados ao cliente.
     *
     * @param dados dados a serem enviados ao cliente
     * @throws IOException
     */
    public void envieDados(String dados) throws IOException {
        outputStream.writeUTF(dados);
    }
}
