package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldShould {

    @Test
    void have_correct_message() {
        assertEquals("Hello World", HelloWorld.message());
    }
}
