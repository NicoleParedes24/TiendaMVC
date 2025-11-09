## 🏪 TiendaMVC (Java + MySQL Workbench)
Este repositorio contiene un sistema de gestión de tienda desarrollado en Java, aplicando la arquitectura MVC (Modelo - Vista - Controlador) y conectado a una base de datos en MySQL Workbench.
Permite registrar, editar y eliminar clientes y productos, además de gestionar ventas mediante una interfaz gráfica creada con Swing. 

## 📁 Estructura del Proyecto


# TiendaMVC
```
├── src/ 
│   ├── controller/   ← Controladores que manejan la lógica del sistema
│   ├── model/        ← Clases que representan las entidades y la conexión a la base de datos
│   ├── view/         ← Interfaces gráficas creadas con Swing
│   └── images/       ← Imágenes utilizadas en la interfaz
│
├── lib/              ← Librerías externas (por ejemplo, el conector MySQL)
└── README.md         ← Este archivo
```

## ✅ Características principales
- Gestión de clientes: registrar, editar y eliminar información.  
- Gestión de productos: control de inventario y precios.  
- Módulo de ventas: registrar ventas asociadas a clientes.  
- 🗂 Arquitectura MVC: separación clara entre modelo, vista y controlador.  
- 🖼️ Interfaz gráfica amigable creada con Swing.  
- 🛢️ Conexión con MySQL Workbench para el almacenamiento de datos.  


---
##  Cómo ejecutar el sistema

1. Clona o descarga este repositorio.  
2. Abre el proyecto en NetBeans o IntelliJ IDEA.  
3. Asegúrate de agregar el conector MySQL (JDBC) en la carpeta lib/.  
4. Configura los datos de conexión en la clase del modelo (usuario, contraseña, base de datos).  
5. Ejecuta la clase principal Main.java.  

---

 El archivo tienda\_db.sql será agregado próximamente para la creación de la base de datos.  


##  Tecnologías utilizadas

- Java (Swing)  

- MySQL Workbench  

- JDBC (Connector/J)  

- Patrón MVC



# Desarrollado por Nicole Paredes Espín



