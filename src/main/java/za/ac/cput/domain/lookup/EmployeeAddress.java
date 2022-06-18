/**
 EmployeeAddress.java
 Entity for the EmployeeAddress
 Author: Legiste Ndabashinze (217046207)
 Date: 12 June 2022
 */
package za.ac.cput.domain.lookup;

import za.ac.cput.domain.location.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class EmployeeAddress {
    @NotNull
    @Id
    private String staffId;
    @Embedded
    private Address address;

    protected EmployeeAddress() {
    }

    private EmployeeAddress(EmployeeAddressBuilder employeeAddressBuilder) {
        this.staffId = employeeAddressBuilder.staffId;
        this.address = employeeAddressBuilder.address;
    }

    public String getStaffId() {
        return staffId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", address=" + address +
                '}';
    }

    public static class EmployeeAddressBuilder{
        private String staffId;
        private Address address;

        public EmployeeAddressBuilder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public EmployeeAddressBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public EmployeeAddressBuilder copy(EmployeeAddress employeeAddress){
            this.staffId = employeeAddress.staffId;
            this.address = employeeAddress.address;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeAddress that = (EmployeeAddress) o;
            return staffId.equals(that.staffId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(staffId);
        }

        public EmployeeAddress build(){
            return new EmployeeAddress(this);
        }
    }
}
