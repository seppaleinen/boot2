package se.david.labs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("Testing out junit5/spring integration")
@AutoConfigureMockMvc
class NestedSpringTests {
    @Autowired
    private MockMvc mvc;

    @Nested
    @DisplayName("Karl Pilkington")
    class KarlPilkingTon {
        @Test
        @DisplayName("A slug is always on its own. It's a lonely insect")
        void slug() throws Exception {
            mvc.perform(MockMvcRequestBuilders.get("/"))
                    .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("Hello"));
        }

        @Test
        @DisplayName("People who live in glass houses... have to answer the door")
        void glassHouses() throws Exception {
            mvc.perform(MockMvcRequestBuilders.get("/"))
                    .andExpect(MockMvcResultMatchers.header().string(HttpHeaders.CONTENT_TYPE, containsString("charset=UTF-8")))
                    .andExpect(MockMvcResultMatchers.header().string(HttpHeaders.CONTENT_TYPE, containsString(MediaType.APPLICATION_JSON_VALUE)));
        }
    }

    @Nested
    @DisplayName("DJ Khaled")
    class DjKhaled {
        @Test
        @DisplayName("Don't ever play yoself")
        void dontEverPlayYourself() {}
        @Test
        @DisplayName("Who U love?")
        void whoYouLove() {}
        @Test
        @DisplayName("Who yo friends love?")
        void WhoYourFriendsLove() {}
        @Test
        @DisplayName("Baby U smart")
        void babyYouSmart() {}
        @Test
        @DisplayName("U Loyal")
        void youLoyal() {}
    }

}
