package com.proxiel.testoffer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Spring Boot main class unit test.
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TestOfferApplication.class)
public class TestOfferApplicationTests {

    private String test = "test";

    @Test
    public void whenPropertyValueCalled_shouldReturnPropertyValue() {

        TestOfferApplication.main(new String[]{});
        assertEquals("test", test);
    }

}
