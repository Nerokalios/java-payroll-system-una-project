import java.util.ArrayList;
import java.util.Scanner;

public class FolhaDePagamentoFinal {

    static ArrayList<ArrayList<String>> listaFuncionarios = new ArrayList<>();
    static final double SALARIO_FIXO = 2000.00;
    static Scanner sc = new Scanner(System.in);

    // Índices de cada campo no ArrayList
    static final int IDX_TIPO          = 0;
    static final int IDX_NOME          = 1;
    static final int IDX_MATRICULA     = 2;
    static final int IDX_SALARIO_BASE  = 3;
    static final int IDX_EXTRA         = 4;
    static final int IDX_COMISSAO      = 5;
    static final int IDX_PRODUCAO      = 6;
    static final int IDX_SALARIO_FINAL = 7;

    public static void main(String[] args) {
        imprimirCabecalho();
        String opcao;

        do {
            int total = listaFuncionarios.size();
            String rodape = "";
            if (total > 0) {
                rodape = " (" + total + " cadastrado(s))";
            }

            System.out.println("\n── Menu ─────────────────────────────────");
            System.out.println(" [1] Cadastrar funcionário padrão");
            System.out.println(" [2] Cadastrar funcionário comissionado");
            System.out.println(" [3] Cadastrar funcionário de produção");
            System.out.println(" [4] Imprimir folha de pagamento" + rodape);
            System.out.println(" [5] Limpar folha de pagamento");
            System.out.println(" [0] Sair");
            System.out.println("─────────────────────────────────────────");

            System.out.print("▶ Digite uma opção: ");
            opcao = sc.nextLine();

            switch (opcao) {
                case "1": cadastrarPadrao();        break;
                case "2": cadastrarComissionado();  break;
                case "3": cadastrarProducao();      break;
                case "4": imprimirFolha();          break;
                case "5": limparFolha();            break;
                case "0":
                    System.out.println("\nPrograma encerrado.");
                    sc.close();
                    break;
                default:
                    System.out.println("  Opção inválida. Tente novamente.");
            }

        } while (!opcao.equals("0"));
    }

    static boolean matriculaJaCadastrada(String id) {
        for (ArrayList<String> funcionario : listaFuncionarios) {
            if (funcionario.get(IDX_MATRICULA).equals(id)) {
                return true;
            }
        }
        return false;
    }

    static double lerDouble(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.println("  Valor inválido. Digite um número.");
            sc.nextLine();
            System.out.print(prompt);
        }
        double valor = sc.nextDouble();
        sc.nextLine();

        while (valor < 0) {
            System.out.println("  Valor não pode ser negativo.");
            System.out.print(prompt);
            while (!sc.hasNextDouble()) {
                System.out.println("  Valor inválido. Digite um número.");
                sc.nextLine();
                System.out.print(prompt);
            }
            valor = sc.nextDouble();
            sc.nextLine();
        }

