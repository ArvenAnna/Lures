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
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "T_LURE_COLOR")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "A_COLOR_ID")
    private Integer id;

    @Size(max = 100)
    @Column(name = "A_COLOR_NAME")
    private String name;

    @Size(max = 100)
    @Column(name = "A_COLOR_IMG")
    private String img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "A_LURE_ID")
    private Lure lure;
}
