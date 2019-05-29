import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        String url = "http://localhost:8080/courses";

        //настраиваем авторизацию по логин и паролю
        String authData = Credentials.basic("admin", "12345678");
        System.out.println(authData);


        //параметризированный запрос
//        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder(); //http://localhost:8080/courses
//        builder.addQueryParameter("title", "Java");      //http://localhost:8080/courses?title=Java


        Request request = new Request.Builder()
                .addHeader("Authorization", authData)
                .url(url)
                .build();




        client.newCall(request).enqueue(new Callback() {
            //когда запрос будет отправлен и придет ответ, отработает один из двух методов

            public void onFailure(Call call, IOException e) {
                    e.printStackTrace();


            }
            public void onResponse(Call call, Response response) throws IOException {
                String responseBody = response.body().string();         // получаем ответ(тело сообщения body) из response
                System.out.println(responseBody);

                ObjectMapper objectMapper = new ObjectMapper(); //читаем из JSON строчки данные
                List<Course> courseList = objectMapper.readValue(responseBody, new TypeReference<List<Course>>() {});

                System.out.println(courseList);
                System.out.println(courseList.get(0).getTitle());


            }
        });




    }

}
