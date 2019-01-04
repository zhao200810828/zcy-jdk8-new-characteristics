package com.zcy.jdk8;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sue on 2018/11/27.
 */
public class MainTest {

    /**
     * 测试Lambda表达式
     */
    @Test
    public void testLambda(){

     //   Arrays.asList("a","b","d").forEach(e-> System.out.println(e));
     //   Arrays.asList("1","2","3").forEach((String e) -> System.out.println(e));
        Arrays.asList("a","b","c").forEach(e->{
            System.out.print(e);
            System.out.print(e);
        });
    }

    private void func(LambdaInterface<Integer> lambdaInterface){
        int a =1;
        lambdaInterface.test(a);
    }

    /**
     * 测试自己写的接口应用lambda表达式
     */
    @Test
    public void testMyLambda(){
        func((Integer x) -> {
            System.out.println("kkk-----"  + x);
            return true;
        });
    }

    /**
     * 该方法测试接口默认方法不用应用
     */
    @Test
    public void defautValueTest(){

        DefaultValue defaultValue = DefaulableFactory.create(DefaultValueImpl::new);
        System.out.println(defaultValue.notRequired());
        defaultValue = DefaulableFactory.create(OverrideAbleImpl::new);
        System.out.println(defaultValue.notRequired());
    }

    /**
     * 该方法测试Optional
     */
    @Test
    public void optionalTest(){
        Optional< String > fullName = Optional.ofNullable( null );
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
    }

    private List<Student> sutdentLists(){
        Random random = new Random();
        List<Student>stuList = new ArrayList<Student>();

        for (int i = 0; i < 100; i++) {
            stuList.add(new Student("student" + i, random.nextInt(50) + 50));
        }

        return stuList;
    }

    /**
     * 该方法主要测试streams新特性,取的大于85分的学生
     */
    @Test
    public void streamsTest(){
        List<Student> lists = sutdentLists();
        System.out.println("lists:" + lists);
        List<String> studentList = lists.stream()
                .filter(x->x.getScore()>85)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("studentList:"+studentList);
    }

    /**
     * reduce这个方法的主要作用是把 Stream 元素组合起来
     */
    @Test
    public void streams_reduceTest(){
       List list = Stream.of(23,21,46,32).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list);

        Optional<String> sss = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce(String::concat);
        System.out.println(sss.orElse("error"));
    }

    /**
     * limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素
     */
    @Test
    public void streams_limit_skipTest(){
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        List<String> personList2 = persons.stream().
                map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(personList2);
    }

    /**
     * match
     * allMatch：Stream 中全部元素符合传入的 predicate，返回 true
       anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
        noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
     */
    @Test
    public void streams_matchTest(){
        List<Person> persons = new ArrayList();
        persons.add(new Person(1, "name" + 1, 10));
        persons.add(new Person(2, "name" + 2, 21));
        persons.add(new Person(3, "name" + 3, 34));
        persons.add(new Person(4, "name" + 4, 6));
        persons.add(new Person(5, "name" + 5, 55));
        boolean isAllAdult = persons.stream().
                allMatch(p -> p.getAge() > 18);
        System.out.println("All are adult? " + isAllAdult);
        boolean isThereAnyChild = persons.stream().
                anyMatch(p -> p.getAge() < 12);
        System.out.println("Any child? " + isThereAnyChild);
    }
}
