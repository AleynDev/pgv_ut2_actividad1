package creacion_de_hilos;

public class MiHilo implements Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new MiHilo(), "Hilo " + i);
            thread.start();
            try {
                Thread.sleep((int) (Math.random() * 150));
            } catch (InterruptedException ignored) {

            }
        }
        System.out.println("El hilo principal: " + Thread.currentThread().getName() + " finalizo");
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ejecutando el hilo: " + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep((int) (Math.random() * 100));
            } catch (InterruptedException ignored) {

            }
        }
        System.out.println("El hilo: " + Thread.currentThread().getName() + " finalizo");
    }
}
