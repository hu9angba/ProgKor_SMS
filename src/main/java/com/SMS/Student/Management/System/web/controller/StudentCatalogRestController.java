package com.SMS.Student.Management.System.web.controller;

import com.SMS.Student.Management.System.data.SMS;
import com.SMS.Student.Management.System.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/song")
public class StudentCatalogRestController {
    /**
     * A REST controller for managing songs in the music catalog.
     */
    private final SMSService smsService;

        @Autowired
        public StudentCatalogRestController(SMSService smsService) {
            this.smsService = smsService;
        }

        /**
         * Returns a song with the given id.
         *
         * @param id the id of the song to retrieve
         * @return the song object
         */
        @GetMapping("/{id}")
        public ResponseEntity<SMS> getsongbyid  (@PathVariable Long id) {
            Optional<SMS> sms = smsService.retrieveSMSById (id);
            return sms.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        /**
         * Returns a list of all the songs in the catalog.
         *
         * @return the list of songs
         */
        @GetMapping
        public List<SMS> getAllSMS() {
            return smsService.retrieveAllSMS();
        }

        /**
         * Creates a new song and returns it.
         *
         * @param sms the song object to create
         * @return the created song object
         */
        @PostMapping
        public SMS createSong(@RequestBody SMS sms) {
            return smsService.createSMS(sms);
        }

        /**
         * Updates an existing song and returns it.
         *
         * @param sms the song object to update
         * @return the updated song object
         */
        @PutMapping
        public SMS updatesms (@RequestBody SMS sms) {
            return smsService.updateSMS(sms);
        }

        /**
         * Deletes a song by its id.
         *
         * @param id the id of the song to delete
         */
        @DeleteMapping("/{id}")
        public void deleteSongById(@PathVariable Long id) {
            smsService.deleteSMSById(id);
        }
    }
