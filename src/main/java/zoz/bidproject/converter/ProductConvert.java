package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;

import zoz.bidproject.dto.PackDto;
import zoz.bidproject.dto.ProductDto;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Product;

public class ProductConvert {
	public ProductDto entityToDto(Product product) {
		ProductDto productDto = new ProductDto();

		return productDto;
	}
	public List<ProductDto> entityToDto(List<Product> products) {

		return products.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}
	public Product dtoToEntity(ProductDto productDto) {
		Product product = new Product();
		return product;
	}

	public List<Product> dtoToEntity(List<ProductDto> ProductsDto) {

		return ProductsDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}

}
