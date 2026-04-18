import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {

    static ArrayList<ArrayList<String>> employeesList = new ArrayList<>();   // Global list that stores all people
    static double SalarioFixo = 2000.00;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        String input;

        do {
            System.out.println("Payroll system menu:");
            System.out.println(" [1] to register a standard employee.\n" +
                    " [2] to register a commissioned employee.\n" +
                    " [3] to register a production employee.\n" +
                    " [4] to print the payroll sheet.\n" +
                    " [0] to terminate the program.");
            System.out.print("please enter the code of the desired option: ");
            input = sc.nextLine();

            System.out.println("You entered: " + input);

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
                    PrintList();
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (!input.equals("0"));

    }

    public static void PrintList() {
        for (ArrayList<String> employee : employeesList) {   // Print all data

            String employeesListClasify = employee.get(0);

            if (employeesListClasify.equals("Funcionário Padrão")){
                System.out.println("----------------------");
                System.out.println("employee:");
                System.out.println("employee Type: " + employee.get(0));
                System.out.println("Nome: " + employee.get(1));
                System.out.println("Matrícula: " + employee.get(2));
                System.out.println("Salário Fixo: " + employee.get(3));
                System.out.println("Extras: " + employee.get(4));
                System.out.println("Salário final: " + employee.get(5));
                System.out.println("----------------------");

            } else if (employeesListClasify.equals("Funcionário Comissionado")) {
                
            }
        }
    }

    public static void employee1(){

        System.out.print("Enter the employee’s name: ");
        String nomeEmployee = sc.nextLine();

        System.out.print("Enter the employee’s ID number (registration number): ");
        String IdEmployee = sc.nextLine();

        ArrayList<String> employee = new ArrayList<>();  // First person (inner list)
        employee.add("Funcionário Padrão");
        employee.add(nomeEmployee);
        employee.add(IdEmployee);
        employee.add(Double.toString(SalarioFixo));
        employee.add("N/A");
        employee.add(Double.toString(SalarioFixo));

        employeesList.add(employee);    // Add inner lists into the global list
    }
//------------------------------------------------
    public static void employee2(){

    }
//------------------------------------------------
    public static void employee3(){

    }
//------------------------------------------------
}
