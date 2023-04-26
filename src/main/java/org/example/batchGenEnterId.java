package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.io.IOUtils;

public class batchGenEnterId {
    public static void main(String[] input) {
        String hdfsOdsEnter = input[0];
        String odsEnter = hdfsOdsEnter == null ? "": hdfsOdsEnter;
        Configuration conf = new Configuration();
        try {
            // 创建HDFS文件系统对象
            FileSystem fs = FileSystem.get(conf);

            // 指定要读取的文件路径
            Path filePath = new Path("/path/to/your/file");

            // 检查文件是否存在
            if (!fs.exists(filePath)) {
                System.out.println("文件不存在");
                return;
            }

            // 打开文件输入流
            FSDataInputStream inputStream = fs.open(filePath);

            // 读取文件内容
            byte[] buffer = new byte[1024];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                // 处理读取的数据
                String data = new String(buffer, 0, bytesRead);
                System.out.println(data);
            }

            // 关闭输入流
            inputStream.close();
            // 关闭文件系统对象
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
