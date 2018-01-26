package br.edu.ifnmg.marketmanagement.aplicacao;

import java.util.Objects;

/**
 *
 * @author guilherme
 */
public abstract class Pessoa implements Entidade {
    private long id;
    private Endereco endereco;
    private String telefone;
    private String celular;
    private String email;

    public Pessoa(long id, Endereco endereco, String telefone, String email, String celular) {
        this.id = id;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.celular = celular;
    }   

    public Pessoa() {
        this.telefone = "";
        this.celular = "";
    }

    public String getCelular() {
        
            return celular;
        
       
    }

    public void setCelular(String celular) {
        this.celular = celular;
        
    }
    
  
    @Override
    public long getId(){
        return id;
    }
    
    @Override
    public void setId(long id){        
        this.id = id;       
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) throws ViolacaoRegraNegocioException{
        if(endereco==null){
            throw new ViolacaoRegraNegocioException("O endereco não pode ser nulo!");
        }
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone){       
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ViolacaoRegraNegocioException {
       int pos=-1,count=0; 
       pos = email.indexOf('.');
       for(int i=0; i<email.length(); i++){
           if(email.charAt(i)=='@'){
               count++;
           }
       }       
       if(email == null || pos==-1 || (count==0 || count>1)) {
            throw new ViolacaoRegraNegocioException("O email deve conter pelo menos 1 ponto(.) e obrigatoriamente apenas 1 arroba(@)");
       }
        this.email = email;       
    }
  
}
