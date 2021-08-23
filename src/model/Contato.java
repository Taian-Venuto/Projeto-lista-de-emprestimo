/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


public class Contato {
    int id;
    String nome, telefone, objeto;
    String whatsapp;

    public Contato(int id, String nome, String telefone, String email, String whatsapp) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.objeto = email;
        this.whatsapp = whatsapp;
    }

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.objeto = email;
    }
    
    public Contato(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.objeto = email;
    }

    public Contato(String nome, String telefone, String email, String whatsapp) {
        this.nome = nome;
        this.telefone = telefone;
        this.objeto = email;
        this.whatsapp = whatsapp;
    }
    
    public Contato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

   
    
    
}
