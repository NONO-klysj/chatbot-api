package com.nonoklysj.chatbot.api.test;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import java.io.IOException;
/**
 * 单元测试
 */
public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpclient= HttpClientBuilder.create().build();
        HttpGet get=new HttpGet("https://api.zsxq.com/v2/groups/48884181224128/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","zsxq_access_token=2D1F7DC4-17AE-6621-919B-48675F6F418B_7E552B6967FFB38A; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415881848284848%22%2C%22first_id%22%3A%2218ba4b458c48f0-0c625393d743c68-4c657b58-2621440-18ba4b458c5b4b%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiYTRiNDU4YzQ4ZjAtMGM2MjUzOTNkNzQzYzY4LTRjNjU3YjU4LTI2MjE0NDAtMThiYTRiNDU4YzViNGIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU4ODE4NDgyODQ4NDgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415881848284848%22%7D%2C%22%24device_id%22%3A%2218ba4b458c48f0-0c625393d743c68-4c657b58-2621440-18ba4b458c5b4b%22%7D; abtest_env=product; zsxqsessionid=f3443371a8b3af504a9904b96f4e10e6");
        get.addHeader("Content-Type","application/json;charset=utf8");
        CloseableHttpResponse response= httpclient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res= EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }
        else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient=HttpClientBuilder.create().build();
        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/211242122844541/answer");
        post.addHeader("cookie","zsxq_access_token=2D1F7DC4-17AE-6621-919B-48675F6F418B_7E552B6967FFB38A; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415881848284848%22%2C%22first_id%22%3A%2218ba4b458c48f0-0c625393d743c68-4c657b58-2621440-18ba4b458c5b4b%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiYTRiNDU4YzQ4ZjAtMGM2MjUzOTNkNzQzYzY4LTRjNjU3YjU4LTI2MjE0NDAtMThiYTRiNDU4YzViNGIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU4ODE4NDgyODQ4NDgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415881848284848%22%7D%2C%22%24device_id%22%3A%2218ba4b458c48f0-0c625393d743c68-4c657b58-2621440-18ba4b458c5b4b%22%7D; abtest_env=product; zsxqsessionid=f3443371a8b3af504a9904b96f4e10e6");
        post.addHeader("Content-Type","application/json;charset=utf8");
        String paramJson="{\n" +
                "  \"text\": \"一会告诉你\\n\",\n" +
                "  \"image_ids\": []\n" +
                "}";
       StringEntity StringEntity= new StringEntity(paramJson, ContentType.create("text/json","UTF-8"));
       post.setEntity(StringEntity);
       CloseableHttpResponse response=httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res= EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }
        else{
            System.out.println( HttpStatus.SC_OK);
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
