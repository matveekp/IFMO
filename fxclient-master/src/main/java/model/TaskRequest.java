package model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class TaskRequest {

    private String url = "http://localhost:8080/tasks";

    // jakson
    private ObjectMapper mapper = new ObjectMapper(); // для работы jaskon библиотеки для формирования json
    // формирует из строчки обхект и наоброт. Чтобы он знал как, нужно указывать typereference
    private TypeReference<Task> taskType = new TypeReference<Task>() {
    };  // с помощью этих объектов будем указывать как формировать строчки из json
    private TypeReference<List<Task>> taskListType = new TypeReference<List<Task>>() {
    };

    //httpClient
    // обработчик ответа - сервер пришлет строчку, мы должны ее получить и обработать
    // когда придет ответ на запрос мы указываем адрес и обработчик этот
    private ResponseHandler<String> getResponseHandler() {
        return response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {

                HttpEntity entity = response.getEntity();
//                return entity != null ? EntityUtils.toString(entity) : null;  // можно так, вместо null можно что угодно
                return EntityUtils.toString(entity);
            } else {
                throw new ClientProtocolException("Status error " + status);
            }

        };
    }

    public Task postRequest(Task task) throws IOException {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url); //формируем объект запроса
            httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            String jsonTask = mapper.writeValueAsString(task); //формируем json строку из объекта
            httpPost.setEntity(new StringEntity(jsonTask));

            String responseBody = httpClient.execute(httpPost, getResponseHandler());

            return mapper.readValue(responseBody, taskType);

        }

    }

    public Task getRequest(int id) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url + "/" + id);
            String responseBody = httpClient.execute(httpGet, getResponseHandler());

            return mapper.readValue(responseBody, taskType);
        }

    }

    public List<Task> getRequest() throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            String responseBody = httpClient.execute(httpGet, getResponseHandler());

            return mapper.readValue(responseBody, taskListType);

        }

    }


}
