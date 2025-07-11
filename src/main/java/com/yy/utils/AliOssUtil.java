package com.yy.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/*********************************************************
 ** ali oss工具类
 ** <br><br>
 ** @ClassName: AliOssUtil
 ** @author: yangfeng
 ** @date: 2025/7/11 11:21
 ** @version: 1.0.0
 *********************************************************/
@Component
public class AliOssUtil {
    // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
    @Value("${aliyun.endpoint:https://oss-cn-beijing.aliyuncs.com}")
    private String ENDPOINT = "https://oss-cn-beijing.aliyuncs.com";
    @Value("${aliyun.uKeyId:1}")
    private String ACCESS_KEY_ID="LTAI5tDo5L5Xzx8vaHRxyFFB";
    @Value("${aliyun.uKeySecret:1}")
    private String ACCESS_KEY_SECRET="7Y68TzPJUzEZLslsmbvyENm5get9eZ";
    // 填写Bucket名称，例如examplebucket。
    @Value("${aliyun.bucketName:1}")
    private String BUCKET_NAME = "big-event";

    public String uploadFile(String objectName, InputStream in) throws Exception {


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT,ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        String url = "";
        try {
            // 填写字符串。
            String content = "Hello OSS，你好世界";

            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, in);

            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);

            // 上传字符串。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            //url组成: https://bucket名称.区域节点/objectName
            url = "https://"+BUCKET_NAME+"."+ENDPOINT.substring(ENDPOINT.lastIndexOf("/")+1)+"/"+objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        return url;
    }
}
