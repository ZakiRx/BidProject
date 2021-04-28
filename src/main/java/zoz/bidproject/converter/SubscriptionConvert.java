package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.SubscriptionDto;
import zoz.bidproject.model.Subscription;

public class SubscriptionConvert {
	public SubscriptionDto entityToDto(Subscription subscription) {
		SubscriptionDto subscriptionDto = new SubscriptionDto();

		return subscriptionDto;
	}

	public List<SubscriptionDto> entityToDto(List<Subscription> subscriptions) {

		return subscriptions.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Subscription dtoToEntity(SubscriptionDto subscriptionDto) {
		Subscription subscription = new Subscription();
		return subscription;
	}

	public List<Subscription> dtoToEntity(List<SubscriptionDto> subscriptionssDto) {

		return subscriptionssDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}

}
