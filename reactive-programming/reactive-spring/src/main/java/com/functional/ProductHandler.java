package com.functional;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.model.Product;
import com.model.ProductEvent;
import com.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class ProductHandler {
	
	private ProductRepository repository;
	
	public ProductHandler(ProductRepository repository) {
		this.repository = repository;
	}
	
	public Mono<ServerResponse> getAllProducts(ServerResponse request){
		
		Flux<Product> products = repository.findAll();
		return ServerResponse.ok()
				.contentType(APPLICATION_JSON)
				.body(products, Product.class);
	}
	
//	public Mono<ServerResponse> getProduct(ServerRequest request){
//		String id = request.pathVariable("id");
//		Mono<Product> productMono = repository.findById(id);
//		Mono<ServerResponse>notFound = ServerResponse.notFound().build();
//		return productMono.flatMap(product ->
//										ServerResponse.ok()
//										.contentType(APPLICATION_JSON)
//										.body(fromObject(product))
//										.switchIfEmpty(notFound)
//				);
//	}
	
	public Mono<ServerResponse> saveProduct(ServerRequest request){
		Mono<Product> productMono = request.bodyToMono(Product.class);
		return productMono
				.flatMap(product ->
									ServerResponse.status(HttpStatus.CREATED)
									.contentType(APPLICATION_JSON)
									.body(repository.save(product),Product.class)
				);
	}
	
	public Mono<ServerResponse> updateProduct(ServerRequest request){
		
		String id = request.pathVariable("id");
		Mono<Product> existingProductMono = repository.findById(id);
		Mono<Product> productMono = request.bodyToMono(Product.class);
		Mono<ServerResponse>notFound = ServerResponse.notFound().build();
		return productMono
				.zipWith(existingProductMono, 
						(product, existingProduct) ->
						 new Product(existingProduct.getId(),existingProduct.getName(),existingProduct.getPrice())
						)
				.flatMap( product ->
						ServerResponse.ok()
						.contentType(APPLICATION_JSON)
						.body(repository.save(product), Product.class)
						).switchIfEmpty(notFound);
	}
	
	public Mono<ServerResponse> deleteProduct(ServerRequest request){
		
		String id = request.pathVariable("id");
		Mono<Product> productMono = repository.findById(id);
		Mono<ServerResponse>notFound = ServerResponse.notFound().build();
		return productMono
				.flatMap( existingProduct ->
						ServerResponse.ok()
						.build(repository.delete(existingProduct))
						).switchIfEmpty(notFound);
	}
	
	public Mono<ServerResponse> deleteAllProduct(ServerRequest request){
		
		return ServerResponse.ok()
						.build(repository.deleteAll());
	}
	
	public Mono<ServerResponse> getProductEvent(ServerRequest request){
		
		Flux<ProductEvent> eventFlux = Flux
				.interval(Duration.ofSeconds(1))
				.map(val -> 
						new ProductEvent(val, "Product Event")
					);
		
		return ServerResponse.ok()
							 .contentType(MediaType.TEXT_EVENT_STREAM)
						.body(eventFlux, Product.class);
	}

}
