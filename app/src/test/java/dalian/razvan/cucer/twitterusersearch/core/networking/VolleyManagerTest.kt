package dalian.razvan.cucer.twitterusersearch.core.networking

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class VolleyManagerTest {

    @Mock
    lateinit var apiCallbackInterface: APICallbackInterface

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        apiCallbackInterface = mock(APICallbackInterface::class.java)
    }

    @After
    fun tearDown() {}
}