package com.pracas.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.pracas.domain.controller.AdapterFactory;
import com.pracas.exception.InvalidLetterException;

@Entity
public class Partida {
	
	@Id
	private int idPartida;
	@Basic
	private boolean acabada;
	@Basic
	private boolean guanyada;
	@Basic
	private int errors;
	@ManyToOne
	private Paraula paraula;
	@Transient
	private IEstrategiaPuntuacio estrategiaPuntuacio;
	@Transient
	private List<Casella> caselles;

	public Partida(int _idPartida, Categoria _categoria, Jugador _jugadorPartidaActual) {
		super();
		acabada = false;
		guanyada = false;
		errors = 0;
		idPartida = _idPartida;
		if (_jugadorPartidaActual.getMes2PartidesGuanyades()) {
			estrategiaPuntuacio = AdapterFactory.getEstrategiaPenalitzacio();
		} else {
			estrategiaPuntuacio = AdapterFactory.getEstrategiaNoPenalitzacio();
		}
		paraula = _categoria.getParaulaAleatoria();
		caselles = new ArrayList<Casella>();
		int pos = 0;
		for (char ch : paraula.getNom().toCharArray()) {
			try {
				Casella c = new Casella(pos, Lletra.getLletraByChar(ch));
				caselles.add(c);
				pos++;
			} catch(InvalidLetterException ignore) {}
		}
		_jugadorPartidaActual.setPartidaActual(this);
	}
	
	public void getDadesInicials() {
		Parametres.getNombreMaximErrors();
		// puntuacio inicial = 0
		estrategiaPuntuacio.getPuntuacioEncert();
		estrategiaPuntuacio.getPuntuacioError();
		//TODO Create responsetype;
	}
	
	public void ferJugada(int pos, char _ch) throws InvalidLetterException {
		Casella casella = caselles.get(pos);

		if (!casella.intentarLletra(Lletra.getLletraByChar(_ch))) {
			errors++;
			if (errors >= Parametres.getNombreMaximErrors())
				acabada = true;
			int numEncerts = 0;
			for (Casella c : caselles) {
				if (c.isEncert())
					numEncerts++;
			}
			if (numEncerts == caselles.size()) {
				acabada = true;
				guanyada = true;
			}
			estrategiaPuntuacio.calcularPuntuacio(numEncerts, errors);
		}
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

	/*public Jugador getJugadorPartidaActual() {
		return jugadorPartidaActual;
	}

	public void setJugadorPartidaActual(Jugador jugadorPartidaActual) {
		this.jugadorPartidaActual = jugadorPartidaActual;
	}*/
	
	

}
