package ir.reserveiran.mobile.tourismapplication.Service;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



/**
 * Created by Morteza on 1/19/2017.
 */

public class FireBaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("TAG = ","Refreshed token: " + refreshedToken);

        // TODO: Implement this method to send any registration to your app's servers.
/*
        sendRegistrationToServer(refreshedToken);
*/
    }




}
