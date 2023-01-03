import java.util.ArrayList;
import java.util.Scanner;

public class teste {

    /*
    public static void main(String[] args) {
        menu();
        Utilizador u = new Utilizador();
        u.registrar_utilizador();
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Administrador admin = new Administrador("admin", "password");
        ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();

        while(true) {
            System.out.println("Insira o nome de utilizador e password:");
            String username = input.nextLine();
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
                        String nome = input.nextLine();
                        String email = input.nextLine();
                        String funcao = input.nextLine();

                        if(admin.verificar_utilizador(utilizadores, nome)) {
                            System.out.println("Utilizador com esse nome já existe");
                        } else {
                            Utilizador utilizador = new Utilizador(nome, email, funcao);
                            utilizadores.add(utilizador);
                            System.out.println("Utilizador criado com sucesso!");
                            System.out.println(utilizadores);
                        }

                    }
                    else if(opcao == 2) {
                        System.out.println("Insira o nome do utilizador:");
                        String nome = input.nextLine();
                        if(admin.verificar_utilizador(utilizadores, nome)) {
                            System.out.println("Válido");
                            System.out.println(utilizadores);

                        } else {
                            System.out.println("Inválido");
                        }

                    }
                    else if(opcao == 3) {
                        break;
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



    /*
    public static void menu() {
        System.out.println("Menu inicial:");
        System.out.println("1-Validar admin");
        Scanner t = new Scanner(System.in);
        System.out.println("Opção:");
        int opcao = t.nextInt();
        if (opcao==1) {
            Administrador a = new Administrador();
            a.validar_admin();
        }
    }
    */






