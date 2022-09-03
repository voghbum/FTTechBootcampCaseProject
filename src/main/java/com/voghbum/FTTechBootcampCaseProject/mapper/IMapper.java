package com.voghbum.FTTechBootcampCaseProject.mapper;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Kullanici;
import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;
import com.voghbum.FTTechBootcampCaseProject.dto.KullaniciInfoDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunInfoDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunYorumInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MapperImpl", componentModel = "spring")
public interface IMapper {
    Kullanici toKullanici(KullaniciInfoDTO kullaniciInfoDTO);

    KullaniciInfoDTO toKullaniciInfoDTO(Kullanici kullanici);

    UrunInfoDTO toUrunInfoDTO(Urun urun);

    Urun toUrun(UrunInfoDTO urunInfoDTO);

    UrunYorumInfoDTO toUrunYorumInfoDTO(UrunYorum urunYorum);

    UrunYorum toUrunYorum(UrunYorumInfoDTO urunYorumInfoDTO);
}
