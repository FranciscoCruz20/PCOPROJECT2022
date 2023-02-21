package domain;

/**
 * Classe de códigos promocionais
 */
public class CodigoPromocional {

    private String codigo;
    private boolean estado; //estado serve para saber se já foi usado, false=não usado, true=já foi usado

    public CodigoPromocional(String codigo, boolean estado) {
        this.codigo = codigo;
        this.estado = false;
    }

    /**
     * Chama o método de criação de objetps deste tipo no creator
     */
    public static void criar_codigo() {
        CodigoPromocionalCreator.criar_codigo();
    }

    //Getters e Setters:

    /**
     *
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
