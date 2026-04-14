USE happy_wedding;

-- 1) Nếu muốn site_content id=1 có dữ liệu ngay từ đầu,
-- hãy INSERT trước rồi mới UPDATE.

-- 2) Đồng bộ DB với frontend hiện tại.
-- Nếu bạn giữ spring.jpa.hibernate.ddl-auto=update thì backend sẽ tự thêm 2 cột này.
-- Chạy tay cũng được để chủ động hơn.
ALTER TABLE rsvps
    ADD COLUMN IF NOT EXISTS phone VARCHAR(30),
    ADD COLUMN IF NOT EXISTS guest_count INT DEFAULT 1;

-- 3) Cột email trong bảng rsvps hiện chưa dùng ở frontend.
-- Có thể giữ lại hoặc xóa sau khi xác nhận không cần nữa.

-- 4) Dữ liệu mẫu site_content chuẩn hơn nên làm theo thứ tự này:
DELETE FROM site_content;

INSERT INTO site_content (
    groom_name,
    bride_name,
    wedding_date,
    wedding_location,
    wedding_map_url,
    hero_title,
    welcome_message,
    story,
    show_gallery,
    show_music,
    show_wishes,
    hero_image_url,
    background_music_url,
    background_music_title,
    ceremony_title,
    ceremony_place_name,
    ceremony_address,
    ceremony_time,
    ceremony_map_url,
    reception_title,
    reception_place_name,
    reception_address,
    reception_time,
    reception_map_url,
    qr_image_url,
    qr_description,
    qr_button_text
) VALUES (
    'Duy Trung',
    'Thu Trang',
    '2026-05-10 17:30:00',
    'Nghệ An',
    'https://maps.google.com',
    'Duy Trung & Thu Trang',
    'Một lời hẹn giữa yêu thương, để cùng nhau chứng kiến khoảnh khắc đẹp nhất của chúng tôi.',
    'Chúng tôi gặp nhau, yêu nhau và quyết định đồng hành cùng nhau đến hết cuộc đời.',
    TRUE,
    TRUE,
    TRUE,
    '',
    '',
    'Perfect - Ed Sheeran',
    'Lễ thành hôn',
    'Nghệ An',
    '40 Nhà Chung, Hoàn Kiếm',
    '15:30 - 17:00',
    'https://maps.google.com/?q=40+Nha+Chung+Hoan+Kiem',
    'Tiệc cưới',
    'Khách sạn Metropole · Grand Ballroom',
    '15 Lý Thường Kiệt, Hà Nội',
    '18:00 - 22:00',
    'https://maps.google.com/?q=15+Ly+Thuong+Kiet+Ha+Noi',
    'https://your-domain.com/uploads/qr.png',
    'Quét mã tại cửa để nhận ảnh cưới kỷ niệm và món quà lưu niệm nhỏ từ cô dâu chú rể.',
    'Xem QR'
);
