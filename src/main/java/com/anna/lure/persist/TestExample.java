package com.anna.lure.persist;

import com.anna.lure.dto.LureType;
import com.anna.lure.hibernateexamples.FunctionCreationTimestamp;
import com.anna.lure.hibernateexamples.LureTypeConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "EXAMPLE")
@Where(clause = "active = true" )
public class TestExample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "A_ID")
    private Integer id;

    @Convert(converter = LureTypeConverter.class)
    @Column(name = "A_TYPE")
    private LureType type;

    @FunctionCreationTimestamp
    @Column(name = "A_DATE")
    private LocalDateTime date;

    @Column(name = "A_VAL")
    @ColumnTransformer(
            read = "value/10",
            write = "value*10"
    )
    // for non one column mapping
    // @ColumnTransformer(forColumn = "money", read = "money / 100", write = "? * 100")
    // and
    // @Columns(columns = {@Column(name = "money"), @Column(name = "currency")})
    private Integer value;

    @Formula(value = "value * value")
    private Integer computedValue;

    @Column(name = "A_ACT")
    private Boolean active;

    // enabling optimistic locking
    @Version
    @Access( AccessType.FIELD )
    private Integer version;

//    @OneToMany
//    @Filter(name="activeAccount", condition="active = :active")
//    private TestExample2 field;
//
//    @Entity(name = "Account")
//    @FilterDef(name="activeAccount", parameters=@ParamDef( name="active", type="boolean" ) )
//    @Filter(name="activeAccount", condition="active = :active")
//    class TestExample2 {}
}
