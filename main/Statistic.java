package main;

import plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class Statistic implements Runnable{
    private volatile IslandLocationCell[][] islandLocationCells;
    private static CopyOnWriteArrayList<String> statisticEventList = new CopyOnWriteArrayList<>();
    private static void clearStatistic (){
        statisticEventList.clear();
    }

    public static void setStatisticEvent (String event){
        statisticEventList.add(event);
    }


    public Statistic(IslandLocationCell[][] islandLocationCells) {
        this.islandLocationCells = islandLocationCells;
    }
    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now()+" TaskPrintStatistic Started");
            printStatisticEvent(Statistic.statisticEventList);
            System.out.println("Print Cell");
            System.out.println();
            printEmojiGameBoard(islandLocationCells);
            Statistic.clearStatistic();
            System.out.println();
            System.out.print("Если хотите остановиться введите любой символ и нажмите Ввод: ");


        }

    }

    private void printEmojiGameBoard(IslandLocationCell[][] islandLocationCells){
        for (int i = 0; i < islandLocationCells.length; i++) {
            for (int j = 0; j < islandLocationCells[i].length; j++) {
                System.out.print("Cell - " + i + "X" + j + " ");
                for (CopyOnWriteArrayList<FlorAndFauna> element: islandLocationCells[i][j].arraysCell) {
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
