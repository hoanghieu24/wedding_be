package com.happywedding.backend.service;

import com.happywedding.backend.entity.SiteContent;
import com.happywedding.backend.repository.SiteContentRepository;
import org.springframework.stereotype.Service;

@Service
public class SiteContentService {

    private final SiteContentRepository siteContentRepository;

    public SiteContentService(SiteContentRepository siteContentRepository) {
        this.siteContentRepository = siteContentRepository;
    }

    public SiteContent getOrCreate() {
        return siteContentRepository.findTopByOrderByIdAsc()
                .orElseGet(() -> siteContentRepository.save(createDefault()));
    }

    public SiteContent update(SiteContent incoming) {
        SiteContent current = getOrCreate();
        current.setGroomName(incoming.getGroomName());
        current.setBrideName(incoming.getBrideName());
        current.setWeddingDate(incoming.getWeddingDate());
        current.setWeddingLocation(incoming.getWeddingLocation());
        current.setWeddingMapUrl(incoming.getWeddingMapUrl());
        current.setHeroTitle(incoming.getHeroTitle());
        current.setWelcomeMessage(incoming.getWelcomeMessage());
        current.setStory(incoming.getStory());
        current.setShowGallery(incoming.getShowGallery());
        current.setShowMusic(incoming.getShowMusic());
        current.setShowWishes(incoming.getShowWishes());
        current.setHeroImageUrl(incoming.getHeroImageUrl());
        current.setBackgroundMusicUrl(incoming.getBackgroundMusicUrl());
        current.setBackgroundMusicTitle(incoming.getBackgroundMusicTitle());
        current.setCeremonyTitle(incoming.getCeremonyTitle());
        current.setCeremonyPlaceName(incoming.getCeremonyPlaceName());
        current.setCeremonyAddress(incoming.getCeremonyAddress());
        current.setCeremonyTime(incoming.getCeremonyTime());
        current.setCeremonyMapUrl(incoming.getCeremonyMapUrl());
        current.setReceptionTitle(incoming.getReceptionTitle());
        current.setReceptionPlaceName(incoming.getReceptionPlaceName());
        current.setReceptionAddress(incoming.getReceptionAddress());
        current.setReceptionTime(incoming.getReceptionTime());
        current.setReceptionMapUrl(incoming.getReceptionMapUrl());
        current.setQrImageUrl(incoming.getQrImageUrl());
        current.setQrDescription(incoming.getQrDescription());
        current.setQrButtonText(incoming.getQrButtonText());
        return siteContentRepository.save(current);
    }

    private SiteContent createDefault() {
        SiteContent site = new SiteContent();
        site.setHeroTitle("Duy Trung ❤️ Thu Trang");
        site.setShowGallery(true);
        site.setShowMusic(true);
        site.setShowWishes(true);
        return site;
    }
}
