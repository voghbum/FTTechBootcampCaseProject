package com.voghbum.FTTechBootcampCaseProject.util;

import com.voghbum.FTTechBootcampCaseProject.data.entity.Kullanici;
import com.voghbum.FTTechBootcampCaseProject.data.entity.Urun;
import com.voghbum.FTTechBootcampCaseProject.data.entity.UrunYorum;
import com.voghbum.FTTechBootcampCaseProject.data.repository.IKullaniciRepository;
import com.voghbum.FTTechBootcampCaseProject.data.repository.IUrunRepository;
import com.voghbum.FTTechBootcampCaseProject.data.repository.IUrunYorumRepository;
import net.bytebuddy.asm.Advice;
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
        urunYorum.urun = m_urunRepository.findById(urunId).orElseThrow(() -> new RuntimeException("Urun bulunamadı"));
        urunYorum.kullanici = m_kullaniciRepository.findById(kullaniciId).orElseThrow(() -> new RuntimeException("Kullanici bulunamadı"));

        m_urunYorumRepository.save(urunYorum);
    }

    @Override
    public void run(String... args) throws Exception {

        if(m_kullaniciRepository.count() != 0)
            return;

        addKullanici("Hüseyin", "Aşcı", "huseyinascci@gmail.com", "505 334 06 06");
        addKullanici("Burhan", "Altıntop", "pabucumunrakcisi@gmail.com", "505 314 22 79");
        addKullanici("Volkan", "Sütçüoğlu", "volkansütçüoğlu@gmail.com", "505 332 34 56");
        addKullanici("Fatoş", "Akın", "fatoşakın@gmail.com", "505 332 88 65");

        if(m_urunRepository.count() != 0)
            return;

        addUrun("Çamaşır makinesi", new BigDecimal("10000.999"), null);
        addUrun("Cips", new BigDecimal("6"), LocalDate.of(2010,9,15));
        addUrun("Süt", new BigDecimal("12"), LocalDate.of(2022, 8, 30));
        addUrun("Laptop", new BigDecimal("20000.888"), null);
        addUrun("Ayakkabı", new BigDecimal("600.999"), null);

        if(m_urunYorumRepository.count() != 0)
            return;

        addUrunYorum("yıllardır tüketiyorum türkiyede satılan en iyi cips. Muhallebi dükkanımızda da satıyoruz.",
                LocalDateTime.of(2007,6,13, 0, 0), 3, 2);
        addUrunYorum("ikinci yılını doldurmadan bozuldu berbat bir ürün paranızı çöpe atmayın!!!",
                LocalDateTime.of(2008, 8, 20, 0, 0), 2, 4);
        addUrunYorum("Tadı çok güzel fakat diyette olduğum için dikkatli tüketiyorum",
                LocalDateTime.of(2009,6, 11, 0, 0), 4, 2);
        addUrunYorum("Öncelikle satıcıya teşekkür ediyorum sorularıma anında cevap verdi. " +
                "Ertesi günü kargoladı. Güzelce paketlenmiş. Seri numarası sorgulattım garantisi 2023 e kadar orijinal ürün. Rengi çok güzel rose gold. " +
                "Type c girişi var sadece.", LocalDateTime.of(2010, 10, 10, 0, 0), 1, 4);
        addUrunYorum("Güzel bir çamaşır makinesi",
                LocalDateTime.of(2010, 1, 5, 0, 0), 2, 1);
        addUrunYorum("Ayağımı acıttı görünüşü güzel fakat ergonomik değil",
                LocalDateTime.of(2022,12,5, 0, 0), 4, 5);

    }
}
