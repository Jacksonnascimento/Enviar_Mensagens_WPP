/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.enviarmensagenswpp;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestePython {
    public static void main(String[] args) {
        try {
            // Caminho para o script Python
            String caminhoPython = "C:\\Users\\jacks\\AppData\\Local\\Programs\\Python\\Python312\\python.exe"; // Caminho completo para o Python
            String caminhoScriptPython = "D:\\GitHub\\Enviar_Mensagens_WPP\\teste.py"; // Caminho para o script Python

            // Parâmetros a serem passados para o script Python
            String param1 = "Hello";
            String param2 = "World";

            // Comando para executar o script Python com parâmetros
            String comando = caminhoPython + " " + caminhoScriptPython + " " + param1 + " " + param2;

            // Verifica se Python existe
            File arquivoPython = new File(caminhoPython);
            if (!arquivoPython.exists()) {
                System.out.println("Python não encontrado no diretório.");
                return; // Sai do programa
            }
            
            File arquivocaminhoScriptPython= new File(caminhoScriptPython);
            if (!arquivocaminhoScriptPython.exists()) {
                System.out.println("Arquivo Python não encontrado no diretório.");
                return; // Sai do programa
            }

            // Executa o comando
            Process processo = Runtime.getRuntime().exec(comando);

            // Obtém a saída do processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            StringBuilder saidaPython = new StringBuilder();
            while ((linha = reader.readLine()) != null) {
                saidaPython.append(linha).append("\n");
            }

            // Espera o processo terminar e obtém o código de saída
            int codigoSaida = processo.waitFor();

            // Imprime a saída do Python
            System.out.println("Saída do Python:");
            System.out.println(saidaPython.toString());

            // Imprime o código de saída
            System.out.println("Código de saída: " + codigoSaida);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


