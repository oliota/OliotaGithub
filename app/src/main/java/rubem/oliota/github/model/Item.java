package rubem.oliota.github.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Item {
    @JsonIgnore
    private int id;
    @JsonIgnore
    private String node_id;
    private String name;
    @JsonIgnore
    private String full_name;
    @JsonIgnore
    private boolean Private;
    private Owner owner;
    @JsonIgnore
    private String html_url;
    private String description;
    @JsonIgnore
    private boolean fork;
    @JsonIgnore
    private String url;
    @JsonIgnore
    private String forks_url;
    @JsonIgnore
    private String keys_url;
    @JsonIgnore
    private String collaborators_url;
    @JsonIgnore
    private String teams_url;
    @JsonIgnore
    private String hooks_url;
    @JsonIgnore
    private String issue_events_url;
    @JsonIgnore
    private String events_url;
    @JsonIgnore
    private String assignees_url;
    @JsonIgnore
    private String branches_url;
    @JsonIgnore
    private String tags_url;
    @JsonIgnore
    private String blobs_url;
    @JsonIgnore
    private String git_tags_url;
    @JsonIgnore
    private String git_refs_url;
    @JsonIgnore
    private String trees_url;
    @JsonIgnore
    private String statuses_url;
    @JsonIgnore
    private String languages_url;
    @JsonIgnore
    private String stargazers_url;
    @JsonIgnore
    private String contributors_url;
    @JsonIgnore
    private String subscribers_url;
    @JsonIgnore
    private String subscription_url;
    @JsonIgnore
    private String commits_url;
    @JsonIgnore
    private String git_commits_url;
    @JsonIgnore
    private String comments_url;
    @JsonIgnore
    private String issue_comment_url;
    @JsonIgnore
    private String contents_url;
    @JsonIgnore
    private String compare_url;
    @JsonIgnore
    private String merges_url;
    @JsonIgnore
    private String archive_url;
    @JsonIgnore
    private String downloads_url;
    @JsonIgnore
    private String issues_url;
    @JsonIgnore
    private String pulls_url;
    @JsonIgnore
    private String milestones_url;
    @JsonIgnore
    private String notifications_url;
    @JsonIgnore
    private String labels_url;
    @JsonIgnore
    private String releases_url;
    @JsonIgnore
    private String deployments_url;
    @JsonIgnore
    private Date created_at;
    @JsonIgnore
    private Date updated_at;
    @JsonIgnore
    private Date pushed_at;
    @JsonIgnore
    private String git_url;
    @JsonIgnore
    private String ssh_url;
    @JsonIgnore
    private String clone_url;
    @JsonIgnore
    private String svn_url;
    @JsonIgnore
    private Object homepage;
    @JsonIgnore
    private int size;
    @JsonIgnore
    private int stargazers_count;
    @JsonIgnore
    private int watchers_count;
    @JsonIgnore
    private String language;
    @JsonIgnore
    private boolean has_issues;
    @JsonIgnore
    private boolean has_projects;
    @JsonIgnore
    private boolean has_downloads;
    @JsonIgnore
    private boolean has_wiki;
    @JsonIgnore
    private boolean has_pages;
    @JsonIgnore
    private int forks_count;
    @JsonIgnore
    private Object mirror_url;
    @JsonIgnore
    private boolean archived;
    @JsonIgnore
    private boolean disabled;
    @JsonIgnore
    private int open_issues_count;
    @JsonIgnore
    private Object license;
    @JsonIgnore
    private int forks;
    @JsonIgnore
    private int open_issues;
    @JsonIgnore
    private int watchers;
    @JsonIgnore
    private String default_branch;
    @JsonIgnore
    private double score;


    Item() {
    }

    Item(String name, Owner owner, String description) {
        this.name = name;
        this.owner = owner;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setPrivate(boolean aPrivate) {
        Private = aPrivate;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setForks_url(String forks_url) {
        this.forks_url = forks_url;
    }

    public void setKeys_url(String keys_url) {
        this.keys_url = keys_url;
    }

    public void setCollaborators_url(String collaborators_url) {
        this.collaborators_url = collaborators_url;
    }

    public void setTeams_url(String teams_url) {
        this.teams_url = teams_url;
    }

    public void setHooks_url(String hooks_url) {
        this.hooks_url = hooks_url;
    }

    public void setIssue_events_url(String issue_events_url) {
        this.issue_events_url = issue_events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public void setAssignees_url(String assignees_url) {
        this.assignees_url = assignees_url;
    }

    public void setBranches_url(String branches_url) {
        this.branches_url = branches_url;
    }

    public void setTags_url(String tags_url) {
        this.tags_url = tags_url;
    }

    public void setBlobs_url(String blobs_url) {
        this.blobs_url = blobs_url;
    }

    public void setGit_tags_url(String git_tags_url) {
        this.git_tags_url = git_tags_url;
    }

    public void setGit_refs_url(String git_refs_url) {
        this.git_refs_url = git_refs_url;
    }

    public void setTrees_url(String trees_url) {
        this.trees_url = trees_url;
    }

    public void setStatuses_url(String statuses_url) {
        this.statuses_url = statuses_url;
    }

    public void setLanguages_url(String languages_url) {
        this.languages_url = languages_url;
    }

    public void setStargazers_url(String stargazers_url) {
        this.stargazers_url = stargazers_url;
    }

    public void setContributors_url(String contributors_url) {
        this.contributors_url = contributors_url;
    }

    public void setSubscribers_url(String subscribers_url) {
        this.subscribers_url = subscribers_url;
    }

    public void setSubscription_url(String subscription_url) {
        this.subscription_url = subscription_url;
    }

    public void setCommits_url(String commits_url) {
        this.commits_url = commits_url;
    }

    public void setGit_commits_url(String git_commits_url) {
        this.git_commits_url = git_commits_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public void setIssue_comment_url(String issue_comment_url) {
        this.issue_comment_url = issue_comment_url;
    }

    public void setContents_url(String contents_url) {
        this.contents_url = contents_url;
    }

    public void setCompare_url(String compare_url) {
        this.compare_url = compare_url;
    }

    public void setMerges_url(String merges_url) {
        this.merges_url = merges_url;
    }

    public void setArchive_url(String archive_url) {
        this.archive_url = archive_url;
    }

    public void setDownloads_url(String downloads_url) {
        this.downloads_url = downloads_url;
    }

    public void setIssues_url(String issues_url) {
        this.issues_url = issues_url;
    }

    public void setPulls_url(String pulls_url) {
        this.pulls_url = pulls_url;
    }

    public void setMilestones_url(String milestones_url) {
        this.milestones_url = milestones_url;
    }

    public void setNotifications_url(String notifications_url) {
        this.notifications_url = notifications_url;
    }

    public void setLabels_url(String labels_url) {
        this.labels_url = labels_url;
    }

    public void setReleases_url(String releases_url) {
        this.releases_url = releases_url;
    }

    public void setDeployments_url(String deployments_url) {
        this.deployments_url = deployments_url;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setPushed_at(Date pushed_at) {
        this.pushed_at = pushed_at;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public void setSsh_url(String ssh_url) {
        this.ssh_url = ssh_url;
    }

    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }

    public void setSvn_url(String svn_url) {
        this.svn_url = svn_url;
    }

    public void setHomepage(Object homepage) {
        this.homepage = homepage;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public void setWatchers_count(int watchers_count) {
        this.watchers_count = watchers_count;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setHas_issues(boolean has_issues) {
        this.has_issues = has_issues;
    }

    public void setHas_projects(boolean has_projects) {
        this.has_projects = has_projects;
    }

    public void setHas_downloads(boolean has_downloads) {
        this.has_downloads = has_downloads;
    }

    public void setHas_wiki(boolean has_wiki) {
        this.has_wiki = has_wiki;
    }

    public void setHas_pages(boolean has_pages) {
        this.has_pages = has_pages;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }

    public void setMirror_url(Object mirror_url) {
        this.mirror_url = mirror_url;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public void setOpen_issues_count(int open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    public void setLicense(Object license) {
        this.license = license;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
