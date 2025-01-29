package DesignPatterns.Behavorial.Mediator.example2;
class Runway {
    private ATCMediator mediator;

    public Runway(ATCMediator mediator) {
        this.mediator = mediator;
        mediator.registerRunway(this);
    }

    public void ready() {
        System.out.println("Runway is ready.");
        mediator.setLandingStatus(false);
    }
}