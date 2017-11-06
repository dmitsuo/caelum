/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;

/**
 *
 * @author eu
 */
public class TesteInsereMov {

    public static void main(String[] args) {
        JPAUtil jpaUtil = new JPAUtil();
        EntityManager manager = jpaUtil.getEntityManager();
        MovDao dao = new MovDao(manager);
        Movimentacao m = new Movimentacao();
        m.setConta(null);
        //m.setData(LocalDateTime.now());
        m.setData(null);
        m.setDescricao("Movimentação de Teste " + LocalDateTime.now());
        m.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        m.setValor(new BigDecimal(1000));
        manager.getTransaction().begin();
        dao.adiciona(m);
        manager.getTransaction().commit();
        manager.close();
        jpaUtil.closeFactory();
        System.out.println("Movimentação gravada com sucesso!");        
    }

}
