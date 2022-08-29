package com.voghbum.FTTechBootcampCaseProject.controller;

import com.voghbum.FTTechBootcampCaseProject.dto.UrunInfoWithoutYorumDTO;
import com.voghbum.FTTechBootcampCaseProject.dto.UrunYorumInfoWithoutUrunAndKullaniciDTO;
import com.voghbum.FTTechBootcampCaseProject.service.FTTechProjectService;
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

    // *****************************************************************
    // CASE Kapsamında İstenen Kriterler
    @GetMapping("urunyorum/findAll/ByKullaniciId")
    public List<UrunYorumInfoWithoutUrunAndKullaniciDTO> findAllUrunYorumByKullaniciId(@RequestParam long kullaniciId)
    {
        return m_ftTechProjectService.findAllUrunYorumByKullaniciId(kullaniciId);
    }

    @GetMapping("urunyorum/findAll/byUrun")
    public List<UrunYorumInfoWithoutUrunAndKullaniciDTO> findAllUrunYorumByUrunId(@RequestParam long urunId)
    {
        return m_ftTechProjectService.findAllUrunYorumByUrunId(urunId);
    }

    @GetMapping("urunyorum/findAll/byTarihAndKullanici")
    public List<UrunYorumInfoWithoutUrunAndKullaniciDTO> findAllUrunYorumBeetwenDatesAndKullaniciId(@RequestParam String startDate,
                                                                                                    @RequestParam String endDate,
                                                                                                    @RequestParam long kullaniciId)
    {
        LocalDateTime dateStart = LocalDateTime.parse(startDate, dateTimeFormatter);
        LocalDateTime dateEnd = LocalDateTime.parse(endDate, dateTimeFormatter);

        return m_ftTechProjectService.findAllUrunYorumBeetwenDatesAndKullaniciId(dateStart, dateEnd, kullaniciId);
    }

    @GetMapping("urunyorum/findAll/byTarihAndUrun")
    public List<UrunYorumInfoWithoutUrunAndKullaniciDTO> findAllUrunYorumBeetwenDatesAndUrunId(@RequestParam String startDate,
                                                                                               @RequestParam String endDate, @RequestParam long urunId)
    {
        LocalDateTime dateStart = LocalDateTime.parse(startDate, dateTimeFormatter);
        LocalDateTime dateEnd = LocalDateTime.parse(endDate, dateTimeFormatter);

        return m_ftTechProjectService.findAllUrunYorumBeetwenDatesAndUrunId(dateStart, dateEnd, urunId);
    }

    @GetMapping("urun/findAll/sonkullanmatarihigecmis")
    public List<UrunInfoWithoutYorumDTO> findAllKullanmaTarihiGecmisUrunler() {
        return m_ftTechProjectService.findUrunBySonKullanmaTarihiBefore(LocalDate.now());
    }
    
    @GetMapping("urun/findAll/sonkullanmatarihigecmemis")
    public List<UrunInfoWithoutYorumDTO> findAllKullanmaTarihiGecmemisUrunler() {
        return m_ftTechProjectService.findUrunBySonKullanmaTarihiAfterOrNull(LocalDate.now());
    }

    // *****************************************************************


}
