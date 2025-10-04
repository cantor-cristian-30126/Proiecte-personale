package socialmedia.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Date createdOn;

    private Status status;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = true)
    private socialmedia.user.User user;
}