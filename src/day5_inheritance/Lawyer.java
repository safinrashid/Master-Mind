package day5_inheritance;

public class Lawyer extends Employee{ //inheritance

    public Lawyer (int years){
        super(years);
    }

    @Override //not necessary, helps error,compile
    public String getVacationForm(){
        return "pink";
    }

    @Override //not necessary, helps error,compile
    public int getVacationDays(){
        return super.getVacationDays() + 5;
    }

    public void sue(){
        System.out.println("See u in court, loser!");
    }

}
