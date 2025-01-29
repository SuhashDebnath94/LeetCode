package DesignPatterns.Behavorial.Mediator.example2;

public class Driver {
    public static void main(String[] args) {
        ATCMediator mediator = new AirTrafficControl();

        Runway runway = new Runway(mediator);
        Flight flight = new PassengerFlight(mediator);

        flight.requestLanding();
        runway.ready();
        flight.requestLanding();
    }
}
