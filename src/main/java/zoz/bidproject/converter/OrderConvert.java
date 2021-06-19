package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;



import zoz.bidproject.dto.OrderDto;
import zoz.bidproject.model.Ordre;

public class OrderConvert {
	public OrderDto entityToDto(Ordre order) {
		OrderDto orderDto = new OrderDto(order.getId(),order.getCreatedAt(),order.getUpdatedAt(),order.getPurchase().getShippingDetails().getId(),order.getPurchase().getId());

		return orderDto;
	}

	public List<OrderDto> entityToDto(List<Ordre> orders) {

		return orders.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Ordre dtoToEntity(OrderDto orderDto) {
		Ordre order = new Ordre();
		return order;
	}

	public List<Ordre> dtoToEntity(List<OrderDto> OrdersDto) {

		return OrdersDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}

}
