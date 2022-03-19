package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
public class Email {
    public Scanner sc = new Scanner(System.in); // classse Scanner
    // sendo a vaiariavel como privada não dar para iniciar diretamente

    private String primeiroNome;
    private String sobreNome;
    private String dept;
    private String email;
    private String password;
    private int  mailCapacidade = 500;
    private String alterarEmail;

    // construtor para receber primeiro nome, sobrenome
    public Email (String primeiroNome, String sobreNome) {
        this.primeiroNome = primeiroNome;
        this.sobreNome = sobreNome;
        System.out.println("Novo nome empregado: " + this.primeiroNome + " " + this.sobreNome );

    // Chamando métodos
    //esse método foi criado depois do método exibido informações do funcionario
    this.dept = this.definirDepartamento(); //Departamento
    this.password = this.gerarSenha(8); //senha
    this.email = this.gerarEmail();//Endereço eletrónico gerado

    }
    //Método de gerar endereço eletrónico
    private String gerarEmail() {
        return  this.primeiroNome.toLowerCase()+"."+this.sobreNome.toLowerCase() + "@" + this.dept.toLowerCase()
                + ".company.com";
    }
    //Pedido por departamento
    private String definirDepartamento() {
        System.out.println("""
                Codigos do Departamento:\s
                1 Para vendas\s
                2 Para Desenvolvimento\s
                3 Para Contabilidade\s
                0 Para nulo""");
        boolean bandeira = false;
        do {
            System.out.println("Entre com o codigo do Departamento");
            int escolher = sc.nextInt();
            switch (escolher) {
                case 1:
                    return "Vendas";
                case 2:
                    return "Desenvolvimento";
                case 3:
                    return "Contabilidade";
                case 0:
                    return " Nenhum";
                default:
                    System.out.println("**Escolha Iválida**");
            }
        } while (!bandeira);
        return null;
    }
    //Gerando senha Aleatoria
    private String gerarSenha(int comprimento) {
        Random r = new Random();
        String grandesCaracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String pequenosCaracteres = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolos = "!@#$%&?";
        String valores = grandesCaracteres + pequenosCaracteres + numeros + simbolos;

        String senha = "";
        for (int i = 0; i < comprimento; i++) {
            senha = senha + valores.charAt(r.nextInt(valores.length()));
        }
        return senha;
    }
    // alterar senha
    public void configurar_senha () {
        boolean bandeira = false;
        do {
            System.out.print("Tem certeza que quer mudar sua senha? (s/n) : ");
            char escolha = sc.next().charAt(0);
            if (escolha == 'S' || escolha == 's') {
                bandeira = true;
                System.out.print("Digite a senha atual: ");
                String atual = sc.next();
                if (atual.equals(this.password)) {
                    System.out.print("Digite uma nova senha: ");
                    this.password = sc.next();
                    System.out.println("SENHA ALTERADA COM SUCESSO! ");
                }
                else {
                    System.out.println("Senha Incorreta! ");
                }
            } else if (escolha == 'N' || escolha == 'n') {
                bandeira = true;
                System.out.println("MUDANÇA DE SENHA CANCELADA!");
            }
            else {
                System.out.println("**DIGITE UMA ESCOLHA VÁLIDA**");
            }
        } while (bandeira);
    }
    //Defina a capacidade da caixa de correio
    public void definirCapacidadeEmail () {
        System.out.println("Capacidade atual = " + this.mailCapacidade + "mb");
        System.out.print("Insira a nova capacidade: ");
        this.mailCapacidade = sc.nextInt();
        System.out.println("CAPACIDADE DA CAIXA DE CORREIO ALTERADA COM SUCESSO!\n");
    }
    // Definir o email alternativo
    public void emailAlternativo () {
        System.out.println("Entre com o novo email: ");
        this.alterarEmail = sc.next();
        System.out.println("E-MAIL ALTERNATIVO CONFIGURADO COM SUCESSO!");
    }
    //Exibindo as informações do funcionário
    public void obterInformacao () {
        System.out.println("Nome: " + this.primeiroNome + " " + this.sobreNome);
        System.out.println("Departamento: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Senha: " + this.password);
        System.out.println("Capacidade da caixa postal: " + this.mailCapacidade + "mb");
        System.out.println("Alterar email: " + this.alterarEmail);
    }
    //Armazenar arquivo

    public void armazenarArquivo () {
        try {
            FileWriter in = new FileWriter("C:\\Users\\AndréIsaNeusa\\Documents\\Java Programação orientado a objetos\\Meus Projetos java\\Projetos 1 Sistema de  administração de email\\src\\emailapp\\info.txt");
            in.write("Primeiro nome: " + this.primeiroNome);
            in.append("\nSobrenome: " + this.sobreNome);
            in.append("\nEmail: " + this.email);
            in.append("\nSenha: " + this.password);
            in.append("\nCapacidade: " + this.mailCapacidade);
            in.append("\nEmail alternativo: " + this.alterarEmail);
            in.close();
            System.out.println("Bancos de Dados");

        }catch (Exception e) {
            System.out.println(e);
        }
    }
    //Método de leitura de aquivo
    public void lerArquivo () {
        try {
            FileReader f1 = new FileReader("C:\\Users\\AndréIsaNeusa\\Documents\\Java Programação orientado a objetos\\Meus Projetos java\\Projetos 1 Sistema de  administração de email\\src\\emailapp\\info.txt");
            int i;
            while ((i = f1.read()) != -1) {
                System.out.println((char) i);
            }
            f1.close();
        } catch (Exception e) {System.out.println(e);}
    }
}
