# Sistema de Gestión de Inventario y Abastecimiento - `store`

Este repositorio contiene la solución a la **Prueba Técnica de Ingeniería para el Desarrollo de Software**. El proyecto consiste en un sistema backend robusto enfocado en la automatización del control de inventarios, aplicando principios de arquitectura limpia, desacoplamiento técnico mediante interfaces e Inversión de Control (IoC).

El núcleo de la aplicación está diseñado bajo el ecosistema de **Spring Boot**, estructurando las reglas de negocio críticas para responder de forma eficiente ante fluctuaciones en el stock de productos y garantizar el reabastecimiento oportuno mediante integraciones simuladas con proveedores.

---

## 1. Arquitectura del Sistema y Patrones de Diseño

La aplicación se ha desarrollado siguiendo una **Arquitectura en Capas (Layered Architecture)** para garantizar una separación clara de responsabilidades, alta cohesión y bajo acoplamiento:

* **Capa de Dominio / Entidades (`com.famisanar.store.entity`):** Contiene los modelos de datos que mapean las tablas de la base de datos relacional mediante JPA. La entidad `Product` encapsula los atributos y el estado del producto.
* **Capa de Persistencia / Repositorios (`com.famisanar.store.repository`):** Implementa el patrón *Repository* abstrayendo el acceso a los datos a través de `ProductRepository`.
* **Capa de Servicio / Lógica de Negocio (`com.famisanar.store.service`):** Implementa la **Inversión de Control (IoC)** mediante una interfaz pura (`ProductService`) y una clase de implementación (`ProductServiceImpl`).
* **Capa de Entrada / Controladores (`com.famisanar.store.controller`):** Expone las API REST para interactuar con el sistema.

---

## 2. Estructura del Proyecto

```text
store/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/famisanar/store/
│       │       ├── controller/  # Controladores REST
│       │       ├── entity/      # Entidades (Product.java)
│       │       ├── repository/  # Interfaces de persistencia (ProductRepository.java)
│       │       ├── service/     # Contratos e implementaciones (ProductService.java, ProductServiceImpl.java)
│       │       └── StoreApplication.java  # Clase principal
│       └── resources/
│           └── application.properties   # Configuración global
└── pom.xml                          # Dependencias de Maven
