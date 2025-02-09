class Employee{
    private String name;    //stores the name and salary of the employee
    private double salary;

       Employee(String name,double salary){  //constructor for the name and salary
           this.name=name;
           this.salary=salary;
       }

       public String getname(){
        return name;
       }

       public double getSalary(){
        return salary;
       }
}

class paySlipPrinter{  //for printing the slip of an employee
    public void printPaySlip(Employee employee){
        system.out.println("Employee: "+employee.getname()+",salary:$"+salary);
    }

}

interface EmployeeData{   //interface for the employee data storage
    void save(Employee employee);
}

class DatabaseEmployeeData implements EmployeeData{
    public void save(Employee employee){
        system.out,println("saving employee to data..");
    }
}

class FileEmployeeData implements EmployeeData{
    public void save(Employee employee){
        system.out,println("saving employee to file..");
    }
}


public class Main{   //main class to demonstrate the function
    public static void main(String[]args){
        Employee emp=new Employee("sai ganesh",100.0);
        
        
        paySlipPrinter printer=new PaySlipPrinter();
        printer.printPaySlip(emp);

        Employee database=new DatabaseEmployeeData();
        database.save(emp);

        Employee filestorage=new FileEmployeeData();
        filestorage.save(emp);
    }
}



