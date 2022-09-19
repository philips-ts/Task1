package com.tarasenko.gof_patterns.structutal;


class Billing{
    public void createBill(){}
    public void processBill(){}
    public void closeBill(){}
}

class Shipping{
    public void createShipping(){}
    public void sendGoods(){}
}

class CallService{
    public void call(){}
}





class OrderService {
    public void createOrder(){
        Billing billing = new Billing();
        Shipping shipping = new Shipping();
        CallService  callService = new CallService();
        callService.call();
        billing.createBill();
        billing.processBill();
        billing.closeBill();
        shipping.createShipping();
        shipping.sendGoods();
    }
}


public class Facade {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.createOrder();
    }
}
