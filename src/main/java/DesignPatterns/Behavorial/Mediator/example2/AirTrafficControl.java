package DesignPatterns.Behavorial.Mediator.example2;

import java.util.ArrayList;
import java.util.List;

// Concrete Mediator
class AirTrafficControl implements ATCMediator {
    private List<Runway> runways = new ArrayList<>();
    private List<Flight> flights = new ArrayList<>();
    private boolean landingStatus;

    @Override
    public void registerRunway(Runway runway) {
        runways.add(runway);
    }

    @Override
    public void registerFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public boolean canLand(Flight flight) {
        return !landingStatus;
    }

    @Override
    public void setLandingStatus(boolean status) {
        this.landingStatus = status;
    }
}