package com.voghbum.FTTechBootcampCaseProject.controller;

import com.voghbum.FTTechBootcampCaseProject.service.FTTechProjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("FTTech/bootcamp/api/kullanici")
public class KullaniciController {
    private final FTTechProjectService m_ftTechProjectService;

    public KullaniciController(FTTechProjectService ftTechProjectService) {
        m_ftTechProjectService = ftTechProjectService;
    }
}
