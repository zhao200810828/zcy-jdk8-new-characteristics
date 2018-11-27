package com.zcy.jdk8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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
}
