package rubem.oliota.github.model;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import rubem.oliota.github.R;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ItemTest {

    @Mock
    Context context = mock(Context.class);

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
    }

    @Test
    public void getName() {
        String result = item.getName();
        String expected = context.getString(R.string.test_get_name_repository);
        assertEquals(expected, result);
    }

    @Test
    public void setName() {
        item.setName(context.getString(R.string.test_set_name_repository));
        String result = item.getName();
        String expected = context.getString(R.string.test_set_name_repository);
        assertEquals(expected, result);
    }

    @Test
    public void getOwner() {
        String result = item.getOwner().getLogin();
        String expected = context.getString(R.string.test_get_login_owner);
        assertEquals(expected, result);
    }

    @Test
    public void setOwner() {
        item.getOwner().setLogin(context.getString(R.string.test_get_login_owner));
        item.getOwner().setAvatar_url(context.getString(R.string.test_get_avatar_url_owner));

        String result = item.getOwner().getLogin() + item.getOwner().getAvatar_url();
        String expected = context.getString(R.string.test_get_login_owner) +
                context.getString(R.string.test_get_avatar_url_owner);
        assertEquals(expected, result);
    }

    @Test
    public void getDescription() {
        String result = item.getDescription();
        String expected = context.getString(R.string.test_get_description_repository);
        assertEquals(expected, result);

    }

    @Test
    public void setDescription() {
        item.setDescription(context.getString(R.string.test_set_description_repository));
        String result = item.getName();
        String expected = context.getString(R.string.test_set_description_repository);
        assertEquals(expected, result);
    }
}