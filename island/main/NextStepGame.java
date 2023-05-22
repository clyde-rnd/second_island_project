package island.main;

public class NextStepGame implements Runnable{
    private GameBoardIsland gameBoardIsland;
    private int boardHeight;
    private int boardWidth;

    public NextStepGame( GameBoardIsland gameBoardIsland) {
        this.gameBoardIsland = gameBoardIsland;

    }


    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {

                Thread thread1 = new Thread(new TaskToMoveAnimal(gameBoardIsland));
                Thread thread2 = new Thread(new TaskReproduction(gameBoardIsland));
                Thread thread3 = new Thread(new TaskOfEating(gameBoardIsland));
                Thread thread4 = new Thread(new Statistic(gameBoardIsland));


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
