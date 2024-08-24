package Com.MedicalAgency;

import Com.MedicalAgency.Entity.Doctor;
import Com.MedicalAgency.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static List<String> consultasAgendadas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Etapa 1: Perguntar o nome do usuário
        System.out.println("Seja bem-vindo!");
        System.out.print("Por favor, digite seu nome: ");
        String nome = scanner.nextLine();

        // Criar objeto User
        User user = new User();
        user.setNome(nome);

        System.out.println("Seja bem-vindo, " + user.getNome() + "! Seu código é: #" + user.getRandomcode());

        // Menu principal
        while (true) {
            System.out.println("\nComo podemos lhe ajudar hoje?");
            System.out.println("1 - Agendar uma consulta presencial");
            System.out.println("2 - Agendar uma consulta online");
            System.out.println("3 - Conferir nossos planos");
            System.out.println("4 - Ver consultas agendadas");
            System.out.println("5 - Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    agendarConsulta(user, "presencial");
                    break;
                case 2:
                    agendarConsulta(user, "online");
                    break;
                case 3:
                    exibirPlanos();
                    break;
                case 4:
                    listarConsultas();
                    break;
                case 5:
                    System.out.println("Obrigado por utilizar nosso sistema. Até mais!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida, por favor, tente novamente.");
            }
        }
    }

    //
    public static void exibirPlanos() {
        System.out.println("\nEscolha um dos nossos planos:");
        System.out.println("1 - Plano Pessoal");
        System.out.println("2 - Plano Familiar");
        System.out.println("3 - Plano Maior Idade");
    }


    public static void agendarConsulta(User user, String tipoConsulta) {
        Scanner scanner = new Scanner(System.in);
        List<Doctor> doctors = listarMedicos();

        System.out.println("\nEscolha o seu médico profissional:");

        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + " - " + doctors.get(i));
        }

        int escolhaMedico = scanner.nextInt();

        if (escolhaMedico > 0 && escolhaMedico <= doctors.size()) {
            Doctor doctorEscolhido = doctors.get(escolhaMedico - 1);
            String consulta = "Consulta " + tipoConsulta + " com " + doctorEscolhido.getNome() + " (Especialidade: " + doctorEscolhido.getEspecialidade() + ") agendada para " + user.getNome() + " (Código: " + "#" + user.getRandomcode() + ")";
            consultasAgendadas.add(consulta);
            System.out.println(consulta);
        } else {
            System.out.println("Opção de médico inválida. Tente novamente.");
        }
    }

    // Lista de médicos com especialidades e skills
    public static List<Doctor> listarMedicos() {
        List<Doctor> doctors = new ArrayList<>();

        doctors.add(new Doctor("Dr. João", "Cardiologista"));
        doctors.add(new Doctor("Dra. Maria", "Dermatologista"));

        return doctors;
    }

    public static void listarConsultas() {
        if (consultasAgendadas.isEmpty()) {
            System.out.println("Nenhuma consulta foi agendada.");
        } else {
            System.out.println("\nConsultas agendadas:");
            for (String consulta : consultasAgendadas) {
                System.out.println(consulta);
            }
        }
    }
}
