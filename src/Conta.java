
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public boolean sacar(double valor) {
		if (saldo - valor >= 0){
			saldo -= valor;
			return true;
		}
		else{
			System.out.println("Saldo insuficiente!");
			return false;
		}
    }

	@Override
	public void depositar(double valor) {
		if (valor > 0){
			saldo += valor;
		} else{
			System.out.println("Erro ao tentar depositar valor negativo!");
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (this.sacar(valor)){
			contaDestino.depositar(valor);
		}
		else{
			System.out.println("Saldo insuficente para transferência!");
		}


	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
