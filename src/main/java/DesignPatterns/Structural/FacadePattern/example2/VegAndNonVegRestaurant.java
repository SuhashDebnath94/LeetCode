package DesignPatterns.Structural.FacadePattern.example2;

public class VegAndNonVegRestaurant implements Hotel {

    public String getMenus()
    {
        return "Non VEg and VEg Menu:";
    }
}