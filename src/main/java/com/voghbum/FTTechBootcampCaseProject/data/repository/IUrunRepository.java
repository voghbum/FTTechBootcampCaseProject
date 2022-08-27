package com.voghbum.FTTechBootcampCaseProject.data.repository;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface IUrunRepository extends CrudRepository<Urun, Long> {
    Iterable<Urun> findAllBySonKullanmaTarihiAfterOrSonKullanmaTarihiIsNull(LocalDate now);

    Iterable<Urun> findAllBySonKullanmaTarihiBefore(LocalDate now);
}