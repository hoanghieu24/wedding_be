# Happy Wedding - Duy Trung & Thu Trang

Bộ source full-stack mẫu cho web thiệp cưới:
- Frontend: React + Vite
- Backend: Spring Boot 3 + MySQL + JWT
- Media: Cloudinary

## Chức năng đã có
- Trang user xem thiệp cưới
- Gửi lời chúc
- Gửi RSVP tham dự trực tiếp hoặc online
- Trang admin đăng nhập
- Admin sửa nội dung thiệp cưới
- Bật/tắt hiển thị lời chúc / gallery / nhạc
- Upload ảnh lên Cloudinary rồi lưu URL vào MySQL
- Danh sách RSVP và lời chúc trong admin

## Tài khoản mặc định
- username: admin
- password: 123456

## Chạy backend
```bash
cd backend
mvn spring-boot:run
```

## Chạy frontend
```bash
cd frontend
npm install
npm run dev
```

## MySQL
Tạo database `happy_wedding` hoặc để `createDatabaseIfNotExist=true` trong JDBC URL.

## Cloudinary
Điền biến môi trường:
- CLOUDINARY_CLOUD_NAME
- CLOUDINARY_API_KEY
- CLOUDINARY_API_SECRET

Theo tài liệu chính thức của Cloudinary, backend Java có thể upload file server-side bằng Java SDK qua HTTPS, còn React có thể dùng upload widget hoặc gọi API của backend. Trong bộ này mình chọn cách an toàn hơn: upload qua backend Spring Boot rồi backend đẩy file lên Cloudinary. citeturn522943search0turn522943search3turn522943search9

## Gợi ý deploy
- Frontend React: Vercel hỗ trợ deploy từ Git và thêm custom domain rất nhanh. citeturn522943search2turn522943search5
- Backend Spring Boot: Render hỗ trợ Web Service từ Git repo hoặc Dockerfile. citeturn522943search1turn522943search10turn522943search13

## Domain `happyweddingduytrungvathutrang.io.vn`
Một số nhà đăng ký tại Việt Nam có thông tin hoặc hỗ trợ với `.io.vn` gồm P.A Việt Nam, Mắt Bão, iNET và Nhân Hòa. Bạn nên kiểm tra trực tiếp tình trạng tên miền trước khi mua. citeturn911786search0turn911786search1turn911786search6turn911786search10

## Khuyến nghị stack deploy thực tế
- Domain: mua tại iNET hoặc P.A Việt Nam
- Frontend: Vercel
- Backend: Render
- Database MySQL: Aiven / Railway MySQL / VPS riêng

## Việc bạn nên làm tiếp theo
1. Thay toàn bộ text demo bằng nội dung thật của đám cưới.
2. Thêm section lịch trình lễ ăn hỏi / lễ cưới / tiệc cưới nếu muốn giống website mẫu hơn.
3. Thêm xác thực mạnh hơn, validate dữ liệu và phân trang admin trước khi đưa production.
4. Đổi mật khẩu admin mặc định ngay sau khi deploy.
