package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void result_should_have_success(){
        Result<Integer> result = Result.success(42);
        assertTrue(result.isSuccess());
        assertEquals(42, result.value());
    }

}