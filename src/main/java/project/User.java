package project;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class User {

    private static final String CREATE_USER = "/api/auth/register";
    private static final String LOGIN_USER = "/api/auth/login";
    private static final String USER_USER = "/api/auth/user";
    Configuration configuration = new Configuration();
    private String email;
    private String password;
    private String name;
    private String token;
    public User(String email, String password, String name, String token) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.token = token;
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User() {
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Step("Create User")
    public ValidatableResponse createUser(User user) {
        ValidatableResponse response = given()
                .spec(configuration.getSpecification())
                .body(user)
                .when()
                .post(CREATE_USER)
                .then();
        user.setToken(response.extract().path("accessToken"));
        return response;
    }
    @Step("Authorize User")
    public ValidatableResponse loginUser(User user) {
        ValidatableResponse response = given()
                .spec(configuration.getSpecification())
                .body(user)
                .when()
                .post(LOGIN_USER)
                .then();
        user.setToken((response.extract().path("accessToken")));
        return response;
    }
    @Step("Delete user")
    public ValidatableResponse deleteUser(User user) {
        return given()
                .spec(configuration.getSpecification())
                .header("Authorization", user.getToken())
                .delete(USER_USER + "user")
                .then();
    }
}