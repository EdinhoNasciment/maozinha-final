package com.maozinha.api.domain;

public enum Gender {
	
	    // Gêneros binários
	    MASCULINO,
	    FEMININO,

	    // Gêneros não-binários e expansivos
	    NAO_BINARIO,
	    GENERO_FLUIDO,
	    GENERO_NEUTRO,
	    AGENDER, // Sem gênero
	    BIGENERO, // Identificação com dois gêneros
	    PANGENERO, // Identificação com múltiplos gêneros
	    DEMIGENERO, // Gênero parcial (como demi-boy, demi-girl)
	    TWO_SPIRIT, // Termo indígena para identidades de gênero misturadas

	    // Identidades específicas
	    TRANS_MASCULINO,
	    TRANS_FEMININO,
	    CIS_MASCULINO,
	    CIS_FEMININO,

	    // Gêneros culturais ou específicos
	    HIJRA, // Identidade de gênero da Índia e Sul da Ásia
	    FA_AFAFINE, // Identidade de gênero da cultura Samoa
	    MUXE, // Identidade de gênero de comunidades Zapotecas

	    // Outros
	    OUTRO,
	    PREFIRO_NAO_DECLARAR;

	    @Override
	    public String toString() {
	        switch (this) {
	            case MASCULINO: return "Masculino";
	            case FEMININO: return "Feminino";
	            case NAO_BINARIO: return "Não-binário";
	            case GENERO_FLUIDO: return "Gênero Fluido";
	            case GENERO_NEUTRO: return "Gênero Neutro";
	            case AGENDER: return "Agênero";
	            case BIGENERO: return "Bigênero";
	            case PANGENERO: return "Pangênero";
	            case DEMIGENERO: return "Demigênero";
	            case TWO_SPIRIT: return "Two-Spirit";
	            case TRANS_MASCULINO: return "Trans Masculino";
	            case TRANS_FEMININO: return "Trans Feminino";
	            case CIS_MASCULINO: return "Cis Masculino";
	            case CIS_FEMININO: return "Cis Feminino";
	            case HIJRA: return "Hijra";
	            case FA_AFAFINE: return "Fa'afafine";
	            case MUXE: return "Muxé";
	            case OUTRO: return "Outro";
	            case PREFIRO_NAO_DECLARAR: return "Prefiro Não Declarar";
	            default: return "Não Especificado";
	        }
	    }
	}