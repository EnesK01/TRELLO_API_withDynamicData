package BaseUrlTrello;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

;

public class TrelloBaseUrlForCardTransactions {
    protected RequestSpecification trelloCardTransactionsBaseUrl;


    public TrelloBaseUrlForCardTransactions() {
        trelloCardTransactionsBaseUrl = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1/cards")
                .build();
    }
}
