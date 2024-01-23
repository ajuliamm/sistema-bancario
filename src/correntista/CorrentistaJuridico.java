package correntista;

import conta.ContaJuridica;

//classe filha ou subclasse
public class CorrentistaJuridico extends Correntista{

   
    private String nomeResponsavel; 

    public CorrentistaJuridico( String nome, String nomeResponsavel, ContaJuridica conta){
       //nesse caso que tem outro atributo além do enviado para a superclasse, o operador super precisa obrigatóriamente vir antes da atribuição do outro parâmetro. 
       //O super() sepre vem antes 
       super(nome, conta);
        this.nomeResponsavel = nomeResponsavel; 
    }    
    public void exibeIdentificacao() {
        System.out.println("Eu sou um correntista Jurídico " + getCodigo() + " - " + getNome());
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    
}