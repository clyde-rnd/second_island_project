package main;

public class NextStepGame implements Runnable{

    private int boardHeight;
    private int boardWidth;

    public NextStepGame( int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;

    }


    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {

                Thread thread1 = new Thread(new TaskToMoveAnimal( boardHeight, boardWidth));
                Thread thread2 = new Thread(new TaskReproduction());
                Thread thread3 = new Thread(new TaskOfEating());
                Thread thread4 = new Thread(new Statistic());

                thread1.start();
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                thread2.start();
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                thread3.start();
                try {
                    thread3.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                thread4.start();
                try {
                    thread4.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        }
    }
}
