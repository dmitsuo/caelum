/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eu
 */
public class JPAUtil {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    
    public void closeFactory() {
        factory.close();
    }
}
