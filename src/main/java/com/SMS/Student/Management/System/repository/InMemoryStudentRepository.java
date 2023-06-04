package com.SMS.Student.Management.System.repository;
import com.SMS.Student.Management.System.data.SMS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

    /**
     * Map-based in-memory implementation of {@link Repository}.
     */
    @org.springframework.stereotype.Repository
    public class InMemoryStudentRepository implements Repository< SMS, Long> {

        private static final Map<Long, SMS> STORAGE = new HashMap<>();

        @Override
        public SMS save(SMS student) {
            Long id = STORAGE.size() + 1L;
            student.setId(id);
            STORAGE.put(id, student);
            return STORAGE.get(id);
        }

        @Override
        public Optional<SMS> getById(Long id) {
            return Optional.ofNullable(STORAGE.get(id));
        }

        @Override
        public List<SMS> getAll() {
            return STORAGE.values().stream().toList();
        }

        @Override
        public SMS update(SMS student) {
            Long id = student.getId();
            STORAGE.put(id, student);
            return STORAGE.get(id);
        }

        @Override
        public void deleteById(Long id) {
            STORAGE.remove(id);
        }
    }


