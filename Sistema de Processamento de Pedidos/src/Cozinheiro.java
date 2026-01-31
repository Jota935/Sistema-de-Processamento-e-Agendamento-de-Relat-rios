public class Cozinheiro implements Runnable {

    private FilaDePedidos fila;
    private String nome;
    private int contador = 1;

    public Cozinheiro(String nome, FilaDePedidos fila) {
        this.nome = nome;
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000); // 2 segundos para preparar
                String prato = nome + " - Prato " + contador++;
                fila.adicionarPedido(prato);
            }
        } catch (InterruptedException e) {
            System.out.println(nome + " finalizou.");
        }
    }
}