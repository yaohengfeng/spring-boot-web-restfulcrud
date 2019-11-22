package com.yhf.springboot.utlis;

import java.util.HashMap;
import java.util.Map;

public class UserInfoUtil {
    public static Map<String,String> toBean(String resultInfo){
        resultInfo=resultInfo.replace("{","").replace("}","");
        String []args=resultInfo.split(",");

        Map<String,String> map=new HashMap<>();
        for (int i=0;i<args.length;i++){
            String key=args[i].substring(0,args[i].indexOf(":")).replace("\"","");
            String value=args[i].substring(args[i].indexOf(":")+1,args[i].length()).replace("\"","");
            //System.out.println("key:"+key+",value"+value);
            map.put(key,value);
            //System.out.println(map);
            //System.out.println(map.get("openid"));
        }
        return map;
    }
}
