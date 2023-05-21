package main;

public class NextStepGame implements Runnable{
    private volatile IslandLocationCell[][] islandLocationCells;
    private int boardHeight;
    private int boardWidth;

    public NextStepGame(IslandLocationCell[][] islandLocationCells,  int boardHeight, int boardWidth) {
        this.islandLocationCells = islandLocationCells;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;

    }


    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            synchronized (islandLocationCells) {
                Thread thread1 = new Thread(new TaskToMoveAnimal(islandLocationCells, boardHeight, boardWidth));
                Thread thread2 = new Thread(new TaskReproduction(islandLocationCells));
                Thread thread3 = new Thread(new TaskOfEating(islandLocationCells));
                Thread thread4 = new Thread(new Statistic(islandLocationCells));

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
}
