package onlineRadioDatabase;

public class Song {
    private String artistName;
    private String songName;
    private int length;

    public Song(String artistName, String songName, String length) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    private void setArtistName(String artistName) {
        if (artistName.length()<3|| artistName.length()>20){
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.length()<3||songName.length()>30){
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setLength(String length) {

        int songInSeconds = 0;
        String[]lengthInfo = length.split(":");
        songInSeconds = Integer.parseInt(lengthInfo[0])*60 + Integer.parseInt(lengthInfo[1]);
        if (Integer.parseInt(lengthInfo[0])<0||Integer.parseInt(lengthInfo[0])>14){
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
        if (Integer.parseInt(lengthInfo[1])<0||Integer.parseInt(lengthInfo[1])>59){
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
        if (songInSeconds<0||songInSeconds>899){
            throw  new IllegalArgumentException("Invalid song length.");
        }
        this.length = songInSeconds;
    }

    public int getLength() {
        return this.length;
    }
}
