import java.util.Date;

public class Licenca {

    //Atributos:
    private Date data_criacao;
    private String estado;
    private Date validade;
    private  UtilizadorTMA utilizadortma;
    private boolean pagamento;
    private boolean renovacao;
    private float preco;
    private Cliente cliente;

    //Construtor:
    public Licenca(Date data_criacao,String estado, Date validade, UtilizadorTMA utilizadortma, boolean pagamento, boolean renovacao, float preco, Cliente cliente) {
        this.data_criacao = data_criacao;
        this.estado = "Inativa";
        this.validade = validade;
        this.utilizadortma = utilizadortma;
        this.pagamento = false;
        this.renovacao = false;
        this.preco = preco;
        this.cliente = cliente;
    }

    //Metodos para obter data do sistema:
    public void obter_data() {
        Date data = new Date();
        System.out.println("A hora do sitema é "+ data.toString());
    }

    public  void data_criacao() {
        Date data_criacao = new Date();
        System.out.println("Data de criação: "+ data_criacao.toString());
    }

    public void criar_licenca() {

    }

    public void dados_licenca(Date validade, UtilizadorTMA utilizadortma, Cliente cliente) {

    }

    public void confirmar_licenca() {

    }

    //Getters e Setters:
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isRenovacao() {
        return renovacao;
    }

    public void setRenovacao(boolean renovacao) {
        this.renovacao = renovacao;
    }

    public boolean isPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public UtilizadorTMA getUtilizadortma() {
        return utilizadortma;
    }

    public void setUtilizadortma(UtilizadorTMA utilizadortma) {
        this.utilizadortma = utilizadortma;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }
}
