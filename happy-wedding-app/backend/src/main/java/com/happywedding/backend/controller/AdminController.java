package com.happywedding.backend.controller;

import com.happywedding.backend.dto.AdminDashboardResponse;
import com.happywedding.backend.dto.ApiMessageResponse;
import com.happywedding.backend.entity.GalleryImage;
import com.happywedding.backend.entity.SiteContent;
import com.happywedding.backend.entity.Wish;
import com.happywedding.backend.exception.ResourceNotFoundException;
import com.happywedding.backend.repository.GalleryImageRepository;
import com.happywedding.backend.repository.RsvpRepository;
import com.happywedding.backend.repository.WishRepository;
import com.happywedding.backend.service.FileStorageService;
import com.happywedding.backend.service.SiteContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final SiteContentService siteContentService;
    private final GalleryImageRepository galleryImageRepository;
    private final WishRepository wishRepository;
    private final RsvpRepository rsvpRepository;
    private final FileStorageService fileStorageService;

    public AdminController(SiteContentService siteContentService,
                           GalleryImageRepository galleryImageRepository,
                           WishRepository wishRepository,
                           RsvpRepository rsvpRepository,
                           FileStorageService fileStorageService) {
        this.siteContentService = siteContentService;
        this.galleryImageRepository = galleryImageRepository;
        this.wishRepository = wishRepository;
        this.rsvpRepository = rsvpRepository;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/dashboard")
    public ResponseEntity<AdminDashboardResponse> getDashboard() {
        return ResponseEntity.ok(new AdminDashboardResponse(
                siteContentService.getOrCreate(),
                galleryImageRepository.findAllByOrderByIdDesc(),
                wishRepository.findAllByOrderByCreatedAtDesc(),
                rsvpRepository.findAllByOrderByCreatedAtDesc()
        ));
    }

    @PutMapping("/site")
    public ResponseEntity<SiteContent> updateSite(@RequestBody SiteContent request) {
        return ResponseEntity.ok(siteContentService.update(request));
    }

    @PostMapping("/gallery/upload")
    public ResponseEntity<GalleryImage> uploadGallery(@RequestParam("file") MultipartFile file,
                                                      @RequestParam(value = "title", required = false) String title) throws Exception {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File upload không được để trống");
        }
        String finalTitle = StringUtils.hasText(title) ? title : file.getOriginalFilename();
        FileStorageService.UploadResult uploadResult = fileStorageService.uploadImage(file, finalTitle);

        GalleryImage image = new GalleryImage();
        image.setTitle(uploadResult.title());
        image.setImageUrl(uploadResult.imageUrl());
        image.setPublicId(uploadResult.publicId());
        return ResponseEntity.ok(galleryImageRepository.save(image));
    }

    @PatchMapping("/wishes/{id}/toggle")
    public ResponseEntity<ApiMessageResponse> toggleWish(@PathVariable Long id) {
        Wish wish = wishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lời chúc"));
        wish.setVisible(!Boolean.TRUE.equals(wish.getVisible()));
        wishRepository.save(wish);
        return ResponseEntity.ok(new ApiMessageResponse("Cập nhật trạng thái lời chúc thành công"));
    }
}
