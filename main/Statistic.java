package main;

import plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class Statistic implements Runnable{
    private volatile CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>> islandLocationCells = GamePlay.islandLocationCells;
    private static CopyOnWriteArrayList<String> statisticEatEventList = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<String> statisticDeathEventList = new CopyOnWriteArrayList<>();

    private static CopyOnWriteArrayList<String> statisticBirthEventList = new CopyOnWriteArrayList<>();
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
            System.out.println(LocalDateTime.now()+" TaskPrintStatistic Started");
            printStatisticEvent(Statistic.statisticEatEventList);
            System.out.println("Print Death statistic");
            printStatisticEvent(Statistic.statisticDeathEventList);
            System.out.println("Print Birth statistic");
            printStatisticEvent(Statistic.statisticBirthEventList);
            System.out.println("Print Cell");
            System.out.println();
            printEmojiGameBoard(islandLocationCells);
            Statistic.clearStatistic();
            System.out.println();
            System.out.print("Если хотите остановиться введите любой символ и нажмите Ввод: ");


        }

    }

    private void printEmojiGameBoard(CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>> islandLocationCells){
        for (int i = 0; i < islandLocationCells.size(); i++) {
            for (int j = 0; j < islandLocationCells.get(i).size(); j++) {
                System.out.print("Cell - " + i + "X" + j + " ");
                for (CopyOnWriteArrayList<FlorAndFauna> element: islandLocationCells.get(i).get(j).arraysCell) {
                    for (FlorAndFauna florAndFaunElement: element) {
                        if (florAndFaunElement instanceof Plants){
                            System.out.print(florAndFaunElement.getEmoji()+"-"+((Plants) florAndFaunElement).getCurrentWeight());
                        }else {
                            System.out.print(florAndFaunElement.getEmoji());
                        }

                    }
                }
                System.out.println();
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
