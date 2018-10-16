package br.com.fiap;

import java.util.List;

public interface Avaliacao {

   public List obterQuestoes(int codigoAvaliacao);
   public String obterQuestao(int codigo);
   public void removerEJB();
}
