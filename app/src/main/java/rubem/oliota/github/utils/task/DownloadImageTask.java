package rubem.oliota.github.utils.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import rubem.oliota.github.utils.interfaces.OnTaskCompleted;

public class DownloadImageTask extends AsyncTask<Void, Void, Bitmap> {

    private ProgressDialog statusDialog;
    private Activity activity;
    private String url;
    private OnTaskCompleted listener;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setListener(OnTaskCompleted listener) {
        this.listener = listener;
    }

    protected Bitmap doInBackground(Void... params) {
        try {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    statusDialog = new ProgressDialog(activity);
                    statusDialog.setMessage("downloading user image");
                    statusDialog.setCancelable(true);
                    statusDialog.show();
                }
            });
            return DownloadImage(url);
        } catch (Exception e) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    statusDialog.dismiss();
                }
            });
            return null;
        }
    }

    private Bitmap DownloadImage(String URL) {
        Bitmap bitmap = null;
        InputStream in;
        try {
            in = OpenHttpConnection(URL);
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bitmap;
    }

    private InputStream OpenHttpConnection(String urlString) throws IOException {
        InputStream in = null;
        int response;

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Erro");

        try {
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        } catch (Exception ex) {
            throw new IOException("Erro");
        }
        return in;
    }

    protected void onPostExecute(final Bitmap bitmap) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (bitmap != null)
                    listener.onTaskCompleted(bitmap);
                statusDialog.dismiss();
            }
        });
    }
}