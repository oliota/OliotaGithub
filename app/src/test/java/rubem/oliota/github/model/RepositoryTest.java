package rubem.oliota.github.model;

import android.content.Context;

import org.junit.Test;
import org.mockito.Mock;

import rubem.oliota.github.R;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class RepositoryTest {

    @Mock
    Context context = mock(Context.class);

    @Mock
    Repository repository = new Repository(
            context.getString(R.string.test_get_name_repository),
            context.getString(R.string.test_get_owner_repository),
            context.getString(R.string.test_get_avatar_repository),
            context.getString(R.string.test_get_description_repository)
    );

    @Test
    public void getName() {
        String result = repository.getName();
        String expected = context.getString(R.string.test_get_name_repository);
        assertEquals(expected, result);
    }

    @Test
    public void setName() {
        repository.setName(context.getString(R.string.test_set_name_repository));
        String result = repository.getName();
        String expected = context.getString(R.string.test_set_name_repository);
        assertEquals(expected, result);
    }

    @Test
    public void getOwner() {
        String result = repository.getOwner();
        String expected = context.getString(R.string.test_get_owner_repository);
        assertEquals(expected, result);
    }

    @Test
    public void setOwner() {
        repository.setOwner(context.getString(R.string.test_set_owner_repository));
        String result = repository.getName();
        String expected = context.getString(R.string.test_set_owner_repository);
        assertEquals(expected, result);
    }

    @Test
    public void getAvatar_url() {
        String result = repository.getAvatar_url();
        String expected = context.getString(R.string.test_get_avatar_repository);
        assertEquals(expected, result);
    }

    @Test
    public void setAvatar_url() {
        repository.setAvatar_url(context.getString(R.string.test_set_avatar_repository));
        String result = repository.getName();
        String expected = context.getString(R.string.test_set_avatar_repository);
        assertEquals(expected, result);
    }

    @Test
    public void getDescription() {
        String result = repository.getDescription();
        String expected = context.getString(R.string.test_get_description_repository);
        assertEquals(expected, result);
    }

    @Test
    public void setDescription() {
        repository.setDescription(context.getString(R.string.test_set_description_repository));
        String result = repository.getName();
        String expected = context.getString(R.string.test_set_description_repository);
        assertEquals(expected, result);
    }
}