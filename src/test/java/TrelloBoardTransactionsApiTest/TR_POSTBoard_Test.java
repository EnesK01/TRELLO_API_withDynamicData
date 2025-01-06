package TrelloBoardTransactionsApiTest;

import Authorization.Authorization;
import BaseUrlTrello.TrelloBaseUrlForBoardTransactions;
import TestOutputDataForTrello.TestsResponsesControllerForEachRequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
/*
curl --request POST \
  --url 'https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken'
 */

public class TR_POSTBoard_Test extends TrelloBaseUrlForBoardTransactions {
    Authorization authorization=new Authorization();
    TestsResponsesControllerForEachRequestType testsResponsesControllerForEachRequestType=new TestsResponsesControllerForEachRequestType();


    public String PostRequest(){
       authorization.putApiKeyAndTokenQueryparamstoBaseUrl(boardMainurlRequest);
        boardMainurlRequest.queryParam("name","this is board");
        Response response=given().contentType(ContentType.JSON).when().spec(boardMainurlRequest).post();
        String id=response.jsonPath().getString("id");
        System.out.println(id);
        testsResponsesControllerForEachRequestType.PostResponseBodyCheckandAssert(response);
        return id;

    }


}
