public class TesteaContaComComparcao {

    public static void main(String[] args) {

        //Depositar com conta ativa
        Conta conta = new Conta();

        conta.ativar();
        conta.depositar(100);

        System.out.println();
        System.out.println("Deve depositar com conta ativa: ");
       if(conta.getSaldo()==100){
           System.out.println("Funcionou!");
       }else {
           System.out.println("Falhou");
       }

        //Depositar com conta inativa
        Conta conta2 = new Conta();

        conta2.inativar();
        conta2.depositar(100);

        System.out.println();
        System.out.println("Não deve depositar com conta ativa: ");
        if(conta2.getSaldo()==0){
            System.out.println("Funcionou!");
        }else {
            System.out.println("Falhou");
        }

    }

}
