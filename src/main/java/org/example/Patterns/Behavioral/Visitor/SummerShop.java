package org.example.Patterns.Behavioral.Visitor;

public class SummerShop implements Shop{
    @Override
    public void accept(Seller seller) {
        seller.sell(this);
    }
    public void SummerClothesSell(){
        System.out.println("Summer Clothes Sell");
    }
}
