package com.sms.student.management.system.service;

import com.sms.student.management.system.data.sms;

import java.util.List;
import java.util.Optional;

public interface SMSService {


    /**
     * A service for managing songs in the music catalog.
     */


        /**
         * Creates a new song.
         *
         * @param sms the song to create
         * @return the created song
         */
        sms createSMS(sms sms);

        /**
         * Retrieves a song by its id.
         *
         * @param id the id of the song to retrieve
         * @return the retrieved song or empty optional if it was not found
         */
        Optional<sms> retrieveSMSById(Long id);

        /**
         * Retrieves all the songs in the catalog.
         *
         * @return the list of found songs
         */
        List<sms> retrieveAllSMS();

        /**
         * Updates an existing song.
         *
         * @param sms the song to update
         * @return the updated song
         */
        sms updateSMS(sms sms);

        /**
         * Deletes a song by its id.
         *
         * @param id the id of the song to delete
         */
        void deleteSMSById(Long id);
    }


