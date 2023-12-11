package com.example.practica_appreceptora

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class MensajeReciever : BroadcastReceiver(){
    // determinar canales por los que se va a comunicar
     private val ID_CANAL = "appReceptora"
    private val idNotificacion = 111

    override fun onReceive(contexto: Context?, intentMetodo: Intent?) {
        // se toma el contexto que recibe a traves de los servicios del sistema y se le instancia como nitificacionManager
        val administrarNotificacion = contexto?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // se establece el intent receptivo del mensaje de la aplicacion emisora
        val intentReceptor = Intent(contexto, MainActivity ::class.java)// define que va a abrir al recibir el intent

        // se define el intent pendiente para que espere el mensaje de entrada que es lo que va a lanzar el intent que contiene
        // se debe pasar el contexto de ejecución , el intent que lo activa, un codigo de contento y la flag inmutable que son por defecto cero o el prpio flag inmuitable
        val pendingIntentRinicio = PendingIntent.getActivity(contexto, 0, intentReceptor, PendingIntent.FLAG_IMMUTABLE)

        /// definir la notificacion en concreto
        // si se quieren diferentes notificaciones habra que definir cada una de ellas
        val notificaciones = NotificationCompat.Builder(contexto!!, ID_CANAL) // se hace un notificacion builder para construir la notificacion
            .setContentTitle("Mensaje recibido") // definir el titulo de la notificacion
            .setContentText("Un mensaje ha sido recibido por la aplicación") // definir el mensaje que va a mostrar
            .setSmallIcon(R.drawable.ic_launcher_background) // el icono que se quiere que se vea en la aplicación
            .setPriority(NotificationCompat.PRIORITY_LOW) // la prioridad de lña nofitifacion en el computo de todas las nofiticaciones que puedes tener
            .setContentIntent(pendingIntentRinicio) // se asocia el intent que debe hacer que la aplicacion se abra al pinchar en ella
            .setAutoCancel(true) //determinar si se quiere que se borre la apliación al pinchar sobre ella///// si no se pone habria que cerrarla manualmente
            .build() // contruye la notificacion, si no se pone es como no mostrar el mesnaje en show dialog


        // OJO-- como se va a hacer una notificacion se DEBE poner el permiso de notificaciones  <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
        administrarNotificacion.notify(idNotificacion, notificaciones)
    }

}