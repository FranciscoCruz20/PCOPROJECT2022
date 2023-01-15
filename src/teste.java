import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class teste {
    static Utilizador util = new Utilizador("nome","email","", "");
    static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
    static Administrador admin = new Administrador("admin", "password");


    //Main:
    //Para aceder como admin:
    //Username: admin
    //Password: 12345
    public static void main(String[] args) throws IOException {
        Utilizador util = new Utilizador("nome","email","","");
        Administrador admin = new Administrador("admin", "password");
        menu_inicial();
    }

    //Primeiro menu apresentado, com acesso ao menu de administrador(com verificação implementada), confirmação de email de utilizador(com verificação do email), menu de utilizador(com verificação de nome e password):
    public static void menu_inicial() throws IOException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Menu de administrador");
            System.out.println("2 - Confirmação email");
            System.out.println("3 - Menu de utilizador");
            System.out.println("4 - Sair");

            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                menu_admin();
            }
            if (opcao == 2) {
                menu_confirmacao_inicial();
            }
            if (opcao == 3) {
                menu_confirmacao_utilizador();
            }
            if (opcao == 4) {
                break;
            }
            else {
                System.out.println("Opção inválida");
            }
        }
    }

    public static void menu_confirmacao_inicial() throws IOException {
        //Inputs:
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Insira o nome de utilizador e o email:");
            System.out.print("Nome: ");
            String nome = input.nextLine();
            System.out.print("Email: ");
            String email = input.nextLine();
            if (util.verificar_utilizador_confirmar(utilizadores, nome, email)) {
                if (util.getConfrimacao_email()==false) {
                    System.out.println("1-Confirmar email");
                    System.out.println("2-Sair");
                    int opcao = input.nextInt();
                    input.nextLine();
                    if (opcao == 1) {
                        util.setConfrimacao_email(true);
                        System.out.println("Insira a sua nova password:");
                        String password = input.nextLine();
                        util.setPassword(password);
                        menu_utilizador();
                    } else if (opcao == 2) {
                        menu_inicial();
                    } else {
                        System.out.println("Opção inválida");
                    }
                }
                else {
                    System.out.println("Email confirmado");
                    menu_inicial();
                }
            }
            else {
                System.out.println("Não existe utilizador com esse nome ou email");
                menu_inicial();

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


    public static void menu_utilizador() throws IOException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Menu utilizador:");
            System.out.println("1-Sair");
            int opcao = input.nextInt();
            input.nextLine();
            if(opcao == 1) {
                menu_inicial();
            }
            else {
                System.out.println("Opção inválida");
            }
        }
    }

    //Menu para aceder como administrador:
    public static void menu_admin() throws IOException{

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Insira o nome de utilizador e password:");
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();

            if(admin.login(username, password)) {
                while(true) {
                    System.out.println("Menu:");
                    System.out.println("1 - Criar novo utilizador");
                    System.out.println("2 - Verificar utilizador existente");
                    System.out.println("3 - Sair");

                    int opcao = input.nextInt();
                    input.nextLine();

                    if(opcao == 1) {
                        System.out.println("Insira o nome, email e função do utilizador:");
                        System.out.print("Nome: ");
                        String nome = input.nextLine();
                        System.out.print("Email: ");
                        String email = input.nextLine();
                        System.out.print("Função: ");
                        String funcao = input.nextLine();

                        if(admin.verificar_utilizador(utilizadores, nome)) {
                            System.out.println("Utilizador com esse nome já existe");
                        } else {
                            Utilizador utilizador = new Utilizador(nome, email, funcao, password);
                            utilizadores.add(utilizador);
                            System.out.println("Utilizador criado com sucesso!");
                            System.out.println(utilizadores);
                            Escreverficheiros.writeToFile(utilizadores, "Utilizadores.txt");
                        }

                    }
                    else if(opcao == 2) {
                        System.out.println("Insira o nome do utilizador:");
                        System.out.print("Nome: ");
                        String nome = input.nextLine();
                        if(admin.verificar_utilizador(utilizadores, nome)) {
                            System.out.println("Existe um utilizador com este nome");
                            System.out.println(nome);

                        } else {
                            System.out.println("Não existe nenhum utilizador com este nome");
                        }

                    }
                    else if(opcao == 3) {
                        menu_inicial();
                    }
                    else {
                        System.out.println("Opção inválida");
                    }
                }
            } else {
                System.out.println("Username ou password incorretos");
            }
        }
    }
}







