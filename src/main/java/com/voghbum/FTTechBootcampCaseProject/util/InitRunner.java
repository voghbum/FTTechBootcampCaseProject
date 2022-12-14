package com.voghbum.FTTechBootcampCaseProject.util;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Kullanici;
import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;
import com.voghbum.FTTechBootcampCaseProject.data.repository.IKullaniciRepository;
import com.voghbum.FTTechBootcampCaseProject.data.repository.IUrunRepository;
import com.voghbum.FTTechBootcampCaseProject.data.repository.IUrunYorumRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class InitRunner implements CommandLineRunner {
    private final IKullaniciRepository m_kullaniciRepository;
    private final IUrunRepository m_urunRepository;
    private final IUrunYorumRepository m_urunYorumRepository;

    public InitRunner(IKullaniciRepository kullaniciRepository, IUrunRepository urunRepository, IUrunYorumRepository urunYorumRepository) {
        m_kullaniciRepository = kullaniciRepository;
        m_urunRepository = urunRepository;
        m_urunYorumRepository = urunYorumRepository;
    }

    private void addKullanici(String name, String surname, String email, String telefon) {
        var kullanici = new Kullanici();
        kullanici.adi = name;
        kullanici.soyadi = surname;
        kullanici.email = email;
        kullanici.telefon = telefon;

        m_kullaniciRepository.save(kullanici);
    }

    private void addUrun(String name, BigDecimal price, LocalDate expDate) {
        var urun = new Urun();
        urun.adi = name;
        urun.fiyat = price;
        urun.sonKullanmaTarihi = expDate;

        m_urunRepository.save(urun);
    }

    private void addUrunYorum(String comment, LocalDateTime commentDate, long kullaniciId, long urunId) {
        var urunYorum = new UrunYorum();
        urunYorum.yorum = comment;
        urunYorum.yorumTarihi = commentDate;
        urunYorum.urun = m_urunRepository.findById(urunId).orElseThrow(() -> new RuntimeException("Urun bulunamad??"));
        urunYorum.kullanici = m_kullaniciRepository.findById(kullaniciId).orElseThrow(() -> new RuntimeException("Kullanici bulunamad??"));

        m_urunYorumRepository.save(urunYorum);
    }

    @Override
    public void run(String... args) throws Exception {
        if (m_kullaniciRepository.count() != 0)
            return;

        addKullanici("H??seyin", "A??c??", "huseyinascci@gmail.com", "505 334 06 06");
        addKullanici("Burhan", "Alt??ntop", "pabucumunrakcisi@gmail.com", "505 314 22 79");
        addKullanici("Volkan", "S??t????o??lu", "volkans??t????o??lu@gmail.com", "505 332 34 56");
        addKullanici("Fato??", "Ak??n", "fato??ak??n@gmail.com", "505 332 88 65");

        if (m_urunRepository.count() != 0)
            return;

        addUrun("Elma", new BigDecimal("10000.999"), LocalDate.of(2024, 8, 30));
        addUrun("Cips", new BigDecimal("6"), LocalDate.of(2010, 9, 15));
        addUrun("S??t", new BigDecimal("12"), LocalDate.of(2025, 8, 30));
        addUrun("Laptop", new BigDecimal("20000.888"), null);
        addUrun("Ayakkab??", new BigDecimal("600.999"), null);

        if (m_urunYorumRepository.count() != 0)
            return;

        addUrunYorum("y??llard??r t??ketiyorum t??rkiyede sat??lan en iyi cips. Muhallebi d??kkan??m??zda da sat??yoruz.",
                LocalDateTime.of(2007, 6, 13, 0, 0), 3, 2);
        addUrunYorum("ikinci y??l??n?? doldurmadan bozuldu berbat bir ??r??n paran??z?? ????pe atmay??n!!!",
                LocalDateTime.of(2008, 8, 20, 0, 0), 2, 4);
        addUrunYorum("Tad?? ??ok g??zel fakat diyette oldu??um i??in dikkatli t??ketiyorum",
                LocalDateTime.of(2009, 6, 11, 0, 0), 4, 2);
        addUrunYorum("??ncelikle sat??c??ya te??ekk??r ediyorum sorular??ma an??nda cevap verdi. " +
                "Ertesi g??n?? kargolad??. G??zelce paketlenmi??. Seri numaras?? sorgulatt??m garantisi 2023 e kadar orijinal ??r??n. Rengi ??ok g??zel rose gold. " +
                "Type c giri??i var sadece.", LocalDateTime.of(2010, 10, 10, 0, 0), 1, 4);
        addUrunYorum("G??zel bir ??ama????r makinesi",
                LocalDateTime.of(2010, 1, 5, 0, 0), 2, 1);
        addUrunYorum("Aya????m?? ac??tt?? g??r??n?????? g??zel fakat ergonomik de??il",
                LocalDateTime.of(2022, 12, 5, 0, 0), 4, 5);

    }
}
