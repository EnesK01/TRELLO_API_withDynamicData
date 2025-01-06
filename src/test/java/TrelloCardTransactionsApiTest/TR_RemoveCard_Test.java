package TrelloCardTransactionsApiTest;

import Authorization.Authorization;
import BaseUrlTrello.TrelloBaseUrlForCardTransactions;
import TestOutputDataForTrello.TestsResponsesControllerForEachRequestType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
curl --request DELETE \
  --url 'https://api.trello.com/1/cards/{id}?key=APIKey&token=APIToken'

 */
public class TR_RemoveCard_Test extends TrelloBaseUrlForCardTransactions {
     Authorization authorization=new Authorization();
     TestsResponsesControllerForEachRequestType testsResponsesControllerForEachRequestType =new TestsResponsesControllerForEachRequestType();

    public void RemoveCards(String[] cardlist){

         trelloCardTransactionsBaseUrl.pathParam("id",cardlist[0]);
         authorization.putApiKeyAndTokenQueryparamstoBaseUrl(trelloCardTransactionsBaseUrl);
         Response deleteCard=given().when().spec(trelloCardTransactionsBaseUrl).delete("/{id}");
         trelloCardTransactionsBaseUrl.pathParam("id",cardlist[1]);
         Response deleteSecondCard=given().when().spec(trelloCardTransactionsBaseUrl).delete("/{id}");

     }
}
