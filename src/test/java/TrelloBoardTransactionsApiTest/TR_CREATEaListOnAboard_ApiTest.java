package TrelloBoardTransactionsApiTest;

import Authorization.Authorization;
import BaseUrlTrello.TrelloBaseUrlForBoardTransactions;
import TestOutputDataForTrello.TestsResponsesControllerForEachRequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TR_CREATEaListOnAboard_ApiTest extends TrelloBaseUrlForBoardTransactions {
    Authorization authorization=new Authorization();
    TestsResponsesControllerForEachRequestType testsResponsesControllerForEachRequestType=new TestsResponsesControllerForEachRequestType();
    public String createAlist(String boardId){
        boardMainurlRequest.pathParam("idl",boardId);
        authorization.putApiKeyAndTokenQueryparamstoBaseUrl(boardMainurlRequest);
        boardMainurlRequest.queryParam("name","this is list");
        Response response=given().contentType(ContentType.JSON).when().spec(boardMainurlRequest).post("/{idl}/lists");
        String id=response.jsonPath().getString("id");
        testsResponsesControllerForEachRequestType.PostResponseBodyCheckandAssert(response);
        return id;

    }
}
