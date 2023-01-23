import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

    static Cliente cli = new Cliente("","",000000000,000000000,"","","","","");
    static Utilizador util = new Utilizador("nome", "email", "", "");
    static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Administrador admin = new Administrador("admin", "password");
    static Licenca lic = new Licenca(null,"Inátiva",null,null,false,false,100,null);
    static UtilizadorTMA utilTMA = new UtilizadorTMA("", 0,0,"",null,null,"",false);


    //Main:
    //Para aceder como admin:
    //Username: admin
    //Password: 12345
    public static void main(String[] args) throws IOException {

        Utilizador util = new Utilizador("nome", "email", "", "");
        Administrador admin = new Administrador("admin", "password");
        Licenca lic = new Licenca(null,"Inátiva",null,null,false,false,100,null);
        UtilizadorTMA utilTMA = new UtilizadorTMA("", 0,0,"",null,null,"",false);

        menu_inicial();
    }

    //Primeiro menu apresentado, com acesso ao menu de administrador(com verificação implementada), confirmação de email de utilizador(com verificação do email), menu de utilizador(com verificação de nome e password):
    public static void menu_inicial() throws IOException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Menu de administrador");
            System.out.println("2 - Menu de utilizador");
            System.out.println("3 - Sair");

            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                menu_admin();
            }
            if (opcao == 2) {
                menu_confirmacao_utilizador();
            }
            if (opcao == 3) {
                break;
            }
            if (opcao == 4) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }


    //Administrador:
    //Menu para aceder como administrador:
    public static void menu_admin() throws IOException {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Insira o nome de utilizador e password:");
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();

            if (admin.login(username, password)) {
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

                        System.out.println("Insira o nome, email e função do utilizador:");
                        System.out.print("Nome: ");
                        String nome = input.nextLine();

                        if (util.verificar_utilizador(utilizadores, nome)) {

                            System.out.println("Utilizador com esse nome já existe");
                        }
                        else {

                            System.out.print("Email: ");
                            String email = input.nextLine();
                            System.out.print("Função(Admin/Gestor): ");
                            String funcao = input.nextLine();

                            if (funcao.equals("Admin") ^ funcao.equals("Gestor")) {

                                System.out.println("1-Confirmar email");
                                int opcao2 = input.nextInt();
                                input.nextLine();

                                if (opcao2 == 1) {

                                    util.setConfrimacao_email(true);
                                    System.out.println("Insira a sua nova password:");
                                    String passwordU = input.nextLine();
                                    Utilizador utilizador = new Utilizador(nome, email, funcao, passwordU);
                                    utilizadores.add(utilizador);
                                    Escreverficheiros.writeToFile(utilizadores, "Utilizadores.txt");

                                } else {

                                    System.out.println("Opção inválida");
                                }
                            }
                            else {

                                System.out.println("Função não existe, crie novamente");
                            }
                        }

                    }
                    if (opcao == 2) {

                        System.out.println("Insira o nome do utilizador:");
                        System.out.print("Nome: ");
                        String nome = input.nextLine();

                        if (util.verificar_utilizador(utilizadores, nome)) {

                            System.out.println("Existe um utilizador com este nome");
                            System.out.println(nome);

                        } else {

                            System.out.println("Não existe nenhum utilizador com este nome");
                        }

                    }
                    else if (opcao == 3) {

                        cli.criar_cliente();
                    }
                    else if (opcao == 4) {

                        System.out.println("Insira o nome do cliente:");
                        System.out.print("Nome: ");
                        String nome = input.nextLine();

                        if (cli.verificar_cliente(clientes, nome)) {

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

                        System.out.println("Opção inválida");
                    }
                }
            } else{

                System.out.println("Username ou password incorretos");
            }
        }
    }

    //Utilizadores:
    public static void menu_utilizador() throws IOException {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Menu utilizador:");
            System.out.println("1-Criar licença");
            System.out.println("2-Criar utilizadorTMA");
            System.out.println("3-Sair");
            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                lic.criar_licenca();
            }
            else if (opcao == 2){
                utilTMA.criar_utilizadorTMA();
            }
            else if (opcao == 3) {
                menu_inicial();
            }
            else {
                System.out.println("Opção inválida");
            }
        }
    }

    public static void menu_confirmacao_utilizador() throws IOException {

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Insira o nome de utilizador e a sua password:");
            System.out.print("Nome: ");
            String nome = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();
            if (util.verificar_utilizador_confirmar(utilizadores, nome, password)) {
                menu_utilizador();
            } else {
                System.out.println("Não existe utilizador com esse nome ou password");
                menu_inicial();
            }
        }
    }
}







