package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private double baseSalary;

    // Only one department
    private Department department;

    // Many contracts, so List of type HourContract
    // No constructor for it, so instantiate an empty List;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

//    public void setContracts(List<HourContract> contracts) {
//        this.contracts = contracts;
//    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public double income(int year, int month) {

        Calendar cal = Calendar.getInstance();
        double sum = baseSalary;

        for(HourContract c : contracts) {

            cal.setTime(c.getDate());
            int cYear = cal.get(Calendar.YEAR);
            int cMonth = 1 + cal.get(Calendar.MONTH); // +1 because months start counting at 0

            if(cYear == year && cMonth == month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }


}
