import entites.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        List<Employee> list = new ArrayList<>();
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Emplyoee # " + (i + 1) + ":");
            System.out.print("id: ");
            Integer id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();
        Integer pos = position(list, idSalary);
        if (pos == null){
            System.out.println("This id does not exist! ");
        }
        else {
            System.out.print("enter the percentage: ");
            double percent = sc.nextDouble();
            list.get(pos).increanseSalary(percent);
        }

        System.out.println("List of employees: ");
        for (Employee emp : list){
            System.out.println(emp);
        }
        sc.close();
    }

    public static Integer position(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}