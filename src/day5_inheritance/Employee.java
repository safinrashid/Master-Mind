package day5_inheritance;

public class Employee {
    double salary = 40000;
    int vacationDays = 10;
    int years;
    static int numOfEmployees = 0;

    public double getSalary(){
        return salary;
    }

    public String getVacationForm(){
        return "yellow";
    }

    //package protected
    int getVacationBonus(){
        return 2*years;
    }

    public int getVacationDays(){
        return vacationDays + getVacationBonus();
    }

    public Employee(int years){
        this.years = years;
        numOfEmployees++;
    }

}
