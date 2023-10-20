package exercises.filaC;
import apiTest.configuration.Configuration;
import apiTest.factoryRequest.FactoryRequest;
import apiTest.factoryRequest.RequestInfo;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class Ejercicio1 extends TestBaase {
    @Test
    public void createUserTokenProjectDeleteTokenCreateProject() {
        String user = "Brenda@gmai.com";
        String pass = "bren12345678";

        JSONObject body = new JSONObject();
        body.put("Email", user);
        body.put("FullName", "Brenda");
        body.put("Password", pass);

        // 1st - Create User
        this.createUser(Configuration.host + "/api/user.json", body, post);

        Configuration.setUser(user);
        Configuration.setPassword(pass);

        // 2nd - Create Token
        this.createToken();

        // 3rd - Create Item with the Token
        JSONObject item = new JSONObject();
        item.put("Content", "Item creado");
        this.createItem(Configuration.host + "/api/items.json", item, post);

        // 4th - Delete Token
        this.deleteToken();

        // 5th - Create Item with the deleted Token
        item.put("Content", "Item nuevo");
        this.createItemWrong(Configuration.host + "/api/items.json", item, post);

    }

    private void createUser(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }

    private void createItem(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).sendWithToken(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void createItemWrong(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).sendWithToken(requestInfo);
        response.then().statusCode(200).
                body("ErrorCode", equalTo(102));
    }

    private void createToken(){
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setUrl(Configuration.token);
        response = FactoryRequest.make(get).send(requestInfo);
        Configuration.tokenValue = response.then()
                .extract()
                .path("TokenString");
    }

    private void deleteToken(){
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setUrl(Configuration.token);
        response = FactoryRequest.make(delete).send(requestInfo);
        Configuration.tokenValue = "";
    }
}