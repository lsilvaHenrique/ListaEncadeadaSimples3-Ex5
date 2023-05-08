package controller;

import model.Cliente;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroController {
    private static final String CAMINHO_ARQUIVO = "C:\\TEMP\\cadastro.csv";

    private static String formatarLinha(Cliente cliente) {
        return cliente.getCpf() + ";" + cliente.getNome() + ";" + cliente.getIdade() + ";" + cliente.getLimiteCredito() + System.lineSeparator();
    }

    private static void novoArquivo(List<Cliente> lista, String nomeArquivo) {
        File arquivo = new File("C:\\TEMP", nomeArquivo);

        try {
            FileWriter writer = new FileWriter(arquivo);
            StringBuffer buffer = new StringBuffer();

            for (Cliente cliente : lista) {
                buffer.append(formatarLinha(cliente));
            }

            writer.write(buffer.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void novoCadastro(int idadeMin, int idadeMax, double limiteCredito) {
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            Scanner scanner = new Scanner(new File(CAMINHO_ARQUIVO));

            while (scanner.hasNext()) {
                String[] campos = scanner.nextLine().split(";");

                String cpf = campos[0];
                String nome = campos[1];
                int idade = Integer.parseInt(campos[2]);
                double credito = Double.parseDouble(campos[3]);

                if (idade >= idadeMin && idade <= idadeMax && credito > limiteCredito) {
                    clientes.add(new Cliente(cpf, nome, idade, credito));
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        String nomeArquivo = "Idade " + idadeMin + "-" + idadeMax + " limite " + limiteCredito + ".csv";
        novoArquivo(clientes, nomeArquivo);
    }
}

