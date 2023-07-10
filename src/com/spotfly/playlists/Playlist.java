package com.spotfly.playlists;

import java.util.ArrayList;
import java.util.List;

import com.spotfly.models.Music;

public class Playlist {

	private String nome;
	private List<Music> musicas;
	
	public Playlist(String nome) {
		super();
		this.nome = nome;
		this.musicas = new ArrayList<>();
	}
	
    public void adicionarMusica(Music musica) {
        musicas.add(musica);
    }

    public void removerMusica(Music musica) {
        musicas.remove(musica);
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Music> getMusicas() {
		return musicas;
	}

}
