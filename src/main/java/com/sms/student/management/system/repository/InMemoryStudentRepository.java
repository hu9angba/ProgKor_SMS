package com.sms.student.management.system.repository;
import com.sms.student.management.system.data.sms;
import com.sms.student.management.system.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

    /**
     * Map-based in-memory implementation of {@link Repository}.
     */
    @org.springframework.stereotype.Repository
    public class InMemoryStudentRepository implements Repository< sms, Long> {

        private static final Map<Long, sms> STORAGE = new HashMap<>();

        @Override
        public sms save(sms student) {
            Long id = STORAGE.size() + 1L;
            student.setId(id);
            STORAGE.put(id, student);
            return STORAGE.get(id);
        }

        @Override
        public Optional<sms> getById(Long id) {
            return Optional.ofNullable(STORAGE.get(id));
        }

        @Override
        public List<sms> getAll() {
            return STORAGE.values().stream().toList();
        }

        @Override
        public sms update(sms student) {
            Long id = student.getId();
            STORAGE.put(id, student);
            return STORAGE.get(id);
        }

        @Override
        public void deleteById(Long id) {
            STORAGE.remove(id);
        }
    }


