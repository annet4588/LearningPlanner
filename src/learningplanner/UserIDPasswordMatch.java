package learningplanner;

import java.util.HashMap;

public class UserIDPasswordMatch {
    HashMap<String, String> loginInfo = new HashMap<>();

    UserIDPasswordMatch(){
        loginInfo.put("Anna", "12345");
        loginInfo.put("Michael", "12345");
    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }

}
