package island.main;

import island.GamePlay;
import island.plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class Statistic implements Runnable{
    private GameBoardIsland gameBoardIsland;
    private static CopyOnWriteArrayList<String> statisticEatEventList = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<String> statisticDeathEventList = new CopyOnWriteArrayList<>();

    private static CopyOnWriteArrayList<String> statisticBirthEventList = new CopyOnWriteArrayList<>();

    public Statistic(GameBoardIsland gameBoardIsland) {
        this.gameBoardIsland = gameBoardIsland;
    }

    private static void clearStatistic (){
        statisticEatEventList.clear();
        statisticDeathEventList.clear();
        statisticBirthEventList.clear();
    }

    public static void setEatStatisticEvent(String event){
        statisticEatEventList.add(event);
    }
    public static void setDeathStatisticEvent(String event){
        statisticDeathEventList.add(event);
    }
    public static void setStatisticBirthEvent(String event){
        statisticBirthEventList.add(event);
    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            synchronized (gameBoardIsland) {
                System.out.println(LocalDateTime.now() + " TaskPrintStatistic Started");
                printStatisticEvent(Statistic.statisticEatEventList);
                System.out.println("Print Death statistic");
                printStatisticEvent(Statistic.statisticDeathEventList);
                System.out.println("Print Birth statistic");
                printStatisticEvent(Statistic.statisticBirthEventList);
                System.out.println("Print Cell");
                System.out.println();
            }
                gameBoardIsland.printEmojiGameBoard();
            synchronized (gameBoardIsland) {
                Statistic.clearStatistic();
                System.out.println();
                System.out.print("Если хотите остановиться введите любой символ и нажмите Ввод: ");
            }

        }

    }



    private void printStatisticEvent(CopyOnWriteArrayList<String> statisticEventList){
        for (int i = 0; i < statisticEventList.size(); i++) {
            if (i%10 == 0){
                System.out.println();
            }
            if (i != statisticEventList.size()-1){
                System.out.print(statisticEventList.get(i)+", ");
            }else {
                System.out.println(statisticEventList.get(i));
                System.out.println();
            }
        }
    }


}
