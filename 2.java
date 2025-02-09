class bird{  //class with incorrect implementation
    void fly(){
        system.out.println("Flying");
    }
}

class penguin extends Bird{
    //penguins can't fly!
}



//it follows Lsp
//by using interface for birds


interface Bird{  //interface for birds
    void makeSound();
}

interface FlyingBird extends Bird{   
   public void fly();
}

interface Eat extends Bird{
    public void eat();
}

class Sparrow implements FlyingBird{
    public void fly(){
        system.out.println("Flying");
    }
    public void makeSound(){
        system.out.println("hook hook");
    }
}

class Penguin implements Bird{
    public void makeSound(){
        system.out.println("hook hook");
    }
}

class Vulture implements Bird{
   public void eat(){
    system.out.println("eat animals");
   }
}


public class Main{    //main method to demonstrate the function
    public static void main(String[] args){
        FlyingBird sparrow=new Sparrow();
        sparrow.fly();
        sparrow.makeSound();
  
        Bird Penguin=new Penguin();
        Penguin.makeSound(); 

        Bird vulture=new Vulture();
        vulture.eat();
    }
}