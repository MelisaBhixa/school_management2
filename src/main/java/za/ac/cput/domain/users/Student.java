/**
 Student.java
 Entity for the Student
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */

package za.ac.cput.domain.users;

import za.ac.cput.domain.userInfo.Name;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

    @NotNull @Id
    private String studentId;
    private String email;
    @Embedded
    private Name name;

    protected Student (){}

    public Student(Student.Builder builder) {

        this.studentId = builder.studentId;
        this.email = builder.email;
        this.name = builder.name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public Name getName(){
        return name;
    }

    public static class Builder {

        private String studentId;
        private String email;
        private Name name;

        public Student.Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Student.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Student.Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

        public Student.Builder copy(Student student) {
            this.studentId = student.studentId;
            this.email = student.email;
            this.name = student.name;
            return this;

        }

        @Override

        public String toString() {
            return "StudentAddress{" +
                    ", name ='" + name + '\'' +
                    "studentId='" + studentId + '\'' +
                    ", email ='" + email + '\'' +
                    '}';

        }
    }
}
