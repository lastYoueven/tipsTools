package org.example;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getAreaCode extends UDF {

    /**
     * 解析地址
     * @author lin
     * @param address
     * @return
     */
    public static String evaluate(String address){
        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|.*?区|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m=Pattern.compile(regex).matcher(address);
        String province=null,city=null,county=null,town=null,village=null;
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<String,String>();
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            county=m.group("county");
            row.put("county", county==null?"":county.trim());
            town=m.group("town");
            row.put("town", town==null?"":town.trim());
            village=m.group("village");
            row.put("village", village==null?"":village.trim());
        }
        System.out.println(row.get("city") != ""?
                row.get("city"):row.get("province"));
        return null;
    }
    public static void main(String[] args) {
        System.out.println(evaluate("重庆市渝北区人和镇龙湖水晶郦城1号附1号"));
    }
}