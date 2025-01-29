package DesignPatterns.Behavorial.Mediator.example2;

interface ATCMediator {
    void registerRunway(Runway runway);
    void registerFlight(Flight flight);
    boolean canLand(Flight flight);
    void setLandingStatus(boolean status);
}