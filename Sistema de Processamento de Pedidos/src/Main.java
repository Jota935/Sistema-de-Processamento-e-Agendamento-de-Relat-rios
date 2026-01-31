public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("===== USANDO notifyAll() =====");
        executarSimulacao(true);

        System.out.println("\n\n===== USANDO notify() =====");
        executarSimulacao(false);

        System.out.println("\nSistema totalmente encerrado.");
    }

    private static void executarSimulacao(boolean usarNotifyAll) throws InterruptedException {

        FilaDePedidos fila = new FilaDePedidos(6, usarNotifyAll);

        Thread c1 = new Thread(new Cozinheiro("Cozinheiro 1", fila));
        Thread c2 = new Thread(new Cozinheiro("Cozinheiro 2", fila));

        Thread g1 = new Thread(new Garcom("Garçom 1", fila));
        Thread g2 = new Thread(new Garcom("Garçom 2", fila));

        c1.start();
        c2.start();
        g1.start();
        g2.start();


        Thread.sleep(15000);


        c1.interrupt();
        c2.interrupt();
        g1.interrupt();
        g2.interrupt();


        c1.join();
        c2.join();
        g1.join();
        g2.join();

        System.out.println(">>> Simulação finalizada (" +
                (usarNotifyAll ? "notifyAll()" : "notify()") + ")");
    }
}