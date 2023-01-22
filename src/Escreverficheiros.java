import java.io.*;
import java.util.ArrayList;

//Classe dedicada a ficheiros:
public class Escreverficheiros {

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

    //Escreve no ficheiro selecionado a lista de utilizadores criados;
    public static void writeToFile(ArrayList<Utilizador> utilizadores, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Utilizadores.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Utilizador utilizador : utilizadores) {
                printWriter.println("Nome: " +utilizador.getNome() + ", Email: " + utilizador.getEmail() + ", Função: " + utilizador.getFuncao() + ", Password: " + utilizador.getPassword() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Escreve no ficheiro selecionado a lista de utilizadores criados;
    public static void writeToFileUtilizadorTMA(ArrayList<UtilizadorTMA> utilizadorestma, String fileName) {
        try (FileWriter fileWriter = new FileWriter("UtilizadoresTMA.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (UtilizadorTMA utilizadortma : utilizadorestma) {
                printWriter.println("Username: " +utilizadortma.getUsername() + ", PCC: " + utilizadortma.getPcc() + ", HCMID: " + utilizadortma.getHcmid() + ", Estado: " + utilizadortma.getEstado() + ", Data de criação: " + utilizadortma.getData_criacao() + ", Data da última alteração: " + utilizadortma.getData_ultima_alteracao() + ", Licença : " + utilizadortma.getLicenca() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Escreve no ficheiro selecionado a lista de clientes criados;
    public static void writeToFileCliente(ArrayList<Cliente> clientes, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Clientes.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Cliente cliente : clientes) {
                printWriter.println("Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail() + ", Telefone: " + cliente.getTelefone() + ", Nif: " + cliente.getNif() + ", Endereço: " + cliente.getEndereco() + ", Código Postal: " + cliente.getCodigo_postal() + ", País: " + cliente.getPais() + ", Informação adicional: " + cliente.getInformacao_adicional() + ", Método de pagamento: " + cliente.getPagamento_default() + ", Gestor: " + cliente.getGestor() +"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Escreve no ficheiro selecionado a lista de licenças criados;
    public static void writeToFileLicenca(ArrayList<Licenca> licencas, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Licenças.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Licenca licenca : licencas) {
                printWriter.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Escreve no ficheiro selecionado a lista de pools criados;
    public static void writeToFilePool(ArrayList<Pool> pools, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Pools.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Pool pool : pools) {
                printWriter.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void alterar_ficheiros_licencas(ArrayList<Licenca> licencas,String filename,String parametro, String alteracao) {
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
