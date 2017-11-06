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
public class TesteInsereConta {

    public static void main(String[] args) {
        JPAUtil jpaUtil = new JPAUtil();
        EntityManager manager = jpaUtil.getEntityManager();
        ContaDao dao = new ContaDao(manager);
        Conta conta = new Conta();
        conta.setTitular("Jose Roberto");
        conta.setBanco("Banco do Brasil");
        conta.setNumero("123456-6");
        conta.setAgencia("0999");
        manager.getTransaction().begin();
        dao.adiciona(conta);
        manager.getTransaction().commit();
        manager.close();
        jpaUtil.closeFactory();
        System.out.println("Conta gravada com sucesso!");        
    }

}
