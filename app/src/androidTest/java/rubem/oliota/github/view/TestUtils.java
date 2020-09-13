package rubem.oliota.github.view;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.SystemClock;

import androidx.test.platform.app.InstrumentationRegistry;

class TestUtils {
    static void setMobileWifinEnabled(boolean enabled) {
        WifiManager wifiManager = (WifiManager) InstrumentationRegistry.getInstrumentation().getContext().getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null) {
            wifiManager.setWifiEnabled(enabled);
            SystemClock.sleep(2000);
        }
    }
}
