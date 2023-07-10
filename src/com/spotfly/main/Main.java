package com.spotfly.main;

import com.spotfly.models.Album;
import com.spotfly.models.Music;
import com.spotfly.models.MusicOffline;
import com.spotfly.models.MusicOnline;
import com.spotfly.playlists.Playlist;
import com.spotfly.users.User;
import com.spotfly.users.UserPremium;
import com.spotfly.playlists.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro do usuário
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();

        System.out.print("Digite o email do usuário: ");
        String emailUsuario = scanner.nextLine();

        System.out.print("Digite a senha do usuário: ");
        String senhaUsuario = scanner.nextLine();

        String tipoUsuario = "";
        while (!tipoUsuario.equalsIgnoreCase("padrão") && !tipoUsuario.equalsIgnoreCase("premium")) {
            System.out.print("Digite o tipo de usuário (Padrão ou Premium): ");
            tipoUsuario = scanner.nextLine();

            if (!tipoUsuario.equalsIgnoreCase("padrão") && !tipoUsuario.equalsIgnoreCase("premium")) {
                System.out.println("Opção inválida. Apenas 'Padrão' ou 'Premium' são permitidos.");
            }
        }

        User usuario;
        if (tipoUsuario.equalsIgnoreCase("premium")) {
            usuario = new UserPremium(nomeUsuario, emailUsuario, senhaUsuario, tipoUsuario);
        } else {
            usuario = new User(nomeUsuario, emailUsuario, senhaUsuario);
        }

        // Verificação de conexão (online ou offline)
        String conexao = "";
        while (!conexao.equalsIgnoreCase("online") && !conexao.equalsIgnoreCase("offline")) {
            System.out.print("Você está online ou offline? ");
            conexao = scanner.nextLine();

            if (!conexao.equalsIgnoreCase("online") && !conexao.equalsIgnoreCase("offline")) {
                System.out.println("Opção inválida. Apenas 'online' ou 'offline' são permitidos.");
            }
        }

        if (conexao.equalsIgnoreCase("online")) {
            String plataformaStreaming = "";
            while (!plataformaStreaming.equalsIgnoreCase("itunes") &&
                    !plataformaStreaming.equalsIgnoreCase("spotfly") &&
                    !plataformaStreaming.equalsIgnoreCase("deezer") &&
                    !plataformaStreaming.equalsIgnoreCase("padrão")) {
                System.out.print("Digite a plataforma de streaming (iTunes, Spotfly, Deezer, Padrão): ");
                plataformaStreaming = scanner.nextLine();

                if (!plataformaStreaming.equalsIgnoreCase("itunes") &&
                        !plataformaStreaming.equalsIgnoreCase("spotfly") &&
                        !plataformaStreaming.equalsIgnoreCase("deezer") &&
                        !plataformaStreaming.equalsIgnoreCase("padrão")) {
                    System.out.println("Opção inválida. Apenas 'iTunes', 'Spotfly', 'Deezer' ou 'Padrão' são permitidos.");
                }
            }

            // Lógica para usuário premium
            if (usuario instanceof UserPremium) {
                UserPremium usuarioPremium = (UserPremium) usuario;
                usuarioPremium.setPlataformaStreaming(plataformaStreaming);
            } else {
                System.out.println("Apenas usuários premium têm acesso a plataformas de streaming.");
            }
        } else if (conexao.equalsIgnoreCase("offline")) {
            System.out.print("Digite o caminho do arquivo de música: ");
            String caminhoMusica = scanner.nextLine();

            // Lógica para usuário premium
            if (usuario instanceof UserPremium) {
                UserPremium usuarioPremium = (UserPremium) usuario;
                usuarioPremium.setCaminhoMusica(caminhoMusica);
            } else {
                System.out.println("Apenas usuários premium têm acesso a músicas offline.");
            }
        }

        // Menu interativo
        String opcao;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Criar um álbum");
            System.out.println("2. Criar uma playlist");
            System.out.println("3. Adicionar uma música à playlist");
            System.out.println("4. Reproduzir uma música");
            System.out.println("5. Registrar uma música");
            System.out.println("6. Adicionar música a um álbum");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    criarAlbum(usuario, scanner);
                    break;
                case "2":
                    criarPlaylist(usuario, scanner);
                    break;
                case "3":
                    adicionarMusicaPlaylist(usuario, scanner);
                    break;
                case "4":
                    reproduzirMusica(usuario, scanner);
                    break;
                case "5":
                    adicionarMusica(usuario, scanner);
                    break;
                case "6":
                    adicionarMusicaAlbum(usuario, scanner);
                    break;
                case "0":
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        } while (!opcao.equals("0"));

        scanner.close();
    }
    
    private static void adicionarMusicaAlbum(User usuario, Scanner scanner) {
        System.out.print("Digite o título da música: ");
        String tituloMusica = scanner.nextLine();

        System.out.print("Digite o título do álbum: ");
        String tituloAlbum = scanner.nextLine();

        Music musica = new Music(tituloMusica, "", "", 0);

        Album album = new Album(tituloAlbum, "", 0, null);

        album.addMusica(musica);
        System.out.println("Música adicionada ao álbum com sucesso.");
    }

    
    private static void adicionarMusica(User usuario, Scanner scanner) {
        System.out.print("Digite o título da música: ");
        String tituloMusica = scanner.nextLine();

        System.out.print("Digite o artista da música: ");
        String artistaMusica = scanner.nextLine();

        System.out.print("Digite o gênero da música: ");
        String generoMusica = scanner.nextLine();

        System.out.print("Digite a duração da música em segundos: ");
        int duracaoMusica = scanner.nextInt();
        scanner.nextLine();

        Music novaMusica;
        if (usuario.isOnline()) {
            novaMusica = new MusicOnline(tituloMusica, artistaMusica, generoMusica, duracaoMusica, generoMusica);
        } else {
            System.out.print("Digite o caminho do arquivo de música offline: ");
            String caminhoMusicaOffline = scanner.nextLine();
            novaMusica = new MusicOffline(tituloMusica, artistaMusica, generoMusica, duracaoMusica, caminhoMusicaOffline);
        }

        usuario.adicionarMusica(novaMusica);
        System.out.println("Música registrada com sucesso!");
        System.out.println();
        novaMusica.reproduzir();
    }

    
    private static void adicionarMusicaPlaylist(User usuario, Scanner scanner) {
        System.out.print("Digite o título da música: ");
        String tituloMusica = scanner.nextLine();

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();

        Music musica = new Music(tituloMusica, "", "", 0);

        Playlist playlist = new Playlist(nomePlaylist);

        Player player = new Player(usuario);
        player.adicionarMusicaNaPlaylist(musica, playlist);
    }
    
    private static void criarPlaylist(User usuario, Scanner scanner) {
        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();

        Playlist playlist = new Playlist(nomePlaylist);
        usuario.adicionarPlaylist(playlist);
        System.out.println("Playlist criada com sucesso!");
    }
    
    private static void criarAlbum(User usuario, Scanner scanner) {
        System.out.print("Digite o título do álbum: ");
        String tituloAlbum = scanner.nextLine();

        System.out.print("Digite o artista do álbum: ");
        String artistaAlbum = scanner.nextLine();

        System.out.print("Digite o ano do álbum: ");
        int anoAlbum = scanner.nextInt();
        scanner.nextLine();

        Album album = new Album(tituloAlbum, artistaAlbum, anoAlbum, null);
        System.out.println("Álbum criado com sucesso!");

        usuario.adicionarAlbum(album);
    }
    
    private static void reproduzirMusica(User usuario, Scanner scanner) {
        System.out.print("Digite o título da música: ");
        String tituloMusica = scanner.nextLine();

        Music musica = new Music(tituloMusica, "", "", 0);

        Player player = new Player(usuario);
        player.reproduzirMusica(musica);
    }
    
}
