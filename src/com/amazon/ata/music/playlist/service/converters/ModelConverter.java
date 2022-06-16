package com.amazon.ata.music.playlist.service.converters;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.SongModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ModelConverter {
    List<String> tags = null;
    /**
     * Converts a provided {@link Playlist} into a {@link PlaylistModel} representation.
     * @param playlist the playlist to convert
     * @return the converted playlist
     */
    public PlaylistModel toPlaylistModel(Playlist playlist) {
        if (playlist.getTags() != null) {
            tags = new ArrayList<>(playlist.getTags());
        }

        return PlaylistModel.builder()
            .withId(playlist.getId())
                .withName(playlist.getName())
                .withCustomerId(playlist.getCustomerId())
                .withSongCount(playlist.getSongCount())
                .withTags(tags)
            .build();
    }

    public SongModel toSongModel (AlbumTrack albumTrack) {
        return SongModel.builder()
                .withAsin(albumTrack.getAsin())
                .withTrackNumber(albumTrack.getTrackNumber())
                .withAlbum(albumTrack.getAlbumName())
                .withTitle(albumTrack.getSongTitle())
                .build();
    }

    public LinkedList<SongModel> toSongModelList(LinkedList<AlbumTrack> songList) {
        LinkedList<SongModel> songModelList = new LinkedList<>();
        for (AlbumTrack song : songList) {
            SongModel songModel = toSongModel(song);
            songModel.setAsin(song.getAsin());
            songModel.setTrackNumber(song.getTrackNumber());
            song.setAlbumName(song.getAlbumName());
            songModel.setTitle(song.getSongTitle());

            songModelList.add(songModel);
        }
        return songModelList;
    }
}
