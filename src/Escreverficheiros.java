import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//Classe dedicada a ficheiros:
public class Escreverficheiros {

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

    //Escreve no ficheiro selecionado a lista de clientes criados;
    public static void writeToFilecliente(ArrayList<Cliente> clientes, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Clientes.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Cliente cliente : clientes) {
                printWriter.println("Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail() + ", Telefone: " + cliente.getTelefone() + ", Nif: " + cliente.getNif() + ", Endereço: " + cliente.getEndereco() + ", Código Postal: " + cliente.getCodigo_postal() + ", País: " + cliente.getPais() + ", Informação adicional: " + cliente.getInformacao_adicional() + ", Método de pagamento: " + cliente.getPagamento_default() + ", Gestor: " + cliente.getGestor() +"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
