package day5_inheritance;

public class Secretary extends Employee {

    public Secretary(int years){
        super(years);
    }

    public void takeDictation(){
        System.out.println("Dictate to me");
    }

}
