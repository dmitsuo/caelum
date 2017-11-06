/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.dao;

import br.com.caelum.financas.modelo.Conta;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author eu
 */
public class ContaDao {

    private EntityManager manager;

    public ContaDao(EntityManager manager) {
        this.manager = manager;
    }

    public Conta busca(Integer id) {
        return this.manager.find(Conta.class, id);
    }

    public List<Conta> lista() {
        return this.manager.createQuery("select c from Conta c", Conta.class).getResultList();
    }

    public void adiciona(Conta conta) {
        this.manager.persist(conta);
    }

    public void remove(Conta conta) {
        this.manager.remove(conta);
    }

}
