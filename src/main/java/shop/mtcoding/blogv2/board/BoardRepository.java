package shop.mtcoding.blogv2.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 * save(), findById(), findAll(), count(), deleteById()
 */
// 스프링이 실행될 때,BOardRepository의 구현체가 IOC 컨테이너에 생성된다
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // select id, title, content, user_id, from board_tb b inner join user_tb u on
    // b.user_id = u.id;
    // fetch를 붙여야 *(전체를 프로모션)한다.
    @Query("select b from Board b join fetch b.user")
    List<Board> mfindAll();
}
