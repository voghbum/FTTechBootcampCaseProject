package com.voghbum.FTTechBootcampCaseProject.mapper;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Kullanici;
import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;
import com.voghbum.FTTechBootcampCaseProject.dto.KullaniciInfoWithoutYorumDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunInfoWithoutYorumDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunYorumInfoWithoutUrunAndKullaniciDTO;
import org.springframework.stereotype.Component;

@Component
public class MyMapperImpl implements IMapper {
    @Override
    public Kullanici toKullanici(KullaniciInfoWithoutYorumDTO kullaniciInfoWithoutYorumDTO) {
        if (kullaniciInfoWithoutYorumDTO == null)
            return null;

        var kullanici = new Kullanici();

        kullanici.id = kullaniciInfoWithoutYorumDTO.getId();
        kullanici.adi = kullaniciInfoWithoutYorumDTO.getAdi();
        kullanici.soyadi = kullaniciInfoWithoutYorumDTO.getSoyadi();
        kullanici.email = kullaniciInfoWithoutYorumDTO.getEmail();
        kullanici.telefon = kullaniciInfoWithoutYorumDTO.getTelefon();

        return kullanici;

    }

    @Override
    public KullaniciInfoWithoutYorumDTO toKullaniciInfoDTO(Kullanici kullanici) {
        if (kullanici == null)
            return null;

        var kullaniciInfoDTO = new KullaniciInfoWithoutYorumDTO();

        kullaniciInfoDTO.setId(kullanici.id);
        kullaniciInfoDTO.setAdi(kullanici.adi);
        kullaniciInfoDTO.setSoyadi(kullanici.soyadi);
        kullaniciInfoDTO.setEmail(kullanici.email);
        kullaniciInfoDTO.setTelefon(kullanici.telefon);

        return kullaniciInfoDTO;

    }

    @Override
    public UrunInfoWithoutYorumDTO toUrunInfoDTO(Urun urun) {
        if (urun == null)
            return null;

        var urunInfoDTO = new UrunInfoWithoutYorumDTO();

        urunInfoDTO.setId(urun.id);
        urunInfoDTO.setAdi(urun.adi);
        urunInfoDTO.setFiyat(urun.fiyat);
        urunInfoDTO.setSonKullanmaTarihi(urun.sonKullanmaTarihi);

        return urunInfoDTO;

    }

    @Override
    public Urun toUrun(UrunInfoWithoutYorumDTO urunInfoWithoutYorumDTO) {
        if (urunInfoWithoutYorumDTO == null)
            return null;

        var urun = new Urun();
        urun.id = urunInfoWithoutYorumDTO.getId();
        urun.adi = urunInfoWithoutYorumDTO.getAdi();
        urun.fiyat = urunInfoWithoutYorumDTO.getFiyat();
        urun.sonKullanmaTarihi = urunInfoWithoutYorumDTO.getSonKullanmaTarihi();

        return urun;
    }

    @Override
    public UrunYorumInfoWithoutUrunAndKullaniciDTO toUrunYorumInfoDTO(UrunYorum urunYorum) {
        if (urunYorum == null)
            return null;

        var urunYorumDTO = new UrunYorumInfoWithoutUrunAndKullaniciDTO();

        urunYorumDTO.setYorum(urunYorum.yorum);
        urunYorumDTO.setYorumTarihi(urunYorum.yorumTarihi);

        return urunYorumDTO;
    }

    @Override
    public UrunYorum toUrunYorum(UrunYorumInfoWithoutUrunAndKullaniciDTO urunYorumInfoWithoutUrunAndKullaniciDTO) {
        if (urunYorumInfoWithoutUrunAndKullaniciDTO == null)
            return null;

        var urunYorum = new UrunYorum();

        urunYorum.yorum = urunYorumInfoWithoutUrunAndKullaniciDTO.getYorum();
        urunYorum.yorumTarihi = urunYorumInfoWithoutUrunAndKullaniciDTO.getYorumTarihi();

        return urunYorum;
    }
}
