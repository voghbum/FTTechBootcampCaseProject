package com.voghbum.FTTechBootcampCaseProject.controller;

import com.voghbum.FTTechBootcampCaseProject.dto.UrunInfoWithoutYorumDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunYorumInfoWithoutUrunAndKullaniciDTO;
import com.voghbum.FTTechBootcampCaseProject.service.FTTechProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

@RestController
@RequestMapping("FTTech/bootcamp/api")
public class FTTechProjectController {
    private final FTTechProjectService m_ftTechProjectService;

    // Dependency Injection yapılması daha makul fakat Case kapsamında tek bir formatter yeterli olduğu için gerek duymadım.
    // Bu Fromatter ile request Date verilirken saat bilgileri verilmez ise default olarak 0 alınıyor.
    private final DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy[ [HH][:mm][:ss][.SSS]]")
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .toFormatter();

    public FTTechProjectController(FTTechProjectService ftTechProjectService) {
        m_ftTechProjectService = ftTechProjectService;
    }

    @GetMapping("urunyorum/findAll/ByKullaniciId")
    public ResponseEntity<List<UrunYorumInfoWithoutUrunAndKullaniciDTO>> findAllUrunYorumByKullaniciId(@RequestParam long kullaniciId) {
        return ResponseEntity.ok(m_ftTechProjectService.findAllUrunYorumByKullaniciId(kullaniciId));
    }

    @GetMapping("urunyorum/findAll/byUrun")
    public ResponseEntity<List<UrunYorumInfoWithoutUrunAndKullaniciDTO>> findAllUrunYorumByUrunId(@RequestParam long urunId) {
        return ResponseEntity.ok(m_ftTechProjectService.findAllUrunYorumByUrunId(urunId));
    }

    @GetMapping("urunyorum/findAll/byTarihAndKullanici")
    public ResponseEntity<?> findAllUrunYorumBeetwenDatesAndKullaniciId(@RequestParam String startDate,
                                                                        @RequestParam String endDate,
                                                                        @RequestParam long kullaniciId) {
        try {
            LocalDateTime dateStart = LocalDateTime.parse(startDate, dateTimeFormatter);
            LocalDateTime dateEnd = LocalDateTime.parse(endDate, dateTimeFormatter);

            var entity = m_ftTechProjectService.findAllUrunYorumBeetwenDatesAndKullaniciId(dateStart, dateEnd, kullaniciId);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("urunyorum/findAll/byTarihAndUrun")
    public ResponseEntity<?> findAllUrunYorumBeetwenDatesAndUrunId(@RequestParam String startDate,
                                                                   @RequestParam String endDate, @RequestParam long urunId) {
        try {
            LocalDateTime dateStart = LocalDateTime.parse(startDate, dateTimeFormatter);
            LocalDateTime dateEnd = LocalDateTime.parse(endDate, dateTimeFormatter);

            var entity = m_ftTechProjectService.findAllUrunYorumBeetwenDatesAndUrunId(dateStart, dateEnd, urunId);
            return ResponseEntity.ok(entity);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("urun/findAll/sonkullanmatarihigecmis")
    public ResponseEntity<List<UrunInfoWithoutYorumDTO>> findAllKullanmaTarihiGecmisUrunler() {
        return ResponseEntity.ok(m_ftTechProjectService.findUrunBySonKullanmaTarihiBefore(LocalDate.now()));
    }

    @GetMapping("urun/findAll/sonkullanmatarihigecmemis")
    public ResponseEntity<List<UrunInfoWithoutYorumDTO>> findAllKullanmaTarihiGecmemisUrunler() {
        return ResponseEntity.ok(m_ftTechProjectService.findUrunBySonKullanmaTarihiAfterOrNull(LocalDate.now()));
    }


}
