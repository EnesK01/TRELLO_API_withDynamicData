package BaseUrlTrello;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/*curl --request GET \
        --url 'https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken' \
        --header 'Accept: application/json'

 */
public class TrelloBaseUrlForBoardTransactions {
    protected RequestSpecification boardMainurlRequest;


    public TrelloBaseUrlForBoardTransactions(){
        boardMainurlRequest=new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1/boards").build();
    }
}
