package rubem.oliota.github.utils.interfaces;

import java.util.ArrayList;

import rubem.oliota.github.model.Repository;

public interface OnGitHubTaskCompleted {
    void onGitHubTaskCompleted(ArrayList<Repository> repositories);

    void onGitHubTaskCompleted(ArrayList<Repository> repositories, String query);
}
