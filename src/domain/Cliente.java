package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    
    //Atributos do cliente:
    private String nome;
    private String email;
    private int telefone;
    private int nif;
    private String endereco;
    private String codigo_postal;
    private String pais;
    private String informacao_adicional;
    private String pagamento_default;
    private Utilizador gestor;//Gestor corrresponde ao nome do utilizador responsável por este cliente;
    private static ArrayList<Cliente> clientes = new ArrayList<>();//Lista de clientes criados;


   //Verificar se o nome do cliente está na lista de clientes:
   public static boolean verificar_cliente(String nome) {
       for(Cliente cliente : clientes) {
           try {
               //Leitura do ficheiro;
               FileReader fr = new FileReader("Clientes.txt");
               BufferedReader br = new BufferedReader(fr);
               String line;
               //Verificação em linha:
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

    //Construtor:
    public Cliente(String nome, String email, int telefone, int nif, String endereco, String codigo_postal, String pais, String informacao_adicional, String pagamento_default) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.nif = nif;
        this.endereco = endereco;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
        this.informacao_adicional = informacao_adicional;
        this.pagamento_default = pagamento_default;
    }


    public static boolean verificar_cliente(ArrayList<Cliente> clientes, String nome) throws FileNotFoundException {
        for(Cliente cliente : clientes) {
            try {
                //Leitura do ficheiro;
                FileReader fr = new FileReader("Clientes.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Verificação em linha:
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

    public static void criar_cliente() {

        Scanner input = new Scanner(System.in);

        System.out.println("Nome:");
        String nome = input.nextLine();

        System.out.println("Email:");
        String email = input.nextLine();

        System.out.println("Número de telefone:");
        int telefone = Integer.parseInt(input.nextLine());

        System.out.println("NIF:");
        int nif = Integer.parseInt(input.nextLine());

        System.out.println("Código postal:");
        String codigo_postal = input.nextLine();

        System.out.println("Endereço:");
        String endereco = input.nextLine();

        System.out.println("País");
        String  pais = input.nextLine();

        System.out.println("Informação adicional:");
        String informacao_adicional = input.nextLine();

        System.out.println("Pagamento default:");
        String pagamento_default = input.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone, nif, endereco, codigo_postal, pais, informacao_adicional, pagamento_default);
        clientes.add(cliente);
        Escreverficheiros.writeToFileCliente(clientes, "Clientes.txt");
        System.out.println("Cliente criado com sucesso");
        cliente.toString();

    }

    public static Cliente procurarCliente(String nome) {
        for(Cliente cliente : clientes) {
            if(cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }


    //Getters e Setters:
    public Utilizador getGestor() {
        return gestor;
    }

    public void setGestor(Utilizador gestor) {
        this.gestor = gestor;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getInformacao_adicional() {
        return informacao_adicional;
    }

    public void setInformacao_adicional(String informacao_adicional) {
        this.informacao_adicional = informacao_adicional;
    }

    public String getPagamento_default() {
        return pagamento_default;
    }

    public void setPagamento_default(String pagamento_default) {
        this.pagamento_default = pagamento_default;
    }

    @Override
    public String toString() {
        return "domain.Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", nif=" + nif +
                ", endereco='" + endereco + '\'' +
                ", codigo_postal='" + codigo_postal + '\'' +
                ", pais='" + pais + '\'' +
                ", informacao_adicional='" + informacao_adicional + '\'' +
                ", pagamento_default='" + pagamento_default + '\'' +
                ", gestor=" + gestor +
                '}';
    }
}
