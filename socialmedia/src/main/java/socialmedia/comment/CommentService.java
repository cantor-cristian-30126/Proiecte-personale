package socialmedia.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment findById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Transactional
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    public List<Comment> getAllCommentsForPost(int postId) {
        return commentRepository.getAllCommentsForPost(postId);
    }
}
