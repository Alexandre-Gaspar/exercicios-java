package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Employee;
import models.entities.OutsourceEmployee;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employee = new ArrayList<>();

        System.out.print("\nEnter the number of employees: ");
        int quantityOfEmployee = sc.nextInt();

        int count = 0;
        while (count < quantityOfEmployee) {
            ++count;
            System.out.println("Employee #" + count + " data: ");
            System.out.print("Outsourced (y/n)? ");
            char outsourced = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            if (outsourced == 'y' || outsourced == 'Y') {
                Double additionalCharge = sc.nextDouble();

                Employee emp = new OutsourceEmployee(name, hours, valuePerHour, additionalCharge);
                employee.add(emp);
            } else {
                

                Employee emp = new Employee(name, hours, valuePerHour);
                employee.add(emp);
            }
        }

        System.out.println("\nPAYMENTS:");
        for (Employee each : employee)
            System.out.println(each.getName() + " - $" + String.format("%.2f", each.payment()));

        sc.close();
    }
}
