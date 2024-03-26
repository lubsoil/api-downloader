package pl.lubsoil.apidownloader.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lubsoil.apidownloader.model.Post;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Log
public class ApiDownloadService {

    private final String baseURI = "https://jsonplaceholder.typicode.com/";

    private RestTemplate restTemplate;

    public ApiDownloadService()
    {
        restTemplate = new RestTemplate();
    }

    public List<Post> getAllPosts()
    {
        try
        {
            ResponseEntity<Post[]> response
                    = restTemplate.getForEntity(baseURI + "/posts", Post[].class);

            Post[] posts = response.getBody();

            if(posts == null) return Collections.emptyList();

            log.info("Received " + posts.length + " posts");

            return Arrays.stream(posts).toList();
        }
        catch (Exception exception)
        {
            log.severe("Failed to download posts from API");

            return Collections.emptyList();
        }
    }

    public List<String> savePosts(List<Post> posts, String path)
    {
        File directory = new File(path);
        if(!directory.exists()){
            directory.mkdirs();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        posts.forEach(post -> {
            try {
                String filePath = path + "/" + post.id() + ".json";
                objectMapper.writeValue(new File(filePath),post);
            } catch (IOException e) {
                log.severe("Failed to create file for post of id: " + post.id());
                throw new RuntimeException(e);
            }
        });

        log.info("Saved " + posts.size() + " posts into JSON file");

        return posts.stream().map(post -> path + "/" + post.id() + ".json").toList();
    }
}
