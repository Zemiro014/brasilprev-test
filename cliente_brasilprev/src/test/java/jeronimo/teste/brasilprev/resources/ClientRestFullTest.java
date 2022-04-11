package jeronimo.teste.brasilprev.resources;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import jeronimo.teste.brasilprev.factorObject.BuildObject;
import jeronimo.teste.brasilprev.restfull.ClientRestFull;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
@TestHTTPEndpoint(ClientRestFull.class)
public class ClientRestFullTest {

//    @Test
//    public void testFindAllClients(){
//        when().get()
//                .then()
//                .statusCode(200);
//    }

//    @Test
//    public void testFindClientById(){
//        when().get("b07e0b20-b7b4-11ec-aa42-bb7fafee3cf6")
//                .then()
//                .statusCode(200)
//                .body(notNullValue());
//    }
//    @Test
//    public void testClientByIdNotFound(){
//        when().get("b07e0b20-b7b4-11ec-aa42-bb7fafee3cf65")
//                .then()
//                .statusCode(400)
//                .body(notNullValue());
//    }

    @Test
    public void testCreateNewClient(){
        RestAssured.given()
                .contentType("application/json")
                .body(new BuildObject().createClientRequestTO())
                .when()
                .post()
                .then()
                .statusCode(201);
    }
}
