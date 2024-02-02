package bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static{
        hashMap.put("1", "tom");
        hashMap.put("2", "jack");
    }

    public String queryUserName(String uId){
        return hashMap.get(uId);
    }
}
