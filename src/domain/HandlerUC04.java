package domain;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/**
 * Information Expert
 * Tem a responsabilidade sobre o caso de uso UC04
 * Este Information Expert sugere que a responsabilidade de executar uma ação sobre o caso de uso 4
 * deve ser atribuída ao objeto que possui a informação necessária para executá-la.
 * Neste caso esta classe tem como responsabilidade os inputs dos valores dos atríbutos da classe Licenca.
 * E a confirmação de craiçãod e uma licença com os respetidos valores atribuidos.
 * E sugere a responsabilidade de criação do objeto do tipo Licenca para a classe LicencaCreator.
 */
public class HandlerUC04 {

    /**
     * Método responsável pelos inputs que vão corresponder ao valores dos atributos do futuro objeto a ser criado
     * @throws FileNotFoundException
     */
    public static void criar_licenca() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Introduza os dados da licença");
        System.out.println("Validade(ano-mês-dia):");
        String validade = input.nextLine();
        Licenca.setValidade(validade);
        System.out.println("Utilizador TMA:");
        String utilizadortma = input.nextLine();
        Date data_criacao = null;
        String estado = null;
        if (HandlerUC06.verificar_utilizadortma(Licenca.utilizadorestma, utilizadortma)) {
            Licenca.setUtilizadortma(utilizadortma);
            System.out.println("Cliente:");
            String cliente = input.nextLine();
            if (Cliente.verificar_cliente(cliente) == true) {
                Licenca.setCliente(cliente);
                HandlerUC06.data_criacao();
                estado = Licenca.getEstado();
                HandlerUC04.confirmar_licenca(data_criacao, estado, Licenca.getValidade(), utilizadortma, Licenca.getPagamento(), Licenca.getRenovacao(), Licenca.getPreco(), Licenca.getCliente());
            } else {
                System.out.println("Dados inseridos incorretos");
            }
        } else {
            System.out.println("Dados inseridos incorretos");
        }

    }

    /**
     * Método que confirma a criação de uma nova licença
     * Chama o método responsável pela criação do objeto na classe LicençaCreator
     * @param data_criacao
     * @param estado
     * @param validade
     * @param utilizadortma
     * @param pagamento
     * @param renovacao
     * @param preco
     * @param cliente
     * @throws FileNotFoundException
     */
    public static void confirmar_licenca(Date data_criacao, String estado, String validade, String utilizadortma, boolean pagamento, boolean renovacao, float preco, String cliente) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("1-Confirmar licença");
        int opcao = input.nextInt();
        if (opcao == 1) {
            LicencaCreator.criarLicenca(data_criacao, estado, Licenca.getValidade(), utilizadortma, Licenca.getPagamento(), Licenca.getRenovacao(), Licenca.getPreco(), Licenca.getCliente());

        } else {
            System.out.println("Opção inválida");
        }
    }
}
