package com.sms.student.management.system.service;
import com.sms.student.management.system.data.*;
import com.sms.student.management.system.repository.Repository;
import com.sms.student.management.system.repository.InMemoryStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.sms.student.management.system.repository.Repository;
import com.sms.student.management.system.service.SMSService;
    /**
     * Default implementation of {@link SMSService}.
     */
    @Service
    public class DefaultSMSService implements SMSService {

        public final Repository <sms, Long> SMSRepository;

        @Autowired
        public DefaultSMSService(Repository <sms, Long> SMSRepository)
        {
            this.SMSRepository = SMSRepository;
        }

        @Override
        public sms createSMS(sms student) {
            return SMSRepository.save(student);
        }

        @Override
        public Optional<sms> retrieveSMSById(Long id) {
            return SMSRepository.getById(id);
        }

        @Override
        public List<sms> retrieveAllSMS() {
            return SMSRepository.getAll();
        }

        @Override
        public sms updateSMS(sms sms) {
            return SMSRepository.update( sms );
        }

        @Override
        public void deleteSMSById(Long id) {
            SMSRepository.deleteById(id);
        }
    }


