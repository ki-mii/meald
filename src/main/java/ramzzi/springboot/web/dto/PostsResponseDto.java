package ramzzi.springboot.web.dto;

import lombok.Getter;
import ramzzi.springboot.domain.posts.Posts;

@Getter
public class PostsResponseDto { //Entity의 필드 중 일부만 사용 , Dto는 entity를 받아 처리

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
