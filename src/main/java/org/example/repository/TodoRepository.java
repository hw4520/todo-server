package org.example.repository;

import org.example.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    public List<TodoEntity> findByOrder(Long order);

    public List<TodoEntity> findByTitleContaining(String title);

    public List<TodoEntity> findByCompletedOrderByOrderDesc(boolean completed);

    public List<TodoEntity> findByIdGreaterThanAndTitleContaining(Long id, String title);
}
