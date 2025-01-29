package DesignPatterns.Behavorial.StrategyPatterns.example2;

public class Driver {
    public static void main(String[] args) {
        SortContext context = new SortContext();

        int[] data = {5, 2, 9, 1, 5, 6};

        context.setSortStrategy(new BubbleSort());
        context.executeSort(data);

        context.setSortStrategy(new QuickSort());
        context.executeSort(data);
    }
}
