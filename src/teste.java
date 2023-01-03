import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        /*
        menu();
         */
        Utilizador u = new Utilizador();
        u.registrar_utilizador();


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
}
