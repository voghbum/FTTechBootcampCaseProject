package com.voghbum.FTTechBootcampCaseProject.dto;

/*
    Normalde DTO Layer'da frontend'e gitmesi istenmeyen entity üye değerleri çıkarılır.

    Fakat bu DTO'dan yorumlar çıkarıldı. Bunun sebebi UrunYorumDTO'da Kullanıcı bilgisi yer alması, KullanıcıDTO'da ise
    yorum bilgisi yer almasıdır. Bu nedenle mapping kısmında infinite loop oluşuyor.
*/

import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;

import java.util.Set;

public class KullaniciInfoWithoutYorumDTO {
    private long            m_id;
    private String          m_adi;
    private String          m_soyadi;
    private String          m_email;
    private String          m_telefon;

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

    public String getSoyadi() {
        return m_soyadi;
    }

    public void setSoyadi(String soyadi) {
        m_soyadi = soyadi;
    }

    public String getEmail() {
        return m_email;
    }

    public void setEmail(String email) {
        m_email = email;
    }

    public String getTelefon() {
        return m_telefon;
    }

    public void setTelefon(String telefon) {
        m_telefon = telefon;
    }

    @Override
    public String toString() {
        return "KullaniciInfoDTO{" +
                "m_adi='" + m_adi + '\'' +
                ", m_soyadi='" + m_soyadi + '\'' +
                ", m_email='" + m_email + '\'' +
                ", m_telefon='" + m_telefon + '\'' +
                '}';
    }
}
