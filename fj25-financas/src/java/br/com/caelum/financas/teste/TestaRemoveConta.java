/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author eu
 */
public class TestaRemoveConta {

    public static void main(String[] args) {
        // recupera um EntityManager
        JPAUtil jpaUtil = new JPAUtil();
        EntityManager manager = jpaUtil.getEntityManager();
        ContaDao dao = new ContaDao(manager);
        manager.getTransaction().begin();
        Conta conta = dao.busca(1); // usar um ID que exista no banco
        dao.remove(conta);
        manager.getTransaction().commit();
        manager.close();
        jpaUtil.closeFactory();
    }
}
