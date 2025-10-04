package socialmedia.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable int id) {
        return commentService.findById(id);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id) {
        commentService.deleteById(id);
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getAllCommentsForPost(@PathVariable int postId) {
        return commentService.getAllCommentsForPost(postId);
    }
}
