package socialmedia.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:8080")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id) {
        return postService.findById(id);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAllPosts();
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deleteById(id);
    }

    @GetMapping("/published/{userId}")
    public List<Post> getAllPublishedPostsForUser(@PathVariable int userId) {
        return postService.getAllPublishedPostsForUser(userId);
    }
}
