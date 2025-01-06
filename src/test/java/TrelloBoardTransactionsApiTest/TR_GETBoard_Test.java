package TrelloBoardTransactionsApiTest;

import Authorization.Authorization;
import BaseUrlTrello.TrelloBaseUrlForBoardTransactions;
import TestOutputDataForTrello.TestsResponsesControllerForEachRequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/*
curl --request GET \
  --url 'https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken' \
  --header 'Accept: application/json'
 */
public class TR_GETBoard_Test extends TrelloBaseUrlForBoardTransactions {
     Authorization authorization=new Authorization();
     TestsResponsesControllerForEachRequestType testsResponsesControllerForEachRequestType=new TestsResponsesControllerForEachRequestType();



    public void GetRequest(String id){
    boardMainurlRequest.pathParam("id",id);
    authorization.putApiKeyAndTokenQueryparamstoBaseUrl(boardMainurlRequest);
    Response response=given().contentType(ContentType.JSON).when().spec(boardMainurlRequest).get("/{id}");
    response.prettyPrint();
    testsResponsesControllerForEachRequestType.GetResponseBodyCheckandAssert(response);
}

}
