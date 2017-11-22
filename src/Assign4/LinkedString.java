package Assign4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by insung151 on 11/22/17.
 */
public class LinkedString implements LinkedStringInterface {
    List<Character> charList = new LinkedList<>();

    @Override
    public void remove(String substr) {

    }

    @Override
    public void remove(LinkedStringInterface substr) {

    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public LinkedStringInterface substring(int startIndex, int endIndex) {
        return null;
    }

    @Override
    public boolean contains(LinkedStringInterface substr) {
        return false;
    }

    @Override
    public boolean contains(String substr) {
        return false;
    }

    @Override
    public int compareTo(LinkedStringInterface str) {
        return 0;
    }

    @Override
    public int compareTo(String str) {
        return 0;
    }

    @Override
    public int compareToIgnoreCase(LinkedStringInterface str) {
        return 0;
    }

    @Override
    public int compareToIgnoreCase(String str) {
        return 0;
    }

    @Override
    public LinkedStringInterface concat(LinkedStringInterface str) {
        return null;
    }

    @Override
    public LinkedStringInterface concat(String str) {
        return null;
    }

}