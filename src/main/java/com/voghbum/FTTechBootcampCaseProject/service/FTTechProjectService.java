package com.voghbum.FTTechBootcampCaseProject.service;

import com.voghbum.FTTechBootcampCaseProject.data.dal.FTTechProjectDAL;
import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunInfoDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunYorumInfoDTO;
import com.voghbum.FTTechBootcampCaseProject.mapper.IMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.voghbum.util.data.DatabaseUtil.*;

@Service
public class FTTechProjectService {
    private final FTTechProjectDAL m_ftTechProjectDAL;
    private final IMapper m_mapper;

    public FTTechProjectService(FTTechProjectDAL ftTechProjectDAL, /*@Qualifier("MapperImpl")*/ IMapper mapper) {
        m_ftTechProjectDAL = ftTechProjectDAL;
        m_mapper = mapper;
    }

    private static <T, R> List<R> convertToList(Iterable<? extends T> iterable, boolean parallel, Function<? super T, ? extends R> function) {
        return StreamSupport.stream(iterable.spliterator(), parallel)
                .map(function)
                .collect(Collectors.toList());
    }

    public List<UrunYorumInfoDTO> findAllUrunYorumByUrunId(long urunId) {
        return doWorkForService(() -> findAllUrunYorumByUrunIdCallback(urunId),
                "FTTechProjectService.findAllUrunYorumByUrunId");
    }

    private List<UrunYorumInfoDTO> findAllUrunYorumByUrunIdCallback(long urunId) {
        return convertToList(m_ftTechProjectDAL.findAllUrunYorumByUrunId(urunId), false, m_mapper::toUrunYorumInfoDTO);
    }

    public List<UrunYorumInfoDTO> findAllUrunYorumBeetwenDatesAndUrunId(LocalDateTime startDate,
                                                                        LocalDateTime endDate,
                                                                        long productId) {
        return doWorkForService(() -> findAllUrunYorumBeetwenDatesAndUrunIdCallback(startDate, endDate, productId),
                "FTTechProjectService.findAllUrunYorumBeetwenDatesAndUrunId");
    }

    private List<UrunYorumInfoDTO> findAllUrunYorumBeetwenDatesAndUrunIdCallback(LocalDateTime startDate,
                                                                                 LocalDateTime endDate,
                                                                                 long productId) {
        return convertToList(m_ftTechProjectDAL.findAllUrunYorumBeetwenDatesAndUrunId(startDate, endDate, productId),
                false, m_mapper::toUrunYorumInfoDTO);
    }

    public List<UrunYorumInfoDTO> findAllUrunYorumByKullaniciId(long kullaniciId) {
        return doWorkForService(() -> findAllUrunYorumByKullaniciIdCallBack(kullaniciId),
                "FTTechProjectService.findAllUrunYorumByKullaniciId");
    }

    private List<UrunYorumInfoDTO> findAllUrunYorumByKullaniciIdCallBack(long kullaniciId) {
        return convertToList(m_ftTechProjectDAL.findAllUrunYorumByKullaniciId(kullaniciId), false, m_mapper::toUrunYorumInfoDTO);
    }

    public List<UrunYorumInfoDTO> findAllUrunYorumBeetwenDatesAndKullaniciId(LocalDateTime startDate,
                                                                             LocalDateTime endDate, long kullaniciId) {
        return doWorkForService(() -> findAllUrunYorumBeetwenDatesAndKullaniciIdCallBack(startDate, endDate, kullaniciId),
                "FTTechProjectService.findAllUrunYorumBeetwenDatesAndKullaniciId");
    }

    private List<UrunYorumInfoDTO> findAllUrunYorumBeetwenDatesAndKullaniciIdCallBack(LocalDateTime startDate,
                                                                                      LocalDateTime endDate,
                                                                                      long kullaniciId) {
        return convertToList(m_ftTechProjectDAL.findAllUrunYorumBeetwenDatesAndKullaniciId(startDate, endDate, kullaniciId),
                false, m_mapper::toUrunYorumInfoDTO);
    }

    public List<UrunInfoDTO> findUrunBySonKullanmaTarihiAfterOrNull(LocalDate now) {
        return doWorkForService(() -> findUrunBySonKullanmaTarihiAfterCallBack(now),
                "FTTechProjectService.findUrunBySonKullanmaTarihiAfter");
    }

    private List<UrunInfoDTO> findUrunBySonKullanmaTarihiAfterCallBack(LocalDate now) {
        return convertToList(m_ftTechProjectDAL.findUrunBySonKullanmaTarihiAfterOrNull(now), false, m_mapper::toUrunInfoDTO);
    }

    public List<Urun> findUrunBySonKullanmaTarihiBefore(LocalDate now) {
        return doWorkForService(() -> findUrunBySonKullanmaTarihiBeforeOrNullCallBack(now),
                "FTTechProjectService.findUrunBySonKullanmaTarihiBeforeOrNull");
    }

    private List<Urun> findUrunBySonKullanmaTarihiBeforeOrNullCallBack(LocalDate now) {
        return //convertToList(m_ftTechProjectDAL.findUrunBySonKullanmaTarihiBefore(now), false, m_mapper::toUrunInfoDTO);
                StreamSupport.stream(m_ftTechProjectDAL.findUrunBySonKullanmaTarihiBefore(now).spliterator(), false).collect(Collectors.toList());
    }

}
