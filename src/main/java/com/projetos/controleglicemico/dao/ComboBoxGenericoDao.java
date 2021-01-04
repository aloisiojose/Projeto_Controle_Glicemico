
package com.projetos.controleglicemico.dao;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

public class ComboBoxGenericoDao<T> {
        
    private  ObservableList<T> obsList = FXCollections.observableArrayList();
    
    public  ObservableList<T> comboBox(String nomeClasse) {
        List<T> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        lista = session.createQuery(" from "+nomeClasse).getResultList();
        session.getTransaction().commit();
        session.close();
        
        for (T tp : lista) {
            obsList.add(tp);
        }
        return obsList;
    }
}
