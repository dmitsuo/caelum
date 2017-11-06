/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author eu
 */
public class TestaBuscaContaDaMovimentacao {

    public static void main(String[] args) {
        // recupera um EntityManager
        JPAUtil jpaUtil = new JPAUtil();
        EntityManager manager = jpaUtil.getEntityManager();

        try {
            MovDao dao = new MovDao(manager);
            Movimentacao m = dao.busca(3);
            System.out.println("Titular da Conta #1: " + m.getConta().getTitular());
        } finally {
            manager.close();
            jpaUtil.closeFactory();
        }
    }
}
