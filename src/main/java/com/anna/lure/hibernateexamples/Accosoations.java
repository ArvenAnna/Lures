package com.anna.lure.hibernateexamples;

/**
 * Created by Hanna_Sira on 11/24/2016.
 */
public class Accosoations {
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
//    @OrderBy("number")
//    private List<Phone> phones = new ArrayList<>();

//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
//    @OrderColumn(name = "order_id")
//    private List<Phone> phones = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL)
//    @SortComparator(ReverseComparator.class)
//    private SortedSet<Phone> phones = new TreeSet<>();

//    @OneToMany(cascade = CascadeType.ALL)
//    @SortNatural
//    private SortedSet<Phone> phones = new TreeSet<>();

//    public enum PhoneType {
//        LAND_LINE,
//        MOBILE
//    }
//
//    @Entity(name = "Person")
//    public static class Person {
//
//        @Id
//        private Long id;
//        @Temporal(TemporalType.TIMESTAMP)
//        @ElementCollection
//        @CollectionTable(name = "phone_register")
//        @Column(name = "since")
//        @MapKeyJoinColumn(name = "phone_id", referencedColumnName = "id")
//        private Map<Phone, Date> phoneRegister = new HashMap<>();
//
//        public Person() {
//        }
//
//        public Person(Long id) {
//            this.id = id;
//        }
//
//        public Map<Phone, Date> getPhoneRegister() {
//            return phoneRegister;
//        }
//    }
//
//    @Embeddable
//    public static class Phone {
//
//        private PhoneType type;
//
//        @Column(name = "`number`")
//        private String number;
//
//        public Phone() {
//        }
//
//        public Phone(PhoneType type, String number) {
//            this.type = type;
//            this.number = number;
//        }
//
//        public PhoneType getType() {
//            return type;
//        }
//
//        public String getNumber() {
//            return number;
//        }
//    }
//    CREATE TABLE Person (
//            id BIGINT NOT NULL ,
//            PRIMARY KEY ( id )
//    )
//
//    CREATE TABLE phone_register (
//            Person_id BIGINT NOT NULL ,
//            since TIMESTAMP ,
//            number VARCHAR(255) NOT NULL ,
//    type INTEGER NOT NULL ,
//    PRIMARY KEY ( Person_id, number, type )
//    )
//    ALTER TABLE phone_register
//    ADD CONSTRAINT FKrmcsa34hr68of2rq8qf526mlk
//    FOREIGN KEY (Person_id) REFERENCES Person
//
//    person.getPhoneRegister().put(
//            new Phone( PhoneType.LAND_LINE, "028-234-9876" ), new Date()
//    );
//    person.getPhoneRegister().put(
//            new Phone( PhoneType.MOBILE, "072-122-9876" ), new Date()
//    );
//    INSERT INTO phone_register (Person_id, number, type, since)
//    VALUES (1, '072-122-9876', 1, '2015-12-15 17:16:45.311')
//
//    INSERT INTO phone_register (Person_id, number, type, since)
//    VALUES (1, '028-234-9876', 0, '2015-12-15 17:16:45.311')

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable(
//            name = "phone_register",
//            joinColumns = @JoinColumn(name = "phone_id"),
//            inverseJoinColumns = @JoinColumn(name = "person_id"))
//    @MapKey(name = "since")
//    @MapKeyTemporal(TemporalType.TIMESTAMP)
//    private Map<Date, Phone> phoneRegister = new HashMap<>();

//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    @MapKey(name = "type")
//    @MapKeyEnumerated
//    private Map<PhoneType, Phone> phoneRegister = new HashMap<>();
}
