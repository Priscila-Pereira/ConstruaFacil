package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class User {
    String uri = "https://petstore.swagger.io/v2/user";
    int userId = 2124;
    String username = "ppri";
    String password = "senha";
    String token = "";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

@Test
    public void incluirUser() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/user.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(Integer.toString(userId)))


        ;
}
@Test
    public void consultarUser(){

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(2124))
                .body("username", is("ppri"))
                .body("firstName", is("priscila"))
                .body("lastName", is("silva"))
                .body("email", is("priscila.pereira_silva@hotmail.com"))
                .body("password", is("senha"))
                .body("phone", is("5511999998888"))
                .body("userStatus", is(0))



        ;
}
@Test
    public void alterarUser() throws IOException {
    String jsonBody = lerJson("src/test/resources/data/newuser.json");

    given()
            .contentType("application/json")
            .log().all()
            .body(jsonBody)
    .when()
            .put(uri)
    .then()
            .log().all()
            .statusCode(200)
            .body("code", is(200))
            .body("type", is("unknown"))
            .body("message", is(Integer.toString(userId)))
    ;
}
@Test
    public void excluirUser(){

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + userId)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(Integer.toString(userId)))
    ;

}
@Test
public void login(){

        String mensagem =
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/login?username=" + username + "&password=" + password)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
        .extract()
                .path("message")
        ;
        System.out.println("A mensagem é: " + mensagem);
        token = mensagem.substring(24);
        System.out.println("o token é: " + token);

}


}
