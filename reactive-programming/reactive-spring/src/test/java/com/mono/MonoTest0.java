package com.mono;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class MonoTest0 {
	
//	@Test
//	void firstMono() {
//		Mono.just("A")
//		.log()
//		.subscribe();
//	}
	
//	@Test
//	void monoWithConsumer() {
//		Mono.just("A")
//		.log()
//		.subscribe(s -> System.out.println(s));
//	}
	
//	@Test
//	void monoWithDoOn() {
//		Mono.just("A")
//		.log()
//		.doOnSubscribe(subs -> System.out.println("Subscribed: "+subs))
//		.doOnRequest(req -> System.out.println("Request: "+req))
//		.doOnSuccess(complete -> System.out.println("Complete: "+complete))
////		.subscribe(s -> System.out.println(s));
//		.subscribe(System.out::println);
//	}
	
//	@Test
//	void emptyMono() {
//		Mono.empty()
//		.log()
//		.subscribe(System.out::println);
//	}
	
//	@Test
//	void emptyCompleteConsumerMono() {
//		Mono.empty()
//		.log()
//		.subscribe(
//				System.out::println,
//				null,
//				() -> System.out.println("Done"));
//	}
	
//	@Test
//	void errorRuntimeExceptionMono() {
//		Mono.error(new RuntimeException())
//		.log()
//		.subscribe();
//	}
	
//	@Test
//	void errorExceptionMono() {
//		Mono.error(new Exception())
//		.log()
//		.subscribe();
//	}
	
//	@Test
//	void errorComsumerMono() {
//		Mono.error(new Exception())
//		.log()
//		.subscribe(System.out::println,
//				e -> System.out.println("Error: "+e));
//	}
	
//	@Test
//	void errorOnErrorResumeMono() {
//		Mono.error(new Exception())
//		.onErrorResume(
//				e -> {
//					 System.out.println("Caught: "+e);
//					 return Mono.just("B");
//				})
//		.log()
//		.subscribe();
//	}
	
	@Test
	void errorOnErrorResumeMono() {
		Mono.error(new Exception())
		.onErrorResume(
				e -> {
					 System.out.println("Caught: "+e);
					 return Mono.just("B");
				})
		.log()
		.subscribe();
	}
//	
//	
	
}
