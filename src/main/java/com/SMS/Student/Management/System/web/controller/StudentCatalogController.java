package com.SMS.Student.Management.System.web.controller;

import com.SMS.Student.Management.System.data.SMS;
import com.SMS.Student.Management.System.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/sms")
public class StudentCatalogController {
    /**
     * Controller for the music catalog.
     */
        private final SMSService smsService;

        @Autowired
        public StudentCatalogController(SMSService smsService) {
            this.smsService = smsService;
        }

        /**
         * Shows the song editor screen.
         *
         * @param model the model object to store attributes
         * @param id the id of the song to retrieve
         * @return the name of the edit view to render
         */
        @GetMapping("/{id}")
        public String getSMSById(Model model, @PathVariable Long id) {
            Optional<SMS> optionalSMS = smsService.retrieveSMSById(id);
            return optionalSMS.map(student -> {
                model.addAttribute("student", student);
                return "sms/edit";
            }).orElseGet(() -> {
                model.addAttribute("requestUri", "sms/" + id);
                return "sms/notFound";
            });
        }

        /**
         * Shows the song list screen.
         *
         * @param model the model object to store attributes
         * @return the name of the song list view to render
         */
        @GetMapping
        public String getAllSongs(Model model) {
            List<SMS> allSongs = smsService.retrieveAllSMS();
            model.addAttribute("songs", allSongs);
            return "sms/list";
        }

        /**
         * Shows the song creation screen.
         *
         * @return the name of the song creation view to render
         */
        @GetMapping("/create")
        public String createSms() {
            return "sms/create";
        }

        /**
         * Creates a new song.
         * Also navigates back to the editor screen.
         *
         * @param model the model object to store attributes
         * @param sms the song object to create
         * @return the name of the edit view to render
         */
        @PostMapping("/create")
        public String createSms(Model model, SMS sms) {
            SMS newsms = smsService.createSMS(sms);
            model.addAttribute("sms", newsms);
            return "sms/edit";
        }

        /**
         * Updates an existing song.
         * Also navigates back to the editor screen.
         *
         * @param model the model object to store attributes
         * @param sms the song object to update
         * @return the name of the edit view to render
         */
        @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        public String updateSMS(Model model, SMS sms) {
            SMS updateSMS = smsService.updateSMS(sms);
            model.addAttribute("sms", updateSMS);
            return "sms/edit";
        }

        /**
         * Deletes a song by ID.
         * Also navigates back to the song list screen.
         *
         * @param model the model object to store attributes
         * @param id the id of the song to delete
         * @return the name of the song list view to render
         */
        @GetMapping("/{id}/delete")
        public String deleteSongById(Model model, @PathVariable Long id) {
            smsService.deleteSMSById(id);
            List<SMS> allStudent  = smsService.retrieveAllSMS();
            model.addAttribute("student", allStudent);
            return "sms/list";
        }
    }



