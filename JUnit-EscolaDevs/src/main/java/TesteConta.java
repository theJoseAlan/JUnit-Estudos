public class TesteConta {
    public static void main(String[] args) {


        //Depositar com conta ativa
        Conta conta = new Conta();

        conta.ativar();
        conta.depositar(100);

        System.out.println();
        System.out.println("Deve depositar com conta ativa");
        System.out.println("Saldo conta 1: "+conta.getSaldo());

        //Depositar com conta inativa
        Conta conta2 = new Conta();

        conta2.inativar();
        conta2.depositar(100);

        System.out.println();
        System.out.println("Não deve depositar com conta inativa");
        System.out.println("Saldo conta 2: "+conta2.getSaldo());

    }
}
