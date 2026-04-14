package com.happywedding.backend.dto;

import com.happywedding.backend.entity.GalleryImage;
import com.happywedding.backend.entity.SiteContent;
import com.happywedding.backend.entity.Wish;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PublicSiteResponse {
    private SiteContent site;
    private List<GalleryImage> gallery;
    private List<Wish> wishes;
}
