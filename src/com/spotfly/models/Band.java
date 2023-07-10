package com.spotfly.models;

public class Band extends Artist {
	
	private String estiloMusical;

	public Band(String nome, String nacionalidiade, String estiloMusical, int numIntegrantes) {
		super(nome, nacionalidiade);
		this.estiloMusical = estiloMusical;
	}

	@Override
	public void realizarApresentacao() {
		System.out.println("A banda " + getNome() + " está performando.");
		
	}

	public String getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(String estiloMusical) {
		this.estiloMusical = estiloMusical;
	}
	
}
