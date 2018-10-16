package br.com.fiap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(Avaliacao.class)
@WebService(name="avaliacao")
public class AvaliacaoBean implements Avaliacao, Serializable{

	@PersistenceContext(name="Chamado")
	private EntityManager em;
	
	@Override
	public List obterQuestoes(int codigoAvaliacao) {
		return em.createQuery("from Questao ch where ch.codigoAvaliacao=:codigoAvaliacao")
	    		.setParameter("codigoAvaliacao", codigoAvaliacao).getResultList();
	}
	
	@Override
	public String obterQuestao(int codigo) {
	    return em.createQuery("from Questao ch where ch.id=:codigo")
	    		.setParameter("codigo", codigo).getSingleResult().toString();
	}

	@Remove
	public void removerEJB() {
		System.out.println("Removendo instancia EJB.");
	}

}
