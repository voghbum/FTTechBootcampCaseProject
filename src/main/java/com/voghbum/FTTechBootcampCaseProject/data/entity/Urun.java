package com.voghbum.FTTechBootcampCaseProject.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
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

    @OneToMany(mappedBy = "urun", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    public Set<UrunYorum> yorumlar;

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", fiyat=" + fiyat +
                ", sonKullanmaTarihi=" + sonKullanmaTarihi +
                ", yorumlar=" + yorumlar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urun urun = (Urun) o;
        return id == urun.id && Objects.equals(adi, urun.adi) && Objects.equals(fiyat, urun.fiyat)
                && Objects.equals(sonKullanmaTarihi, urun.sonKullanmaTarihi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adi, fiyat, sonKullanmaTarihi);
    }
}
