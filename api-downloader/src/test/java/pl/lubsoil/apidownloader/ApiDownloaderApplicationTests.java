package pl.lubsoil.apidownloader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lubsoil.apidownloader.model.Post;
import pl.lubsoil.apidownloader.service.ApiDownloadService;

import java.io.File;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class ApiDownloaderApplicationTests {
	

	@Test
	void savePost() {
		/*File testJson = new File("C:/Users/emil0/OneDrive/Documents/Test/123.json");
		if(testJson.exists()){
			testJson.delete();
		}

		List<Post> postToSave = Collections.singletonList(new Post(123,123,"test","test"));
		apiDownloadService.savePosts(postToSave, "C:/Users/emil0/OneDrive/Documents/Test");

		assert( (new File("C:/Users/emil0/OneDrive/Documents/Test/123.json")).exists() );*/
	}

}
