package com.voghbum.FTTechBootcampCaseProject.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="products")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    public long id;

    @Column(name = "name", length = 50, nullable = false)
    public String adi;

    @Column(name = "price", nullable = false)
    public BigDecimal fiyat;

    @Column(name = "Exp_date")
    public LocalDate sonKullanmaTarihi;

    @OneToMany(mappedBy = "urun", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    public Set<UrunYorum> yorumlar;

    @Override
    public String toString() {
        return "Urun{" +
                "adi='" + adi + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
