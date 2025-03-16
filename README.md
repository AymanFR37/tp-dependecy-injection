# Dependency Injection Project

## Overview
This project demonstrates different methods of dependency injection in Java:
1. **Static Instantiation**
2. **Dynamic Instantiation**
3. **Dependency Injection with Spring Framework**
    - XML Configuration
    - Annotations

The project is structured to showcase how to decouple components and inject dependencies using various techniques.

---
## Key Components
### **1. DAO Layer**
- **`IDao.java`**: Interface defining the `getData()` method.
- **`DaoImpl.java`**: Implementation of `IDao` returning a static value.
- **`DaoImplV2.java`**: Alternative implementation of `IDao` for demonstration.
### **2. Business Logic Layer**
- **`IMetier.java`**: Interface defining the `calcul()` method.
- **`MetierImpl.java`**: Implementation of `IMetier` that uses `IDao` for calculations.
### **3. Presentation Layer**
- **`Pres1.java`**: Demonstrates dependency injection via **static instantiation**.
- **`Pres2.java`**: Demonstrates dependency injection via **dynamic instantiation** using a configuration file.
- **`PresSpringXML.java`**: Demonstrates dependency injection using **Spring Framework (XML configuration)**.
- **`PresSpringAnnotation.java`**: Demonstrates dependency injection using **Spring Framework (annotations)**.
---
## Dependency Injection Methods
### **1. Static Instantiation**
- **File**: `Pres1.java`
- **Description**: Dependencies are manually instantiated and injected.
- **Example**:
  ```java
  IDao dao = new DaoImpl();
  MetierImpl metier = new MetierImpl();
  metier.setDao(dao);
### **2. Dynamic Instantiation**
- **File**: `Pres2.java`
- **Description**: Dependencies are loaded dynamically using a configuration file (config.txt).
- **Example**:
  ```java
  Scanner scanner = new Scanner(new File("config.txt"));

  String daoClassName = scanner.nextLine();
  Class<?> cDao = Class.forName(daoClassName);
  IDao dao = (IDao) cDao.newInstance();
        
  String metierClassName = scanner.nextLine();
  Class<?> cMetier = Class.forName(metierClassName);
  IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
### **3. Spring Framework (XML Configuration)**
- **File**: `PresSpringXML.java`
- **Description**: Dependencies are injected using Spring's XML configuration (config.xml).
- **Example**:
  ```xml
    <bean id="dao" class="com.backend.dao.DaoImplV2"/>
    <bean id="metier" class="com.backend.metier.MetierImpl">
        <constructor-arg ref="dao"/>
    </bean>
### **4. Spring Framework (Annotations)**
- **File**: `PresSpringAnnotation.java`
- **Description**: Dependencies are injected using Spring annotations (@Component , @Autowired -> constructor).
- **Example**:
  ```java
    @Component("dao1")
    public class DaoImpl implements IDao { ... }
    
    @Component("metier")
    public class MetierImpl implements IMetier {
    @Autowired
    @Qualifier("dao1")
    private IDao dao;
    }
---
## Configuration Files

### **1. `config.xml`**
- Used for Spring XML configuration.
- Defines beans and their dependencies.
### **2. `config.txt`**
- Used for dynamic instantiation.
- Contains the fully qualified class name of the DAO implementation.
### **3. `pom.xml`**
- Maven configuration file.
- Includes dependencies for Spring Framework.
---
## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/AymanFR37/tp-dependecy-injection.git
2. Navigate to the project directory:
   ```bash
   cd <project-folder>
3. Compile and run the project using Maven:
   ```bash
   mvn clean install
   mvn exec:java -Dexec.mainClass="com.backend.presentation.Pres1"  # Replace with the desired main class
4. To run other classes, replace **Pres1** with:
- **Pres2** for dynamic instantiation.
- **PresSpringXML** for Spring XML configuration.
- **PresSpringAnnotation** for Spring annotations.
---
## Conclusion

🎯 **Key Takeaways**:
This project successfully demonstrates the power and flexibility of **dependency injection** in Java. By implementing **static instantiation**, **dynamic instantiation**, and leveraging the **Spring Framework** (both XML and annotations), we’ve explored how to decouple components and create more maintainable, testable, and scalable applications.

---

✨ **Why Dependency Injection Matters**:
- **Loose Coupling**: Components are independent, making the system easier to modify and extend.
- **Testability**: Dependencies can be mocked or replaced, simplifying unit testing.
- **Scalability**: Applications become more modular, allowing for easier scaling and maintenance.

---

🚀 **Next Steps**:
- Explore advanced Spring features like **Spring Boot** for faster development.
- Integrate **unit tests** using frameworks like JUnit and Mockito.
- ...
---

💡 **Final Thoughts**:
Dependency injection is not just a design pattern—it’s a philosophy that encourages clean, modular, and maintainable code. This project serves as a foundation for understanding and applying these principles in real-world applications.

Happy coding! 🚀