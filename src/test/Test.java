package test;

import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by l81022078 on 2017/8/3.
 */
public class Test implements Serializable{
    public static void main(String[] args) {
        //System.out.println(System.getProperty("user.dir"));
        try {
            System.out.println(Long.MAX_VALUE / (365 * 24 * 60 * 60 * 1000));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
