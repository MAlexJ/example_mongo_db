### Object References

link: https://docs.spring.io/spring-data/mongodb/reference/mongodb/mapping/document-references.html

#### Using DBRefs

The mapping framework does not have to store child objects embedded within the document.
You can also store them separately and use a DBRef to refer to that document.

When the object is loaded from MongoDB, those references are eagerly resolved so that you get back a mapped object
that looks the same as if it had been stored embedded within your top-level document.

```
@Document
public class Account {

  @Id
  private ObjectId id;
  private Float total;
}

@Document
public class Person {

  @Id
  private ObjectId id;
  @Indexed
  private Integer ssn;
  @DBRef
  private List<Account> accounts;
}
```

##### IMPORTANT

The mapping framework does not handle cascading saves.
If you change an Account object that is referenced by a Person object, you must save the Account object separately.
Calling save on the Person object does not automatically save the Account objects in the accounts property.

##### TIP

Lazily loaded DBRefs can be hard to debug.
Make sure tooling does not accidentally trigger proxy resolution by e.g. calling toString()
or some inline debug rendering invoking property getters.
Please consider to enable trace logging for org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
to gain insight on DBRef resolution.

##### CAUTION

Lazy loading may require class proxies, that in turn, might need access to jdk internals,
that are not open, starting with Java 16+, due to JEP 396: Strongly Encapsulate JDK Internals by Default.
For those cases please consider falling back to an interface type (eg. switch from ArrayList to List)
or provide the required --add-opens argument.

### Using Document References