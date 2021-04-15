package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
