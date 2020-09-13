package rubem.oliota.github.model;

import java.util.List;

public class Root {
    private int total_count;
    private boolean incomplete_results;
    private List<Item> items;

    Root() {
    }

    Root(int total_count, boolean incomplete_results, List<Item> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    int getTotal_count() {
        return total_count;
    }

    void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    boolean isIncomplete_results() {
        return incomplete_results;
    }

    void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
