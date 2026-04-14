package com.happywedding.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "site_content")
public class SiteContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "groom_name")
    private String groomName;

    @Column(name = "bride_name")
    private String brideName;

    @Column(name = "wedding_date", length = 100)
    private String weddingDate;

    @Column(name = "wedding_location")
    private String weddingLocation;

    @Column(name = "wedding_map_url", length = 500)
    private String weddingMapUrl;

    @Column(name = "hero_title")
    private String heroTitle;

    @Column(name = "welcome_message", columnDefinition = "TEXT")
    private String welcomeMessage;

    @Column(columnDefinition = "TEXT")
    private String story;

    @Column(name = "show_gallery")
    private Boolean showGallery = true;

    @Column(name = "show_music")
    private Boolean showMusic = true;

    @Column(name = "show_wishes")
    private Boolean showWishes = true;

    @Column(name = "hero_image_url", length = 500)
    private String heroImageUrl;

    @Column(name = "background_music_url", length = 500)
    private String backgroundMusicUrl;

    @Column(name = "background_music_title")
    private String backgroundMusicTitle;

    @Column(name = "ceremony_title")
    private String ceremonyTitle;

    @Column(name = "ceremony_place_name")
    private String ceremonyPlaceName;

    @Column(name = "ceremony_address")
    private String ceremonyAddress;

    @Column(name = "ceremony_time", length = 100)
    private String ceremonyTime;

    @Column(name = "ceremony_map_url", length = 500)
    private String ceremonyMapUrl;

    @Column(name = "reception_title")
    private String receptionTitle;

    @Column(name = "reception_place_name")
    private String receptionPlaceName;

    @Column(name = "reception_address")
    private String receptionAddress;

    @Column(name = "reception_time", length = 100)
    private String receptionTime;

    @Column(name = "reception_map_url", length = 500)
    private String receptionMapUrl;

    @Column(name = "qr_image_url", length = 500)
    private String qrImageUrl;

    @Column(name = "qr_description", length = 500)
    private String qrDescription;

    @Column(name = "qr_button_text", length = 100)
    private String qrButtonText;
}
