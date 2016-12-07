package com.anna.lure.persist;

import com.anna.lure.dto.LureType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "T_LURE_DETAIL")
public class LureDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "A_DETAIL_ID")
    private Integer id;

    @Column(name = "A_LENGTH")
    private Double length;

    @Column(name = "A_WEIGHT")
    private Double weight;

    @Column(name = "A_DEPTH")
    private Double depth;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "A_LURE_ID")
    private Lure lure;

    @Size(max = 25)
    @Column(name = "A_TYPE")
    @Enumerated(EnumType.STRING)
    // instead of Enumerated you can use @Convert( converter = LureTypeConverter.class )
    // which implements AttributeConverter<LureType, Character> for example
    private LureType type;
}
