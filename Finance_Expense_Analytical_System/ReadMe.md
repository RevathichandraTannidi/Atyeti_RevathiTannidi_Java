💼 WealthPilot — Personal Finance Analytics & Advisory Engine


A Java-based personal finance system that tracks user transactions, analyzes spending patterns, provides smart savings advice, and evaluates loan affordability using real-world financial logic

🚀 Overview

WealthPilot is a console-based personal finance assistant built using Core Java that helps users:

✔ Track daily transactions
✔ Analyze spending patterns
✔ Get personalized savings advice
✔ Evaluate loan (EMI) affordability
✔ Receive real-time budget alerts

🎯 Key Features
📊 Spending Analytics
Category-wise expense breakdown using Java Streams
Identify top spending category
Monthly spending insights
💡 Smart Savings Advisor
Strategy Pattern for dynamic recommendations
Data-driven suggestions based on user spending
🏦 EMI Calculator
Real-world EMI formula implementation
Loan affordability check (≤ 40% income rule)
Total interest & payment breakdown
🔔 Budget Alerts (Multithreading)
Background monitoring using ScheduledExecutorService
Alerts when spending exceeds threshold
📄 Monthly Report Generator
Income vs Spending vs Savings
Category-wise breakdown
🧪 Unit Testing
Test coverage using JUnit 5

🛠️ Tech Stack
Layer	Technology
Language	Core Java 17
Database	MySQL (JDBC)
Build Tool	Maven
Testing	JUnit 5
Concepts	Streams, Multithreading, Design Patterns
🏗️ Project Structure
fincoach/
├── model/
├── service/
├── repository/
├── patterns/
├── concurrent/
├── util/
├── db/
└── Main.java
Design Patterns Used
✅ Strategy Pattern → Dynamic savings logic
✅ Factory Pattern → Strategy creation
✅ Singleton Pattern → Database connection
🧱 SOLID Principles
S → Single responsibility per class
O → Extend without modifying existing code
L → Interchangeable strategy implementations
I → Focused interfaces
D → Depend on abstractions
🔥 Highlights

✔ Real-world finance use case
✔ Clean architecture
✔ Multithreading + Streams + JDBC combined
✔ Interview-ready project

🚀 Future Enhancements
GUI (JavaFX / Web UI)
REST APIs (Spring Boot)
Charts & analytics dashboard
User authentication




