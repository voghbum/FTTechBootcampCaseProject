package com.voghbum.FTTechBootcampCaseProject.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
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

    @OneToMany(mappedBy = "kullanici", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    public Set<UrunYorum> yorumlar;

    @Override
    public String toString() {
        return "Kullanici{" +
                "adi='" + adi + '\'' +
                ", soyadi='" + soyadi + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
