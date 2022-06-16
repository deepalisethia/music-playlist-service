package com.amazon.ata.music.playlist.service.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Represents a record in the album_tracks table.
 */
@DynamoDBTable(tableName = "albumTracks")
public class AlbumTrack {
    private String asin;
    private Integer trackNumber;
    private String albumName;
    private String songTitle;

    @DynamoDBHashKey(attributeName = "asin")
    public String getAsin() {
        return asin;
    }

    @DynamoDBAttribute (attributeName = "trackNumber")
    public Integer getTrackNumber() {
        return trackNumber;
    }


    @DynamoDBAttribute (attributeName = "albumName")
    public String getAlbumName() {
        return albumName;
    }

    @DynamoDBAttribute (attributeName = "songTitle")
    public String getSongTitle() {
        return songTitle;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
}
