package ru.autqa.mantis.tests;

import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {



    @Test
    public void testRegistration () {
        app.registration().start("user1", "ser@gmail.com");
    }
}
