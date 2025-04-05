
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		ContaPoupanca cp = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(120, cp);

		cp.imprimirExtrato();

	}

}
