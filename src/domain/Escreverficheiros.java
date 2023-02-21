package domain;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe dedicada a leitura e escrita de ficheiros
 */
public class Escreverficheiros {

    /**
     *
     * @param filePath
     * @return ArrayList
     */
    private static ArrayList<String> readFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Método que escreve os dados dos utilizadores num ficheiro txt. especifico
     * @param utilizadores
     * @param fileName
     */
    public static void writeToFile(ArrayList<Utilizador> utilizadores, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Utilizadores.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Utilizador utilizador : utilizadores) {
                printWriter.println("Nome: " +utilizador.getNome() + ", Email: " + utilizador.getEmail() + ", Função: " + utilizador.getFuncao() + ", Password: " + utilizador.getPassword() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que escreve os dados dos utilizadorestma num ficheiro txt. especifico
     * @param utilizadorestma
     * @param fileName
     */
    public static void writeToFileUtilizadorTMA(ArrayList<UtilizadorTMA> utilizadorestma, String fileName) {
        try (FileWriter fileWriter = new FileWriter("UtilizadoresTMA.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (UtilizadorTMA utilizadortma : utilizadorestma) {
                printWriter.println("Username: " +utilizadortma.getUsername() + ", PCC: " + utilizadortma.getPcc() + ", HCMID: " + utilizadortma.getHcmid() + ", Estado: " + utilizadortma.getEstado() + ", Data de criação: " + utilizadortma.getData_criacao() + ", Data da última alteração: " + utilizadortma.getData_ultima_alteracao() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que escreve os dados dos clientes num ficheiro txt. especifico
     * @param clientes
     * @param fileName
     */
    public static void writeToFileCliente(ArrayList<Cliente> clientes, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Clientes.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Cliente cliente : clientes) {
                printWriter.println("Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail() + ", Telefone: " + cliente.getTelefone() + ", Nif: " + cliente.getNif() + ", Endereço: " + cliente.getEndereco() + ", Código Postal: " + cliente.getCodigo_postal() + ", País: " + cliente.getPais() + ", Informação adicional: " + cliente.getInformacao_adicional() + ", Método de pagamento: " + cliente.getPagamento_default() + ", Gestor: " + cliente.getGestor() +"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que escreve os dados das licenças num ficheiro txt. especifico
     * @param licencas
     * @param fileName
     */
    public static void writeToFileLicenca(ArrayList<Licenca> licencas, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Licenças.txt",true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Licenca licenca : licencas) {
                printWriter.println("Data de criação: " + licenca.getData_criacao() + "Estado: " + licenca.getEstado() + "Validade: " + licenca.getValidade() + "domain.UtilizadorTMA:" + licenca.getUtilizadortma() + "Pagamento: " + licenca.getPagamento() + "Renovação: " + Licenca.getRenovacao() + "Preço " + licenca.getPreco() + "Clientes: " + licenca.getCliente() + " " + "Pool:" + Licenca.getPool());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que escreve os dados das pools num ficheiro txt. especifico
     * @param pools
     * @param fileName
     */
    public static void writeToFilePool(ArrayList<Pool> pools, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Pools.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Pool pool : pools) {
                printWriter.println("Nome: " + Pool.getNome() + " " + "Data de criação : " + Pool.getData_criacao() + " " + "Validade : " + Pool.getValidade() + " " + "Estado : " + Pool.getEstado() + " " + "Licenças  : " + Pool.getLicencas_disp() + " " + "Número máximo de licanças: " + Pool.getMax_licencas() + " " + "Licenças disponíveis: " + Pool.getLicencas_disp() + " " + "Licenças usadas: " + Pool.getLicencas_usadas() );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite alteração de dados das licenças no ficheiro txt.
     * @param licencas
     * @param filename
     * @param parametro
     * @param alteracao
     */
    public static void alterar_ficheiros_licencas(ArrayList<Licenca> licencas, String filename, String parametro, String alteracao) {
        // Caminho do arquivo
        String filePath = "Licenças.txt";
        // O parâmetro que você deseja alterar
        String param = parametro;
        // Novo valor para o parâmetro
        String novovalor = alteracao;

        // Lê o arquivo
        ArrayList<String> novo_licencas = readFile(filePath);

        // Procurar a linha que contém o parâmetro específico
        int index = -1;
        for (int i = 0; i < novo_licencas.size(); i++) {
            if (novo_licencas.get(i).contains(param)) {
                index = i;
                break;
            }
        }

        // Altera o valor do parâmetro na lista de strings
        if (index != -1) {
            String[] parts = novo_licencas.get(index).split("=");
            novo_licencas.set(index, parts[0] + "=" + novovalor);
        }

        // Escreve a lista de strings de volta para o arquivo
        writeToFileLicenca(licencas, filePath);
    }
}
