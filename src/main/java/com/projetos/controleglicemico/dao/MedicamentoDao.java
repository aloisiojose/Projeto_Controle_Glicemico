package com.projetos.controleglicemico.dao;

import com.projetos.controleglicemico.model.CadastroPessoa;
import com.projetos.controleglicemico.model.MedicamentoPaciente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class MedicamentoDao {

     public boolean salvar(MedicamentoPaciente tipo) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(tipo);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception erro) {
            System.out.println("Ocorreu um erro:" + erro);
            //ARQUIVO DE
            return false;
        }
    }

    public List<MedicamentoPaciente> consulta(String nome) {
        List<MedicamentoPaciente> lista = new ArrayList();
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
}
