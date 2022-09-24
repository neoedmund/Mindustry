package mindustry.gen;

import arc.Core;
import arc.audio.Music;

public class Musics {
  public static Music boss1 = new arc.audio.Music();

  public static Music boss2 = new arc.audio.Music();

  public static Music editor = new arc.audio.Music();

  public static Music fine = new arc.audio.Music();

  public static Music game1 = new arc.audio.Music();

  public static Music game2 = new arc.audio.Music();

  public static Music game3 = new arc.audio.Music();

  public static Music game4 = new arc.audio.Music();

  public static Music game5 = new arc.audio.Music();

  public static Music game6 = new arc.audio.Music();

  public static Music game7 = new arc.audio.Music();

  public static Music game8 = new arc.audio.Music();

  public static Music game9 = new arc.audio.Music();

  public static Music land = new arc.audio.Music();

  public static Music launch = new arc.audio.Music();

  public static Music menu = new arc.audio.Music();

  public static void load() {
    Core.assets.load("music/boss1.ogg", arc.audio.Music.class).loaded = a -> { boss1 = (arc.audio.Music)a; };
    Core.assets.load("music/boss2.ogg", arc.audio.Music.class).loaded = a -> { boss2 = (arc.audio.Music)a; };
    Core.assets.load("music/editor.ogg", arc.audio.Music.class).loaded = a -> { editor = (arc.audio.Music)a; };
    Core.assets.load("music/fine.ogg", arc.audio.Music.class).loaded = a -> { fine = (arc.audio.Music)a; };
    Core.assets.load("music/game1.ogg", arc.audio.Music.class).loaded = a -> { game1 = (arc.audio.Music)a; };
    Core.assets.load("music/game2.ogg", arc.audio.Music.class).loaded = a -> { game2 = (arc.audio.Music)a; };
    Core.assets.load("music/game3.ogg", arc.audio.Music.class).loaded = a -> { game3 = (arc.audio.Music)a; };
    Core.assets.load("music/game4.ogg", arc.audio.Music.class).loaded = a -> { game4 = (arc.audio.Music)a; };
    Core.assets.load("music/game5.ogg", arc.audio.Music.class).loaded = a -> { game5 = (arc.audio.Music)a; };
    Core.assets.load("music/game6.ogg", arc.audio.Music.class).loaded = a -> { game6 = (arc.audio.Music)a; };
    Core.assets.load("music/game7.ogg", arc.audio.Music.class).loaded = a -> { game7 = (arc.audio.Music)a; };
    Core.assets.load("music/game8.ogg", arc.audio.Music.class).loaded = a -> { game8 = (arc.audio.Music)a; };
    Core.assets.load("music/game9.ogg", arc.audio.Music.class).loaded = a -> { game9 = (arc.audio.Music)a; };
    Core.assets.load("music/land.ogg", arc.audio.Music.class).loaded = a -> { land = (arc.audio.Music)a; };
    Core.assets.load("music/launch.ogg", arc.audio.Music.class).loaded = a -> { launch = (arc.audio.Music)a; };
    Core.assets.load("music/menu.ogg", arc.audio.Music.class).loaded = a -> { menu = (arc.audio.Music)a; };
  }
}
