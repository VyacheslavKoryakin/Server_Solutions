package org.example.Patterns.Behavioral.Visitor;

public class ShopSeller implements Seller {

    @Override
    public void sell(WinterShop winterShop) {
        System.out.println("I am work in a winter shop");
        winterShop.WinterClothesSell();
    }

    @Override
    public void sell(SummerShop summerShop) {
        System.out.println("I am work in a summer shop");
        summerShop.SummerClothesSell();

    }
}
