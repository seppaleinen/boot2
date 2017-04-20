package se.david;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DemoApplicationTests {

    @Nested
    @DisplayName("YAY")
    public class NestedClass {
        @Test
        public void contextLoads() {
        }
    }

}
