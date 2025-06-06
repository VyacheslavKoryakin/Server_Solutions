package org.example.Patterns.FactoryMethod;

public class Main {
    private static Dialog dialog;
    static void selectDelivery(String deliveryPlane) {
        if(deliveryPlane.equals("sea")){
            dialog = new ShipDialog();
        } else if (deliveryPlane.equals("road")) {
            dialog = new TruckDialog();
        }else{
            System.out.println("Invalid deliveryPlane");
        }
    }
    static Transport runDeliveryLogistics(){
        return dialog.renderTransport();
    }

    public static void main(String[] args) {
        Transport transport;
        selectDelivery("road");
        transport =  runDeliveryLogistics();
        transport.delivery();
    }

}
