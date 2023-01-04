import java.util.ArrayList;

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
    private static ArrayList<Cliente> clientes;//Lista de clientes criados;


   //Verificar se o nome do cliente está na lista de clientes:
   public static void verificar_cliente(String cliente) {
        if (clientes.contains(cliente)) {
            System.out.println("Cliente válido.");
        }
        else {
            System.out.println("Cliente inválido.");
        }
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
}
