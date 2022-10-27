package gestion_de_hilos;

public class Hilos extends Thread {

    public static void main(String[] args) {

        // Creo las tareas
        Thread task1 = new Thread(new Hilos(), "Tarea 1");
        Thread task2 = new Thread(new Hilos(), "Tarea 2");
        Thread task3 = new Thread(new Hilos(), "Tarea 3");

        // Les asigno la prioridad
        task1.setPriority(MIN_PRIORITY);
        task2.setPriority(NORM_PRIORITY);
        task3.setPriority(MAX_PRIORITY);

        task1.start();
        task2.start();
        task3.start();

        // Hago q el main espere a q finalicen los otros hilos
        try {
            task1.join();
            task2.join();
            task3.join();
        } catch (InterruptedException ignored) {

        }

        System.out.println("\nTermina el main");
    }


    public void run() {
        for (int i = 0; i < 10; i++) {
            int priority = Thread.currentThread().getPriority();
            System.out.println("Ejecutando el hilo: " + Thread.currentThread().getName() +
                    " con prioridad: " + namePriority(priority));
            if ((i == 4) && (priority == MAX_PRIORITY || priority == MIN_PRIORITY)) {
                System.out.println("---- El Hilo " + Thread.currentThread().getName() + " cambió su prioridad ----");
                Thread.currentThread().setPriority(newPriority(priority));
            }
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ignored) {

            }
        }
    }

    private static String namePriority(int priority) {
        return priority == MIN_PRIORITY ? "Baja" : priority == NORM_PRIORITY ? "Normal" : "Alta";
    }

    private static int newPriority(int priority) {
        return priority == MAX_PRIORITY ? MIN_PRIORITY : MAX_PRIORITY;
    }

}
