package org.example.Patterns.Behavioral.Visitor;

public class Main {
    public static void main(String[] args) {
        Seller seller = new ShopSeller();

        Shop[] shops = {new WinterShop(), new SummerShop()};
        for (Shop shop : shops) {
            shop.accept(seller);
        }
    }
}
