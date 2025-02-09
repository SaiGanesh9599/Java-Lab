interface PaymentStrategy{   //interface for the payment strategy
    void pay(double amount);
}


class CreditCardPayment implements PaymentStrategy{    //payment strategy for the credit card,paypal,google pay 
    public void pay(double amount){
        system.out.println("paid"+amount+"using credit card");
    }
}

class PayPalPayment implements PaymentStrategy{
    public void pay(double amount){
        system.out.println("paid"+amount+"using paypal");
    }
}

class GooglePayPayment implents PaymentStrategy{
    public void pay(double amount){
        system.out.println("paid"+amount+"usinggooglepay");
    }
}

public class PaymentProcessor{     //payment process class that tells the processing of payment
    private PaymentStrategy paymentstrategy;
 //constructor to initilize the payment strategy
    public PaymentProcessor(PaymentStrategy paymentstrategy){
        this.paymentstrategy = paymentstrategy;

    }

    public void processpayment (double amount){   //method to process 
        paymentstrategy.pay(amount);
        }

}


public class PaymentSystem{  //main class to test the payment system
    public static void main(String[]args){
        Paymentprocessor CreditCardProcessor=new PaymentProcessor(new CreditCardPayment());
        CreditCardPayment.processpayment(100.0);

        Paymentprocessor PaypalProcessor=new PaymentProcessor(new PayPalPayment());
        PayPalPayment.processpayment(100.0);

        Paymentprocessor GooglePayProcessor=new PaymentProcessor(new GooglePayPayment());
        GooglePayPayment.processpayment(100.0);
    }
}