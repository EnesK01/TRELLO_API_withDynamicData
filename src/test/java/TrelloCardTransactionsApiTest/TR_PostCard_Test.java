package TrelloCardTransactionsApiTest;

import Authorization.Authorization;
import BaseUrlTrello.TrelloBaseUrlForCardTransactions;
import TestOutputDataForTrello.TestsResponsesControllerForEachRequestType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/*
curl --request POST \
  --url 'https://api.trello.com/1/cards?idList=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken' \
  --header 'Accept: application/json'
 */
public class TR_PostCard_Test extends TrelloBaseUrlForCardTransactions {
    Authorization authorization = new Authorization();
    TestsResponsesControllerForEachRequestType testsResponsesControllerForEachRequestType = new TestsResponsesControllerForEachRequestType();


    public String[] makeCard(String idList) {

        trelloCardTransactionsBaseUrl.queryParam("idList", idList);
        authorization.putApiKeyAndTokenQueryparamstoBaseUrl(trelloCardTransactionsBaseUrl);
        trelloCardTransactionsBaseUrl.queryParam("name", "this is a new card");
        Response createCard = given().contentType(ContentType.JSON).spec(trelloCardTransactionsBaseUrl).header("Accept", "application/json").post();
        testsResponsesControllerForEachRequestType.PostResponseBodyCheckandAssert(createCard);
        Response createOneMoreCard = given().contentType(ContentType.JSON).spec(trelloCardTransactionsBaseUrl).header("Accept", "application/json").post();
        testsResponsesControllerForEachRequestType.PostResponseBodyCheckandAssert(createOneMoreCard);

        String cardId = createCard.jsonPath().getString("id");
        String SecondcardId = createOneMoreCard.jsonPath().getString("id");
    String[] cardidList={cardId,SecondcardId};
    cardidList[0]=cardId;
    cardidList[1]=SecondcardId;
    return cardidList;
    }

}
