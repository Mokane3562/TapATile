package com.matatl.fightfight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Mokane on 1/3/2015.
 */
public class AudioManager {
    public static final Sound KILL_TILE_FX = Gdx.audio.newSound(Gdx.files.internal("bomb.wav"));
    public static final Sound MULT_TILE_FX = Gdx.audio.newSound(Gdx.files.internal("mult.wav"));
    public static final Sound POINT_TILE_FX = Gdx.audio.newSound(Gdx.files.internal("beat.wav"));
    private static Array<Song> songList;
    public static int songs;

     public static class Song {
         private Music title;
         private int bpm;

         public Song(String title, int bpm) {
             this.title = Gdx.audio.newMusic(Gdx.files.internal(title));
             this.bpm = bpm;
         }
         public Music getMusic() {
             return title;
         }
         public int getBPM() {
             return bpm;
         }
     }
    public static void initSongs() {
        songList= new Array<Song>();
        songList.add(new Song("Hypnothis.mp3",104));
        songList.add(new Song("Itty Bitty 8 Bit.mp3",108));
        songList.add(new Song("Latin Industries.mp3",122));
        songList.add(new Song("Ouroboros.mp3",130));
        songList.add(new Song("One Sly Move.mp3",95));
        songs = songList.size;
    }
    public static Array<Song> songList() {
        return songList;
    }

}
