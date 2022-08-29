package com.voghbum.FTTechBootcampCaseProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

/*
    Normalde DTO Layer'da frontend'e gitmesi istenmeyen entity üye değerleri çıkarılır.

    Fakat bu DTO'dan yorumlar çıkarıldı. Bunun sebebi UrunYorumDTO'da UrunDTO yer alması, UrunDTO'da ise
    UrunYorumDTO yer almasıdır. Bu nedenle mapping kısmında infinite loop oluşuyor.
*/

public class UrunInfoWithoutYorumDTO {
    private long m_id;
    private String m_adi;
    private BigDecimal m_fiyat;
    private LocalDate m_sonKullanmaTarihi;

    public long getId() {
        return m_id;
    }

    public void setId(long id) {
        m_id = id;
    }

    public String getAdi() {
        return m_adi;
    }

    public void setAdi(String adi) {
        m_adi = adi;
    }

    public BigDecimal getFiyat() {
        return m_fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        m_fiyat = fiyat;
    }

    @JsonProperty("Son kullanma tarihi")
    public LocalDate getSonKullanmaTarihi() {
        return m_sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(LocalDate sonKullanmaTarihi) {
        m_sonKullanmaTarihi = sonKullanmaTarihi;
    }

    @Override
    public String toString() {
        return "UrunInfoDTO{" +
                "m_adi='" + m_adi + '\'' +
                ", m_fiyat=" + m_fiyat +
                ", m_sonKullanmaTarihi=" + m_sonKullanmaTarihi +
                '}';
    }
}
