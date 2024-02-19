package api_test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api_endpoints.userEndpoints;
import api_payload.Store;
import api_payload.User;
import io.restassured.response.Response;

public class UserTests {
    Faker faker;
    User user;
    Store store;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        user = new User();

        user.setId(faker.idNumber().hashCode());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setUserName(faker.name().username());
        user.setEmail(faker.internet().safeEmailAddress());
        user.setPassword(faker.internet().password(5, 10));
        user.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostUser() {
        Response response = userEndpoints.createUser(user);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testGetUser() {
        Response response1 = userEndpoints.getUser(this.user.getUserName());
        response1.then().log().all();

        Assert.assertEquals(response1.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void testUpdateUser() {

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setUserName(faker.name().username());

        Response response2 = userEndpoints.updateUser(user, this.user.getUserName());
        response2.then().log().all();

        Assert.assertEquals(response2.getStatusCode(), 200);
    }

    @Test
    public void testPostStore() {
        store = new Store();
        store.setComplete(true);
        store.setId(1);
        store.setPetId(2);
        store.setQuantity(5);
        store.setStatus("delivered");
        store.setShipDate("2023-10-19T05:28:27.340Z");

        Response response = userEndpoints.createStore(store);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getStoreData() {
        Response response = userEndpoints.getStore();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
