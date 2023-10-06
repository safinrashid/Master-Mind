package day5_inheritance;

public class LegalSecretary extends Secretary{

    public LegalSecretary(int years){
        super(years);
    }

    public void writeBrief(){
        System.out.println("h");
    }

    @Override
    public double getSalary(){
        return super.getSalary() + 5000;
    }

    @Override
    int getVacationBonus(){
        return 0;
    }

}
