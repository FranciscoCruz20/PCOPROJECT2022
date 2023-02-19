package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public static ArrayList<Cliente> clientes = new ArrayList<>();//Lista de clientes criados;

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

    /**
     * Método que verifica a existencia de um cliente com um nome especifico no ficheiro onde estão guardados os dados dos clientes
     * @param nome
     * @return estado da verificação
     */
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

    /**
     * Método que verifica a existencia de um cliente com um nome especifico no ficheiro onde estão guardados os dados dos clientes
     * @param clientes
     * @param nome
     * @return estado da verificação
     */
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

    /**
     * Método que chama o método que cria objetos do tipo Cliente na classe creator de Clientes
     */
    public static void criar_cliente() {
        ClienteCreator.criar_cliente();
    }

    /**
     * Método que procura um cliente pelo nome na lista de clientes
     * @param nome
     * @return cliente
     */
    public static Cliente procurarCliente(String nome) {
        for(Cliente cliente : clientes) {
            if(cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    //Getters e Setters:

    /**
     *
     * @return gestor
     */
    public Utilizador getGestor() {
        return gestor;
    }

    /**
     *
     * @param gestor
     */
    public void setGestor(Utilizador gestor) {
        this.gestor = gestor;
    }

    /**
     *
     * @return clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     *
     * @param clientes
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     *
     * @return nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return email do cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return telefone do cliente
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return nif do cliente
     */
    public int getNif() {
        return nif;
    }

    /**
     *
     * @param nif
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     *
     * @return endereço do cliente
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     *
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return código postal do cliente
     */
    public String getCodigo_postal() {
        return codigo_postal;
    }

    /**
     *
     * @param codigo_postal
     */
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     *
     * @return pais do cliente
     */
    public String getPais() {
        return pais;
    }

    /**
     *
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     *
     * @return informação adicional do cliente
     */
    public String getInformacao_adicional() {
        return informacao_adicional;
    }

    /**
     *
     * @param informacao_adicional
     */
    public void setInformacao_adicional(String informacao_adicional) {
        this.informacao_adicional = informacao_adicional;
    }

    /**
     *
     * @return pagamento default do cliente
     */
    public String getPagamento_default() {
        return pagamento_default;
    }

    /**
     *
     * @param pagamento_default
     */
    public void setPagamento_default(String pagamento_default) {
        this.pagamento_default = pagamento_default;
    }

    @Override
    /**
     * Método que mostra os dados do cliente
     */
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
