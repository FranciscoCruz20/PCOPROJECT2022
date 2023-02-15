package domain;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/**
 * Classe creator de licenças, cria objetos do tipo Licenca com os devidos inputs;
 */
public class LicencaCreator {

    /**
     *
     * Método que cria objetos do tipo Licenca onde os inputs são associados aos atributos de licenca;
     * Para além da criação do objeto, este é guardado numa lista de objetos do mesmo tipo e guardado num ficheiro txt.;
     * @return objeto do tipo Licenca;
     * @throws FileNotFoundException
     */
    public static Licenca criarLicenca() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Introduza os dados da licença");
        System.out.println("Validade(ano-mês-dia):");
        String validade = input.nextLine();
        Licenca.setValidade(validade);
        System.out.println("domain.Utilizador TMA:");
        String utilizadortma = input.nextLine();
        Date data_criacao = null;
        String estado = null;
        if (UtilizadorTMA.verificar_utilizadortma(Licenca.utilizadorestma, utilizadortma)) {
            Licenca.setUtilizadortma(utilizadortma);
            System.out.println("domain.Cliente:");
            String cliente = input.nextLine();
            if (Cliente.verificar_cliente(cliente) == true) {
                Licenca.setCliente(cliente);
                data_criacao = Licenca.data_criacao();
                System.out.println("1-Confirmar licença");
                estado = Licenca.getEstado();
                int opcao = input.nextInt();
                if (opcao == 1) {
                    Licenca licenca = new Licenca(data_criacao, estado, Licenca.getValidade(), utilizadortma, Licenca.getPagamento(), Licenca.getRenovacao(), Licenca.getPreco(), Licenca.getCliente());
                    Licenca.licencas.add(licenca);
                    //return new Licenca(data_criacao, estado, validade, utilizadortma, Licenca.getPagamento(), Licenca.getRenovacao(), Licenca.getPreco(),  Licenca.getCliente());
                    Escreverficheiros.writeToFileLicenca(Licenca.licencas, "Licenças.txt");
                    System.out.println("Licença criada com sucesso");
                } else {
                    System.out.println("Opção inválida");
                }
            } else {
                System.out.println("Dados inseridos incorretos");
            }
        } else {
            System.out.println("Dados inseridos incorretos");
        }

        return new Licenca(data_criacao, estado, validade, utilizadortma, Licenca.getPagamento(), Licenca.getRenovacao(), Licenca.getPreco(), Licenca.getCliente());
    }

}
