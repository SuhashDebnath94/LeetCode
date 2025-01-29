package DesignPatterns.Behavorial.StrategyPatterns.example2;

// Context Class
class SortContext {
    private SortStrategy strategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(int[] numbers) {
        if (strategy == null) {
            System.out.println("No sorting strategy selected.");
            return;
        }
        strategy.sort(numbers);
    }
}
