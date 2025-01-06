package TrelloBoardTransactionsApiTest;

import Authorization.Authorization;
import BaseUrlTrello.TrelloBaseUrlForBoardTransactions;
import TestOutputDataForTrello.TestsResponsesControllerForEachRequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/*
6777e5a5e58ab326fbe9c98e
curl --request DELETE \
  --url 'https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken'
 */
public class TR_DELETEBoard_Test extends TrelloBaseUrlForBoardTransactions {
    Authorization authorization=new Authorization();
    TestsResponsesControllerForEachRequestType testsResponsesControllerForEachRequestType=new TestsResponsesControllerForEachRequestType();

    public void DeleteRequest(String BoardId){
        boardMainurlRequest.pathParam("id",BoardId);
        authorization.putApiKeyAndTokenQueryparamstoBaseUrl(boardMainurlRequest);
        Response response=given().contentType(ContentType.JSON).when().spec(boardMainurlRequest).delete("/{id}");
        testsResponsesControllerForEachRequestType.DeleteResponseBodyCheckandAssert(response);

    }
}
