
package com.projetos.controleglicemico.dao;

import com.projetos.controleglicemico.model.CadastroPessoa;
import com.projetos.controleglicemico.model.CidadeEstado;
import com.projetos.controleglicemico.util.TipoSanguinio;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class ConexaoBanco {
    private static  SessionFactory conexao = null;
    private static Configuration configuracao;
    
    
    private static SessionFactory buildSessionFactory(){
    //Objeto que armzena as configuracoes de conxao
    configuracao = new Configuration().configure();
    
    //configurando usuário e senha para acessar o banco de dados 
    configuracao.setProperty("hibernate.connection.username", "root");
    configuracao.setProperty("hibernate.connection.passoword", "");
    
    //Indicando o mapeamentos das classes 
    configuracao.addPackage("com.projetos.controleglicemico.model").addAnnotatedClass(CadastroPessoa.class);
    configuracao.addPackage("com.projetos.controleglicemico.model").addAnnotatedClass(TipoSanguinio.class);
    configuracao.addPackage("com.projetos.controleglicemico.model").addAnnotatedClass(CidadeEstado.class);
    
    //sessionFactory recebe a contrucao da sessao da conexao do bando de dados 
    conexao = configuracao.buildSessionFactory();
        return conexao;
    }
    public static SessionFactory getSessionFactory(){
        if(conexao == null){
            conexao = buildSessionFactory();
        }
    return conexao;
    }
    
}
