import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.LinkedList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final var employees = new LinkedList<Employee>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Employees quantity: ");
        final var employeeQuantity = sc.nextInt();

        for (int i = 0; i < employeeQuantity; i++) {
            sc.nextLine();

            System.out.print("Is outsourced? (y/n) ");
            var isOutsourced = sc.nextLine().charAt(0);

            System.out.print("Name: ");
            var name = sc.nextLine();

            System.out.print("Hours: ");
            var hours = sc.nextInt();


            System.out.print("Value per hour: ");
            var valuePerHour = sc.nextDouble();

            if (isOutsourced == 'y') {
                System.out.print("Additional charge: ");
                var additionalCharge = sc.nextDouble();

                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
               employees.add(new Employee(name, hours, valuePerHour));
            }
        }

        employees.forEach(employee -> {
            System.out.printf("%s: %.2f %n",  employee.getName(), employee.getPayment());
        });

        sc.close();
    }
}
