# 🚀 Mobile Test Automation - General Store App

## 🌟 Introduction
This repository contains a robust **mobile automation testing** framework for the **General Store App**, built using **Appium** and **TestNG**. It follows the **Page Object Model (POM)** design pattern and integrates with **Allure Reports** for clear and comprehensive test reporting.

---
## 🎯 Key Features
- **Automated UI Testing** for the General Store App on Android devices.
- **Page Object Model (POM)** for structured test automation.
- **Data-Driven Testing** using external JSON files.
- **Allure Reports** for visually appealing and detailed test execution reports.
- **Maven-based** project for easy dependency management.

---
## ✅ Automated Test Scenarios
This project automates the following **end-to-end** test case:

1. **Launch** the General Store App on an Android device/emulator.
2. **Select** a country (e.g., Egypt) from the dropdown.
3. **Enter** a username.
4. **Choose** a gender option.
5. **Proceed** to shopping.
6. **Add** two products to the cart.
7. **Navigate** to the cart screen.
8. **Verify** that selected products are displayed correctly.
9. **Validate** the total price matches the sum of the selected items.

---
## 🛠️ Tech Stack & Tools
- **Programming Language**: Java
- **Automation Framework**: Appium
- **Test Runner**: TestNG
- **Reporting**: Allure Reports
- **Build Tool**: Maven
- **IDE**: Eclipse / IntelliJ IDEA

---
## 📂 Project Structure

![ProjectStructure](https://github.com/user-attachments/assets/c6c2488b-f822-4bee-9a08-4241e88a99ca)

---
## ⚙️ Setup & Prerequisites
Before running the tests, ensure the following are installed:
- **Java 8+**
- **Maven**
- **Appium 2.0**
- **Android Studio & Emulator**
- **Appium Server**

---
## 🚀 Running the Tests
### 1️⃣ Start Appium Server
```sh
appium
```
### 2️⃣ Launch Android Emulator or Connect a Physical Device
### 3️⃣ Run Test Cases
```sh
mvn clean test
```
### 4️⃣ Generate & View Allure Report
```sh
allure serve
```

---
## 📊 Test Reports & Results
**Allure Reports provide detailed insights into the test execution, including step-by-step execution and failure analysis.**

![Allure Report](https://github.com/user-attachments/assets/e67c5fcc-7bc4-42aa-baf4-56a4390f130b)


---
## 📖 References
- [Appium Official Docs](http://appium.io/docs/en/2.0/quickstart/)
- [TestNG Documentation](https://testng.org/doc/)
- [Allure Reports Guide](https://docs.qameta.io/allure/)

---
## 🔄 Future Enhancements
- ✅ iOS Automation Support
- ✅ Cloud-Based Testing Integration
- ✅ Parallel Execution Optimization
- ✅ CI/CD Pipeline Integration

---
## 🤝 Contributions & Support
Contributions are highly encouraged! Feel free to **fork, enhance, and submit PRs**.

📩 For queries or suggestions, reach out via GitHub Issues.

---
### 🎯 Happy Testing & Automation! 🚀

