# Reactive Programming

Reactive programming is a programming paradigm that promotes an asynchronous, non-blocking, event-driven approach to data processing. Reactive programming involves modeling data and events as observable data streams and implementing data processing routines to react to the changes in those streams.

Reactive and non-blocking generally do not make applications run faster. The expected benefit of reactive and non-blocking is the ability to scale the application with a small, fixed number of threads and lesser memory requirements. It makes applications more resilient under load because they scale in a more predictable manner.

To build a truly non-blocking application, we must aim to create/use all of its components as non-blocking i.e. client, controller, middle services and even the database. If one of them is blocking the requests, our aim will be defeated.

## Spring WebFlux 

Spring WebFlux is parallel version of Spring MVC and supports fully non-blocking reactive streams. It has been added with Spring 5.0. It supports the back pressure concept and uses Netty as inbuilt server to run reactive applications. If you are familiar with Spring MVC programming style, you can easily work on webflux also.

Spring WebFlux uses project reactor as reactive library. Reactor is a Reactive Streams library and, therefore, all of its operators support non-blocking back pressure. It is developed in close collaboration with Spring.

## References

1. [Netty Event Loop & Threading Model](https://livebook.manning.com/book/netty-in-action/chapter-7/1)
