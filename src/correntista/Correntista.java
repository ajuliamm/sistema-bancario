package correntista;

import java.io.Serializable;

import conta.Conta;

//classe mãe ou superclasse
public abstract class Correntista implements Serializable{

    private static int proxCodigo = 1;

    private Conta conta; 

    private int codigo; 
    private String nome; 


    public Correntista( String nome, Conta conta){
        this.codigo = getProxCodigo();
        this.nome = nome;
        this.conta = conta;
    }
    public abstract void exibeIdentificacao();

    public static int getProxCodigo(){
        return proxCodigo++; 
    }

    public int getCodigo(){
        return codigo;
    }


    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome; 
    }
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
//A palavra reservada this referencia o parâmetro implícito de um método. 