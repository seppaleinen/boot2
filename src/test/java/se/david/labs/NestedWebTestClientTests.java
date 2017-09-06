package se.david.labs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import se.david.labs.dto.SuperDto;

import java.util.stream.Stream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@DisplayName("Testing out WebTestClient")
class NestedWebTestClientTests {
    @Autowired
    private WebTestClient webClient;

    @Nested
    @DisplayName("Trying out testfactory")
    class Tests {
        @TestFactory
        Stream<DynamicTest> test() {
            return Stream.of("/", "/", "/").map(path ->
                    DynamicTest.dynamicTest("Test translate " + path, () ->
                            webClient.get().uri(path)
                                .exchange()
                                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                                .expectBody(SuperDto.class).isEqualTo(new SuperDto("Hello"))
                    )
            );
        }
    }

}
