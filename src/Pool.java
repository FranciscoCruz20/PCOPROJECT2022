import java.util.Date;
import java.util.List;

public class Pool {

    //Atributos:
    private int max_licencas;
    private Date data_criacao;
    private Date validade;
    private String estado;
    private int licencas_disp;
    private boolean estado_pagamento;
    private boolean renovacao;
    private float preco;
    private Cliente cliente;
    private int licencas_usadas;

    public Pool(int max_licencas, Date data_criacao, Date validade, String estado,int licencas_disp, boolean estado_pagamento, boolean renovacao, float preco,Cliente cliente, List licencas, int licencas_usadas) {
        this.max_licencas = 0;
        this.data_criacao = data_criacao;
        this.validade = validade;
        this.estado = "Inativa";
        this.licencas_disp = 0;
        this.estado_pagamento = false;
        this.renovacao = false;
        this.preco = 0;
        this.cliente = cliente;
        this.licencas_usadas = 0;

    }

    //Metodos para obter data do sistema:
    public void obter_data() {
        Date data = new Date();
        System.out.println("Data: "+ data.toString());
    }

    public  void data_criacao() {
        Date data_criacao = new Date();
        System.out.println("Data de criação: "+ data_criacao.toString());
    }


    //Getters e Setters:
    public int getMax_licencas() {

        return max_licencas;
    }

    public void setMax_licencas(int max_licencas) {

        this.max_licencas = max_licencas;
    }

    public Date getData_criacao() {

        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {

        this.data_criacao = data_criacao;
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

    public int getLicencas_disp() {

        return licencas_disp;
    }

    public void setLicencas_disp(int licencas_disp) {

        this.licencas_disp = licencas_disp;
    }

    public boolean getEstado_pagamento() {

        return estado_pagamento;
    }

    public void setEstado_pagamento(boolean estado_pagamento) {

        this.estado_pagamento = estado_pagamento;
    }

    public boolean getRenovacao() {

        return renovacao;
    }

    public void setRenovacao(boolean renovacao) {

        this.renovacao = renovacao;
    }

    public float getPreco() {

        return preco;
    }

    //Preço da pool é o preço de uma licença x o número máximo de licenças
    public void setPreco(int max_licencas) {
        this.preco = max_licencas*100;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public void setCliente(Cliente cliente) {

        this.cliente = cliente;
    }
}
