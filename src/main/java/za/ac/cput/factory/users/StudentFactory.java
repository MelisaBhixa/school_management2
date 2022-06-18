/**
 StudentFactory.java
 Entity for StudentFactory
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */

package za.ac.cput.factory.users;

import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.domain.users.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {

    public static Student newStudent(String studentId, String email, Name name) {
        Helper.checkStringParam("studentId", studentId);
        Helper.checkStringParam("email", email);

        return new Student.Builder().setStudentId(studentId).setEmail(email).setName(name).build();
    }
}
