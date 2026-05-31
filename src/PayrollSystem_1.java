import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem_1 {

    static ArrayList<ArrayList<String>> employeesList = new ArrayList<>();
    static double salarioFixo = 2000.00;
    static Scanner sc = new Scanner(System.in);

    static void main(){
        String input;

        do {
            System.out.println("\nMenu do sistema de folha de pagamento:");
            System.out.println(" [1] Cadastrar funcionário padrão");
            System.out.println(" [2] Cadastrar funcionário comissionado");
            System.out.println(" [3] Cadastrar funcionário de produção");
            System.out.println(" [4] Imprimir folha de pagamento");
            System.out.println(" [0] Sair");

            System.out.print("Digite uma opção: ");
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
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (!input.equals("0"));
    }

    public static void printList() {
        for (ArrayList<String> employee : employeesList) {
            String type = employee.get(0);

            System.out.println("\n----------------------");
            System.out.println("Tipo de funcionário: " + employee.get(0));
            System.out.println("Nome: " + employee.get(1));
            System.out.println("Matrícula: " + employee.get(2));
            System.out.println("Salário base: " + employee.get(3));

            // exibir info adicional de acordo com o tipo de funcionário
            if (type.equals("Funcionário Padrão")) {
                System.out.println("Extras: " + employee.get(4));
            } else if (type.equals("Funcionário Produção")) {
                System.out.println("Bônus de produtividade: " + employee.get(6));
            }

            System.out.println("Salário final: " + employee.get(7));
            System.out.println("----------------------");
        }
    }

    public static void employee1(){
        System.out.println("\nAinda não implementado.");
    }

    public static void employee2() {
        System.out.print("\nDigite o nome do funcionário: ");
        String nomeEmployee = sc.nextLine();

        System.out.print("Digite a matrícula do funcionário: ");
        String idEmployee = sc.nextLine();

        System.out.print("Digite o valor das vendas: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Valor inválido. Digite o valor das vendas: ");
            sc.next();
        }
        double sales = sc.nextDouble();

        System.out.print("Digite o percentual de comissão: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Valor inválido. Digite o percentual de comissão: ");
            sc.next();
        }
        double commissionPercent = sc.nextDouble();
        sc.nextLine();

        double commission = sales * (commissionPercent / 100);
        double finalSalary = salarioFixo + commission;

        ArrayList<String> employee = new ArrayList<>();
        employee.add("Funcionário Comissionado");
        employee.add(nomeEmployee);
        employee.add(idEmployee);
        employee.add(Double.toString(salarioFixo));
        employee.add("N/A");
        employee.add(Double.toString(commission));
        employee.add("N/A");
        employee.add(Double.toString(finalSalary));

        employeesList.add(employee);
        System.out.print("Cadastrado!\n");
    }

    public static void employee3(){
        System.out.print("\nDigite o nome do funcionário: ");
        String nomeEmployee = sc.nextLine();

        System.out.print("Digite a matrícula do funcionário: ");
        String idEmployee = sc.nextLine();

        System.out.print("Digite a quantidade de peças produzidas: ");
        while (!sc.hasNextInt()) {
            System.out.print("Valor inválido. Digite a quantidade de peças produzidas: ");
            sc.next();
        }
        int piecesProduced = sc.nextInt();

        System.out.print("Digite o valor de cada peça: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Valor inválido. Digite o valor de cada peça: ");
            sc.next();
        }
        double pieceValue = sc.nextDouble();
        sc.nextLine();

        double bonus = pieceValue * piecesProduced;
        double finalSalary = salarioFixo + bonus;

        ArrayList<String> employee = new ArrayList<>();
        employee.add("Funcionário Produção");
        employee.add(nomeEmployee);
        employee.add(idEmployee);
        employee.add(Double.toString(salarioFixo));
        employee.add("N/A");
        employee.add("N/A");
        employee.add(Double.toString(bonus));
        employee.add(Double.toString(finalSalary));

        employeesList.add(employee);
        System.out.print("Cadastrado!\n");
    }
}

///HOLA ISIS KKK
// HOLA 

