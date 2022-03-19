package emailapp;
import java.util.*;
public class EmailApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // informação do usuario
        System.out.println("Entre com o primeiro nome: ");
        String primeiro_nome = sc.next();
        System.out.println("Entre com o sobrenome: ");
        String sobre_nome = sc.next();

        //Criando um funcionário (ou seja, um objeto da classe Endereço eletrónico)
        Email email = new Email(primeiro_nome, sobre_nome);
        int escolha = -1;
        do {
            System.out.println("""
                    *****
                    Entre com sua escolha
                    1.Mostrar informação
                    2.Mudar senha
                    3.Mudar a capacidade da caixa postal
                    4.Definir alteração do email
                    5.Armazenar dados no arquivo
                    6.Mostrar arquivo
                    7.Sair""");
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    email.obterInformacao();
                    break;
                case 2:
                    email.configurar_senha();
                    break;
                case 3:
                    email.definirCapacidadeEmail();
                    break;
                case 4:
                    email.emailAlternativo();
                    break;
                case 5:
                    email.armazenarArquivo();
                    break;
                case 6:
                    email.lerArquivo();
                    break;
                case 7:
                    System.out.println("\nObrigado!!!");
                    break;
                default:
                    System.out.println("Ecolha inválida! Entre novamente! ");
            }

        } while (escolha != 7 );

    }
}
