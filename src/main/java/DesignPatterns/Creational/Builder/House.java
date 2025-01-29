package DesignPatterns.Creational.Builder;

class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasSwimmingPool;
    private boolean hasGarage;
    private boolean hasGarden;

    // Private constructor
    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarage = builder.hasGarage;
        this.hasGarden = builder.hasGarden;
    }

    @Override
    public String toString() {
        return "House [Foundation=" + foundation + ", Structure=" + structure +
                ", Roof=" + roof + ", SwimmingPool=" + hasSwimmingPool +
                ", Garage=" + hasGarage + ", Garden=" + hasGarden + "]";
    }

    static class HouseBuilder {
        private String foundation;
        private String structure;
        private String roof;
        private boolean hasSwimmingPool;
        private boolean hasGarage;
        private boolean hasGarden;

        public HouseBuilder(String foundation, String structure, String roof) {
            this.foundation = foundation;
            this.structure = structure;
            this.roof = roof;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}