package org.example.repository;

import org.example.model.TodoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


@DataJpaTest
class TodoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;

    @BeforeEach
    void setUp() {
        // 더미 데이터 4개 정도
        List<TodoEntity> dummyList = Arrays.asList(
                 TodoEntity.builder().title("제목1").order(1L).completed(false).build()
                ,TodoEntity.builder().title("제목2").order(2L).completed(true).build()
                ,TodoEntity.builder().title("이름1").order(3L).completed(false).build()
                ,TodoEntity.builder().title("이름2").order(4L).completed(true).build()
        );

        this.todoRepository.saveAll(dummyList);
    }

    @Test
    void findByOrder() {
        // order값이 3L인 데이터가 잘 나오는지
        List<TodoEntity> expectedList = this.todoRepository.findByOrder(3L);
        assertThat(expectedList, hasSize(1));

        TodoEntity actual = expectedList.get(0);
        assertEquals("이름1", actual.getTitle());
        assertEquals(3L, actual.getOrder());
        assertEquals(false, actual.getCompleted());
    }

    @Test
    void findByTitleContaining() {
        // title이 제목이 포함되는 todo 조회
    }

    @Test
    void findByCompletedOrderByOrderDesc() {
        // 첫번째 데이터과 마지막 데이터 비교
    }

    @Test
    void findByIdGreaterThanAndTitleContaining() {
        // 첫번째 데이터와 마지막 데이터 비교
    }
}