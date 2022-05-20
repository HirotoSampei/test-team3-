package jp.te4a.spring.boot.myapp9;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class BookForm {
  private Integer id ;
  private String title;
  private String writer;
  private String publisher;
  private Integer price;
}
