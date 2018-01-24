package onlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSongs = Integer.parseInt(br.readLine());

        List<Song>songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String [] songInfo = br.readLine().split(";");
            String artist = songInfo[0].trim();
            String name = songInfo[1].trim();
            String length = songInfo[2].trim();
            try {
                Song song = new Song(artist, name, length);
                songs.add(song);
                System.out.println("Song added.");

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        int length = 0;

        for (Song song:songs) {
            length+=song.getLength();
        }

        int hoers = length/3600;
        length%=3600;
        int minutes = length/60;
        int seconds = length%60;
        System.out.printf("Songs added: %d\n", songs.size());

        System.out.printf("Playlist length: %dh %dm %ds", hoers, minutes, seconds);
    }
}
