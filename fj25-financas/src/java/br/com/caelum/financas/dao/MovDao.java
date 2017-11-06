/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.dao;

import br.com.caelum.financas.modelo.Movimentacao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author eu
 */
public class MovDao {

    private EntityManager manager;

    public MovDao(EntityManager manager) {
        this.manager = manager;
    }

    public Movimentacao busca(Integer id) {
        return this.manager.find(Movimentacao.class, id);
    }

    public List<Movimentacao> lista() {
        return this.manager.createQuery("select o from Movimentacao o", Movimentacao.class).getResultList();
    }

    public void adiciona(Movimentacao m) {
        this.manager.persist(m);
    }

    public void remove(Movimentacao m) {
        this.manager.remove(m);
    }

}
