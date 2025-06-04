# AGENTS.md – Alpaca Tours (Legacy Java Web App in Struts 1.x)

## 🦙 Project: Alpaca Tours

Alpaca Tours is a fictional legacy travel booking system implemented using JSP and Apache Struts 1.x. This project simulates an early-2000s Java EE application architecture for training, testing, or modernization initiatives.

---


## 🛠️ System Architecture

* **Frontend**: JSPs with Struts HTML Tags
* **Backend**: Struts 1.x Action classes
* **Forms**: ActionForms with `validate()` methods
* **Data Layer**: JDBC with simple DAO pattern
* **Configuration**: `web.xml`, `struts-config.xml`
* **Server**: Apache Tomcat 9 or older (for compatibility)

---

## 🧱 Functional Modules

### 🧍‍♂️ User Management

* Register
* Login / Logout
* Session-based authentication

### 🗺️ Tour Management

* View list of tours
* View detailed tour info
* Admin can create/edit/delete tours

### 📅 Booking

* Users can book a tour
* View booking history
* Admin can view all bookings


---

## 🧾 Initial Entities

### `User`

* `id`: int
* `username`: String
* `password`: String (plaintext for legacy realism)
* `role`: String (`USER`, `ADMIN`)

### `Tour`

* `id`: int
* `title`: String
* `location`: String
* `price`: double
* `description`: String
* `capacity`: int

### `Booking`

* `id`: int
* `userId`: FK
* `tourId`: FK
* `numPeople`: int
* `bookingDate`: java.sql.Date

---

## 💡 Design Philosophy

* Emulate a 2000s-style monolithic JSP/Struts application
* Favor procedural, verbose code with limited abstraction
* Show tight coupling between JSPs and business logic
* Prioritize realism over modern best practices

