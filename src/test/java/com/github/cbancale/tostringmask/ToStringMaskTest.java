package com.github.cbancale.tostringmask;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToStringMaskTest {
    @Test
    public void shouldMaskUserFields() {
        User user = new User("johndoe@example.com", "johndoe", "joe", "averysecurepassword",
                "anotherverysecurepassword",
                "123-45-6789", "sampledescription");

        String expected = "User [email=*******@example.com, userName=****doe, userName2=***, password=*******************, password2=*************************, ssn=***-**-6789, description=sampledescription]";

        assertEquals(expected, user.toString());
    }
}
