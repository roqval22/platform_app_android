package com.example.platformapp.core.cfg

/**
 * CONFIGURACIÓN GLOBAL DE LA PLATAFORMA (Macros de Lógica)
 * Modifica estos valores para cambiar el comportamiento de la app base.
 */
object AppCfg {
    
    // --- Identidad de la App ---
    const val APP_NAME = "Platform App Base"
    
    // --- Configuración de Firebase ---
    object Firebase {
        const val ENABLE_AUTH = true
        const val ENABLE_FIRESTORE = true
        const val ENABLE_STORAGE = true
        const val ENABLE_MESSAGING = true
        
        // Colecciones de Firestore
        const val USERS_COLLECTION = "users"
        const val LOGS_COLLECTION = "app_logs"
    }

    // --- Configuración de UI ---
    object UI {
        const val SHOW_WELCOME_SCREEN = true
        const val ENABLE_DARK_MODE_BY_DEFAULT = false
        const val PRIMARY_COLOR = 0xFF6200EE // Color Púrpura base
    }

    // --- Feature Flags (Funcionalidades) ---
    object Features {
        const val USE_NOTIFICATIONS = true
        const val REQUIRE_LOGIN = true
        const val ENABLE_ANALYTICS = false
    }
}
