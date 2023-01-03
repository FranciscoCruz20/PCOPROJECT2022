import java.util.Scanner;

public class Administrador {

    //Atributos
    private String username;
    private String password;

    //Construtor:
    public Administrador() {
        this.username = "admin";
        this.password = "12345";
    }

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
        }

    }

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
