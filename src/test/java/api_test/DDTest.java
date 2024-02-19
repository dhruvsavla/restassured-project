package api_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api_endpoints.userEndpoints;
import api_payload.User;
import api_utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userId, String userName, String fname, String lname, String useremail, String pwd,
            String ph) {
        User user = new User();
        if (userId == null || userId.trim().isEmpty()) {
            // Handle null or empty userId
            System.out.println("Skipping test with null or empty userId.");
            return;
        }

        try {
            // Parse userId to integer
            int parsedUserId = Integer.parseInt(userId);
            user.setId(parsedUserId);
            // Rest of your test logic
            // ...
        } catch (NumberFormatException e) {
            // Handle NumberFormatException (invalid userId)
            System.out.println("Invalid userId format: " + userId);
            // Log the exception if needed: e.printStackTrace();
        }

        user.setUserName(userName);
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setEmail(useremail);
        user.setPassword(pwd);
        user.setPhone(ph);

        Response response = userEndpoints.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 200);

    }

}
