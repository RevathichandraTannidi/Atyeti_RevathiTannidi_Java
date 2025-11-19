Car Rental Management System – Spring Boot Backend

A fully featured Spring Boot backend designed for managing car rentals across multiple branches.
Supports JWT authentication, rental booking, payments, discounts, notifications, and CSV reporting.

==>> Features
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