package exercises.filaA;

import apiTest.configuration.Configuration;
import apiTest.factoryRequest.FactoryRequest;
import exercises.filaC.TestBaase;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class Ejercicio1 extends TestBaase{
    static Random rand = new Random();
    @Test
    public void createUserProjectDeleteUserCreateProject(){

        String user = "brenanjo@bka.com";
        String pass = "b12345678";

        JSONObject body = new JSONObject();
        body.put("Email",user);
        body.put("FullName","Brenda");
        body.put("Password",pass);

        // 1st - Create User
        this.createUser(Configuration.host + "/api/user.json", body, post);

        Configuration.setUser(user);
        Configuration.setPassword(pass);
        
        int idUser = response.then().extract().path("Id");

        // 2nd - Create Project
        JSONObject project = new JSONObject();
        project.put("Content","Proyecto creado");
        this.createProject(Configuration.host + "/api/projects.json", project, post);

        //3rd - Delete User
        this.deleteUser(idUser, "delete", body);

        // 4th - Create Project with the deleted user
        project.put("Content","Proyecto creado luego de la eliminación");
        this.createProjectWrong(Configuration.host + "/api/projects.json", project, post);


    }

    private void createUser(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }

    private void createProject(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }
    
    private void createProjectWrong(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("ErrorCode", equalTo(105));
    }

    private void deleteUser(int idUser, String delete, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/user/" + idUser + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }
}
