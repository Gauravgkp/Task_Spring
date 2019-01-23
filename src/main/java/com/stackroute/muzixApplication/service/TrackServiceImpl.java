package com.stackroute.muzixApplication.service;

import com.stackroute.muzixApplication.domain.Track;
import com.stackroute.muzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl (TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int trackId) {
        Track trackById = trackRepository.findById(trackId).get();
        return trackById;
    }

    @Override
    public Track updateTrack(Track track) {
        Track updatedTrack = trackRepository.save(track);
        return updatedTrack;
    }

    @Override
    public List<Track> getTrackByName(String trackName) {
        List<Track> gettrackByName = trackRepository.trackByName(trackName);
        return gettrackByName;
    }

    @Override
    public void removeTrackById(int trackId) {
        trackRepository.deleteById(trackId);
    }
}
