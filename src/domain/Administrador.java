package domain;

public class Administrador {

    //Atributos:
    private static String username = "admin";
    private static String password = "12345";

    //Construtor:
    public Administrador(String admin, String password) {
        //Atributos com valores default, unicos valores de acesso ao modo admin;
        this.username = "admin";
        this.password = "12345";
    }

    /**
     * Método que faz a verificação das credenciais do administrador
     * @param username
     * @param password
     * @return estado de login
     */
    public static boolean login(String username, String password) {
        return Administrador.username.equals(username) && Administrador.password.equals(password);
    }

    //Getters e setters:

    /**
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
