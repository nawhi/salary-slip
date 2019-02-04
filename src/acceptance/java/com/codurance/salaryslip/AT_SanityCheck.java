package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AT_SanityCheck {

    static {
        assert false;
    }

    @Test
    void blah() {
        assert false;
        assertEquals("Hello World", HelloWorld.message());
    }
}
