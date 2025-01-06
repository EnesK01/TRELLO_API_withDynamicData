package TestOutputDataForTrello;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class TestsResponsesControllerForEachRequestType {

//dinamik data süreçleri olmadığı için bazı assertionlar yorum satırına alındı. Bu durum düzeltildiğinde birden fazla assertion type kullanılabilir.
    public void GetResponseBodyCheckandAssert(Response response){
        Assert.assertEquals(response.getStatusCode(),200);

    }
    public void PostResponseBodyCheckandAssert(Response response){
        response.then().assertThat().statusCode(200).body("id",Matchers.notNullValue());


    }
    public void PutResponseBodyCheckandAssert(Response response) {
        response.then().assertThat().statusCode(200);

    }
    public void DeleteResponseBodyCheckandAssert(Response response){
        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);

    }
}
