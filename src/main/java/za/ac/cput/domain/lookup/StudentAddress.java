/**
 StudentAddress.java
 Entity for the StudentAddress
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */

package za.ac.cput.domain.lookup;

import za.ac.cput.domain.location.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class StudentAddress{

    @NotNull @Id
    private String studentId;
    @Embedded
    private Address address;


    public StudentAddress(Builder builder) {

        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    public String getStudentID() { return studentId; }

    public Address getAddress() {
        return address;
    }

    public static class Builder {

        private String studentId;
        private Address address;

        public StudentAddress.Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentAddress.Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public StudentAddress build() {
            return new StudentAddress(this);
        }

        public StudentAddress.Builder copy(StudentAddress studentAddress) {
            this.studentId = studentAddress.studentId;
            this.address = studentAddress.address;
            return this;

        }

        @Override

        public String toString() {
            return "StudentAddress{" +
                    "studentID='" + studentId + '\'' +
                    ", address ='" + address + '\'' +
                    '}';

        }
    }
}
