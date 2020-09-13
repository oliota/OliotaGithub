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

import java.util.ArrayList;

import rubem.oliota.github.R;
import rubem.oliota.github.model.Repository;
import rubem.oliota.github.utils.AppUtils;
import rubem.oliota.github.utils.interfaces.OnGitHubTaskCompleted;

public class MainActivity extends AppCompatActivity implements OnGitHubTaskCompleted {
    private ProgressDialog statusDialog;
    private RecyclerView recyclerView;
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleActionBar(true);
        initVars();
        callGithubApiPublicRepositories();

    }

    private void callGithubApiPublicRepositories() {
        if (AppUtils.isNetworkNotConnected(MainActivity.this)) {
            Toast.makeText(MainActivity.this, getString(R.string.not_connection_search_repositories), Toast.LENGTH_LONG).show();
            return;
        }
        AppUtils.showDialog(this,
                statusDialog = new ProgressDialog(this),
                getString(R.string.searching_public_repositories_from_github));
        AppUtils.CallGithubApiPublicRepositories(this, this);
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

    @Override
    public void onBackPressed() {
        if (!search.isIconified()) {
            search.onActionViewCollapsed();
            toggleActionBar(true);
        } else
            super.onBackPressed();
    }

    public void initVars() {
        recyclerView = findViewById(R.id.rv_list);
    }

    public void generateList(ArrayList<Repository> repositories) {
        if (recyclerView.getItemAnimator() != null)
            recyclerView.getItemAnimator().setChangeDuration(700);
        recyclerView.setAdapter(new RepositoryAdapter(this, repositories));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicou na liata", Toast.LENGTH_SHORT).show();
            }
        });
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

                if (AppUtils.isNetworkNotConnected(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, getString(R.string.not_connection_search_repositories), Toast.LENGTH_LONG).show();
                    return true;
                }
                AppUtils.showDialog(
                        MainActivity.this,
                        statusDialog = new ProgressDialog(MainActivity.this),
                        MainActivity.this.getString(R.string.searching_repositories_with_keyword) + query
                );

                AppUtils.CallGithubApiRepositoresSearch(
                        MainActivity.this,
                        query,
                        MainActivity.this
                );
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

    public void toggleActionBar(boolean full) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(!full);
            getSupportActionBar().setHomeButtonEnabled(!full);
            getSupportActionBar().setDisplayShowTitleEnabled(full);
        }
    }

    @Override
    public void onGitHubTaskCompleted(final ArrayList<Repository> repositories) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                generateList(repositories);
                statusDialog.dismiss();
            }
        });
    }

    @Override
    public void onGitHubTaskCompleted(final ArrayList<Repository> repositories, final String query) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (repositories.size() == 0) {
                    Toast.makeText(MainActivity.this, getString(R.string.no_repositories_were_found_with_the_keyword) + query, Toast.LENGTH_LONG).show();
                }
                generateList(repositories);
                statusDialog.dismiss();
            }
        });

    }
}
