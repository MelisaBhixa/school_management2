/**
 StudentAddressFactory.java
 Entity for StudentAddressFactory
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */

package za.ac.cput.factory.lookup;

import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.lookup.StudentAddress;
import za.ac.cput.util.Helper;

public class StudentAddressFactory {

    public static StudentAddress newStudentAddress(String studentId, Address address){
        Helper.checkStringParam("studentId", studentId);
        Helper.isObjectNull(address);

        return new StudentAddress.Builder().setStudentId(studentId).setAddress(address).build();


    }
}
