package rubem.oliota.github.model;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import rubem.oliota.github.R;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class OwnerTest {

    @Mock
    Context context = mock(Context.class);

    @Mock
    Owner owner = new Owner();

    @Before
    public void setup() {
        owner = new Owner(
                context.getString(R.string.test_get_login_owner),
                context.getString(R.string.test_get_avatar_url_owner)
        );
    }

    @Test
    public void getLogin() {
        String result = owner.getLogin();
        String expected = context.getString(R.string.test_get_login_owner);
        assertEquals(expected, result);
    }

    @Test
    public void setLogin() {
        owner.setLogin(context.getString(R.string.test_set_login_owner));
        String result = owner.getLogin();
        String expected = context.getString(R.string.test_set_login_owner);
        assertEquals(expected, result);
    }

    @Test
    public void getAvatar_url() {
        String result = owner.getAvatar_url();
        String expected = context.getString(R.string.test_get_avatar_url_owner);
        assertEquals(expected, result);
    }

    @Test
    public void setAvatar_url() {
        owner.setAvatar_url(context.getString(R.string.test_set_avatar_url_owner));
        String result = owner.getAvatar_url();
        String expected = context.getString(R.string.test_set_avatar_url_owner);
        assertEquals(expected, result);
    }
}