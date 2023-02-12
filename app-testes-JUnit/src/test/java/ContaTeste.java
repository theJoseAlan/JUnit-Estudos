import org.junit.jupiter.api.*;

public class ContaTeste {

    private Conta conta;

    private static double depositoInicial;
    private static double saqueValido;
    private static double saqueInvalido;
    private static double saldoZerado;

    @BeforeAll //Para ser executado antes de tudo. Assim ele põe os valores padrão para testes
    public static void definirValoresPadrao(){

        saldoZerado = 0;
        depositoInicial = 100;
        saqueValido = 70;
        saqueInvalido = 110;

    }

    //Isso facilita melhor o entendimento e evita códigos repetidos demais
    //A conta já inicializa e ativa
    @BeforeEach //Executa ante de cada método de teste. Se não colocar a conta não vai ser inicializada
    //nem ativada, e essas condições são necessárias para os casos de teste
    public void inicializarConta(){
        conta = new Conta();

        conta.ativar();
    }

    @Test //Para informar que vou testar esse método
    /*
      No @DisplayName, põe o nome que aparecerá no 'display' referente aquele método
      Muito importante para relatórios e melhor compreenção da função do método
     */
    @DisplayName("Deve Depositar Com Conta Ativa")
    public void deveDepositarComContaAtiva(){

        conta.depositar(depositoInicial);

        //Verifica se o depositar retorna true. Ele é um booleano na classe Conta da main
        //Assertions.assertTrue(conta.depositar(depositoInicial));

        //Como depositei 100, o valor esperado e o valor obtido devem ser iguais.
        //Se mudar o valor esperado para algo diferente do depósito o teste não passa

        //O primeiro valor é o esperado, o segundo é o obtido após o teste
        Assertions.assertEquals(depositoInicial, conta.getSaldo());

    }

    @Test
    @DisplayName("Não Deve Depositar Com Conta Inativa")
    public void naoDeveDepositarComContaInativa(){

        conta.inativar();

        Assertions.assertThrows(RuntimeException.class, () -> conta.depositar(depositoInicial));

        //Verifica se o depositar retorna false. Ele é um booleano na classe Conta da main
        //Assertions.assertFalse(conta.depositar(depositoInicial));

        //Como depositei 100, o valor esperado e o valor obtido devem ser iguais.
        //Se mudar o valor esperado para algo diferente do depósito o teste não passa

        //O primeiro valor é o esperado, o segundo é o obtido após o teste
        Assertions.assertEquals(saldoZerado , conta.getSaldo());
    }

    @Test
    @DisplayName("Deve Sacar Com Conta Ativa e Saldo Maior que o valor de Saque")
    public void NaoSacarComContaAtivaeSaldoMaiorqueoValordeSaque(){

        conta.depositar(depositoInicial);

        conta.sacar(saqueValido);

        Assertions.assertEquals(depositoInicial-saqueValido, conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar Com Conta Inativa")
    public void NaoDeveSacarComContaInativa(){

        conta.depositar(depositoInicial);
        conta.inativar();

        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(saqueValido));

        Assertions.assertEquals(depositoInicial, conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar Com Conta Ativa e Saldo Menor que o valor de Saque")
    public void NaoDeveSacarComContaAtivaeSaldoMenorqueoValordeSaque(){

        conta.depositar(depositoInicial);

        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(saqueInvalido));

        //No valor esperado se pôr 100, funciona porque não permitiu o saque de um valor maior do que o que há
        //na conta. Se pôr 110, por exemplo, e passar tem algo de errado com o método
        Assertions.assertEquals(depositoInicial, conta.getSaldo());
    }

}
