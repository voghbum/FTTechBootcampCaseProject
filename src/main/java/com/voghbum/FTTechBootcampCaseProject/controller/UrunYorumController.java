package com.voghbum.FTTechBootcampCaseProject.controller;

import com.voghbum.FTTechBootcampCaseProject.dto.UrunYorumInfoDTO;
import com.voghbum.FTTechBootcampCaseProject.service.FTTechProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("FTTech/bootcamp/api/urunyorum")
public class UrunYorumController {
    private final FTTechProjectService m_ftTechProjectService;
    private final DateTimeFormatter m_dateTimeFormatter;

    public UrunYorumController(FTTechProjectService ftTechProjectService, DateTimeFormatter dateTimeFormatter) {
        m_ftTechProjectService = ftTechProjectService;
        m_dateTimeFormatter = dateTimeFormatter;
    }

    @GetMapping("findAll/ByKullaniciId")
    public ResponseEntity<List<UrunYorumInfoDTO>> findAllUrunYorumByKullaniciId(@RequestParam long kullaniciId) {
        return ResponseEntity.ok(m_ftTechProjectService.findAllUrunYorumByKullaniciId(kullaniciId));
    }

    @GetMapping("findAll/byUrun")
    public ResponseEntity<List<UrunYorumInfoDTO>> findAllUrunYorumByUrunId(@RequestParam long urunId) {
        return ResponseEntity.ok(m_ftTechProjectService.findAllUrunYorumByUrunId(urunId));
    }

    @GetMapping("findAll/byTarihAndKullanici")
    public ResponseEntity<?> findAllUrunYorumBeetwenDatesAndKullaniciId(@RequestParam String startDate,
                                                                        @RequestParam String endDate,
                                                                        @RequestParam long kullaniciId) {
        try {
            LocalDateTime dateStart = LocalDateTime.parse(startDate, m_dateTimeFormatter);
            LocalDateTime dateEnd = LocalDateTime.parse(endDate, m_dateTimeFormatter);

            var entity = m_ftTechProjectService.findAllUrunYorumBeetwenDatesAndKullaniciId(dateStart, dateEnd, kullaniciId);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("findAll/byTarihAndUrun")
    public ResponseEntity<?> findAllUrunYorumBeetwenDatesAndUrunId(@RequestParam String startDate,
                                                                   @RequestParam String endDate, @RequestParam long urunId) {
        try {
            LocalDateTime dateStart = LocalDateTime.parse(startDate, m_dateTimeFormatter);
            LocalDateTime dateEnd = LocalDateTime.parse(endDate, m_dateTimeFormatter);

            var entity = m_ftTechProjectService.findAllUrunYorumBeetwenDatesAndUrunId(dateStart, dateEnd, urunId);
            return ResponseEntity.ok(entity);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
