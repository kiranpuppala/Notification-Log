package amazontest.com.notificationlog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSBroadcastReceiver extends BroadcastReceiver {

        private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
        private static final String TAG = "SMSBroadcastReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
                if (intent.getAction() == SMS_RECEIVED) {
                    final Bundle bundle = intent.getExtras();
                    try {
                        if (bundle != null) {
                            final Object[] pdusObj = (Object[]) bundle.get("pdus");
                            for (int i = 0; i < pdusObj.length; i++) {
                                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                                String message = currentMessage.getDisplayMessageBody();
                                if(message.contains("LOGIT")){
                                    context.startService(new Intent(context, NotificationService.class));
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
           }
}