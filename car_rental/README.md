Car Rental Management System – Spring Boot Backend

-> Developed a full-featured Spring Boot backend for a multi-branch car rental platform supporting user registration, bookings, payments, discounts, and reporting.

-> Implemented secure authentication and authorization using JWT, enabling role-based access for Admin, Staff, and Customer operations across the system.

-> Designed core domain models including User, Branch, Car, Rental, Payment, Discount, Notification, and ReportJob, mapping complex relationships with Spring Data JPA.

-> Built comprehensive REST APIs covering user management, vehicle availability, rental booking, status updates, payments, notifications, and CSV report exports.

-> Implemented rental lifecycle workflows including real-time car availability checking, booking creation, multi-branch pickup/drop, rental status transitions, and cost calculation.

-> Developed discount engine that applies percentage or flat-rate coupon codes dynamically during payment processing.

-> Created payment module supporting transaction processing, refund handling, payment status tracking (PENDING/COMPLETED/FAILED), and high-value transaction filtering.

-> Designed multi-branch car inventory system, enabling searching by branch, availability date, and vehicle attributes.

-> Implemented notification service (email/SMS simulation) to send booking confirmations, reminders, updates, and payment alerts to users.

-> Built CSV-based reporting module for rental history, revenue analytics, customer loyalty, and car usage statistics, including date-range filtering and downloadable reports.

-> Optimized API performance using service-layer caching, query optimization, and transaction-safe service orchestration.

-> Documented the entire API suite using Postman collections and Swagger UI for easy testing, onboarding, and client integration.

-> Ensured clean architecture with layered design (Controller → Service → Repository) following Spring best practices.

A fully featured Spring Boot backend designed for managing car rentals across multiple branches.
Supports JWT authentication, rental booking, payments, discounts, notifications, and CSV reporting.

==> Features
=> Authentication & Users

JWT-based secure login

Roles: ADMIN, STAFF, CUSTOMER

User registration, search, and loyalty point tracking

=> Car Management

Add/update cars with details (brand, model, year, pricing)

Branch-based car allocation

Check real-time availability

Fetch cars available before specific dates

=> Branch Management

Manage rental branches

Search by name or address

Link cars and rentals to branches

=> Rental Management

Book rentals with start & end dates

Real-time availability validation

Multi-branch pickup/drop-off

Rental status updates (BOOKED, ONGOING, COMPLETED, CANCELLED)

Rental history filtering (date-range, status)

=>  Payments & Discounts

Process payments for rentals

Apply discount codes (Flat or Percentage)

Track payment status (PENDING, COMPLETED, FAILED)

High-value payment filtering

=> Notifications

Send and store notifications for users

Booking confirmations, reminders, alerts

=> Reports (CSV Export)

Rentals report (date range)

Revenue report

Car usage report

Customer loyalty report