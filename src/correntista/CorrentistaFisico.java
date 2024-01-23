package correntista;


import conta.ContaFisica;

//classe filha ou subclasse
public class CorrentistaFisico  extends Correntista{

    public CorrentistaFisico( String nome, ContaFisica conta){
        //Dentro do construtor da classe filha devo fazer uma chmada para o construtor da classe mãe. 
        //A chamada de qualquer método de uma classe mãe é realizada através do perador super
        //super(<Nome do parametro que quero passar para a classe mãe>)
        super(nome,  conta);
        
    }
    public void exibeIdentificacao() {
        System.out.println("Eu sou um correntista físico " + getCodigo() + " - " + getNome());
    }
    
}

