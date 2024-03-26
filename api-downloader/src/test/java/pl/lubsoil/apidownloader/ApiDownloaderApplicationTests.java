package pl.lubsoil.apidownloader;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lubsoil.apidownloader.model.Post;
import pl.lubsoil.apidownloader.service.ApiDownloadService;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Log
class ApiDownloaderApplicationTests {

	ApiDownloadService apiDownloadService;

	@BeforeAll
	static void setup() {
		log.info("Cleaning test files");

		String defaultPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

		File testJson = new File(defaultPath+"/Test/123.json");
		if(testJson.exists()){
			testJson.delete();
		}
	}

	@Test
	void saveTestPost() {
		ApiDownloadService apiDownloadService = new ApiDownloadService();

		String defaultPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

		List<Post> postToSave = Collections.singletonList(new Post(123,123,"title","body"));
		apiDownloadService.savePosts(postToSave, defaultPath+"/Test/123.json");

		assertTrue( (new File(defaultPath+"/Test/123.json")).exists() );
	}

}
