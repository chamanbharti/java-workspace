package com.learnreactivespring.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FluxAndMonoController {

	@GetMapping("flux")
	public Flux<Integer> returnFlux() {
		return Flux.just(1,2,3,4)
				.log();
//		return Flux.just(1,2,3,4)
//				.delayElements(Duration.ofSeconds(1))
//				.log();
	}
	@GetMapping(value="fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> returnFluxStream() {
//		return Flux.just(1,2,3,4)
//				.log();
		return Flux.just(1,2,3,4)
				.delayElements(Duration.ofSeconds(1))
				.log();
	}
	
	@GetMapping("mono")
	public Mono<Integer> returnMono() {
//		return Flux.just(1,2,3,4)
//				.log();
		return Mono.just(1)
				.log();
	}
}
