package com.anna.lure.hibernateexamples;

/**
 * Created by Hanna_Sira on 11/23/2016.
 */
public class AnyGuide {
//    @Any mapping
//
//    There is one more type of property mapping. The @Any mapping defines a polymorphic association to classes from multiple tables. This type of mapping requires more than one column. The first column contains the type of the associated entity. The remaining columns contain the identifier.
//
//    It is impossible to specify a foreign key constraint for this kind of association. This is not the usual way of mapping polymorphic associations and you should use this only in special cases (e.g. audit logs, user session data, etc).
//    The @Any annotation describes the column holding the metadata information. To link the value of the metadata information and an actual entity type, the @AnyDef and @AnyDefs annotations are used. The metaType attribute allows the application to specify a custom type that maps database column values to persistent classes that have identifier properties of the type specified by idType. You must specify the mapping from values of the metaType to class names.
//
//    For the next examples, consider the following Property class hierarchy:
//
//    Example 70. Property class hierarchy
//    public interface Property<T> {
//
//        String getName();
//
//        T getValue();
//    }
//
//
//    @Entity
//    @Table(name="integer_property")
//    public class IntegerProperty implements Property<Integer> {
//
//        @Id
//        private Long id;
//
//        @Column(name = "`name`")
//        private String name;
//
//        @Column(name = "`value`")
//        private Integer value;
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        @Override
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public Integer getValue() {
//            return value;
//        }
//
//        public void setValue(Integer value) {
//            this.value = value;
//        }
//    }
//
//
//    @Entity
//    @Table(name="string_property")
//    public class StringProperty implements Property<String> {
//
//        @Id
//        private Long id;
//
//        @Column(name = "`name`")
//        private String name;
//
//        @Column(name = "`value`")
//        private String value;
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        @Override
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public void setValue(String value) {
//            this.value = value;
//        }
//    }
//    A PropertyHolder can reference any such property, and, because each Property belongs to a separate table, the @Any annotation is, therefore, required.
//
//    Example 71. @Any mapping usage
//    @Entity
//    @Table( name = "property_holder" )
//    public class PropertyHolder {
//
//        @Id
//        private Long id;
//
//        @Any(
//                metaDef = "PropertyMetaDef",
//                metaColumn = @Column( name = "property_type" )
//        )
//        @JoinColumn( name = "property_id" )
//        private Property property;
//
//        //Getters and setters are omitted for brevity
//
//    }
//    CREATE TABLE property_holder (
//            id BIGINT NOT NULL,
//            property_type VARCHAR(255),
//    property_id BIGINT,
//    PRIMARY KEY ( id )
//    )
//    As you can see, there are two columns used to reference a Property instance: property_id and property_type. The property_id is used to match the id column of either the string_property or integer_property tables, while the property_type is used to match the string_property or the integer_property table.
//
//    The table resolving mapping is defined by the metaDef attribute which references an @AnyMetaDef mapping. Although the @AnyMetaDef mapping could be set right next to the @Any annotation, it’s good practice to reuse it, therefore it makes sense to configure it on a class or package-level basis.
//
//    The package-info.java contains the @AnyMetaDef mapping:
//
//    Example 72. @Any mapping usage
//    @AnyMetaDefs(
//            @AnyMetaDef( name= "PropertyMetaDef", metaType = "string", idType = "long",
//                    metaValues = {
//                            @MetaValue(value = "S", targetEntity = StringProperty.class),
//                            @MetaValue(value = "I", targetEntity = IntegerProperty.class)
//                    }
//            )
//    )
//    package org.hibernate.userguide.mapping.basic.any;
//
//    import org.hibernate.annotations.AnyMetaDef;
//    import org.hibernate.annotations.AnyMetaDefs;
//    import org.hibernate.annotations.MetaValue;
//    It is recommended to place the @AnyMetaDef mapping as a package metadata.
//    To see how the @Any annotation in action, consider the following example:
//
//    Example 73. @Any mapping usage
//    doInHibernate( this::sessionFactory, session -> {
//        IntegerProperty ageProperty = new IntegerProperty();
//        ageProperty.setId( 1L );
//        ageProperty.setName( "age" );
//        ageProperty.setValue( 23 );
//
//        StringProperty nameProperty = new StringProperty();
//        nameProperty.setId( 1L );
//        nameProperty.setName( "name" );
//        nameProperty.setValue( "John Doe" );
//
//        session.persist( ageProperty );
//        session.persist( nameProperty );
//
//        PropertyHolder namePropertyHolder = new PropertyHolder();
//        namePropertyHolder.setId( 1L );
//        namePropertyHolder.setProperty( nameProperty );
//        session.persist( namePropertyHolder );
//    } );
//
//    doInHibernate( this::sessionFactory, session -> {
//        PropertyHolder propertyHolder = session.get( PropertyHolder.class, 1L );
//        assertEquals("name", propertyHolder.getProperty().getName());
//        assertEquals("John Doe", propertyHolder.getProperty().getValue());
//    } );
//    INSERT INTO integer_property
//            ( "name", "value", id )
//    VALUES ( 'age', 23, 1 )
//
//    INSERT INTO string_property
//            ( "name", "value", id )
//    VALUES ( 'name', 'John Doe', 1 )
//
//    INSERT INTO property_holder
//            ( property_type, property_id, id )
//    VALUES ( 'S', 1, 1 )
//
//
//    SELECT ph.id AS id1_1_0_,
//    ph.property_type AS property2_1_0_,
//    ph.property_id AS property3_1_0_
//    FROM   property_holder ph
//    WHERE  ph.id = 1
//
//
//    SELECT sp.id AS id1_2_0_,
//    sp."name" AS name2_2_0_,
//    sp."value" AS value3_2_0_
//    FROM   string_property sp
//    WHERE  sp.id = 1
//    @ManyToAny mapping
//
//    The @Any mapping is useful to emulate a @ManyToOne association when there can be multiple target entities. To emulate a @OneToMany association, the @ManyToAny annotation must be used.
//
//    In the following example, the PropertyRepository entity has a collection of Property entities. The repository_properties link table holds the associations between PropertyRepository and Property entities.
//
//    Example 74. @ManyToAny mapping usage
//    @Entity
//    @Table( name = "property_repository" )
//    public class PropertyRepository {
//
//        @Id
//        private Long id;
//
//        @ManyToAny(
//                metaDef = "PropertyMetaDef",
//                metaColumn = @Column( name = "property_type" )
//        )
//        @Cascade( { org.hibernate.annotations.CascadeType.ALL })
//        @JoinTable(name = "repository_properties",
//                joinColumns = @JoinColumn(name = "repository_id"),
//                inverseJoinColumns = @JoinColumn(name = "property_id")
//        )
//        private List<Property<?>> properties = new ArrayList<>(  );
//
//        //Getters and setters are omitted for brevity
//
//    }
//    CREATE TABLE property_repository (
//            id BIGINT NOT NULL,
//            PRIMARY KEY ( id )
//    )
//
//    CREATE TABLE repository_properties (
//            repository_id BIGINT NOT NULL,
//            property_type VARCHAR(255),
//    property_id BIGINT NOT NULL
//    )
//    To see how the @ManyToAny annotation works, consider the following example:
//
//    Example 75. @Any mapping usage
//    doInHibernate( this::sessionFactory, session -> {
//        IntegerProperty ageProperty = new IntegerProperty();
//        ageProperty.setId( 1L );
//        ageProperty.setName( "age" );
//        ageProperty.setValue( 23 );
//
//        StringProperty nameProperty = new StringProperty();
//        nameProperty.setId( 1L );
//        nameProperty.setName( "name" );
//        nameProperty.setValue( "John Doe" );
//
//        session.persist( ageProperty );
//        session.persist( nameProperty );
//
//        PropertyRepository propertyRepository = new PropertyRepository();
//        propertyRepository.setId( 1L );
//        propertyRepository.getProperties().add( ageProperty );
//        propertyRepository.getProperties().add( nameProperty );
//        session.persist( propertyRepository );
//    } );
//
//    doInHibernate( this::sessionFactory, session -> {
//        PropertyRepository propertyRepository = session.get( PropertyRepository.class, 1L );
//        assertEquals(2, propertyRepository.getProperties().size());
//        for(Property property : propertyRepository.getProperties()) {
//            assertNotNull( property.getValue() );
//        }
//    } );
//    INSERT INTO integer_property
//            ( "name", "value", id )
//    VALUES ( 'age', 23, 1 )
//
//    INSERT INTO string_property
//            ( "name", "value", id )
//    VALUES ( 'name', 'John Doe', 1 )
//
//    INSERT INTO property_repository ( id )
//    VALUES ( 1 )
//
//    INSERT INTO repository_properties
//            ( repository_id , property_type , property_id )
//    VALUES
//            ( 1 , 'I' , 1 )
//
//    INSERT INTO repository_properties
//            ( repository_id , property_type , property_id )
//    VALUES
//            ( 1 , 'S' , 1 )
//
//    SELECT pr.id AS id1_1_0_
//    FROM   property_repository pr
//    WHERE  pr.id = 1
//
//    SELECT ip.id AS id1_0_0_ ,
//    integerpro0_."name" AS name2_0_0_ ,
//    integerpro0_."value" AS value3_0_0_
//    FROM   integer_property integerpro0_
//    WHERE  integerpro0_.id = 1
//
//    SELECT sp.id AS id1_3_0_ ,
//    sp."name" AS name2_3_0_ ,
//    sp."value" AS value3_3_0_
//    FROM   string_property sp
//    WHERE  sp.id = 1
}
