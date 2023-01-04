import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilizador {

    //Atributos:
    private String nome;
    private String email;
    private String cliente;
    private String funcao;
    private boolean confrimacao_email;
    private static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
    private static ArrayList<Utilizador> clientes = new ArrayList<>();

    //Construtor:
    Utilizador(String nome, String email, String funcao) {
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
        this.confrimacao_email = false;
    }

    public boolean verificar_utilizador_confirmar(String nome, String email) throws FileNotFoundException {
        for(Utilizador utilizador : utilizadores) {
            try {
                FileReader fr = new FileReader("Utilizadores.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains(nome)&&line.contains(email)) {
                        return true;
                    }
                }
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public void confirmar_email() {
        setConfrimacao_email(true);
    }

    public static void adicionar_cliente(Utilizador client) {
        clientes.add(client);
    }

    //Getters e setters:
    public boolean getConfrimacao_email() {
        return confrimacao_email;
    }

    public void setConfrimacao_email(boolean confrimacao_email) {
        this.confrimacao_email = confrimacao_email;
    }

    public static List<Utilizador> getClientes() {

        return clientes;
    }

    public static void setClientes(List<Utilizador> clientes) {

        Utilizador.clientes = (ArrayList<Utilizador>) clientes;
    }

    public String getFuncao() {

        return funcao;
    }

    public void setFuncao(String funcao) {

        this.funcao = funcao;
    }

    public String getCliente() {

        return cliente;
    }

    public void setCliente(String cliente) {

        this.cliente = cliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        Scanner t = new Scanner(System.in);
        System.out.println("Email:");
        String email = t.next();
        this.email = email;
    }

    public String getNome() {

        return nome;
    }

    public void setNome() {
        /*
        Scanner t = new Scanner(System.in);
        System.out.println("Nome:");
        String nome = t.next();
        if (utilizadores.contains(nome)) {
            System.out.println("Nome já existente.Volte a tentar");
            setNome();
        }
        else {
            System.out.println("Nome válido");
            utilizadores.add(nome);
        }
         */
    }

    /*
    //Registrar novo utilizador:
    public void registrar_utilizador() {
        setNome();
        setEmail();
        Scanner t = new Scanner(System.in);
        System.out.println("Cliente:");
        String cliente = t.next();
        Cliente.verificar_cliente(cliente);
        setCliente(cliente);

        System.out.println(getNome() + getEmail() + getCliente());

    }
     */

        /*
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
        }

         */

}


