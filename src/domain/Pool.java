package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Pool {

    //Atributos:
    private static String nome;
    private static int max_licencas;
    private static Date data_criacao;
    private static String validade;
    private static String estado;
    private static int licencas_disp;
    private static boolean estado_pagamento;
    private static boolean renovacao;
    private static float preco;
    private static Cliente cliente;
    private static Licenca licenca;
    private static int licencas_usadas;
    private static ArrayList<Licenca> licencas = new ArrayList<>();
    public static ArrayList<Pool> pools = new ArrayList<>();

    //Construtor:
    public Pool(String nome, int max_licencas, Date data_criacao, String validade, String estado,int licencas_disp, boolean estado_pagamento, boolean renovacao, float preco,Cliente cliente, List licencas, int licencas_usadas) {
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
        this.licencas = new ArrayList<>();

    }

    /**
     * Chama o creator de objetos do tipo Pool
     * @throws FileNotFoundException
     */
    public static void criar_pool() throws FileNotFoundException {
        PoolCreator.criar_pool();
    }

    /**
     * Méwtodo que verifica a existÊncia de uma pool pelo nome no ficheiro
     * @param pools
     * @param nome
     * @return
     * @throws FileNotFoundException
     */
    public static boolean verificar_pool(ArrayList<Pool> pools, String nome) throws FileNotFoundException {
        for(Pool pool : pools) {
            try {
                //Leitura do ficheiro;
                FileReader fr = new FileReader("Pools.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Verificação em linha:
                while ((line = br.readLine()) != null) {
                    if (line.contains(nome)) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    /**
     * Método que obtém a data de criação da pool
     * @return
     */
    public static Date data_criacao() {
        Date data_criacao = new Date();
        System.out.println("Data de criação: "+ data_criacao.toString());
        return data_criacao;
    }

    //Getters e Setters:

    /**
     *
     * @return licenças usadas
     */
    public static int getLicencas_usadas() {
        return licencas_usadas;
    }

    /**
     *
     * @param licencas_usadas
     */
    public static void setLicencas_usadas(int licencas_usadas) {
        Pool.licencas_usadas = licencas_usadas;
    }

    /**
     *
     * @return número máximo de licenças
     */
    public static int getMax_licencas() {
        return max_licencas;
    }

    /**
     *
     * @param max_licencas
     */
    public static void setMax_licencas(int max_licencas) {

        Pool.max_licencas = max_licencas;
    }

    /**
     *
     * @return data de criação
     */
    public static Date getData_criacao() {

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
     *
     * @return validade
     */
    public static String getValidade() {

        return validade;
    }

    /**
     *
     * @param validade
     */
    public static void setValidade(String validade) {

        Pool.validade = validade;
    }

    /**
     *
     * @return estado
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
     * @return licenças disponiveis
     */
    public static int getLicencas_disp() {

        return licencas_disp;
    }

    /**
     *
     * @param licencas_disp
     */
    public static void setLicencas_disp(int licencas_disp) {

        Pool.licencas_disp = licencas_disp;
    }

    /**
     *
     * @return estado de pagamento
     */
    public static boolean getEstado_pagamento() {

        return estado_pagamento;
    }

    /**
     *
     * @param estado_pagamento
     */
    public void setEstado_pagamento(boolean estado_pagamento) {

        this.estado_pagamento = estado_pagamento;
    }

    /**
     *
     * @return renovação
     */
    public static boolean getRenovacao() {

        return renovacao;
    }

    /**
     *
     * @param renovacao
     */
    public static void setRenovacao(boolean renovacao) {

        Pool.renovacao = renovacao;
    }

    /**
     *
     * @return preço
     */
    public static float getPreco() {

        return preco;
    }

    /**
     * Preço da pool é o preço de uma licença X o número máximo de licenças
     * @param max_licencas
     */
    public void setPreco(int max_licencas) {
        this.preco = max_licencas*100;
    }

    /**
     *
     * @return cliente
     */
    public static Cliente getCliente() {

        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public static void setCliente(Cliente cliente) {

        Pool.cliente = cliente;
    }

    /**
     *
     * @return nome
     */
    public static String getNome() {
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
     * @return lista de licenças
     */
    public static ArrayList<Licenca> getLicencas() {
        return licencas;
    }

    /**
     *
     * @param licencas
     */
    public void setLicencas(ArrayList<Licenca> licencas) {
        this.licencas = licencas;
    }

    /**
     *
     * @return lista de pools
     */
    public static ArrayList<Pool> getPools() {
        return pools;
    }

    /**
     *
     * @param pools
     */
    public void setPools(ArrayList<Pool> pools) {
        this.pools = pools;
    }

    /**
     *
     * @return licença
     */
    public static Licenca getLicenca() {
        return licenca;
    }

    /**
     *
     * @param licenca
     */
    public static void setLicenca(Licenca licenca) {
        Pool.licenca = licenca;
    }

    @Override
    /**
     * Método que mostra a informação da pool
     */
    public String toString() {
        return "Pool{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
