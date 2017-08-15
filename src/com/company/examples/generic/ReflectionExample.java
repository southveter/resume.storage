package com.company.examples.generic;

import com.company.model.Resume;

import java.lang.reflect.*;

/**
 * Created by cic56 on 21.06.2017.
 */
public class ReflectionExample {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new  Resume("Name");
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_Name");
        System.out.println(field.get(r));

        Method method  = resumeClass.getMethod("toString");
        Object res = method.invoke(r);
        System.out.println(res);
        for(Method m : resumeClass.getDeclaredMethods()){
            System.out.println(m.getName());
        }
//        field.set(r,)
    }
}
