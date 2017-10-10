package br.com.caelum.ingresso.model;


import javax.persistence.*;

import java.time.LocalTime;

/**
 * Created by nando on 03/03/17.
 */
@Entity
public class Sessao {

    @Id
    @GeneratedValue
    private Integer id;
    private LocalTime horario;

    @ManyToOne
    private Sala sala;

    @ManyToOne
    private Filme filme;

    /**
     * @deprecated hibernate only
     */
    public Sessao() {

    }

    public Sessao(LocalTime horario, Filme filme, Sala sala) {
        this.horario = horario;
	this.setFilme(filme);
	this.sala = sala;
    }

    public LocalTime getHorarioTermino() {
        return this.horario.plusMinutes(filme.getDuracao().toMinutes());
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
    
}
