package DesignPatterns.Structural.FacadePattern.example2;

public class Driver {
    public static void main (String[] args)
    {
        HotelKeeper keeper = new HotelKeeperImpl();

        String v = keeper.getVegMenu();
        String nv = keeper.getNonVegMenu();
        String both = keeper.getVegNonMenu();

        System.out.println("Veg menu: "+v);
        System.out.println("Non Veg menu: "+nv);
        System.out.println("Veg and Non menu: "+both);
    }
}
