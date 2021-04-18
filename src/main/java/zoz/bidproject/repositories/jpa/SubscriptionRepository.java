package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import zoz.bidproject.model.Seller;
import zoz.bidproject.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
	
	
}
