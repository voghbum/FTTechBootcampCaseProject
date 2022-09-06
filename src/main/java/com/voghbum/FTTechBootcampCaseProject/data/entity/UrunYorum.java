package com.voghbum.FTTechBootcampCaseProject.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class UrunYorum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    public long id;

    @Column(name = "comment", length = 500)
    public String yorum;

    @Column(name = "comment_date")
    public LocalDateTime yorumTarihi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonManagedReference
    public Urun urun;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    public Kullanici kullanici;

    @Override
    public String toString() {
        return "UrunYorum{" +
                "id=" + id +
                ", yorum='" + yorum + '\'' +
                ", yorumTarihi=" + yorumTarihi +
                ", urun=" + urun +
                ", kullanici=" + kullanici +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrunYorum urunYorum = (UrunYorum) o;
        return id == urunYorum.id && Objects.equals(yorum, urunYorum.yorum)
                && Objects.equals(yorumTarihi, urunYorum.yorumTarihi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yorum, yorumTarihi);
    }
}

