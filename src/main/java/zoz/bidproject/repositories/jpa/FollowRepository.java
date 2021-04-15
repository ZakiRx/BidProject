package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {

}
