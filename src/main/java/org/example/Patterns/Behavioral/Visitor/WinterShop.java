package org.example.Patterns.Behavioral.Visitor;

public class WinterShop implements Shop {
    @Override
    public void accept(Seller seller) {
        seller.sell(this);
    }
    public void WinterClothesSell(){
        System.out.println("Winter Clothes Sell");
    }
}
