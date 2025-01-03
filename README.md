# Documentación de la API

Esta es una aplicación desarrollada con **Spring Boot** que expone endpoints REST para gestionar entidades como **Franquicias**, **Productos** y **Sucursales**. A continuación, se describe cómo interactuar con estos recursos.

## Endpoints de la API

### 1. **Franquicia**

- **Crear una franquicia**

  **URL**: `/franquicia/create`  
  **Método**: `POST`  
  **Descripción**: Crea una nueva franquicia.  
  **Cuerpo de la solicitud (JSON)**:

  ```json
  {
    "nombre": "Nombre de la franquicia"
  }
  ```
**Respuesta Exitosa**

  ```json
  {
    "id": 1,
    "nombre": "Nombre de la franquicia"
  }
  ```

**Cambia el nombre de la franquicia**

  **URL**: `/franquicia/update/{id}?nombre=NuevoNombre`  
  **Método**: `PATCH`
    **Descripción**: Actualiza el nombre de una franquicia existente.
    **Parámetros de la URL**:
    - `id` (requerido): ID de la franquicia a actualizar.
    - `nombre` (requerido): Nuevo nombre de la franquicia.

**Respuesta Exitosa**
    
```json
      {
         "id": 1,
         "nombre": "NuevoNombre"
      }
```

### 2. **Producto**

- **Crear un producto**

  **URL**: `/producto/create`  
  **Método**: `POST`  
  **Descripción**: Crea un nuevo producto.  
  **Cuerpo de la solicitud (JSON)**:

  ```json
  {
    "nombre": "Nombre del producto",
    "stock": 100.0,
    "idSucursal": 1
  }
  ```
**Respuesta Exitosa**

  ```json
  {
    "id": 1,
    "nombre": "Nombre del producto",
    "stock": 100.0,
    "idSucursal": 1
  }
  ```
- **Actualizar stock de un producto**
    
**URL**: `/producto/update/{id}?stock=NuevoStock`  
**Método**: `PATCH`
**Descripción**: Actualiza el stock de un producto existente.
**Parámetros de la URL**:
     - `id` (requerido): ID del producto a actualizar.
     - `stock` (requerido): Nuevo stock del producto.


**Respuesta Exitosa**
        
```json
        {
            "id": 1,
            "nombre": "Nombre del producto",
            "stock": 200.0,
            "idSucursal": 1
        }
   ```

- **Eliminar un producto**

  **URL**: `/producto/delete/{id}`  
  **Método**: `DELETE`  
  **Descripción**: Elimina un producto existente.  
  **Parámetros de la URL**:
    - `id` (requerido): ID del producto a eliminar.

- **Cambiar nombre de un producto**

  **URL**: `/producto/update/{id}?nombre=NuevoNombre`  
  **Método**: `PATCH`  
  **Descripción**: Actualiza el nombre de un producto existente.  
  **Parámetros de la URL**:
    - `id` (requerido): ID del producto a actualizar.
    - `nombre` (requerido): Nuevo nombre del producto.



### 3. **Sucursal**

- **Crear una sucursal**

  **URL**: `/sucursal/create`  
  **Método**: `POST`  
  **Descripción**: Crea una nueva sucursal.  
  **Cuerpo de la solicitud (JSON)**:

  ```json
  {
    "nombre": "Nombre de la sucursal",
    "idFranquicia": 1
  }
  ```
**Respuesta Exitosa**

  ```json
  {
    "id": 1,
    "nombre": "Nombre de la sucursal",
    "idFranquicia": 1
  }
  ```
**Actualizar nombre de una sucursal**

**URL**: `/sucursal/update/{id}?nombre=NuevoNombre`  
    **Método**: `PATCH`  
    **Descripción**: Actualiza el nombre de una sucursal existente.  
    **Parámetros de la URL**:
        - `id` (requerido): ID de la sucursal a actualizar.
        - `nombre` (requerido): Nuevo nombre de la sucursal.



## Clonar el repositorio

Para clonar el repositorio, ejecute el siguiente comando:

```bash
git clone url-del-repositorio
```

## Ejecutar la aplicación

Para ejecutar la aplicación, ejecute el siguiente comando:

```bash
mvn spring-boot:run
```

