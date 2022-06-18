package za.ac.cput.service.userInfo.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.factory.userInfo.NameFactory;
import za.ac.cput.service.userInfo.INameService;

import static org.junit.jupiter.api.Assertions.*;

class NameServiceTest {

    private final Name name = NameFactory.newName("Legiste","MiddleName","Ndabashinze");
    @Autowired
    private INameService nameService;

    @Order(1)
    @Test
    void save(){
        Name saved = this.nameService.save(this.name);
        assertEquals(this.name, saved);
        System.out.println(saved);
    }

}