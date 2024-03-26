package pl.lubsoil.apidownloader.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.lubsoil.apidownloader.model.Post;
import pl.lubsoil.apidownloader.service.ApiDownloadService;

import javax.swing.filechooser.FileSystemView;
import java.util.List;

@Controller
@Log
public class ApiDownloadController {
    private final ApiDownloadService apiDownloadService;

    public ApiDownloadController(ApiDownloadService apiDownloadService){
        this.apiDownloadService = apiDownloadService;
    }

    @GetMapping("/api/posts")
    @ResponseBody
    public List<Post> getPosts() {
        return apiDownloadService.getAllPosts();
    }

    @GetMapping("/api/posts/download")
    @ResponseBody
    public List<String> downloadPosts() {
        List<Post> posts = apiDownloadService.getAllPosts();
        String defaultPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

        return apiDownloadService.savePosts(posts,defaultPath+"/Posts");
    }

    @GetMapping()
    public ModelAndView passParametersWithModelAndView() {
        return new ModelAndView("index");
    }
}
