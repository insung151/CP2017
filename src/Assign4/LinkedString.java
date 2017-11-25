package Assign4;

import java.util.LinkedList;

public class LinkedString implements LinkedStringInterface {
    LinkedList<Character> charList;
    LinkedString(String str){
        //This will be frequently used.
        this(str.toCharArray());
    }
    LinkedString(char[] arr){
        charList = new LinkedList<>();
        for (char c : arr)
            charList.add(c);
    }
    LinkedString(){
        charList = new LinkedList<>();
    }

    @Override
    public void remove(String substr) {
        remove(new LinkedString(substr));
    }

    @Override
    public void remove(LinkedStringInterface substr) {
        removeHelper(substr);
    }

    @Override
    public String toString(){
          String s = "";
          for (char c : charList)
              s += c;
          return s;
    }

    @Override
    public char charAt(int index) {
        return charList.get(index);
    }

    @Override
    public int length() {
        return charList.size();
    }

    @Override
    public LinkedString substring(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > length() || startIndex > endIndex)
            throw new IndexOutOfBoundsException();
        char[] charArr = new char[endIndex-startIndex];
        int k = 0;
        for (char c : charList.subList(startIndex, endIndex)){
            charArr[k] = c;
            k++;
        }

        return  new LinkedString(charArr);
    }

    @Override
    public boolean contains(LinkedStringInterface substr) {
        for (int i=0; i<=length()-substr.length(); i++){
            if (this.substring(i,i+substr.length()).compareTo(substr) == 0)
                return true;
        }
        return false;
    }

    @Override
    public boolean contains(String substr) {
        return contains(new LinkedString(substr));
    }

    @Override
    public int compareTo(LinkedStringInterface str) {
        int i = 0;
        boolean flag = false;
        for (i=0; i<Math.min(length(), str.length()); i++){
            if (this.charAt(i) != str.charAt(i)){
                flag = true;
                break;
            }
        }
        if (flag)
            return this.charAt(i) - str.charAt(i);
        else
            return this.length() - str.length();
    }

    @Override
    public int compareTo(String str) {
        return compareTo(new LinkedString(str));
    }

    @Override
    public int compareToIgnoreCase(LinkedStringInterface str) {
        int i = 0;
        boolean flag = false;
        for (i=0; i<Math.min(length(), str.length()); i++){
            char a = this.charAt(i);
            char b = this.charAt(i);
            if (97 <= a && a <= 122)
                a -= 32;
            if (97 <= b && b <= 122)
                b -= 32;
            if (a != b){
                flag = true;
                break;
            }
        }
        if (flag)
            return this.charAt(i) - str.charAt(i);
        else
            return this.length() - str.length();
    }

    @Override
    public int compareToIgnoreCase(String str) {
        return compareToIgnoreCase(new LinkedString(str));
    }

    @Override
    public LinkedString concat(LinkedStringInterface str) {
        for (int i=0; i<str.length(); i++){
            charList.add(str.charAt(i));
        }
        return this;
    }

    @Override
    public LinkedString concat(String str) {
        return concat(new LinkedString(str));
    }

    @Override
    public int indexOf(char ch) {
        for (int i=0; i<length(); i++){
            if (charList.get(i) == ch)
                return i;
        }
        return -1;
    }

    @Override
    public int indexOf(String str) {
        if (!contains(str))
            return -1;
        for (int i=0; i<length(); i++){
            if (substring(i, i+str.length()).compareTo(str) == 0)
                return i;
        }
        return -1;
    }

    @Override
    public LinkedString replace(char oldChar, char newChar) {
        for (int i=0; i<length(); i++){
            if (charList.get(i) == oldChar){
                charList.remove(i);
                charList.add(i,newChar);
            }
        }
        return this;
    }

    private void removeHelper(LinkedStringInterface substr){
        if (!contains(substr))
            return;
        for (int i=0; i <length(); i++){
            if (substring(i, i+substr.length()).compareTo(substr) == 0){
                for(int j=0; j<substr.length(); j++) {
                    charList.remove(i);
                }
                break;
            }
        }
        removeHelper(substr);
    }
}
