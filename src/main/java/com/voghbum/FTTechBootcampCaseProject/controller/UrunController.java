package com.voghbum.FTTechBootcampCaseProject.controller;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunInfoDTO;
import com.voghbum.FTTechBootcampCaseProject.service.FTTechProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("FTTech/bootcamp/api/urun")
public class UrunController {
    private final FTTechProjectService m_ftTechProjectService;

    public UrunController(FTTechProjectService ftTechProjectService) {
        m_ftTechProjectService = ftTechProjectService;
    }

    @GetMapping("findAll/sonkullanmatarihigecmis")
    public ResponseEntity<List<Urun>> findAllKullanmaTarihiGecmisUrunler() {
        return ResponseEntity.ok(m_ftTechProjectService.findUrunBySonKullanmaTarihiBefore(LocalDate.now()));
    }

    @GetMapping("findAll/sonkullanmatarihigecmemis")
    public ResponseEntity<List<UrunInfoDTO>> findAllKullanmaTarihiGecmemisUrunler() {
        return ResponseEntity.ok(m_ftTechProjectService.findUrunBySonKullanmaTarihiAfterOrNull(LocalDate.now()));
    }
}
