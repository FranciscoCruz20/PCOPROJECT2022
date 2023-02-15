package domain;

import view.Menu;

import java.io.IOException;
import java.util.Scanner;

public class UtilizadorTMACreator {

    /**
     * Método responsável pela criação de objetos do tipo UtilziadorTMA
     * @return utilziadortma
     * @throws IOException
     */
    public static UtilizadorTMA criar_utilizadortma() throws IOException {
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
        if (UtilizadorTMA.verificar_dados_utilizadortma(UtilizadorTMA.utilizadorestma, username, pcc, hcmid)) {
            System.out.println("UtilizadorTMA com esse username,pcc e hcmid já existe");
            UtilizadorTMA.inserir_dados_tma();
        }
        else {
            System.out.println("1-Confirmar criação de utilizadorTMA");
            System.out.println("2-Sair");
            int opcao = input.nextInt();
            if (opcao == 1) {
                UtilizadorTMA.data_criacao();
                UtilizadorTMA.data_ultima_alteracao = UtilizadorTMA.data_criacao;
                UtilizadorTMA utilTMA = new UtilizadorTMA(username, pcc, hcmid, gds, UtilizadorTMA.data_criacao, UtilizadorTMA.data_ultima_alteracao, UtilizadorTMA.estado);
                UtilizadorTMA.confirmar_criacao_tma(utilTMA);
            }
            else if (opcao == 2) {
                Menu.menu_utilizador();
            }
            else {
                System.out.println("Opção inválida");
            }
        }
        return new UtilizadorTMA(username, pcc, hcmid, gds, UtilizadorTMA.data_criacao, UtilizadorTMA.data_ultima_alteracao, UtilizadorTMA.estado);
    }
}
