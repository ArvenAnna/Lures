package com.anna.lure.hibernateexamples;

/**
 * Created by Hanna_Sira on 11/23/2016.
 */
public class IdCompositeAndGenerate {

//    @Entity
//    public class Login {
//
//        @EmbeddedId
//        private PK pk;
//
//        @Embeddable
//        public static class PK implements Serializable {
//
//            private String system;
//            private String username;
//            ...
//        }
//   ...
//    }

//   @Entity
//   @IdClass( PK.class )
//   public class Login {
//
//    @Id
//    @ManyToOne
//    private String system;
//
//    @Id
//    @GeneratedValue
//    private String username;
//
//    public static class PK implements Serializable {
//
//        private String system;
//        private String username;
//        ...
//    }
//    ...
// }

//    Hibernate supports identifier value generation across a number of different types. Remember that JPA portably defines identifier value generation just for integer types.
//
//    Identifier value generation is indicates using the javax.persistence.GeneratedValue annotation. The most important piece of information here is the specified javax.persistence.GenerationType which indicates how values will be generated.
//
//    AUTO (the default)
//    Indicates that the persistence provider (Hibernate) should choose an appropriate generation strategy. See Interpreting AUTO.
//
//            IDENTITY
//    Indicates that database IDENTITY columns will be used for primary key value generation. See Using IDENTITY columns.
//
//    SEQUENCE
//    Indicates that database sequence should be used for obtaining primary key values. See Using sequences.
//
//            TABLE
//    Indicates that a database table should be used for obtaining primary key values. See Using identifier table.

//    @Id
//    @GeneratedValue( generation = SEQUENCE, name = "my_sequence" )
//    @SequenceGenerator( name = "my_sequence", schema = "globals", allocationSize = 30 )
//    public Integer id;

//    @Id
//    @GeneratedValue( generator = "uuid" )
//    @GenericGenerator(
//            name = "uuid",
//            strategy = "org.hibernate.id.UUIDGenerator",
//            parameters = {
//                    @Parameter(
//                            name = "uuid_gen_strategy_class",
//                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
//                    )
//            }
//    )
//    public UUID id;

//    JPA 2.0 added support for derived identifiers which allow an entity to borrow the identifier from a many-to-one or one-to-one association.
//
//    Example 117. Derived identifier with @MapsId
//    @Entity
//    public class PersonDetails  {
//
//        @Id
//        private Long id;
//
//        private String nickName;
//
//        @ManyToOne
//        @MapsId
//        private Person person;
//
//        public String getNickName() {
//            return nickName;
//        }
//
//        public void setNickName(String nickName) {
//            this.nickName = nickName;
//        }
//
//        public Person getPerson() {
//            return person;
//        }
//
//        public void setPerson(Person person) {
//            this.person = person;
//        }
//    }

//    The previous example can also be mapped using @PrimaryKeyJoinColumn.
//
//            Example 118. Derived identifier @PrimaryKeyJoinColumn
//    @Entity
//    public class PersonDetails  {
//
//        @Id
//        private Long id;
//
//        private String nickName;
//
//        @ManyToOne
//        @PrimaryKeyJoinColumn
//        private Person person;
//
//        public String getNickName() {
//            return nickName;
//        }
//
//        public void setNickName(String nickName) {
//            this.nickName = nickName;
//        }
//
//        public Person getPerson() {
//            return person;
//        }
//
//        public void setPerson(Person person) {
//            this.person = person;
//            this.id = person.getId();
//        }
//    }


//    @NaturalId
//    private String taxIdentifier;
//
//    @NaturalId
//    @Embedded
//    private PostalCode postalCode;
//
//    @NaturalId
//    @ManyToOne
//    private Department department;
//
//    @NaturalId( mutable = true )
//    private String code;
//
//    Company company = session.byNaturalId( Company.class )
//            .using( "taxIdentifier","abc-123-xyz" )
//            .load();
//
//    PostalCarrier carrier = session.byNaturalId( PostalCarrier.class )
//            .using( "postalCode",new PostalCode(... ) )
//            .load();
//
//    Department department = ...;
//    Course course = session.byNaturalId( Course.class )
//            .using( "department",department )
//            .using( "code","101" )
//            .load();
}
