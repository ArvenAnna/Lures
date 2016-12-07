package com.anna.lure.persist;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "T_LURE_COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Basic annotation is implicitly implied. Attributes:
    // optional - defines whether this attribute allows nulls (true by default)
    // fetch - Hibernate ignores this setting for basic types unless you are using bytecode enhancement (EAGER by default)
    @Basic(optional = false, fetch = FetchType.LAZY)
    @Column(name = "A_COMMENT_ID")
    private Integer id;

    @Column(name = "A_COMMENT_TEXT")
    //explicitly defined sql type
    @org.hibernate.annotations.Type(type = "text")
    private String comment;

    @Size(max = 100)
    @Column(name = "A_COMMENT_AUTH")
    private String author;

    @Column(name = "A_COMMENT_DATE")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "A_LURE_ID")
    private Lure lure;
}
