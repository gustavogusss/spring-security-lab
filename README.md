## 🧱 Project Structure

<p align="left">
  <img src="https://img.shields.io/badge/Java-17+-red?logo=openjdk&logoColor=white&style=for-the-badge" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot&logoColor=white&style=for-the-badge" />
  <img src="https://img.shields.io/badge/Spring%20Security-Learning-blue?logo=springsecurity&logoColor=white&style=for-the-badge" />
</p>



# Spring Security Lab

A clean, structured and evolving repository focused on practicing and understanding **Spring Security** fundamentals and advanced concepts.

This project starts as a minimal Spring Boot application and will progressively evolve as new security mechanisms are implemented and explored.

---

## 📌 Purpose of This Repository

The goal of this lab is to provide a practical environment to experiment with:

- Core Spring Security behavior
- Authentication & authorization flows
- Filters and the security chain
- Customization of the security context
- Stateless security approaches
- Real-world authentication patterns

All features will be added incrementally throughout the study process.

---

## 🚀 Project Evolution (Timeline)

This section will document the evolution of the project step by step.

> You will update these items manually as you progress.

### **Stage 1 — Initial Setup**
- Empty Spring Boot project  
- Basic Spring Security dependency  

### **Stage 2 — First Security Configurations**
- Initial security setup implemented in the feature/adding_security branch. 
- Users -> passwors: user -> user; admin -> admin 
### **Stage 3 — Custom Authentication / Filters**
- PostgreSQL running in Docker via `docker compose up`
- Database schema managed with Flyway migrations
- JDBC-based authentication using Spring Security
- Users and authorities seeded via Flyway for testing purposes
- Environment-variable–driven datasource configuration
- This all is available at feature/addin_database branch: 
  - users, pass: user, user; admin, admin
- Custom implementation of UserDetailsService is at branch feature/custom_DB_table
  - users, pass: user@example.com, user; admin@example.com, admin;

### **Stage 4 — Stateless Security / JWT**
- 

### **Stage 5 — OAuth2 / External IdPs**
- 

### **Stage 6 — Advanced Topics**
- 

---

## 🧱 Project Structure

You may update this section as the project grows:

