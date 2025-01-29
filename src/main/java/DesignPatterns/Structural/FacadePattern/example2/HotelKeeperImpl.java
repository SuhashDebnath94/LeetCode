package DesignPatterns.Structural.FacadePattern.example2;

public class HotelKeeperImpl implements HotelKeeper{
    public String getVegMenu()
    {
        VegRestaurant v = new VegRestaurant();
        return v.getMenus();
    }

    public String getNonVegMenu()
    {
        NonVegRestaurant v = new NonVegRestaurant();
        return v.getMenus();
    }

    public String getVegNonMenu()
    {
        VegAndNonVegRestaurant v=new VegAndNonVegRestaurant();
        return v.getMenus();
    }
}
