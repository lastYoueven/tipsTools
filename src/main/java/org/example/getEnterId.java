package org.example;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import java.text.SimpleDateFormat;
import java.util.Date;
public class getEnterId extends UDF {
    public static Long evaluate(String[] input) {
        String enterpriseName = input[0];
        String regionCode = input[1];
        if (regionCode == null || StringUtils.isBlank(enterpriseName)) {
            System.out.println("缺失参数：companyName  和  regionCode");
            return null;
        }
        enterpriseName = enterpriseName.trim();
        String regionCodeStr = String.valueOf(regionCode);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String currentTime = sdf.format(new Date()).substring(sdf.format(new Date()).length() - 12);
        if (regionCodeStr.length() == 6) {
            String id = new StringBuilder().append(regionCodeStr, 0, 2)
                    .append(currentTime)
                    .append(StringUtils.reverse(String.valueOf(Math.abs(enterpriseName.hashCode()))), 0, 5).toString();
            Long enterid = Long.parseLong(id);
            System.out.println(enterpriseName + ":" + enterid);
            return enterid;
        }
        return null;
    }
}

