package com.pracas.domain.model;

import com.pracas.exception.InvalidLetterException;

public enum Lletra {
	A('a'),
	B('b'),
	C('c'),
	D('d'),
	E('e'),
	F('f'),
	G('g'),
	H('h'),
	I('i'),
	J('j'),
	K('k'),
	L('l'),
	M('m'),
	N('n'),
	O('o'),
	P('p'),
	Q('q'),
	R('r'),
	S('s'),
	T('t'),
	U('u'),
	V('v'),
	W('w'),
	X('x'),
	Y('y'),
	Z('z'),
	;
	
	private char ch;
	
	Lletra(char _ch) {
		this.ch = _ch;
	}
	
	public char getChar() {
		return this.ch;
	}
	
	public static Lletra getLletraByChar(char _ch) throws InvalidLetterException {
		for (Lletra lletra : values()) {
			if (_ch == lletra.getChar())
				return lletra;
		}
		throw new InvalidLetterException();
	}
}
