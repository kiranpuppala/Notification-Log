package amazontest.com.notificationlog;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;


public class NotificationService extends NotificationListenerService {

    Context context;

    @Override

    public void onCreate() {

        super.onCreate();
        context = getApplicationContext();

    }
    @Override

    public void onNotificationPosted(StatusBarNotification sbn) {


        if(sbn != null){

            String text = sbn.getNotification().extras.getCharSequence(Notification.EXTRA_TEXT).toString();

            String title = sbn.getNotification().extras.getCharSequence(Notification.EXTRA_TITLE).toString();


//            String pack = sbn.getPackageName();
//            String ticker = sbn.getNotification().tickerText.toString();
//            Bundle extras = sbn.getNotification().extras;
//            String title = extras.getString("android.title");
//            String text = extras.getCharSequence("android.text").toString();

//            Log.i("Package",pack);
//            Log.i("Ticker",ticker);
//            Log.i("Title",title);
//            Log.i("Text",text);

            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

//            try {
//                GMailSender sender = new GMailSender("kiranpuppala.96@gmail.com", "treeflying");
//                sender.sendMail("New Message",
//                        "Message body :"+text,
//                        "kiranpuppala.96@gmail.com",
//                        "kiranpuppala.96@gmail.com");
//            } catch (Exception e) {
//                Log.e("SendMail", e.getMessage(), e);
//            }


//            Intent msgrcv = new Intent("Msg");
//            msgrcv.putExtra("package", pack);
//            msgrcv.putExtra("ticker", ticker);
//            msgrcv.putExtra("title", title);
//            msgrcv.putExtra("text", text);

//            LocalBroadcastManager.getInstance(context).sendBroadcast(msgrcv);
        }else{
            Toast.makeText(context,"ITS A WHATS",Toast.LENGTH_SHORT).show();
        }



    }

    @Override

    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i("Msg","Notification Removed");

    }
}
 