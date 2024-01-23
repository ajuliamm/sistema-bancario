package conta;

public class ContaFisica implements Conta {

    private double saldo = 0.0;

    //Taxa de juros aplicada 
    public static final double I = 0.03; 

    @Override
    public synchronized void extrato() {
        System.out.println("Saldo da conta física: " + saldo);
    }

    @Override
    public synchronized void deposito(double valor) {
       this.saldo += valor; 
       System.out.println("O valor depositado é " + valor);
    }

    @Override
    public synchronized void saque(double valor) {
        if(valor > this.saldo){
            System.out.println("Saldo insuficiente" );
        } else{
            
            this.saldo-=valor; 
            System.out.println("Valor sacado: " + valor);
        }
    }

    public double simulaEmprestimo(double cf, int n) throws IllegalArgumentException {
        
        // como estamos essa execeção dentro do método simulaEmprestimo temos que marcar utilizando a palavra throws para informar que esse método poderá devolver uma exceção do tipo IllegalArgumentException
        // ele poderá quando o n for mnor ou - a 0 ou cf for negativo ou zero.
        if(cf <=0 || n <= 0 ){

            throw new IllegalArgumentException(); 
        } else{

            //I = Taxa de juros
            //cf = capital financiado
            // n = meses
            return I/(1-1/Math.pow(1+I, n))*cf; 
        } 
    }; 

    
}



