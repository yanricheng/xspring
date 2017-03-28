package net.yanrc.xpring.rpc.manger;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.contains;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.internal.matchers.GreaterThan;
import org.mockito.internal.matchers.LessThan;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import net.yanrc.xpring.dal.mapper.ActivityMapper;
import net.yanrc.xpring.rpc.manger.impl.ActivityManagerImpl;

/**
 * Created by yanricheng on 2017/3/27.
 */
@RunWith(MockitoJUnitRunner.class)
public class ActivityManagerTest {
    @Mock
    Map<String, String> map;
    @Mock
    private ActivityMapper activityMapper;
    @InjectMocks
    private ActivityManagerImpl activityManager;

    @Test
    public void removeTest() {
        when(activityMapper.deleteByPrimaryKey(anyInt())).thenReturn(1);
        Assertions.assertThat(activityManager.remove(-1)).isFalse();
        Assertions.assertThat(activityManager.remove(0)).isFalse();
        Assertions.assertThat(activityManager.remove(1)).isTrue();
        Assertions.assertThat(activityManager.remove(10)).isTrue();
        Assertions.assertThat(activityManager.remove(1000)).isTrue();
        Assertions.assertThat(activityManager.remove(19999)).isTrue();
        Assertions.assertThat(activityManager.remove(Integer.MAX_VALUE)).isTrue();
    }

    @Test(expected = NoInteractionsWanted.class)
    public void find_redundant_interaction() {
        List list = mock(List.class);
        list.add(1);
        list.add(2);
        verify(list, times(2)).add(anyInt());
        // 检查是否有未被验证的互动行为，因为add(1)和add(2)都会被上面的anyInt()验证到，所以下面的代码会通过
        verifyNoMoreInteractions(list);

        List list2 = mock(List.class);
        list2.add(1);
        list2.add(2);
        verify(list2).add(1);
        // 检查是否有未被验证的互动行为，因为add(2)没有被验证，所以下面的代码会失败抛出异常
        verifyNoMoreInteractions(list2);
    }

    @Test
    public void verify_interaction() {
        List list = mock(List.class);
        List list2 = mock(List.class);
        List list3 = mock(List.class);
        list.add(1);
        verify(list).add(1);
        verify(list, never()).add(2);
        // 验证零互动行为
        verifyZeroInteractions(list2, list3);
    }

    @Test
    public void verification_in_order() {
        List list = mock(List.class);
        List list2 = mock(List.class);
        list.add(1);
        list2.add("hello");
        list.add(2);
        list2.add("world");
        // 将需要排序的mock对象放入InOrder
        InOrder inOrder = inOrder(list, list2);
        // 下面的代码不能颠倒顺序，验证执行顺序
        inOrder.verify(list).add(1);
        inOrder.verify(list2).add("hello");
        inOrder.verify(list).add(2);
        inOrder.verify(list2).add("world");
    }

    @Test
    public void verifying_number_of_invocations() {
        List list = mock(List.class);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        // 验证是否被调用一次，等效于下面的times(1)
        Mockito.verify(list).add(1);
        Mockito.verify(list, times(1)).add(1);
        // 验证是否被调用2次
        Mockito.verify(list, times(2)).add(2);
        // 验证是否被调用3次
        Mockito.verify(list, times(3)).add(3);
        // 验证是否从未被调用过
        Mockito.verify(list, never()).add(4);
        // 验证至少调用一次
        Mockito.verify(list, atLeastOnce()).add(1);
        // 验证至少调用2次
        Mockito.verify(list, atLeast(2)).add(2);
        // 验证至多调用3次
        Mockito.verify(list, atMost(3)).add(3);
    }

    @Test(expected = RuntimeException.class)
    public void doThrow_when() {
        List list = mock(List.class);
        doThrow(new RuntimeException()).when(list).add(1);
        list.add(1);
    }

    @Test
    public void maptest2() {
        Map<Integer, Integer> map = mock(Map.class);
        // when(map.get(anyInt())).thenReturn(1000);//匹配任何整数
        when(map.get(argThat(new LessThan<>(100)))).thenReturn(99);
        when(map.get((100))).thenReturn(100);
        when(map.get(argThat(new GreaterThan(100)))).thenReturn(101);
        Assert.assertTrue(map.get(1) == 99);
        Assert.assertTrue(map.get(99) == 99);
        Assert.assertTrue(map.get(100) == 100);
        Assert.assertTrue(map.get(101) == 101);
        Assert.assertTrue(map.get(1000) == 101);
    }

    @Test
    public void mapTest() {
        when(map.get(Mockito.contains("a"))).thenReturn("aaa");
        when(map.get(Mockito.contains("b"))).thenReturn("bbbb");
        System.out.println(map.get("aaaa"));
        System.out.println(map.get("ab"));
        System.out.println(map.get("ba"));
        System.out.println(map.get("ca"));
    }

    @Test
    public void verify_behaviour() {
        // 模拟创建一个List对象
        List mock = Mockito.mock(List.class);
        // 使用mock的对象
        mock.add(1);
        mock.clear();
        // 验证add(1)和clear()行为是否发生
        Mockito.verify(mock).add(1);
        Mockito.verify(mock).clear();
    }

    @Test
    public void when_thenReturn1() {
        // mock一个Iterator类
        Map<String, String> map = mock(Map.class);
        // 预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(map.get(contains("a"))).thenReturn("aa");
        when(map.get(contains("b"))).thenReturn("bb");
        // 验证结果
        Assert.assertEquals("aabb", map.get("aa") + map.get("bb"));
    }

