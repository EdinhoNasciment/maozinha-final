package com.maozinha.api.domain;

public enum Bank {

	BANCO_DO_BRASIL("Banco do Brasil", 001),
	CAIXA_ECONOMICA_FEDERAL("Caixa Econômica Federal", 104),
	BRADESCO("Bradesco", 237), 
	ITAU("Itaú Unibanco", 341), 
	SANTANDER("Santander Brasil", 033),
	SAFRA("Banco Safra", 422),
	INTER("Banco Inter", 077),
	BTG_PACTUAL("BTG Pactual", 208),
	STONE("Banco Stone", 197),
	SICREDI("Sicredi", 748),
	SICOOB("Sicoob", 756);

	private final String nome;
	private final int codigo;

	Bank(String nome, int codigo) {
	        this.nome = nome;
	        this.codigo = codigo;
	    }

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}
}
