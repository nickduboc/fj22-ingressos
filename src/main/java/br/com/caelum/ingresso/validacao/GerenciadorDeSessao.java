package br.com.caelum.ingresso.validacao;

import javax.persistence.*;

import antlr.collections.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by nando on 03/03/17.
 */
public class GerenciadorDeSessao{
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala){
		this.sessoesDaSala = sessoesDaSala;
	}
	private boolean horariosIsValido(Sessao sesssaoExistente, Sessao sessaoAtual){
		LocalDate hoje = LocalDate.now();
		
		LocalDateTime horarioSessao = sessaoExistente.getHorario().atData(hoje);
		LocalDateTime horarioAtual = sessaoAtual.getHorario().atDate(hoje);
		
		boolean ehAntes = horarioAtual.isBefore(horarioSessao);
		
		if (ehAntes) {
			
			return horarioAtual
					.plus(sessaoAtual.getFilme().getDuracao())
					.isBefore(horarioSessao);
		} else{
			
			return horarioSessao
					.plus(sessaoExistente.getFilme().getDuracao())
					isBefore(horarioAtual);
		}
	}
	
	public boolean cabe(Sessao sessaoAtual){
		
		Optional<Boolean> optionalCabe = sessaoDaSala.stream().map(sesssaoExistente -> horarioIsValido(sessaoExistente, sessaoAtual)).reduce(Boolean::logicalAnd);
		
		return optionalCabe.orElse(true);
	}
}