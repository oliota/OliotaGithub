package rubem.oliota.github.model;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import rubem.oliota.github.R;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class RootTest {

    @Mock
    Context context = mock(Context.class);

    @Mock
    Root root = new Root();

    @Mock
    Item item = new Item();

    @Mock
    Owner owner = new Owner();

    @Before
    public void setup() {
        owner = new Owner(
                context.getString(R.string.test_get_login_owner),
                context.getString(R.string.test_get_avatar_url_owner)
        );
        item = new Item(
                context.getString(R.string.test_get_name_repository),
                owner,
                context.getString(R.string.test_get_description_repository)
        );
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        root = new Root(1, false, items);
    }

    @Test
    public void getTotal_count() {
        int result = root.getTotal_count();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void setTotal_count() {
        root.setTotal_count(0);
        int result = root.getTotal_count();
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void isIncomplete_results() {
        boolean result = root.isIncomplete_results();
        boolean expected = false;
        assertEquals(expected, result);
    }

    @Test
    public void setIncomplete_results() {
        root.setIncomplete_results(true);
        boolean result = root.isIncomplete_results();
        boolean expected = true;
        assertEquals(expected, result);
    }

    @Test
    public void getItems() {
        int result = root.getItems().size();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void setItems() {
        owner = new Owner(
                context.getString(R.string.test_get_login_owner),
                context.getString(R.string.test_get_avatar_url_owner)
        );
        item = new Item(
                context.getString(R.string.test_get_name_repository),
                owner,
                context.getString(R.string.test_get_description_repository)
        );
        root.getItems().add(item);
        int result = root.getItems().size();
        int expected = 2;
        assertEquals(expected, result);
    }
}