package exercises.filaC;
import apiTest.configuration.Configuration;
import apiTest.factoryRequest.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class Ejercicio2  extends  TestBaase{
    @Test
    public void create4UsersAndDeleteThem(){
        String user1 = "brenda@gmail.com";
        String user2 = "brend1a@gmail.com";
        String user3 = "brend2a@gmail.com";
        String user4 = "brend5a@gmail.com";
        String pass = "b123567";
        Configuration.setPassword(pass);

        JSONObject body = new JSONObject();
        body.put("Email",user1);
        body.put("FullName","Brenda");
        body.put("Password",pass);

        this.createUser(Configuration.host + "/api/user.json", body, post);
        int idU1 = response.then().extract().path("Id");
        System.out.println("id: " + idU1);

        JSONObject body2 = new JSONObject();
        body2.put("Email",user2);
        body2.put("FullName","Brenda");
        body2.put("Password",pass);

        this.createUser(Configuration.host + "/api/user.json", body2, post);
        int idU2 = response.then().extract().path("Id");

        JSONObject body3 = new JSONObject();
        body3.put("Email",user3);
        body3.put("FullName","Brenda");
        body3.put("Password",pass);

        this.createUser(Configuration.host + "/api/user.json", body3, post);
        int idU3 = response.then().extract().path("Id");

        JSONObject body4 = new JSONObject();
        body4.put("Email",user4);
        body4.put("FullName","Brenda");
        body4.put("Password",pass);

        this.createUser(Configuration.host + "/api/user.json", body4, post);
        int idU4 = response.then().extract().path("Id");

        Configuration.setUser(user1);
        this.readUser(idU1, get, body);

        Configuration.setUser(user2);
        this.readUser(idU2, get, body2);

        Configuration.setUser(user3);
        this.readUser(idU3, get, body3);

        Configuration.setUser(user4);
        this.readUser(idU4, get, body4);

        Configuration.setUser(user1);
        this.deleteUser(idU1,delete, body);

        Configuration.setUser(user2);
        this.deleteUser(idU2,delete, body2);

        Configuration.setUser(user3);
        this.deleteUser(idU3,delete, body3);

        Configuration.setUser(user4);
        this.deleteUser(idU4,delete, body4);
    }
    private void createUser(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }
    private void readUser(int idUser, String get, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/user/" + idUser + ".json");
        System.out.println("............................" + idUser);
        response = FactoryRequest.make(get).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }

    private void deleteUser(int idUser, String delete, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/user/" + idUser + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }
}