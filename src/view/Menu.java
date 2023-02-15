package view;
import domain.*;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    //static Cliente cli = new Cliente("","",000000000,000000000,"","","","","");
    //static Utilizador util = new Utilizador("nome", "email", "", "");
    //static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
    //static ArrayList<Cliente> clientes = new ArrayList<>();
    //static Administrador admin = new Administrador("admin", "password");
    //static Licenca lic = new Licenca(null,"Inátiva",null,null,false,false,100,null);
    //static UtilizadorTMA utilTMA = new UtilizadorTMA("", 0,0,"",null,null,"");
    //static Pool p = new Pool("", 0,null,null,"",0,false,false,0,null,null,0);


    /**
     * Método que representa o menu inicial do programa coma acesso ao menu de administrador e de utilizador
     * @throws IOException
     */
    public static void menu_inicial() throws IOException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Menu de administrador");
            System.out.println("2 - Menu de utilizador");

            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                menu_admin();
            }
            if (opcao == 2) {
                menu_confirmacao_utilizador();
            }
            else {
                System.out.println("Opção inválida");
            }
        }
    }


    //Administrador:

    /**
     * Método que apresenta o menu de administrador
     * Com autenticação de dados de acesso
     * Criação e verificação de utilizadores
     * Criação e verificação de clientes
     * @throws IOException
     */
    public static void menu_admin() throws IOException {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Insira o nome de utilizador e password:");
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();

            if (Administrador.login(username, password)) {
                while (true) {
                    System.out.println("Menu:");
                    System.out.println("1 - Criar novo utilizador");
                    System.out.println("2 - Verificar utilizador existente");
                    System.out.println("3 - Criar um cliente");
                    System.out.println("4 - Verificar cliente existente");
                    System.out.println("5 - Sair");

                    int opcao = input.nextInt();
                    input.nextLine();

                    if (opcao == 1) {
                        Utilizador.criar_utilizador();

                    }
                    if (opcao == 2) {

                        System.out.println("Insira o nome do utilizador:");
                        System.out.print("Nome: ");
                        String nome = input.nextLine();

                        if (Utilizador.verificar_utilizador(Utilizador.utilizadores, nome)) {

                            System.out.println("Existe um utilizador com este nome");
                            System.out.println(nome);

                        } else {

                            System.out.println("Não existe nenhum utilizador com este nome");
                        }

                    }
                    else if (opcao == 3) {

                        Cliente.criar_cliente();
                    }
                    else if (opcao == 4) {

                        System.out.println("Insira o nome do cliente:");
                        System.out.print("Nome: ");
                        String nome = input.nextLine();

                        if (Cliente.verificar_cliente(Cliente.clientes, nome)) {

                            System.out.println("Existe um cliente com este nome");
                            System.out.println(nome);

                        } else {

                            System.out.println("Não existe nenhum cliente com este nome");
                        }

                    }
                    else if (opcao == 5) {

                        menu_inicial();
                    }
                    else {

                        //System.out.println("Opção inválida");
                    }
                }
            } else{

                System.out.println("Username ou password incorretos");
            }
        }
    }

    //Utilizadores:

    /**
     * Método que apresenta o menu de utilizador
     * Criação de licenças
     * Criação de utilizadorestma
     * Criação de pools
     * @throws IOException
     */
    public static void menu_utilizador() throws IOException {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Menu utilizador:");
            System.out.println("1-Criar licença");
            System.out.println("2-Criar utilizadorTMA");
            System.out.println("3-Criar uma pool");
            System.out.println("4-Sair");
            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                Licenca.criar_licenca();
            }
            else if (opcao == 2){
                HandlerUC06.inserir_dados_tma();
            }
            else if (opcao == 3) {
                HandlerUC04.criar_pool();
            }
            else if (opcao == 4) {
                menu_inicial();
            }
            else {
                System.out.println("Opção inválida");
            }
        }
    }

    /**
     * Método que representa o menu de autenticação de acesso ao menu de utilziadores
     * @throws IOException
     */
    public static void menu_confirmacao_utilizador() throws IOException {

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Insira o nome de utilizador e a sua password:");
            System.out.print("Nome: ");
            String nome = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();
            if (Utilizador.verificar_utilizador_confirmar(Utilizador.utilizadores, nome, password)) {
                menu_utilizador();
            } else {
                System.out.println("Não existe utilizador com esse nome ou password");
                menu_inicial();
            }
        }
    }
}
