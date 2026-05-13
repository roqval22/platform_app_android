package com.example.platformapp.data.remote

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FCMService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM", "Nuevo token: $token")
        // Aquí podrías enviar el token a tu servidor/Firestore
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("FCM", "Mensaje recibido de: ${message.from}")
        
        message.notification?.let {
            Log.d("FCM", "Cuerpo notificación: ${it.body}")
            // Aquí puedes mostrar una notificación local si la app está en primer plano
        }
    }
}
