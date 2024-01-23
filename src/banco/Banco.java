package banco;

import correntista.CorrentistaFisico;
import correntista.CorrentistaJuridico;
import correntista.Correntista;
import java.util.ArrayList;

import conta.ContaFisica;
import conta.ContaJuridica; 
import java.util.Iterator; 
import java.io.*;

public class Banco {

    private ArrayList<Correntista> listDeClientes ;

    public Banco() {
        listDeClientes = new ArrayList<Correntista>();
    }
    


    public void salvaClientela() throws IOException{ //dessa forma eu lançarei a exceção para ser tratada em outro ponto do código.  
        //baseado no acesso em camadas preciso passar um file no FileOutputStream e um objeto FileOutputStream no ObjectOutputStream
        File file = new File("database.dat");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(Correntista c : listDeClientes){
            oos.writeObject(c);//persiste cliente no arquivo clientes.dat
        }

        oos.close(); 

    }

    public void leClientela() throws IOException, ClassNotFoundException {
        File file = new File("database.dat");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
    
        Object obj = null; 
        //Lê objetos um a um 
        try {
            while ((obj = ois.readObject()) != null) {
                this.listDeClientes.add( (Correntista)obj ); //typecasting
            }
            
        } catch (EOFException e) {
            // TODO: handle exception
        } finally {
            ois.close();
        }

    }

    public ArrayList<Correntista> getListDeClientes() {
        return listDeClientes;
    }



    public void setListDeClientes(ArrayList<Correntista> listDeClientes) {
        this.listDeClientes = new  ArrayList<>(listDeClientes);
    }
    public static void main(String args[]){

        Banco banco = new Banco();  
        
        ContaFisica conta = new ContaFisica();
        conta.deposito(1000);

        CorrentistaFisico joao = new CorrentistaFisico("João", conta);
        CorrentistaFisico maria = new CorrentistaFisico("Maria", conta);

        SaqueATM saqueJoao = new SaqueATM(joao.getConta(), 500);
        SaqueATM saqueMaria = new SaqueATM(maria.getConta(), 300);

        saqueJoao.start();
        saqueMaria.start();
        
        // CorrentistaFisico c1 = new CorrentistaFisico("Angelina", new ContaFisica());
        // banco.getListDeClientes().add(c1); 
        
        // CorrentistaFisico c2 = new CorrentistaFisico("Ranieri", new ContaFisica());
        // banco.getListDeClientes().add(c2); 
        // CorrentistaFisico c3 = new CorrentistaFisico("Liana", new ContaFisica());
        // banco.getListDeClientes().add(c3); 

        // CorrentistaJuridico c4 = new CorrentistaJuridico("ACME LLC", "Pedro" , new ContaJuridica());
        // banco.getListDeClientes().add(c4); 

        // // try {
        // //     banco.salvaClientela();
        // // } catch (IOException e) {
        // //     // TODO: handle exception
        // // }

        // try {
        //     banco.leClientela();

        //     for(Correntista c : banco.getListDeClientes()){
        //         System.out.println("->" + c.getNome());
        //     }
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }

        // Iterator<Correntista> it = listDeClientes.iterator(); 
        // while(it.hasNext()){//enquanto houver elemento a ser percorrido
        //     System.out.println(it.next().getNome());
        // }

        //como correntistaFisico e Juridico são do tipo Correntista por herança então eles podem ser add na lista. 
        // System.out.println(c1.getCodigo()+ " - " + c1.getNome());
        // System.out.println(c2.getCodigo()+ " - " + c2.getNome());
        // System.out.println(c3.getCodigo()+ " - " + c3.getNome());
        // System.out.println(listDeClientes);

        // c1.exibeIdentificacao();
        // c2.exibeIdentificacao();
        // c3.exibeIdentificacao();
        // c4.exibeIdentificacao();

        // try {

        //     double valorParcela = c1.getConta().simulaEmprestimo((1000.0), 12);
    
        //     System.out.println(valorParcela);
        // } catch(IllegalArgumentException e){
        //     System.out.println("Digite valores válidos");
        // }



        // File meuArquivo = new File("ex.txt");
        
        // try{
            
        //     BufferedWriter writer = new BufferedWriter(new FileWriter(meuArquivo, true)); 
            
        //     writer.write("\nAté logo");

        //     writer.close();
        // } catch(Exception e) {//posso sempre usar o Exception pois todas as ec=xceções herdam do Exception, garantindo que o catch irá apanhar qualquer exceção.
        
        // }
        
        // try{
        //     BufferedReader reader = new BufferedReader(new FileReader(meuArquivo)); 
            
        //     String s = "";
        //     while((s = reader.readLine()) != null) {

        //         System.out.println(s);
        //     }
        //     reader.close();
            
        // } catch(Exception e) {//posso sempre usar o Exception pois todas as ec=xceções herdam do Exception, garantindo que o catch irá apanhar qualquer exceção.
    
        // }
    }



  



    

}
