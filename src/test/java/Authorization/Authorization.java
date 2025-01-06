package Authorization;

import io.restassured.specification.RequestSpecification;

public class Authorization {
protected  String apikey="450119ab21d86b84eff11b09be7465a8";
protected  String token="ATTA41d5a90c3a9a4edf07a06c0e5299dba3d71b3c4fcd18636d1096fe9bb341c0b1FF37D1C7";
    public void putApiKeyAndTokenQueryparamstoBaseUrl(RequestSpecification specification){
        specification.queryParams("key",apikey,
                "token",token);

    }
}
