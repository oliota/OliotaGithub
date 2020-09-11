package rubem.oliota.github.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class AppUtils {

    public static boolean isNetworkConnected(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null)
            return cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isConnected();
        else
            return true;
    }
}
