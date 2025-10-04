package socialmedia.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p WHERE p.user.id = :userId AND p.status = socialmedia.post.Status.PUBLISHED")
    List<Post> getAllPublishedPostsForUser(@Param("userId") int userId);
}
