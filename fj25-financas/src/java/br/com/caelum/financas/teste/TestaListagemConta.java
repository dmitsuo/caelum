/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author eu
 */
public class TestaListagemConta {

    public static void main(String[] args) {
        // recupera um EntityManager
        JPAUtil jpaUtil = new JPAUtil();
        EntityManager manager = jpaUtil.getEntityManager();
        ContaDao dao = new ContaDao(manager);
        List<Conta> lista = dao.lista();
        for (Conta conta : lista) {
            System.out.println(conta.getNumero());
        }
        manager.close();
        jpaUtil.closeFactory();
    }
}
