package TrelloCardTransactionsApiTest;

import Authorization.Authorization;
import BaseUrlTrello.TrelloBaseUrlForCardTransactions;
import TestOutputDataForTrello.TestsResponsesControllerForEachRequestType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

/*
curl --request GET \
  --url 'https://api.trello.com/1/cards/{id}?key=APIKey&token=APIToken' \
  --header 'Accept: application/json'
 */
public class TR_GetCard_Test extends TrelloBaseUrlForCardTransactions {
    Authorization authorization=new Authorization();
    TestsResponsesControllerForEachRequestType testsResponsesControllerForEachRequestType =new TestsResponsesControllerForEachRequestType();
    @Test
    public void test(){
        trelloCardTransactionsBaseUrl.pathParam("id","67728582a447f88de2890ca8");
        authorization.putApiKeyAndTokenQueryparamstoBaseUrl(trelloCardTransactionsBaseUrl);
        Response getCard=given().when().spec(trelloCardTransactionsBaseUrl).get("/{id}");
       testsResponsesControllerForEachRequestType.GetResponseBodyCheckandAssert(getCard);
       getCard.prettyPrint();
    }
}
