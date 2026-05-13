# Platform App Android (Base de Proyecto)

Este repositorio es una base genérica diseñada para crear múltiples aplicaciones Android rápidamente, centralizando la configuración en un solo lugar.

## 🚀 Cómo crear una nueva App (Instanciación)

Para generar una nueva aplicación a partir de esta base, sigue estos pasos:

### 1. Usar el Script de Configuración (Recomendado)
Abre una terminal (PowerShell) en la raíz del proyecto y ejecuta:
```powershell
./setup_app.ps1 -AppName "Nombre de Tu App" -AppId "com.tuempresa.proyecto"
```
Esto actualizará automáticamente el nombre de la app y el identificador de paquete en todos los archivos de configuración.

### 2. Configuración Manual (Opcional)
Si prefieres hacerlo a mano, modifica estos archivos:
- **`app/build_cfg.gradle.kts`**: Cambia el `app_id` (Application ID) y versiones.
- **`app/src/main/java/com/example/platformapp/core/cfg/AppCfg.kt`**: Cambia el `APP_NAME` y activa/desactiva módulos de Firebase o Features.
- **`app/src/main/java/com/example/platformapp/core/cfg/StyleCfg.kt`**: Cambia los colores y el estilo visual.

### 3. Firebase
1. Crea un proyecto en la consola de Firebase.
2. Descarga el `google-services.json`.
3. Pégalo en la carpeta `/app/` del proyecto.

### 4. Sincronizar (Sync)
Para que los cambios de identidad surtan efecto, debes "Sincronizar" el proyecto con Gradle:
1. En Android Studio, busca el icono del **elefante con una flecha azul** en la barra de herramientas superior (o ve a `File > Sync Project with Gradle Files`).
2. Esto hará que Android Studio lea el nuevo `app_id` y genere los recursos con la nueva identidad.

---

## 🛠 Arquitectura
- **Clean Architecture**: Capas separadas de UI, Domain y Data.
- **MVVM**: Manejo de estado con ViewModels y Flow.
- **Hilt**: Inyección de dependencias centralizada.
- **Firebase Master Module**: Auth, Firestore, Storage y FCM listos para usar mediante configuración.

## 📁 Archivos Maestro de Configuración (_cfg)
- `build_cfg.gradle.kts`: Configuración de compilación y sistema.
- `AppCfg.kt`: Configuración de lógica de negocio y Firebase.
- `StyleCfg.kt`: Configuración de UI y temas.
