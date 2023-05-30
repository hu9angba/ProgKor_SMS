package com.SMS.Student.Management.System.service;

import com.SMS.Student.Management.System.data.SMS;

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
        SMS createSMS(SMS sms);

        /**
         * Retrieves a song by its id.
         *
         * @param id the id of the song to retrieve
         * @return the retrieved song or empty optional if it was not found
         */
        Optional<SMS> retrieveSMSById(Long id);

        /**
         * Retrieves all the songs in the catalog.
         *
         * @return the list of found songs
         */
        List<SMS> retrieveAllSMS();

        /**
         * Updates an existing song.
         *
         * @param sms the song to update
         * @return the updated song
         */
        SMS updateSMS(SMS sms);

        /**
         * Deletes a song by its id.
         *
         * @param id the id of the song to delete
         */
        void deleteSMSById(Long id);
    }


