package com.voghbum.FTTechBootcampCaseProject.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="comments")
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
    @JsonBackReference
    public Urun urun;

    /*
    @Transient
    public long urunId;
    */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    public Kullanici kullanici;

    /*
    @Transient
    public long KullaniciId;
    */

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
}
