package com.example.audio_player_10.service;

import android.net.Uri;

import com.example.audio_player_10.R;

final class MusicRepository {

    private final Track[] data ={
            new Track("The Monster", "Rihanna", R.drawable.rihanna, Uri.parse("https://bevak.ru/Eminem_Rihanna_-_The_Monster_47964981.mp3"), (4 * 60 + 11) * 1000),
            new Track("Numb", "Linkin Park", R.drawable.linkin_park, Uri.parse("https://bevak.ru/Linkin_Park_Jay-Z_-_Numb_Encore_64574580.mp3"), (3 * 60 + 26) * 1000),
            new Track("Chicago", "Frank Sinatra", R.drawable.frank_sinatra, Uri.parse("https://bevak.ru/Frank_Sinatra_The_Troggs_-_Chicago_55342379.mp3"), (2 * 60 + 13) * 1000),
            new Track("Don`t worry be happy", "Bobby Mc Ferrin", R.drawable.bobby_mc_ferrin, Uri.parse("https://bevak.ru/Bobby_McFerrin_-_Dont_Worry_Be_Happy.mp3"), (4 * 60 + 54) * 1000)
    };

    private final int maxIndex = data.length - 1;
    private int currentItemIndex = 0;

    Track getNext() {
        if (currentItemIndex == maxIndex)
            currentItemIndex = 0;
        else
            currentItemIndex++;
        return getCurrent();
    }

    Track getPrevious() {
        if (currentItemIndex == 0)
            currentItemIndex = maxIndex;
        else
            currentItemIndex--;
        return getCurrent();
    }

    Track getCurrent() {
        return data[currentItemIndex];
    }

    static class Track {

        private String title;
        private String artist;
        private int bitmapResId;
        private Uri uri;
        private long duration; // in ms

        Track(String title, String artist, int bitmapResId, Uri uri, long duration) {
            this.title = title;
            this.artist = artist;
            this.bitmapResId = bitmapResId;
            this.uri = uri;
            this.duration = duration;
        }

        String getTitle() {
            return title;
        }

        String getArtist() {
            return artist;
        }

        int getBitmapResId() {
            return bitmapResId;
        }

        Uri getUri() {
            return uri;
        }

        long getDuration() {
            return duration;
        }
    }
}
