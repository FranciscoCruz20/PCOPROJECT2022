import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Pool {

    //Atributos:
    private String nome;
    private static int max_licencas;
    private static Date data_criacao;
    private Date validade;
    private String estado;
    private static int licencas_disp;
    private boolean estado_pagamento;
    private boolean renovacao;
    private float preco;
    private Cliente cliente;
    private static Licenca licenca;
    private static int licencas_usadas;
    private static ArrayList<Licenca> licencas = new ArrayList<>();
    private static ArrayList<Pool> pools = new ArrayList<>();

    //Construtor:
    public Pool(String nome, int max_licencas, Date data_criacao, Date validade, String estado,int licencas_disp, boolean estado_pagamento, boolean renovacao, float preco,Cliente cliente, List licencas, int licencas_usadas) {
        this.nome = nome;
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

    public static void confirmar_pool_licenca() {
        adicionar_licenca_pool(licenca);
        setLicencas_disp(licencas_disp--);
        setLicencas_usadas(licencas_usadas++);
    }

    public static void escolher_pool(String pool) {
        //Selecionar pool
        if (pools.contains(pool)) {
            if (licencas_usadas < max_licencas ) {
                confirmar_pool_licenca();
            }
            else {
                System.out.println("Pool cheia");
            }
        }
    }

    public static void adicionar_licenca_pool(Licenca licenca) {
        licencas.add(licenca);
        Escreverficheiros.writeToFileLicenca(licencas, "Licenças.txt");
    }

    public void remover_licenca(Pool pool) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Selecionar licença");
        int opcao = input.nextInt();
        if (opcao==0 && opcao>Pool.getMax_licencas()) {
        licencas.remove(pool);

        }
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


    public static int getLicencas_usadas() {
        return licencas_usadas;
    }

    public static void setLicencas_usadas(int licencas_usadas) {
        Pool.licencas_usadas = licencas_usadas;
    }

    public static int getMax_licencas() {

        return max_licencas;
    }

    public void setMax_licencas(int max_licencas) {

        this.max_licencas = max_licencas;
    }

    public static Date getData_criacao() {

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

    public static int getLicencas_disp() {

        return licencas_disp;
    }

    public static void setLicencas_disp(int licencas_disp) {

        Pool.licencas_disp = licencas_disp;
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

    //Preço da pool é o preço de uma licença X o número máximo de licenças
    public void setPreco(int max_licencas) {
        this.preco = max_licencas*100;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public void setCliente(Cliente cliente) {

        this.cliente = cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Licenca> getLicencas() {
        return licencas;
    }

    public void setLicencas(ArrayList<Licenca> licencas) {
        this.licencas = licencas;
    }

    public static ArrayList<Pool> getPools() {
        return pools;
    }

    public void setPools(ArrayList<Pool> pools) {
        this.pools = pools;
    }
}
