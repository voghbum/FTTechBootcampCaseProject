package com.voghbum.FTTechBootcampCaseProject.mapper;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Kullanici;
import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;
import com.voghbum.FTTechBootcampCaseProject.dto.KullaniciInfoDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunInfoDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunYorumInfoDTO;
import org.springframework.stereotype.Component;

@Component("MyMapper")
public class MyMapper implements IMapper{

    public Kullanici toKullanici(KullaniciInfoDTO kullaniciInfoDTO) {
        if (kullaniciInfoDTO == null) {
            return null;
        }

        var kullanici = new Kullanici();

        kullanici.id = kullaniciInfoDTO.getId();
        kullanici.adi = kullaniciInfoDTO.getAdi();
        kullanici.soyadi = kullaniciInfoDTO.getSoyadi();
        kullanici.email = kullaniciInfoDTO.getEmail();
        kullanici.telefon = kullaniciInfoDTO.getTelefon();

        return kullanici;
    }

    public KullaniciInfoDTO toKullaniciInfoDTO(Kullanici kullanici) {
        if (kullanici == null) {
            return null;
        }

        var kullaniciInfoDTO = new KullaniciInfoDTO();

        kullaniciInfoDTO.setId(kullanici.id);
        kullaniciInfoDTO.setAdi(kullanici.adi);
        kullaniciInfoDTO.setSoyadi(kullanici.soyadi);
        kullaniciInfoDTO.setEmail(kullanici.email);
        kullaniciInfoDTO.setTelefon(kullanici.telefon);

        return kullaniciInfoDTO;

    }

    public UrunInfoDTO toUrunInfoDTO(Urun urun) {
        if (urun == null) {
            return null;
        }

        var urunInfoDTO = new UrunInfoDTO();

        urunInfoDTO.setId(urun.id);
        urunInfoDTO.setAdi(urun.adi);
        urunInfoDTO.setFiyat(urun.fiyat);
        urunInfoDTO.setSonKullanmaTarihi(urun.sonKullanmaTarihi);

        return urunInfoDTO;
    }

    public Urun toUrun(UrunInfoDTO urunInfoDTO) {
        if (urunInfoDTO == null) {
            return null;
        }

        var urun = new Urun();

        urun.id = urunInfoDTO.getId();
        urun.adi = urunInfoDTO.getAdi();
        urun.fiyat = urunInfoDTO.getFiyat();
        urun.sonKullanmaTarihi = urunInfoDTO.getSonKullanmaTarihi();

        return urun;

    }

    public UrunYorumInfoDTO toUrunYorumInfoDTO(UrunYorum urunYorum) {
        if (urunYorum == null) {
            return null;
        }

        var urunYorumInfoDTO = new UrunYorumInfoDTO();

        urunYorumInfoDTO.setYorum(urunYorum.yorum);
        urunYorumInfoDTO.setYorumTarihi(urunYorum.yorumTarihi);

        return urunYorumInfoDTO;
    }

    public UrunYorum toUrunYorum(UrunYorumInfoDTO urunYorumInfoDTO) {
        if (urunYorumInfoDTO == null) {
            return null;
        }

        var urunYorum = new UrunYorum();

        urunYorum.yorum = urunYorumInfoDTO.getYorum();
        urunYorum.yorumTarihi = urunYorumInfoDTO.getYorumTarihi();

        return urunYorum;
    }
}
