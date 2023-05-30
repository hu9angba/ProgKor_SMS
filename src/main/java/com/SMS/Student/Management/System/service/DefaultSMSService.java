package com.SMS.Student.Management.System.service;
import com.SMS.Student.Management.System.data.*;
import com.SMS.Student.Management.System.repository.Repository;
import com.SMS.Student.Management.System.repository.InMemoryStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.SMS.Student.Management.System.repository.Repository;
import com.SMS.Student.Management.System.service.SMSService;
    /**
     * Default implementation of {@link SMSService}.
     */
    @Service
    public class DefaultSMSService implements SMSService {

        public final Repository <SMS, Long> SMSRepository;

        @Autowired
        public DefaultSMSService(Repository <SMS, Long> SMSRepository)
        {
            this.SMSRepository = SMSRepository;
        }

        @Override
        public SMS createSMS(SMS student) {
            return SMSRepository.save(student);
        }

        @Override
        public Optional<SMS> retrieveSMSById(Long id) {
            return SMSRepository.getById(id);
        }

        @Override
        public List<SMS> retrieveAllSMS() {
            return SMSRepository.getAll();
        }

        @Override
        public SMS updateSMS(SMS sms) {
            return SMSRepository.update( sms );
        }

        @Override
        public void deleteSMSById(Long id) {
            SMSRepository.deleteById(id);
        }
    }


