package domain;

import view.Menu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Information Expert
 * Tem a responsabilidade sobre o caso de uso UC06
 * Este Information Expert sugere que a responsabilidade de executar uma ação sobre o caso de uso 6
 * deve ser atribuída ao objeto que possui a informação necessária para executá-la.
 * Neste caso esta classe tem como responsabilidade os inputs dos valores dos atríbutos da classe UtilizadorTMA.
 * E a confirmação de craição de um utilizadortma com os respetidos valores atribuidos.
 * E sugere a responsabilidade de criação do objeto do tipo UtilizadorTMA para a classe UtilizadorTMACreator.
 */
public class HandlerUC06 {

    /**
     * Método que verifica a existência de um utilizadortma na lista dos mesmos e no ficheiro txt onde estão guardados os seus dados
     * @param utilizadorestma
     * @param nome
     * @param pcc
     * @param hcmid
     * @return estado de verificação
     * @throws FileNotFoundException
     */
    public static boolean verificar_dados_utilizadortma(ArrayList<UtilizadorTMA> utilizadorestma, String nome, int pcc, int hcmid) throws FileNotFoundException {
        for(UtilizadorTMA utilizadortma : utilizadorestma) {
            try {
                //Leitura do ficheiro;
                FileReader fr = new FileReader("UtilizadoresTMA.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Verificação em linha:
                while ((line = br.readLine()) != null) {
                    if (line.contains(nome) && line.equals(pcc) && line.equals(hcmid)) {
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
     * Método que confirma a criação de um novo utilizadortma com valores já atribuidos aos seus atributos
     * @param username
     * @param pcc
     * @param hcmid
     * @param gds
     * @throws IOException
     */
    public static void confirmacao_tma(String username, int pcc, int hcmid, String gds) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("1-Confirmar criação de utilizadorTMA");
        System.out.println("2-Sair");
        int opcao = input.nextInt();
        if (opcao == 1) {
            HandlerUC06.data_criacao();
            UtilizadorTMA.data_ultima_alteracao = UtilizadorTMA.data_criacao;
            UtilizadorTMACreator.criar_utilizadortma(username, pcc, hcmid, gds);
        }
        else if (opcao == 2) {
            Menu.menu_utilizador();
        }
        else {
            System.out.println("Opção inválida");
        }
    }

    /**
     * Método que responsável pelos inputs dos dados do novo utilizadortma
     * @throws IOException
     */
    public static void inserir_dados_tma() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o username, pcc(inteiro), hcmid(inteiro) e gds(string):");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("PCC: ");
        int pcc = Integer.parseInt(input.nextLine());
        System.out.print("HCMID: ");
        int hcmid = Integer.parseInt(input.nextLine());
        System.out.println("GDS:");
        String gds = input.nextLine();
        if (HandlerUC06.verificar_dados_utilizadortma(UtilizadorTMA.utilizadorestma, username, pcc, hcmid)) {
            System.out.println("UtilizadorTMA com esse username,pcc e hcmid já existe");
            HandlerUC06.inserir_dados_tma();
        }
        HandlerUC06.confirmacao_tma(username, pcc, hcmid, gds);
    }

    /**
     * Método que obtem a data de criação do utilziadortma
     */
    public static void data_criacao() {
        UtilizadorTMA.data_criacao = new Date();
    }

    /**
     * Método que adiciona o utilziadortma a lista dos mesmos
     * Escreve os dados do utilziadortma no ficheiro txt
     * @param utilTMA
     */
    public static void confirmar_criacao_tma(UtilizadorTMA utilTMA) {
        UtilizadorTMA.utilizadorestma.add(utilTMA);
        Escreverficheiros.writeToFileUtilizadorTMA(UtilizadorTMA.utilizadorestma, "UtilizadoresTMA");
        System.out.println("UtilizadorTMA criado com sucesso");

    }

    /**
     * Método que verifica a existência de um utilizadortma na lista dos mesmos e no ficheiro txt onde estão guardados os seus dados
     * @param utilizadorestma
     * @param nome
     * @return estado de verificação
     * @throws FileNotFoundException
     */
    public static boolean verificar_utilizadortma(ArrayList<UtilizadorTMA> utilizadorestma, String nome) throws FileNotFoundException {
        for(UtilizadorTMA utilizadortma : utilizadorestma) {
            try {
                //Leitura do ficheiro;
                FileReader fr = new FileReader("UtilizadoresTMA.txt");
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

}
