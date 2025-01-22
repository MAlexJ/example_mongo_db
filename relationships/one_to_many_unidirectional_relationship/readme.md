### Many to One: Unidirectional Relationship

The database relationship where a User has a Role, and a Role can have many Users is known as a Many-to-One
relationship from the perspective of the User and One-to-Many from the perspective of the Role.

Entity Relationships

1. User (Many-to-One with Role)

A user belongs to one role, but a role can have many users.

```
@Entity
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    
    private String name;

    @ManyToOne
    @JoinColumn(name = "role_id")  // Foreign key column in the User table
    private Role role;
}

```

2. Role (One-to-Many with User)

A role can be assigned to many users.

```
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
```

Database Schema

	1. User table has a role_id column as a foreign key referencing Role.
	2. Role table does not store or manage any reference to User directly.

Benefits of Unidirectional Relationship

	1. Simpler design: No need to manage collections in the Role entity.
	2. Reduced complexity: No risk of bidirectional navigation issues.
	3. Better performance in some cases: Less overhead when loading Role without needing to initialize a list of Users.

Summary

	• The unidirectional relationship is Many-to-One from User to Role.
	• The Role entity does not know about User.
	• Use this approach when Role does not need to manage or query its users directly.