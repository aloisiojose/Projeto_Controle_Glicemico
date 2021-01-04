
package com.projetos.controleglicemico.dao;

import com.projetos.controleglicemico.model.CidadeEstado;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;



public class CidadeEstadoDao {

    public boolean salvar(CidadeEstado cidadeEstado) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(cidadeEstado);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception erro) {
            System.out.println("Ocorreu um erro:" + erro);
            //ARQUIVO DE
            return false;
        }
    }

    public void excluir(CidadeEstado cidadeEstado) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cidadeEstado);
            session.getTransaction().commit();
            session.close();
            System.out.println("REGISTRO EXCLUIDO COM SUCESSO ");
        } catch (Exception erro) {
            System.out.println("Ocorreu um erro:" + erro);
        }
    }

    public List<CidadeEstado> consulta(String nome) {
        List<CidadeEstado> lista = new ArrayList();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        if (nome.length() == 0) {
            lista = session.createQuery(" from CadastroPessoa ").getResultList();
        } else {
            lista = session.createQuery(" from CadastroPessoa t where t.nome like " + "'" + nome + "%'").getResultList();
        }
        session.getTransaction().commit();
        session.close();

        return lista;
    }
    
    public class ComboBoxGenericoDao<CidadeEstado> {
        
    private  ObservableList<CidadeEstado> obsList = FXCollections.observableArrayList();
    
    public  ObservableList<CidadeEstado> comboBox(String nomeClasse) {
        List<CidadeEstado> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        lista = session.createQuery(" from "+nomeClasse).getResultList();
        session.getTransaction().commit();
        session.close();
        
        for (CidadeEstado tp : lista) {
            obsList.add(tp);
        }
        return obsList;
    }
}
    
}
