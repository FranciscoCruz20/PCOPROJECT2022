import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;

public class Administrador {

    //Atributos
    private String username;
    private String password;
    private ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();

    //Construtor:
    public Administrador(String admin, String password) {
        this.username = "admin";
        this.password = "12345";
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public boolean verificar_utilizador(ArrayList<Utilizador> utilizadores, String nome) throws FileNotFoundException {
        for(Utilizador utilizador : utilizadores) {
            try {
                FileReader fr = new FileReader("Utilizadores.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains(nome)) {
                        return true;
                    }
                }
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }



    /*
    public void validar_admin() {
        Scanner t = new Scanner(System.in);
        System.out.println("Username:");
        String campo1 = t.next();
        System.out.println("Password:");
        String campo2 = t.next();
        //Usado o equals em vez de == porque assim ele compara o conteudo e não o objeto, comparar objetos diferentes com == vai dar smp erro
        if (getUsername().equals(campo1)) {
            if (getPassword().equals(campo2)) {
                System.out.println("Validado com sucesso");
            }
        }
        else {
            System.out.println("Dados errados, volte a tentar.");
            validar_admin();
            System.out.print("Nome: ");
            String nome = t.nextLine();
            System.out.print("Email: ");
            String email = t.nextLine();
            Utilizador utilizador = new Utilizador(nome, email, funcao);
            utilizador.add(utilizador);
        }

    }
     */

    /*
    public void criar_utilizador(ArrayList<Utilizador> utilizadores) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        Utilizador utilizador = new Utilizador(nome, email);
        utilizadores.add(utilizador);

    }
     */

    /*
    void validar_utilizador() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        Utilizador utilizador = new Utilizador(nome, email);

        if (utilizadores.contains(utilizador)) {
            System.out.println("Válido");
        } else {
            System.out.println("Inválido");
        }
    }
     */

    //Getters e setters:
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
