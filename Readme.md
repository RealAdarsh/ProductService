## Learnings 

#### While trying to implement getAllProducts() why we can't get those values into List<FakeStroreProductDto> but a array? 

### Java Type Erasure 

Java tries to be as much compatible with previous version as possible, Java started supporting Generics after Java 5 before that List was there and not List<T>, so in order to support the older list the generics are removed at runtime and that's why when we try to pass FakeStoreProductDto.class in rest-template it throws error as at the runtime everything is treated just like a list. 

### Exception Handling 

Learnt about @ExceptionHandler and @ControllerAdvices and why it is needed to handle Exception gracefully. 

### Cardinality 

Learnt about how the cardinality works in Spring 

@MappedSuperClass

@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "user_id")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
name = "userType",
discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
@DiscriminatorValue(value = "1")

@Entity(name = "tbc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

        

### Qualifiers 

Understood how Qualifier works 

@Qualifiers where we need to distinguish between two service implemented from same interface.  