package ir.reserveiran.mobile.tourismapplication.Service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import ir.reserveiran.mobile.tourismapplication.HotelSearch;
import ir.reserveiran.mobile.tourismapplication.MainActivity;
import ir.reserveiran.mobile.tourismapplication.R;

/**
 * Created by Morteza on 1/19/2017.
 */

public class FireBaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {

            Log.d("RECIEVE MESSAGE : ", "From: " + remoteMessage.getFrom());
            Log.d("RECIEVE MESSAGE : ", "Notification Message Body: " + remoteMessage.getData().get("score"));

            String message = remoteMessage.getNotification().getBody();
            String title = remoteMessage.getNotification().getTitle();

            Intent intent  = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());

        } catch (Exception ex) {
            Log.e("Error On Recieve",ex.getLocalizedMessage());
        }
    }
}
