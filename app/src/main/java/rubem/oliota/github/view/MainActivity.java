package rubem.oliota.github.view;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

import rubem.oliota.github.R;
import rubem.oliota.github.model.Item;
import rubem.oliota.github.model.Repository;
import rubem.oliota.github.model.Root;
import rubem.oliota.github.utils.AppUtils;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Repository> repositories;
    SearchView search;
    private ProgressDialog statusDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleActionBar(true);
        initVars();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (!search.isIconified()) {
                search.onActionViewCollapsed();
                toggleActionBar(true);
            } else
                super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initVars() {
        recyclerView = findViewById(R.id.rv_list);
    }

    private void generateList() {
        if (recyclerView.getItemAnimator() != null)
            recyclerView.getItemAnimator().setChangeDuration(700);
        recyclerView.setAdapter(new RepositoryAdapter(this, repositories));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search = (SearchView) menu.findItem(R.id.search).getActionView();
        if (manager != null)
            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        search.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActionBar(false);
            }
        });
        search.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                toggleActionBar(true);
                return false;
            }
        });
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {

                if (AppUtils.isNetworkConnected(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, getString(R.string.not_connection_search_repositories), Toast.LENGTH_LONG).show();
                    return true;
                }

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(getString(R.string.github_url) + query)
                        .build();
                statusDialog = new ProgressDialog(MainActivity.this);
                statusDialog.setMessage(getString(R.string.searching_repositories_with_keyword) + query);
                statusDialog.setCancelable(true);
                statusDialog.show();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        statusDialog.dismiss();
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        if (!response.isSuccessful()) {
                            statusDialog.dismiss();
                            throw new IOException("Erro " + response);
                        } else {
                            String r = response.body().string();
                            ObjectMapper objectMapper = new ObjectMapper();
                            objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
                            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                            final Root root = objectMapper.readValue(r, Root.class);
                            repositories = new ArrayList<>();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (root.getItems().size() == 0) {
                                        Toast.makeText(MainActivity.this, getString(R.string.no_repositories_were_found_with_the_keyword)+query, Toast.LENGTH_LONG).show();

                                    } else {
                                        for (Item item : root.getItems())
                                            repositories.add(new Repository(item.getName(), item.getOwner().getLogin(), item.getOwner().getAvatar_url(), item.getDescription()));
                                        generateList();
                                    }
                                    statusDialog.dismiss();
                                }
                            });
                        }
                    }
                });
                search.onActionViewCollapsed();
                toggleActionBar(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                return true;
            }
        });
        return true;
    }

    private void toggleActionBar(boolean full) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(!full);
            getSupportActionBar().setHomeButtonEnabled(!full);
            getSupportActionBar().setDisplayShowTitleEnabled(full);
        }
    }
}
