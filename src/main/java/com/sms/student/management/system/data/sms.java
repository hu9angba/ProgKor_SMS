package com.sms.student.management.system.data;

import java.util.Objects;

public class sms {

    /**
     * Model class for Students.
     */

        private Long id;
        private String name;
        private String subject;
        private String grade;


        public sms() {
        }

        public sms(Long id, String name, String subject, String grade) {
            this.id = id;
            this.name = name;
            this.subject = subject;
            this.grade = grade;

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject (String subject) {
            this.subject = subject;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String album) {
            this.grade = grade;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            sms sms = (sms) o;

            if (!Objects.equals(id, sms.id)) {
                return false;
            }
            if (!Objects.equals(name, sms.name)) {
                return false;
            }
            if (!Objects.equals(subject, sms.subject)) {
                return false;
            }
            if (!Objects.equals(grade, sms.grade)) {
                return false;
            }
            return grade == sms.grade;
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (subject != null ? subject.hashCode() : 0);
            result = 31 * result + (grade != null ? grade.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Song{"
                    + "id=" + id
                    + ", nev='" + name + '\''
                    + ", tantargy='" + subject + '\''
                    + ", jegy='" + grade + '\''
                    + '}';
        }
    }

