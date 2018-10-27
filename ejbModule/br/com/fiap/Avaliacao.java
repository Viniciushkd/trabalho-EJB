package br.com.fiap;

import java.util.List;

import br.com.fiap.common.QuestaoVO;

public interface Avaliacao {

   public List<QuestaoVO> obterQuestoes(int codigoAvaliacao);
   public String obterQuestao(int codigo);
   public void removerEJB();
}
