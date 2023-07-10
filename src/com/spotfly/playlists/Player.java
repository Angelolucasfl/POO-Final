package com.spotfly.playlists;

import com.spotfly.models.Music;
import com.spotfly.users.User;

public class Player {

	private User usuarioLogado;

    public Player(User usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void reproduzirMusica(Music musica) {
        if (usuarioLogado != null) {
            System.out.println("Reproduzindo a música: " + musica.getTitulo());
        } else {
            System.out.println("Nenhum usuário logado. Não é possível reproduzir a música.");
        }
    }

    public void adicionarMusicaNaPlaylist(Music musica, Playlist playlist) {
        if (usuarioLogado != null) {
            playlist.adicionarMusica(musica);
            System.out.println("A música " + musica.getTitulo() + " foi adicionada à playlist " + playlist.getNome());
        } else {
            System.out.println("Nenhum usuário logado. Não é possível adicionar a música à playlist.");
        }
    }
	
}
