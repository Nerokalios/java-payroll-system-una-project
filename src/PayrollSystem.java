import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {

    static ArrayList<ArrayList<String>> employeesList = new ArrayList<>();

    // ordem dos itens na lista global
    // (0) tipo de empregado
    // (1) nome
    // (2) matrícula
    // (3) salário fixo
    // (4) extra
    // (5) comissão
    // (6) produtividade
    // (7) salário final

    static double salarioFixo = 2000.00;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        String input;

        do {
            System.out.println("\nPayroll system menu:");
            System.out.println(" [1] Register standard employee");
            System.out.println(" [2] Register commissioned employee");
            System.out.println(" [3] Register production employee");
            System.out.println(" [4] Print payroll");
            System.out.println(" [0] Exit");

            System.out.print("Enter option: ");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    employee1();
                    break;
                case "2":
                    employee2();
                    break;
                case "3":
                    employee3();
                    break;
                case "4":
                    printList();
                    break;
                case "0":
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (!input.equals("0"));
    }

    public static void printList() {
        for (ArrayList<String> employee : employeesList) {

            String type = employee.get(0);

            System.out.println("----------------------");
            System.out.println("Employee Type: " + employee.get(0));
            System.out.println("Name: " + employee.get(1));
            System.out.println("ID: " + employee.get(2));
            System.out.println("Base Salary: " + employee.get(3));

            if (type.equals("Funcionário Padrão")) {
                System.out.println("Extras: " + employee.get(4));
            } else if (type.equals("Funcionário Produção")) {
                System.out.println("Productivity Bonus: " + employee.get(6));
            }

            System.out.println("Final Salary: " + employee.get(7));
            System.out.println("----------------------");
        }
    }

    public static void employee1(){
        System.out.println("Not implemented yet.");
    }

    public static void employee2(){
        System.out.println("Not implemented yet.");
    }

    public static void employee3(){
        System.out.print("Enter the employee’s name: ");
        String nomeEmployee = sc.nextLine();

        System.out.print("Enter the employee’s ID: ");
        String idEmployee = sc.nextLine();

        System.out.print("Enter the quantity of pieces produced: ");
        int piecesProduced = sc.nextInt();

        System.out.print("Enter the value of each piece: ");
        double pieceValue = sc.nextDouble();
        sc.nextLine();

        double bonus = pieceValue * piecesProduced;
        double finalSalary = salarioFixo + bonus;

        ArrayList<String> employee = new ArrayList<>();
        employee.add("Funcionário Produção"); // (0)
        employee.add(nomeEmployee);           // (1)
        employee.add(idEmployee);             // (2)
        employee.add(Double.toString(salarioFixo)); // (3)
        employee.add("N/A");                  // (4)
        employee.add("N/A");                  // (5)
        employee.add(Double.toString(bonus)); // (6)
        employee.add(Double.toString(finalSalary)); // (7)

        employeesList.add(employee);
    }
}