package api_endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api_payload.Store;
import api_payload.User;

public class userEndpoints {
    public static Response createUser(User user) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .post(Routes.post_url);

        return response;
    }

    public static Response getUser(String userName) {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(Routes.get_url);

        return response;
    }

    public static Response updateUser(User user, String userName) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(user)
                .when()
                .put(Routes.post_url);

        return response;
    }

    public static Response createUser(String userName) {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(Routes.post_url);

        return response;
    }

    public static Response createStore(Store store) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(store)
                .when()
                .post(Routes.postStore);

        return response;
    }

    public static Response getStore() {
        Response response = given()
                .when()
                .get(Routes.getStore);

        return response;
    }
}
