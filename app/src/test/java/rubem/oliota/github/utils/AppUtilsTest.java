package rubem.oliota.github.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

public class AppUtilsTest {

    @Mock
    Context context = mock(Context.class);

    @Test
    public void isNetworkNotConnected() {
        boolean isConnected;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null)
            isConnected = false;
        else
            isConnected = cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isConnected();
        Assert.assertFalse(isConnected);
    }
}