package domain;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe creator responsável por criar onjetos do tipo Utilizador
 */
public class UtilizadorCreator {

    /**
     * Método que cria objetos do tipo utilizador e guarda os dados deles num ficheiro txt
     * @return
     */
    public static Utilizador criar_utilizador() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome, email e função do utilizador:");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        if (Utilizador.verificar_utilizador(Utilizador.utilizadores, nome)) {

            System.out.println("Utilizador com esse nome já existe");
        } else {

            System.out.print("Email: ");
            String email = input.nextLine();
            System.out.print("Função(Admin/Gestor): ");
            String funcao = input.nextLine();

            if (funcao.equals("Admin") ^ funcao.equals("Gestor")) {

                System.out.println("1-Confirmar email");
                int opcao2 = input.nextInt();
                input.nextLine();

                if (opcao2 == 1) {

                    Utilizador.setConfrimacao_email(true);
                    System.out.println("Insira a sua nova password:");
                    String passwordU = input.nextLine();
                    Utilizador utilizador = new Utilizador(nome, email, funcao, passwordU);
                    Utilizador.utilizadores.add(utilizador);
                    Escreverficheiros.writeToFile(Utilizador.utilizadores, "Utilizadores.txt");

                } else {

                    System.out.println("Opção inválida");
                }
            } else {

                System.out.println("Função não existe, crie novamente");
            }
        }
        return new Utilizador(nome, Utilizador.getEmail(), Utilizador.getFuncao(), Utilizador.getPassword());
    }
}
