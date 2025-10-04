package socialmedia.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post create(Post post) {
        return postRepository.save(post);
    }

    public Post findById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public List<Post> getAllPublishedPostsForUser(int userId) {
        return postRepository.getAllPublishedPostsForUser(userId);
    }
}
