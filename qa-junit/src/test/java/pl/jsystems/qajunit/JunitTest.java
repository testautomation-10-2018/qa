package pl.jsystems.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("To jest nasza klasa testowa")
public class JunitTest {
    String testowyString;

    
    
    @BeforeEach
    void before() {
        System.out.println("======================Before each");
        testowyString = "testowyString";

    }

    @AfterEach
    void afterEach() {
        System.out.println("===================AfterEach");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("===================Before all");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("===================After all");

    }

    @Test
    @DisplayName("To jest nasz peirwszy test")
    public void firstTest() {
        System.out.println(0.2 * 0.2);
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
//        assertTrue((0.2 * 0.2) == 0.04);

    }



    @RepeatedTest(5)
    @Test
    @DisplayName("To jest nasz stringowy test")
    public void testStringa() {
        assertEquals("testowyString", testowyString);

        assertThat(testowyString, containsString("Strin"));
        assertThat(testowyString, equalTo("testowyString"));
        assertThat(testowyString, endsWith("ing"));

    }


//    @Test
//    public void testStringa2() {
//        assertAll(() -> {
////                    assertEquals("testowyString", testowyString);
////                    assertThat(testowyString, containsString("StrinDDDD"));
////                    assertThat(testowyString, equalTo("testowyString"));
////                    assertThat(testowyString, endsWith("inSSSSgS"));
//            assertThat(testowyString).contains("rin");
//            assertThat(testowyString).contains("BBBBBB");
//            assertThat(testowyString).isEmpty();
//            assertThat(testowyString).isEqualTo(testowyString);
//            assertThat(testowyString).contains("dddd");
//                }
//
//        );
//
//    }

}
