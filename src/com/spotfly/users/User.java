package com.spotfly.users;

import com.spotfly.models.Album;
import com.spotfly.models.Music;
import com.spotfly.playlists.Playlist;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String nome;
    private String email;
    private String senha;
    private boolean online;
    private List<Playlist> playlists;
    private List<Album> albums;

    public User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.playlists = new ArrayList<>();
        this.albums = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void removerPlaylist(Playlist playlist) {
        playlists.remove(playlist);
    }

    public void adicionarMusica(Music novaMusica) {
        // Verificar se a música já existe na lista de músicas do usuário
        if (playlists.stream().flatMap(playlist -> playlist.getMusicas().stream())
                .anyMatch(musica -> musica.getTitulo().equalsIgnoreCase(novaMusica.getTitulo()))) {
            System.out.println("A música já existe na lista de músicas do usuário.");
        } else {
            // Adicionar a música à primeira playlist do usuário (caso exista)
            if (!playlists.isEmpty()) {
                playlists.get(0).adicionarMusica(novaMusica);
                System.out.println("Música adicionada à primeira playlist do usuário.");
            } else {
                System.out.println("O usuário não possui playlists. Crie uma playlist antes de adicionar músicas.");
            }
        }
    }


    public void adicionarAlbum(Album album) {
        albums.add(album);
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isOnline() {
        return online;
    }
}


