package com.anna.lure.persist;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "T_LURE")
public class Lure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "A_LURE_ID")
    private Integer id;

    @Size(max = 100)
    @Column(name = "A_LURE_NAME")
    private String name;

    @Size(max = 100)
    @Column(name = "A_LURE_PRODUCER")
    private String producer;

    @Column(name = "A_LURE_PRICE")
    private Double price;

    @Column(name = "A_LURE_DESC")
    private String description;

    @OneToMany(mappedBy = "lure", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Color> colors;

    @OneToMany(mappedBy = "lure", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToOne(mappedBy = "lure", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private LureDetail details;
}
