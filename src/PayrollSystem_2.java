import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem_2 {

    static ArrayList<ArrayList<String>> employeesList = new ArrayList<>();
    static double salarioFixo = 2000.00;
    static Scanner sc = new Scanner(System.in);

    // índices do ArrayList de cada funcionário:
    // 0=tipo  1=nome  2=matrícula  3=salárioFixo  4=extra  5=comissão  6=produtividade  7=salárioFinal

    static void main() {
        printHeader();
        String input;

        do {
            int total = employeesList.size();
            String rodape = total > 0 ? " (" + total + " cadastrado(s))" : "";

            System.out.println("\n── Menu ─────────────────────────────────");
            System.out.println(" [1] Cadastrar funcionário padrão");
            System.out.println(" [2] Cadastrar funcionário comissionado");
            System.out.println(" [3] Cadastrar funcionário de produção");
            System.out.println(" [4] Imprimir folha de pagamento" + rodape);
            System.out.println(" [0] Sair");
            System.out.println("─────────────────────────────────────────");

            System.out.print("▶ Digite uma opção: ");
            input = sc.nextLine();

            switch (input) {
                case "1": employee1(); break;
                case "2": employee2(); break;
                case "3": employee3(); break;
                case "4": printList(); break;
                case "0": System.out.println("\nPrograma encerrado."); break;
                default:  System.out.println("Opção inválida.");
            }

        } while (!input.equals("0"));
    }

    static void printHeader() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE FOLHA DE PAGAMENTO      ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public static void printList() {
        if (employeesList.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  FOLHA DE PAGAMENTO  │ " + employeesList.size() + " funcionário(s)");
        System.out.println("══════════════════════════════════════════");

        for (ArrayList<String> employee : employeesList) {
            String type = employee.get(0);

            System.out.println("\n  ● " + type);
            System.out.println("    Nome        : " + employee.get(1));
            System.out.println("    Matrícula   : " + employee.get(2));
            System.out.println("    Salário base: R$ " + employee.get(3));

            // campo extra varia por tipo
            if (type.equals("Funcionário Padrão")) {
                System.out.println("    Extras      : R$ " + employee.get(4));
            } else if (type.equals("Funcionário Comissionado")) {
                System.out.println("    Comissão    : R$ " + employee.get(5));
            } else if (type.equals("Funcionário Produção")) {
                System.out.println("    Produtividade: R$ " + employee.get(6));
            }

            System.out.println("    Salário final: R$ " + employee.get(7));
        }

        System.out.println("\n══════════════════════════════════════════");
    }

    public static void employee1() {
        System.out.println("\nAinda não implementado.");
    }

    public static void employee2() {
        System.out.println("\n── Cadastro: Funcionário Comissionado ───");

        System.out.print("  Nome      : ");
        String nome = sc.nextLine();

        System.out.print("  Matrícula : ");
        String id = sc.nextLine();

        System.out.print("  Vendas (R$): ");
        while (!sc.hasNextDouble()) {
            System.out.print("  Valor inválido. Vendas (R$): ");
            sc.next();
        }
        double sales = sc.nextDouble();

        System.out.print("  Comissão (%): ");
        while (!sc.hasNextDouble()) {
            System.out.print("  Valor inválido. Comissão (%): ");
            sc.next();
        }
        double percent = sc.nextDouble();
        sc.nextLine();

        double commission = sales * (percent / 100);
        double finalSalary = salarioFixo + commission;

        ArrayList<String> employee = new ArrayList<>();
        employee.add("Funcionário Comissionado");
        employee.add(nome);
        employee.add(id);
        employee.add(Double.toString(salarioFixo));
        employee.add("N/A");
        employee.add(Double.toString(commission));
        employee.add("N/A");
        employee.add(Double.toString(finalSalary));

        employeesList.add(employee);
        System.out.println("  ✔ Funcionário cadastrado com sucesso!");
    }

    public static void employee3() {
        System.out.println("\n── Cadastro: Funcionário de Produção ────");

        System.out.print("  Nome      : ");
        String nome = sc.nextLine();

        System.out.print("  Matrícula : ");
        String id = sc.nextLine();

        System.out.print("  Peças produzidas: ");
        while (!sc.hasNextInt()) {
            System.out.print("  Valor inválido. Peças produzidas: ");
            sc.next();
        }
        int pieces = sc.nextInt();

        System.out.print("  Valor por peça (R$): ");
        while (!sc.hasNextDouble()) {
            System.out.print("  Valor inválido. Valor por peça (R$): ");
            sc.next();
        }
        double pieceValue = sc.nextDouble();
        sc.nextLine();

        double bonus = pieceValue * pieces;
        double finalSalary = salarioFixo + bonus;

        ArrayList<String> employee = new ArrayList<>();
        employee.add("Funcionário Produção");
        employee.add(nome);
        employee.add(id);
        employee.add(Double.toString(salarioFixo));
        employee.add("N/A");
        employee.add("N/A");
        employee.add(Double.toString(bonus));
        employee.add(Double.toString(finalSalary));

        employeesList.add(employee);
        System.out.println("  ✔ Funcionário cadastrado com sucesso!");
    }
}
