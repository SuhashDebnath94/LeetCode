package DesignPatterns.Behavorial.Mediator.example2;

// Concrete Colleague
class PassengerFlight implements Flight {
    private ATCMediator mediator;

    public PassengerFlight(ATCMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void land() {
        System.out.println("Flight is landing.");
        mediator.setLandingStatus(true);
    }

    @Override
    public void requestLanding() {
        if (mediator.canLand(this)) {
            System.out.println("Landing granted.");
            land();
        } else {
            System.out.println("Waiting for clearance.");
        }
    }
}