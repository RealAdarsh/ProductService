## Learnings 

#### While trying to implement getAllProducts() why we can't get those values into List<FakeStroreProductDto> but a array? 

### Java Type Erasure 

Java tries to be as much compatible with previous version as possible, Java started supporting Generics after Java 5 before that List was there and not List<T>, so in order to support the older list the generics are removed at runtime and that's why when we try to pass FakeStoreProductDto.class in rest-template it throws error as at the runtime everything is treated just like a list. 

### Exception Handling 

Learnt about @ExceptionHandler and @ControllerAdvices and why it is needed to handle Exception gracefully. 

