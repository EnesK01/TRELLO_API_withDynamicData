package AllSteps;

import TrelloBoardTransactionsApiTest.TR_CREATEaListOnAboard_ApiTest;
import TrelloBoardTransactionsApiTest.TR_DELETEBoard_Test;
import TrelloBoardTransactionsApiTest.TR_GETBoard_Test;
import TrelloBoardTransactionsApiTest.TR_POSTBoard_Test;
import TrelloCardTransactionsApiTest.TR_PostCard_Test;
import TrelloCardTransactionsApiTest.TR_PutCard_Test;
import TrelloCardTransactionsApiTest.TR_RemoveCard_Test;
import org.testng.annotations.Test;

import java.util.Random;

public class E2EAPİ {
     TR_GETBoard_Test tr_getBoard_test=new TR_GETBoard_Test();
     TR_POSTBoard_Test tr_postBoard_test=new TR_POSTBoard_Test();
     TR_PostCard_Test tr_postCard_test=new TR_PostCard_Test();
     TR_PutCard_Test tr_putCard_test=new TR_PutCard_Test();
     TR_RemoveCard_Test tr_removeCard_test=new TR_RemoveCard_Test();
     TR_CREATEaListOnAboard_ApiTest tr_creatEaListOnAboard_apiTest=new TR_CREATEaListOnAboard_ApiTest();
     TR_DELETEBoard_Test tr_deleteBoard_test=new TR_DELETEBoard_Test();
     @Test
    public void alltest() throws InterruptedException {
         String boardid=tr_postBoard_test.PostRequest();
         tr_getBoard_test.GetRequest(boardid);
         Thread.sleep(5000);
         String listid=tr_creatEaListOnAboard_apiTest.createAlist(boardid);
         Thread.sleep(5000);
        String[] cardIds=tr_postCard_test.makeCard(listid);
        String firstCardid=cardIds[0];
        String secondCardid=cardIds[1];
         Thread.sleep(5000);
         Random random = new Random();
         int randomIndex = random.nextInt(cardIds.length);
         String randomCard = cardIds[randomIndex];
         tr_putCard_test.UpdateCardName(randomCard);
         Thread.sleep(5000);
         tr_removeCard_test.RemoveCards(cardIds);
         Thread.sleep(5000);
         tr_deleteBoard_test.DeleteRequest(boardid);
         Thread.sleep(5000);




     }
}
