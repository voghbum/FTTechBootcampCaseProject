package com.voghbum.FTTechBootcampCaseProject.dto;

import java.time.LocalDateTime;

/*
    Normalde DTO Layer'da frontend'e gitmesi istenmeyen entity üye değerleri çıkarılır. Bu case'de yorum_id DTO sınıfta
    yer almıyor.
 */

public class UrunYorumInfoWithoutUrunAndKullaniciDTO {
    private String           m_yorum;
    private LocalDateTime    m_yorumTarihi;

    public String getYorum() {
        return m_yorum;
    }

    public void setYorum(String yorum) {
        m_yorum = yorum;
    }

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
