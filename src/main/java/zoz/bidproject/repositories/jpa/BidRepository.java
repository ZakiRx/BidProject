package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {

}
