package com.voghbum.FTTechBootcampCaseProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voghbum.FTTechBootcampCaseProject.data.entity.Kullanici;
import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;

import java.time.LocalDateTime;

/*
    Normalde DTO Layer'da frontend'e gitmesi istenmeyen entity üye değerleri çıkarılır. Bu case'de yorum_id DTO sınıfta
    yer almıyor.
 */


@JsonIgnoreProperties(value = {"kullanici", "urun"})
public class UrunYorumInfoDTO {
    private String m_yorum;
    private LocalDateTime m_yorumTarihi;

    private Kullanici m_kullanici;

    private Urun m_urun;

    @JsonManagedReference
    public Kullanici getKullanici() {
        return m_kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        m_kullanici = kullanici;
    }

    @JsonManagedReference
    public Urun getUrun() {
        return m_urun;
    }

    public void setUrun(Urun urun) {
        m_urun = urun;
    }

    public String getYorum() {
        return m_yorum;
    }

    public void setYorum(String yorum) {
        m_yorum = yorum;
    }

    @JsonProperty("Yorum tarihi")
    public LocalDateTime getYorumTarihi() {
        return m_yorumTarihi;
    }

    public void setYorumTarihi(LocalDateTime yorumTarihi) {
        m_yorumTarihi = yorumTarihi;
    }

    @Override
    public String toString() {
        return "UrunYorumInfoDTO{" +
                "m_yorum='" + m_yorum + '\'' +
                ", m_yorumTarihi=" + m_yorumTarihi +
                '}';
    }
}
