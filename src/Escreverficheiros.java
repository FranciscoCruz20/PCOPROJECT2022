import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Escreverficheiros {

    public static void writeToFile(ArrayList<Utilizador> utilizadores, String fileName) {
        try (FileWriter fileWriter = new FileWriter("Utilizadores.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Utilizador utilizador : utilizadores) {
                printWriter.println(utilizador.getNome() + "," + utilizador.getEmail() + "," + utilizador.getFuncao() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
