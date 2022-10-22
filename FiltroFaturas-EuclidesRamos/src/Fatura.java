public class Fatura {

    private int codigo;
    private int valor;
    private String data;
    private String cliente;

    public Fatura(int valor, String data, String cliente) {
        this.codigo = 123;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }
}
