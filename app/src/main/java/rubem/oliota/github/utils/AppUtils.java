package rubem.oliota.github.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rubem.oliota.github.R;
import rubem.oliota.github.model.Item;
import rubem.oliota.github.model.Repository;
import rubem.oliota.github.model.Root;
import rubem.oliota.github.utils.interfaces.OnGitHubTaskCompleted;

public class AppUtils {

    public static boolean isNetworkNotConnected(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null)
            return false;
        else
            return cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isConnected();
    }

    public static void CallGithubApiPublicRepositories(final Activity activity, final OnGitHubTaskCompleted listener) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(activity.getString(R.string.github_url_public_repositories))
                .build();

        try {
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        throw new IOException("Erro " + response);
                    } else {
                        String r = response.body().string();
                        ObjectMapper objectMapper = new ObjectMapper();
                        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
                        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                        try {
                            final Root root = objectMapper.readValue(r, Root.class);
                            initList(root.getItems());

                        } catch (Exception e) {
                            List<Item> myObjects = objectMapper.readValue(r, new TypeReference<List<Item>>() {
                            });
                            initList(myObjects);
                        }
                    }
                }

                private void initList(List<Item> items) {
                    final ArrayList<Repository> repositories = new ArrayList<>();
                    for (Item item : items)
                        repositories.add(new Repository(item.getName(), item.getOwner().getLogin(), item.getOwner().getAvatar_url(), item.getDescription()));
                    listener.onGitHubTaskCompleted(repositories);
                }
            });
        } catch (Exception e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public static void CallGithubApiRepositoresSearch(final Activity activity, final String query, final OnGitHubTaskCompleted listener) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(activity.getString(R.string.github_url) + query)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Erro " + response);
                } else {
                    String r = response.body().string();
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
                    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                    final Root root = objectMapper.readValue(r, Root.class);
                    initList(root.getItems());
                }
            }

            private void initList(List<Item> items) {
                final ArrayList<Repository> repositories = new ArrayList<>();
                for (Item item : items)
                    repositories.add(new Repository(item.getName(), item.getOwner().getLogin(), item.getOwner().getAvatar_url(), item.getDescription()));
                listener.onGitHubTaskCompleted(repositories, query);
            }
        });
    }

    public static void showDialog(final Activity activity, final ProgressDialog dialog, final String string) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.setMessage(string);
                dialog.setCancelable(true);
                dialog.show();
            }
        });
    }
}
