package se.david.labs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("Testing out junit5/spring integration")
class DemoApplicationTests {

    @Nested
    @DisplayName("Karl Pilkington")
    class KarlPilkingTon {
        @Test
        @DisplayName("A slug is always on its own. It's a lonely insect")
        void slug() {}
        @Test
        @DisplayName("People who live in glass houses... have to answer the door")
        void glassHouses() {}
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
