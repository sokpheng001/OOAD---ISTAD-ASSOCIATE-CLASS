package collectionframework;

import java.util.Map;
import java.util.TreeMap;

record UserInfo(
        Integer id,
        String name,
        String email
){}
public class MapCollectionDemo {
    public static void main(String[] args) {
        Map<String, UserInfo> userInfoMap = new TreeMap<>();
        userInfoMap.put("user",
                new UserInfo(1,"jame","jame123@gmail.com"));
        userInfoMap.put("admin",
                new UserInfo(8888,  "admin-root",null));
        userInfoMap.get("admin"); // object of admin key
        for(Map.Entry<String, UserInfo> u : userInfoMap.entrySet()){
            System.out.println(u);
        }
        System.out.println();
     }
}