    @Test
    public void when_thenReturn2() {
        // mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        // 预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(iterator.next()).thenReturn("hello", "world");
        // 使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        // 验证结果
        Assert.assertEquals("hello world world", result);
    }

    @Test
    public void when_thenReturn3() {
        // mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        // 预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(iterator.next()).thenReturn("hello");
        when(iterator.next()).thenReturn("world");
        // 使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        // 验证结果
        Assert.assertEquals("hello world world", result);
    }

    @Test
    public void unstubTest() {
        Map<String, String> myMap = mock(Map.class);
        when(myMap.get(anyString())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                if (invocation.getMethod().getName().equals("get")) {
                    if (invocation.getArguments()[0].toString().contains("a")) {
                        return "aaa";
                    } else if (invocation.getArguments()[0].toString().contains("b")) {
                        return "bbb";
                    }
                }
                return null;
            }
        });

        Assertions.assertThat(myMap.get("aa")).isEqualTo("aaa");
        Assertions.assertThat(myMap.get("bbb")).isEqualTo("bbb");
    }

    @Test
    public void unstubTest1() {
        Map<String, String> myMap = mock(Map.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                if (invocation.getMethod().getName().equals("get")) {
                    if (invocation.getArguments()[0].toString().contains("a")) {
                        return "aaa";
                    } else if (invocation.getArguments()[0].toString().contains("b")) {
                        return "bbb";
                    }
                } else if (invocation.getMethod().getName().equals("size")) {
                    return 1000;
                }
                return null;
            }
        });

        Assertions.assertThat(myMap.get("dd")).isNull();
        Assertions.assertThat(myMap.size()).isEqualTo(1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void spy_on_real_objects1() {
        List list = new LinkedList();
        List spy = spy(list);
        // 下面预设的spy.get(0)会报错，因为会调用真实对象的get(0)，所以会抛出越界异常
        // when(spy.get(0)).thenReturn(3);

        // 使用doReturn-when可以避免when-thenReturn调用真实对象api
        doReturn(999).when(spy).get(999);
        // 预设size()期望值
        when(spy.size()).thenReturn(100);
        // 调用真实对象的api
        spy.add(1);
        spy.add(2);
        Assert.assertEquals(100, spy.size());
        Assert.assertEquals(1, spy.get(0));
        Assert.assertEquals(2, spy.get(1));
        verify(spy).add(1);
        verify(spy).add(2);
        Assert.assertEquals(999, spy.get(999));
        spy.get(2);
    }

    @Test
    public void unstubbed_invocations() {
        // mock对象使用Answer来对未预设的调用返回默认期望值
        List mock = mock(List.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return 999;
            }
        });
        // 下面的get(1)没有预设，通常情况下会返回NULL，但是使用了Answer改变了默认期望值
        Assert.assertEquals(999, mock.get(1));
        // 下面的size()没有预设，通常情况下会返回0，但是使用了Answer改变了默认期望值
        Assert.assertEquals(999, mock.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void spy_on_real_objects() {
        List list = new LinkedList();
        List spy = spy(list);
        // 下面预设的spy.get(0)会报错，因为会调用真实对象的get(0)，所以会抛出越界异常
        // when(spy.get(0)).thenReturn(3);

        // 使用doReturn-when可以避免when-thenReturn调用真实对象api
        doReturn(999).when(spy).get(999);
        // 预设size()期望值
        when(spy.size()).thenReturn(100);
        // 调用真实对象的api
        spy.add(1);
        spy.add(2);
        Assert.assertEquals(100, spy.size());
        Assert.assertEquals(1, spy.get(0));
        Assert.assertEquals(2, spy.get(1));
        Mockito.verify(spy).add(1);
        Mockito.verify(spy).add(2);
        Assert.assertEquals(999, spy.get(999));
        spy.get(2);
    }

    @Test
    public void capturing_args() {
        PersonDao personDao = mock(PersonDao.class);
        PersonService personService = new PersonService(personDao);

        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
        personService.update(1, "jack");
        Mockito.verify(personDao).update(argument.capture());
        Assert.assertEquals(1, argument.getValue().getId());
        Assert.assertEquals("jack", argument.getValue().getName());
    }

    @Test
    public void real_partial_mock() {
        // 通过spy来调用真实的api
        List list = spy(new ArrayList());
        Assert.assertEquals(0, list.size());
        A a = mock(A.class);
        // 通过thenCallRealMethod来调用真实的api
        when(a.doSomething(anyInt())).thenCallRealMethod();
        Assert.assertEquals(999, a.doSomething(999));
    }

    @Test
    public void reset_mock() {
        List list = mock(List.class);
        when(list.size()).thenReturn(10);
        list.add(1);
        Assert.assertEquals(10, list.size());
        // 重置mock，清除所有的互动和预设
        Mockito.reset(list);
        Assert.assertEquals(0, list.size());
    }

    interface PersonDao {
        public void update(Person person);
    }

    class Person {
        private int id;
        private String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    class PersonService {
        private PersonDao personDao;

        PersonService(PersonDao personDao) {
            this.personDao = personDao;
        }

        public void update(int id, String name) {
            personDao.update(new Person(id, name));
        }
    }

    class A {
        public int doSomething(int i) {
            return i;
        }
    }

}
