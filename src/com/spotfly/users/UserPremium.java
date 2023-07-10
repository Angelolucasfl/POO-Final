package com.spotfly.users;

public class UserPremium extends User {
    private String plataformaStreaming;
    private String caminhoMusica;

    public UserPremium(String nome, String email, String senha, String plataformaStreaming) {
        super(nome, email, senha);
        this.plataformaStreaming = plataformaStreaming;
    }

    public String getPlataformaStreaming() {
        return plataformaStreaming;
    }

    public void setPlataformaStreaming(String plataformaStreaming) {
        this.plataformaStreaming = plataformaStreaming;
    }

    public String getCaminhoMusica() {
        return caminhoMusica;
    }

    public void setCaminhoMusica(String caminhoMusica) {
        this.caminhoMusica = caminhoMusica;
    }

		
}
