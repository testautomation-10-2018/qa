package pl.jsystems.qa.qaapi.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pl.jsystems.qa.qaapi.confiduration.Configuration;

public class Specifications {

    public static RequestSpecification requestSpecBuilder() {
        return new RequestSpecBuilder()
//                .addHeader()
                .setContentType(ContentType.JSON)
                .setBaseUri(Configuration.BASE_URL)
                .setBasePath("/v2")
                .build();
    }
}
