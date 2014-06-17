package com.pracas.domain.model;

public class Partida {
	
	private int idPartida;
	private boolean acabada;
	private boolean guanyada;
	private int errors;
	
	private Jugador jugadorPartidaActual;
	private Jugador jugadorPartidaJugada; // TODO

	public Partida(int idPartida, Jugador jugadorPartidaActual, Categoria categoria) {
		super();
		this.idPartida = idPartida;
		this.jugadorPartidaActual = jugadorPartidaActual;
	}
	
	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public boolean isAcabada() {
		return acabada;
	}

	public void setAcabada(boolean acabada) {
		this.acabada = acabada;
	}

	public boolean isGuanyada() {
		return guanyada;
	}

	public void setGuanyada(boolean guanyada) {
		this.guanyada = guanyada;
	}

	public int getErrors() {
		return errors;
	}

	public void setErrors(int errors) {
		this.errors = errors;
	}

	public Jugador getJugadorPartidaActual() {
		return jugadorPartidaActual;
	}

	public void setJugadorPartidaActual(Jugador jugadorPartidaActual) {
		this.jugadorPartidaActual = jugadorPartidaActual;
	}
	
	

}
