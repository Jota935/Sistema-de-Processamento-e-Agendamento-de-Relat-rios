import java.util.LinkedList;
import java.util.Queue;

public class FilaDePedidos {

    private Queue<String> fila = new LinkedList<>();
    private int capacidadeMaxima;
    private boolean usarNotifyAll;

    public FilaDePedidos(int capacidadeMaxima, boolean usarNotifyAll) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.usarNotifyAll = usarNotifyAll;
    }

    public synchronized void adicionarPedido(String pedido) throws InterruptedException {
        while (fila.size() == capacidadeMaxima) {
            System.out.println("Fila cheia. Cozinheiro aguardando...");
            wait();
        }

        fila.add(pedido);
        System.out.println("Pedido adicionado: " + pedido + " | Total na fila: " + fila.size());

        if (usarNotifyAll) {
            notifyAll();
        } else {
            notify();
        }
    }

    public synchronized String retirarPedido() throws InterruptedException {
        while (fila.isEmpty()) {
            System.out.println("Fila vazia. Garçom aguardando...");
            wait();
        }

        String pedido = fila.remove();
        System.out.println("Pedido retirado: " + pedido + " | Total na fila: " + fila.size());

        if (usarNotifyAll) {
            notifyAll();
        } else {
            notify();
        }

        return pedido;
    }
}