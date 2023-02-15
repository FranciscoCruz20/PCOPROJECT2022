package domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe das licenças;
 */
public class Licenca {

    //Atributos:
    public static Date data_criacao;
    private static String estado;
    private static String validade;
    private static String utilizadortma;
    private static boolean pagamento;
    private static boolean renovacao;
    private static float preco;
    private static String cliente;
    public static ArrayList<Licenca> licencas = new ArrayList<>();
    public static ArrayList<UtilizadorTMA> utilizadorestma = new ArrayList<UtilizadorTMA>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    //Construtor:
    /**
     * Construtor da classe Licença
     * Estado da licença começa como inativa, só passa a ativa mais tarde quando é feito o pagamento
     * Pagamento começa como false, só passa para true quando é efetuado o pagamento
     * Renovação começa como false, só passa para true se o gestor quiser renovar a licença
     * Preço da licença é uma constante
     * @param data_criacao
     * @param estado
     * @param validade
     * @param utilizadortma
     * @param pagamento
     * @param renovacao
     * @param preco
     * @param cliente
     */
    public Licenca(Date data_criacao, String estado, String validade, String utilizadortma, boolean pagamento, boolean renovacao, float preco, String cliente) {
        this.data_criacao = data_criacao;
        this.estado = "Inativa";
        this.validade = validade;
        this.utilizadortma = utilizadortma;
        this.pagamento = false;
        this.renovacao = false;
        this.preco = 100;
        this.cliente = cliente;
    }

    //Getters e Setters:
    /**
     *
     * @return cliente
     */
    public static String getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public static void setCliente(String cliente) {
        Licenca.cliente = cliente;
    }

    /**
     *
     * @return preço da licença
     */
    public static float getPreco() {
        return preco;
    }

    /**
     *
     * @param preco
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     *
     * @return estado da renovação
     */
    public static boolean getRenovacao() {
        return renovacao;
    }

    /**
     *
     * @param renovacao
     */
    public void setRenovacao(boolean renovacao) {
        this.renovacao = renovacao;
    }

    /**
     *
     * @return estado do pagamento
     */
    public static boolean getPagamento() {
        return pagamento;
    }

    /**
     *
     * @param pagamento
     */
    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    /**
     *
     * @return utilizadortma
     */
    public static String getUtilizadortma() {
        return utilizadortma;
    }

    /**
     *
     * @param utilizadortma
     */
    public static void setUtilizadortma(String utilizadortma) {
        Licenca.utilizadortma = utilizadortma;
    }

    /**
     *
     * @return validade da licença
     */
    public static String getValidade() {
        return validade;
    }

    /**
     *
     * @param validade
     */
    public static void setValidade(String validade) {
        Licenca.validade = validade;
    }

    /**
     *
     * @return estado da licença
     */
    public static String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return data de criação da licença
     */
    public  Date getData_criacao() {
        return data_criacao;
    }

    /**
     *
     * @param data_criacao
     */
    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    /**
     *Método que mostra os dados da licença
     * @return dados da licença
     */
    public String toString() {
        return "domain.Licenca{" +
                "data_criacao=" + data_criacao +
                ", estado='" + estado + '\'' +
                ", validade=" + validade +
                ", utilizadortma=" + utilizadortma +
                ", pagamento=" + pagamento +
                ", renovacao=" + renovacao +
                ", preco=" + preco +
                ", cliente=" + cliente +
                '}';
    }
}
