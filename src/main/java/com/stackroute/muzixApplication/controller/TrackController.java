package com.stackroute.muzixApplication.controller;

import com.stackroute.muzixApplication.domain.Track;
import com.stackroute.muzixApplication.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *This is controller class which create object of TrackService class and
 * consume the methods of it.
 */
@RestController
@RequestMapping(value = "api/v1/")
public class TrackController {

    /* It instantiate the TrackService class so as to consume the
     * method of the same
     */
    private TrackService trackService;

    /*
     * Parameterized constructor to create TrackController instance.
     */
    @Autowired
    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    /*
     * This method provide user a mean to add new track in the database.
     */
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created new music track", HttpStatus.CREATED);
        }catch (Exception ex){
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    /*
     * This method provide user with all the track in the database.
     */
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTrack(){
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTrack(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable int trackId){
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity(trackService.getTrackById(trackId), HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("updateTrack")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity(trackService.updateTrack(track), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("trackRemove/{trackId}")
    public ResponseEntity<?> removeTrackById (@PathVariable int trackId){
        trackService.removeTrackById(trackId);
        return new ResponseEntity<String>("removed", HttpStatus.OK);
    }

    @GetMapping("/trackall/{trackName}")
    public ResponseEntity<?> gettrackByName(@PathVariable String trackName){
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity(trackService.getTrackByName(trackName), HttpStatus.OK);
        return responseEntity;
    }

}
