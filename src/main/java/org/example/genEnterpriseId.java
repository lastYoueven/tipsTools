//package org.example;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.client.Get;
//import org.apache.hadoop.hbase.client.HTable;
//import org.apache.hadoop.hbase.client.Result;
//import org.apache.hadoop.hbase.util.Bytes;
//
//import java.io.IOError;
//import java.io.IOException;
//
//public class genEnterpriseId {
//    public static Configuration getConf(){
//        Configuration config = HBaseConfiguration.create();
//        config.set("hbase.zookeeper.quorum", "localhost");
//        config.set("hbase.zookeeper.property.clientPort", "2181");
//        return config;
//    }
//
//    public static String genId() throws IOException {
//        HTable table = new HTable(getConf(), "enterprise_base_info");
//        Get get = new Get(Bytes.toBytes(rowkey));
//        Result result = table.get(get);
//        return null;
//    }
//
//    public static void main(String[] args) {
//    }
//}
