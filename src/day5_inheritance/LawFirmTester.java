package day5_inheritance;

public class LawFirmTester {
    public static void main(String[] args){
        Employee e1 = new Employee(10);
        System.out.println(e1.getSalary());

        Lawyer l1 = new Lawyer(4);
        System.out.println(l1.getVacationForm());
        System.out.println(l1.getVacationDays());

        Employee e2 = new Lawyer(0);

        LegalSecretary ls1 = new LegalSecretary(12);
        System.out.println(ls1.getSalary());
        System.out.println(ls1.getVacationDays());

        Employee e3 = new Employee(10);
        System.out.println(Employee.numOfEmployees); //static

    }

}
