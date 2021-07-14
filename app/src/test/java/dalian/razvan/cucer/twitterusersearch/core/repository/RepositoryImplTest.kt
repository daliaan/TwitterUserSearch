package dalian.razvan.cucer.twitterusersearch.core.repository

import dalian.razvan.cucer.twitterusersearch.core.networking.API
import dalian.razvan.cucer.twitterusersearch.core.networking.APICallbackInterface
import dalian.razvan.cucer.twitterusersearch.core.networking.error.ErrorCallback
import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser
import dalian.razvan.cucer.twitterusersearch.screens.search.list.TwitterUsersCallback
import dalian.razvan.cucer.twitterusersearch.utils.Constants
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.json.JSONObject
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class RepositoryImplTest {

    @Mock
    lateinit var user1: TwitterUser
    @Mock
    lateinit var user2: TwitterUser
    @Mock
    lateinit var repository: RepositoryImpl
    @Mock
    lateinit var api: API
    val usersList = arrayListOf<TwitterUser>()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        user1 = TwitterUser(mock(JSONObject::class.java))
        user2 = TwitterUser(mock(JSONObject::class.java))
        api = mock(API::class.java)
        repository = RepositoryImpl(api)
        for (i in 0 until 10) {
            usersList.add(user1)
            usersList.add(user2)
        }
    }

    @After
    fun tearDown() {

    }

    @Test
    fun data_storeSelectedUser_pass() {
        repository.setSelectedUser(user1)
        Assert.assertEquals(user1, repository.getSelectedUser())
    }

    @Test
    fun data_storeSelectedUser_doesntPass() {
        repository.setSelectedUser(user1)
        Assert.assertNotEquals(user2, repository.getSelectedUser())
    }

    @Test
    fun data_loadUsers_pass() {
        runBlocking {
            `when`(repository.parseUsersResponse(JSONObject()))
        }
    }
}