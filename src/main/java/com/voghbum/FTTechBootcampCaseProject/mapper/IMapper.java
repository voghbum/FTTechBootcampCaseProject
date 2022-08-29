package com.voghbum.FTTechBootcampCaseProject.mapper;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Kullanici;
import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;
import com.voghbum.FTTechBootcampCaseProject.dto.KullaniciInfoWithoutYorumDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunInfoWithoutYorumDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunYorumInfoWithoutUrunAndKullaniciDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MapperImpl", componentModel = "spring")
public interface IMapper {
    Kullanici toKullanici(KullaniciInfoWithoutYorumDTO kullaniciInfoWithoutYorumDTO);

    KullaniciInfoWithoutYorumDTO toKullaniciInfoDTO(Kullanici kullanici);

    UrunInfoWithoutYorumDTO toUrunInfoDTO(Urun urun);

    Urun toUrun(UrunInfoWithoutYorumDTO urunInfoWithoutYorumDTO);

    UrunYorumInfoWithoutUrunAndKullaniciDTO toUrunYorumInfoDTO(UrunYorum urunYorum);

    UrunYorum toUrunYorum(UrunYorumInfoWithoutUrunAndKullaniciDTO urunYorumInfoWithoutUrunAndKullanıcıDTO);
}
