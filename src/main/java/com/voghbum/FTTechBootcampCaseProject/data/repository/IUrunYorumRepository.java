package com.voghbum.FTTechBootcampCaseProject.data.repository;

import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface IUrunYorumRepository extends CrudRepository<UrunYorum, Long> {
    Iterable<UrunYorum> findAllByKullaniciId(long kullaniciId);

    Iterable<UrunYorum> findAllByYorumTarihiBetweenAndUrunId(LocalDateTime startDate, LocalDateTime endDate,
                                                             long urunId);

    Iterable<UrunYorum> findAllByUrunId(long urunId);

    Iterable<UrunYorum> findAllByYorumTarihiBetweenAndKullaniciId(LocalDateTime startDate, LocalDateTime endDate,
                                                                  long kullaniciId);

}