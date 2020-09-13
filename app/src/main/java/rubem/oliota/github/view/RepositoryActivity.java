package rubem.oliota.github.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import rubem.oliota.github.R;
import rubem.oliota.github.model.Repository;
import rubem.oliota.github.utils.AppUtils;
import rubem.oliota.github.utils.interfaces.OnTaskCompleted;
import rubem.oliota.github.utils.task.DownloadImageTask;

public class RepositoryActivity extends AppCompatActivity implements OnTaskCompleted {

    ImageView avatar;
    TextView dono;
    TextInputEditText name;
    TextInputEditText description;
    Repository repositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);
        customizeActionBar();
        initVars();
        renderLayout();
    }

    private void customizeActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    private void initVars() {
        avatar = findViewById(R.id.iv_avatar);
        name = findViewById(R.id.et_name);
        dono = findViewById(R.id.tv_dono);
        description = findViewById(R.id.et_description);
        repositorio = (Repository) getIntent().getSerializableExtra("repository");
    }

    private void renderLayout() {
        if (AppUtils.isNetworkNotConnected(this))
            Toast.makeText(this, getString(R.string.not_connection_download_image_use), Toast.LENGTH_LONG).show();
        else {
            DownloadImageTask downloadImageTask = new DownloadImageTask();
            downloadImageTask.setActivity(this);
            downloadImageTask.setUrl(repositorio.getAvatar_url());
            downloadImageTask.setListener(this);
            downloadImageTask.execute();
        }
        dono.setText(repositorio.getOwner());
        name.setText(repositorio.getName());
        description.setText(repositorio.getDescription());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            super.onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTaskCompleted(Bitmap bitmap) {
        if (bitmap != null)
            avatar.setImageBitmap(bitmap);
    }
}
