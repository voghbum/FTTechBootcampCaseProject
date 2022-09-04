package com.voghbum.FTTechBootcampCaseProject.data.dal;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;
import com.voghbum.FTTechBootcampCaseProject.data.repository.IKullaniciRepository;
import com.voghbum.FTTechBootcampCaseProject.data.repository.IUrunRepository;
import com.voghbum.FTTechBootcampCaseProject.data.repository.IUrunYorumRepository;

import static com.voghbum.util.data.DatabaseUtil.*;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.StreamSupport;

@Component
public class FTTechProjectDAL {
    private final IKullaniciRepository m_kullaniciRepository;
    private final IUrunRepository m_urunRepository;
    private final IUrunYorumRepository m_urunYorumRepository;

    public FTTechProjectDAL(IKullaniciRepository kullaniciRepository,
                            IUrunRepository urunRepository, IUrunYorumRepository urunYorumRepository) {
        m_kullaniciRepository = kullaniciRepository;
        m_urunRepository = urunRepository;
        m_urunYorumRepository = urunYorumRepository;
    }

    public Iterable<UrunYorum> findAllUrunYorumByUrunId(long urunId) {
        return doWorkForRepository(() -> m_urunYorumRepository.findAllByUrunId(urunId),
                "findAllUrunYorumBeetwenDatesAndUrunId.findAllUrunYorumByUrunId");
    }

    public Iterable<UrunYorum> findAllUrunYorumBeetwenDatesAndUrunId(LocalDateTime startDate, LocalDateTime endDate,
                                                                     long productId) {
        return doWorkForRepository(() -> m_urunYorumRepository.findAllByYorumTarihiBetweenAndUrunId(startDate, endDate, productId),
                "FTTechProjectDAL.findAllUrunYorumBeetwenDatesAndUrunId");
    }

    public Iterable<UrunYorum> findAllUrunYorumByKullaniciId(long kullaniciId) {
        return doWorkForRepository(() -> m_urunYorumRepository.findAllByKullaniciId(kullaniciId),
                "FTTechProjectDAL.findAllUrunYorumByKullaniciId");
    }

    public Iterable<UrunYorum> findAllUrunYorumBeetwenDatesAndKullaniciId(LocalDateTime startDate, LocalDateTime endDate, long kullaniciId) {
        return doWorkForRepository(() -> m_urunYorumRepository.findAllByYorumTarihiBetweenAndKullaniciId(startDate, endDate, kullaniciId),
                "FTTechProjectDAL.findAllUrunYorumBeetwenDatesAndKullaniciId");
    }

    public Iterable<Urun> findUrunBySonKullanmaTarihiAfterOrNull(LocalDate now) {
        return doWorkForRepository(() -> m_urunRepository.findAllBySonKullanmaTarihiAfterOrSonKullanmaTarihiIsNull(now),
                "FTTechProjectDAL.findUrunBySonKullanmaTarihiAfter");
    }

    public Iterable<Urun> findUrunBySonKullanmaTarihiBefore(LocalDate now) {
        return doWorkForRepository(() -> m_urunRepository.findAllBySonKullanmaTarihiBefore(now),
                "FTTechProjectDAL.findUrunBySonKullanmaTarihiBeforeOrNull");
    }
}
