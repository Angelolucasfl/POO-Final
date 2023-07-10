package com.spotfly.models;

public class MusicOffline extends Music implements Playable {
	private String arquivo; 

	public MusicOffline(String titulo, String artista, String genero, int duracaoSegundos, String arquivo) {
		super(titulo, artista, genero, duracaoSegundos);
		this.arquivo = arquivo;
	}

	@Override
	public void reproduzir() {
		System.out.println("Tocando Agora(offline): " + getTitulo() + " do arquivo " + arquivo);
	}
	

}
