package com.voghbum.FTTechBootcampCaseProject.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@JsonIgnoreProperties(value = { "urunYorumInfoDTO" })
public class UrunInfoDTO {
    private long m_id;
    private String m_adi;
    private BigDecimal m_fiyat;
    private LocalDate m_sonKullanmaTarihi;

    private Set<UrunYorumInfoDTO> m_urunYorumInfoDTO;

    @JsonBackReference
    public Set<UrunYorumInfoDTO> getUrunYorumInfoDTO() {
        return m_urunYorumInfoDTO;
    }

    public void setUrunYorumInfoDTO(Set<UrunYorumInfoDTO> urunYorumInfoDTO) {
        m_urunYorumInfoDTO = urunYorumInfoDTO;
    }

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
