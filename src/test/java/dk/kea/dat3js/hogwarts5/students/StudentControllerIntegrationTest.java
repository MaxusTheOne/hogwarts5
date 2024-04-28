package dk.kea.dat3js.hogwarts5.students;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void createStudentWithFUllName() {
        webClient
                .post().uri("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("""
                        {
                            "name": "Peter Heronimus Lind",
                            "house": "Gryffindor",
                            "schoolYear": 7
                        }
                        """)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").exists()
                .jsonPath("$.firstName").isEqualTo("Peter")
                .jsonPath("$.middleName").isEqualTo("Heronimus")
                .jsonPath("$.lastName").isEqualTo("Lind")
                .jsonPath("$.fullName").isEqualTo("Peter Heronimus Lind")
                .jsonPath("$.house").isEqualTo("Gryffindor")
                .jsonPath("$.schoolYear").isEqualTo(7);
    }

    @Test
    void createStudentWithNameParts(){
        webClient
                .post().uri("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("""
                        {
                            "firstName": "Peter",
                            "middleName": "Heronimus",
                            "lastName": "Lind",
                            "house": "Gryffindor",
                            "schoolYear": 7
                        }
                        """)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().json("""
                        {
                            "firstName": "Peter",
                            "middleName": "Heronimus",
                            "lastName": "Lind",
                            "fullName": "Peter Heronimus Lind",
                            "house": "Gryffindor",
                            "schoolYear": 7
                        }

                         """);

    }
}
