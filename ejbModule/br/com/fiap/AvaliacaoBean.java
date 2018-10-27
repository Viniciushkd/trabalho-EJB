package br.com.fiap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.common.Questao;
import br.com.fiap.common.QuestaoVO;
import br.com.fiap.common.Resposta;
import br.com.fiap.common.RespostaVO;

@Stateless
@Remote(Avaliacao.class)
@WebService(name="avaliacao")
public class AvaliacaoBean implements Avaliacao, Serializable{

	@PersistenceContext(name="Chamado")
	private EntityManager em;
	
	@Override
	public List<QuestaoVO> obterQuestoes(int codigoAvaliacao) {
		
		List<Questao> questoes = em.createQuery("from Questao ch where ch.codigoAvaliacao=:codigoAvaliacao")
	    		.setParameter("codigoAvaliacao", codigoAvaliacao).getResultList();
		
		List<QuestaoVO> questoesRetorno =  new ArrayList<QuestaoVO>();
		for (Questao questao : questoes) {
			QuestaoVO item = new QuestaoVO();
			item.setCodigoAvaliacao(questao.getCodigoAvaliacao());
			item.setDescricao(questao.getDescricao());
			item.setId(questao.getId());
			List<RespostaVO> respostas = new ArrayList<RespostaVO>();
			for(Resposta resposta : questao.getRespostas()) {
				RespostaVO vo = new RespostaVO();
				vo.setId(resposta.getId());
				vo.setDescricao(resposta.getDescricao());
				respostas.add(vo);
				
			}
			item.setRespostas(new ArrayList<RespostaVO>());
			item.getRespostas().addAll(respostas);
			questoesRetorno.add(item);
		}
		System.out.println("teste");
		return questoesRetorno;
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
