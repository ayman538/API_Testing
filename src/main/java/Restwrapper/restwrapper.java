package Restwrapper;

import java.util.Map;
import java.util.Properties;
import Enum.EndPoints;
import static Helper.PropertiesLoader.readPropertyFile;
import static io.restassured.RestAssured.given;

public class restwrapper {

    private static final Properties urlProps = readPropertyFile("config/api-url.properties");

    public static <T> T restGet(EndPoints endpoint, Map<String, String> headers, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .get(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()))
                .then()
                .extract()
                .as(responseClass);
    }

    public static <T> T restPost(EndPoints endpoint, Map<String, String> headers, Object bodyData, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(bodyData)
                .when()
                .post(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()))
                .then()
                .extract()
                .as(responseClass);
    }

    public static <T> T restPut(EndPoints endpoint, Map<String, String> headers, String Path,Object bodyData, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(bodyData)
                .when()
                .put(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()).concat(Path))
                .then()
                .extract()
                .as(responseClass);
    }

    public static <T> T restDelete(EndPoints endpoint, Map<String, String> headers,String Path ,Object bodyData, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(bodyData)
                .when()
                .delete(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()).concat(Path))
                .then()
                .extract()
                .as(responseClass);
    }
}
