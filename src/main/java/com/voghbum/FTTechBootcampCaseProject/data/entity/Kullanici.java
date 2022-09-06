package com.voghbum.FTTechBootcampCaseProject.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public long id;

    @Column(name = "name", length = 50, nullable = false)
    public String adi;

    @Column(name = "surname", length = 50, nullable = false)
    public String soyadi;

    @Column(name = "email", length = 50, nullable = false)
    public String email;

    @Column(name = "telephone", length = 15, nullable = false)
    public String telefon;

    @OneToMany(mappedBy = "kullanici", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    public Set<UrunYorum> yorumlar;

    @Override
    public String toString() {
        return "Kullanici{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", soyadi='" + soyadi + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kullanici kullanici = (Kullanici) o;
        return id == kullanici.id && Objects.equals(adi, kullanici.adi) && Objects.equals(soyadi, kullanici.soyadi)
                && Objects.equals(email, kullanici.email) && Objects.equals(telefon, kullanici.telefon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adi, soyadi, email, telefon);
    }
}
