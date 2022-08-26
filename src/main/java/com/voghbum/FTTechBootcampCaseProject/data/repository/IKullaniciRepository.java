package com.voghbum.FTTechBootcampCaseProject.data.repository;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Kullanici;
import org.springframework.data.repository.CrudRepository;

public interface IKullaniciRepository extends CrudRepository<Kullanici, Long> {
}
