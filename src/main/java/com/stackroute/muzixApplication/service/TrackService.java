package com.stackroute.muzixApplication.service;

import com.stackroute.muzixApplication.domain.Track;
import org.springframework.http.HttpStatus;

import java.util.List;

/*
 * This is an interface to implement the Track class of domain package.
 */
public interface TrackService {

    /*
     * This method provide user a mean to add new track in the database.
     */
     public Track saveTrack(Track track);

    /*
     * This method provide user with all the track in the database.
     */
    public List<Track> getAllTrack();

    /*
     *This method provide track details to the user of particular track Id.
     */
    public Track getTrackById(int trackId);

    /*
     * This method help user to update track comment of a particular track Id.
     */
    public Track updateTrack(Track track);

    /*
     * This method help user to remove the track from database based on the input track Id.
     */
    public void removeTrackById (int trackId);

    /*
     * This method help user to update track comment of a particular track Id.
     */
    public List<Track> getTrackByName(String trackName);
}
