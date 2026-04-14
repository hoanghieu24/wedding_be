package com.happywedding.backend.controller;

import com.happywedding.backend.dto.ApiMessageResponse;
import com.happywedding.backend.dto.PublicSiteResponse;
import com.happywedding.backend.dto.RsvpRequest;
import com.happywedding.backend.dto.WishRequest;
import com.happywedding.backend.entity.Rsvp;
import com.happywedding.backend.entity.Wish;
import com.happywedding.backend.repository.GalleryImageRepository;
import com.happywedding.backend.repository.RsvpRepository;
import com.happywedding.backend.repository.WishRepository;
import com.happywedding.backend.service.SiteContentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    private final SiteContentService siteContentService;
    private final GalleryImageRepository galleryImageRepository;
    private final WishRepository wishRepository;
    private final RsvpRepository rsvpRepository;

    public PublicController(SiteContentService siteContentService,
                            GalleryImageRepository galleryImageRepository,
                            WishRepository wishRepository,
                            RsvpRepository rsvpRepository) {
        this.siteContentService = siteContentService;
        this.galleryImageRepository = galleryImageRepository;
        this.wishRepository = wishRepository;
        this.rsvpRepository = rsvpRepository;
    }

    @GetMapping("/site")
    public ResponseEntity<PublicSiteResponse> getSite() {
        return ResponseEntity.ok(new PublicSiteResponse(
                siteContentService.getOrCreate(),
                galleryImageRepository.findAllByOrderByIdDesc(),
                wishRepository.findAllByVisibleTrueOrderByCreatedAtDesc()
        ));
    }

    @PostMapping("/wish")
    public ResponseEntity<ApiMessageResponse> createWish(@Valid @RequestBody WishRequest request) {
        Wish wish = new Wish();
        wish.setGuestName(request.getGuestName());
        wish.setMessage(request.getMessage());
        wish.setVisible(true);
        wishRepository.save(wish);
        return ResponseEntity.ok(new ApiMessageResponse("Gửi lời chúc thành công"));
    }

    @PostMapping("/rsvp")
    public ResponseEntity<ApiMessageResponse> createRsvp(@Valid @RequestBody RsvpRequest request) {
        Rsvp rsvp = new Rsvp();
        rsvp.setGuestName(request.getGuestName());
        rsvp.setPhone(request.getPhone());
        rsvp.setGuestCount(request.getGuestCount());
        rsvp.setAttendanceType(request.getAttendanceType());
        rsvp.setAttendanceStatus(request.getAttendanceStatus());
        rsvp.setNote(request.getNote());
        rsvpRepository.save(rsvp);
        return ResponseEntity.ok(new ApiMessageResponse("Xác nhận tham dự thành công"));
    }
}
