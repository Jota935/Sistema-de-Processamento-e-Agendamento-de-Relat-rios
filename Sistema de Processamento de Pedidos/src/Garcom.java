public class Garcom implements Runnable {

    private FilaDePedidos fila;
    private String nome;

    public Garcom(String nome, FilaDePedidos fila) {
        this.nome = nome;
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String prato = fila.retirarPedido();
                System.out.println(nome + " serviu: " + prato);
                Thread.sleep(3000); // 3 segundos para servir
            }
        } catch (InterruptedException e) {
            System.out.println(nome + " finalizou.");
        }
    }
}