        return valor;
    }

    static int lerInt(String texto) {
        System.out.print(texto);
        while (!sc.hasNextInt()) {
            System.out.println("  Valor inválido. Digite um número inteiro.");
            sc.nextLine();
            System.out.print(texto);
        }
        int valor = sc.nextInt();
        sc.nextLine();

        while (valor < 0) {
            System.out.println("  Valor não pode ser negativo.");
            System.out.print(texto);
            while (!sc.hasNextInt()) {
                System.out.println("  Valor inválido. Digite um número inteiro.");
                sc.nextLine();
                System.out.print(texto);
            }
            valor = sc.nextInt();
            sc.nextLine();
        }

        return valor;
    }

    static void imprimirCabecalho() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE FOLHA DE PAGAMENTO      ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    static void limparFolha() {
        listaFuncionarios.clear();
        System.out.println("  ✔ Cadastros apagados com sucesso!");
    }

    // Percorre a lista e imprime os dados de cada funcionário
    static void imprimirFolha() {
        if (listaFuncionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  FOLHA DE PAGAMENTO  │ " + listaFuncionarios.size() + " funcionário(s)");
        System.out.println("══════════════════════════════════════════");

        for (ArrayList<String> funcionario : listaFuncionarios) {
            String tipo = funcionario.get(IDX_TIPO);

            System.out.println("\n  ● " + tipo);
            System.out.println("    Nome         : " + funcionario.get(IDX_NOME));
            System.out.println("    Matrícula    : " + funcionario.get(IDX_MATRICULA));
            System.out.println("    Salário base : R$ " + funcionario.get(IDX_SALARIO_BASE));

            if (tipo.equals("Funcionário Padrão")) {
                System.out.println("    Extras       : R$ " + funcionario.get(IDX_EXTRA));
            } else if (tipo.equals("Funcionário Comissionado")) {
                System.out.println("    Comissão     : R$ " + funcionario.get(IDX_COMISSAO));
            } else if (tipo.equals("Funcionário Produção")) {
                System.out.println("    Produtividade: R$ " + funcionario.get(IDX_PRODUCAO));
            }

            System.out.println("    Salário final: R$ " + funcionario.get(IDX_SALARIO_FINAL));
        }

        System.out.println("\n══════════════════════════════════════════");
    }

    static void cadastrarPadrao() {
        System.out.println("\n── Cadastro: Funcionário Padrão ─────────");

        System.out.print("  Nome      : ");
        String nome = sc.nextLine();

        System.out.print("  Matrícula : ");
        String id = sc.nextLine();

        if (matriculaJaCadastrada(id)) {
            System.out.println("  ✖ Matrícula já cadastrada. Operação cancelada.");
            return;
        }

        double extra = lerDouble("  Extras (R$): ");
        double salarioFinal = SALARIO_FIXO + extra;

        ArrayList<String> funcionario = new ArrayList<>();
        funcionario.add("Funcionário Padrão");
        funcionario.add(nome);
        funcionario.add(id);
        funcionario.add(Double.toString(SALARIO_FIXO));
        funcionario.add(Double.toString(extra));
        funcionario.add("N/A");
        funcionario.add("N/A");
        funcionario.add(Double.toString(salarioFinal));

        listaFuncionarios.add(funcionario);
        System.out.println("  ✔ Funcionário cadastrado com sucesso!");
    }

    static void cadastrarComissionado() {
        System.out.println("\n── Cadastro: Funcionário Comissionado ───");

        System.out.print("  Nome      : ");
        String nome = sc.nextLine();

        System.out.print("  Matrícula : ");
        String id = sc.nextLine();

        if (matriculaJaCadastrada(id)) {
            System.out.println("  ✖ Matrícula já cadastrada. Operação cancelada.");
            return;
        }

        double vendas = lerDouble("  Vendas (R$): ");
        double percentual = lerDouble("  Comissão (%): ");
        double comissao = vendas * (percentual / 100.0);
        double salarioFinal = SALARIO_FIXO + comissao;

        ArrayList<String> funcionario = new ArrayList<>();
        funcionario.add("Funcionário Comissionado");
        funcionario.add(nome);
        funcionario.add(id);
        funcionario.add(Double.toString(SALARIO_FIXO));
        funcionario.add("N/A");
        funcionario.add(Double.toString(comissao));
        funcionario.add("N/A");
        funcionario.add(Double.toString(salarioFinal));

        listaFuncionarios.add(funcionario);
        System.out.println("  ✔ Funcionário cadastrado com sucesso!");
    }

    static void cadastrarProducao() {
        System.out.println("\n── Cadastro: Funcionário de Produção ────");

        System.out.print("  Nome      : ");
        String nome = sc.nextLine();

        System.out.print("  Matrícula : ");
        String id = sc.nextLine();

        if (matriculaJaCadastrada(id)) {
            System.out.println("  ✖ Matrícula já cadastrada. Operação cancelada.");
            return;
        }

        int pecas = lerInt("  Peças produzidas: ");
        double valorPeca = lerDouble("  Valor por peça (R$): ");
        double bonus = valorPeca * pecas;
        double salarioFinal = SALARIO_FIXO + bonus;

        ArrayList<String> funcionario = new ArrayList<>();
        funcionario.add("Funcionário Produção");
        funcionario.add(nome);
        funcionario.add(id);
        funcionario.add(Double.toString(SALARIO_FIXO));
        funcionario.add("N/A");
        funcionario.add("N/A");
        funcionario.add(Double.toString(bonus));
        funcionario.add(Double.toString(salarioFinal));

        listaFuncionarios.add(funcionario);
        System.out.println("  ✔ Funcionário cadastrado com sucesso!");
    }
}