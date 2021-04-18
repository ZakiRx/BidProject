package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Offer;


public interface OfferRepository extends  JpaRepository<Offer, Long> {

}
