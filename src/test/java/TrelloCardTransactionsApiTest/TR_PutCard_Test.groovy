package TrelloCardTransactionsApiTest

import Authorization.Authorization
import BaseUrlTrello.TrelloBaseUrlForCardTransactions
import TestOutputDataForTrello.TestsResponsesControllerForEachRequestType
import io.restassured.http.ContentType
import io.restassured.response.Response
import org.junit.Test

/*
curl --request PUT \
  --url 'https://api.trello.com/1/cards/{id}?key=APIKey&token=APIToken' \
  --header 'Accept: application/json'
 */

class TR_PutCard_Test extends TrelloBaseUrlForCardTransactions {
    Authorization authorization=new Authorization();
    TestsResponsesControllerForEachRequestType testsResponsesControllerForEachRequestType=new TestsResponsesControllerForEachRequestType();

    public void UpdateCardName(String RandomCard) {

    trelloCardTransactionsBaseUrl.pathParam("id",RandomCard);
        trelloCardTransactionsBaseUrl.queryParam("name","I updated card name");
        authorization.putApiKeyAndTokenQueryparamstoBaseUrl(trelloCardTransactionsBaseUrl);
        Response Updatecard=io.restassured.RestAssured.given().contentType(ContentType.JSON).when().spec(trelloCardTransactionsBaseUrl).put("/{id}");
        testsResponsesControllerForEachRequestType.PutResponseBodyCheckandAssert(Updatecard);


    }
}
