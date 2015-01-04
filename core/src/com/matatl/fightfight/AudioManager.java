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
    public static Array<Song> songs;

     class Song {
         private Music title;
         private int bpm;

         public Song(String title, int bpm) {
             this.title = Gdx.audio.newMusic(Gdx.files.internal(title));
             this.bpm = bpm;
         }
     }
    public AudioManager() {
        songs = new Array<Song>();
        songs.add(new Song("Hypnothis.mp3",104));
        songs.add(new Song("Itty Bitty 8 Bit.mp3",108));
        songs.add(new Song("Latin Industries.mp3",122));
        songs.add(new Song("Ouroboros.mp3",130));
        songs.add(new Song("One Sly Move.mp3",95));
    }

}
