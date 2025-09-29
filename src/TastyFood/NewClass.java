/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TastyFood;

/**
 *
 * @author H PC
 */
class Pair<T>{
private T first;
private T second;
public Pair() { first = null; second = null; }
public Pair(T firstItem, T secondItem) {
first = firstItem;
second = secondItem;
}
public void show() {
System.out.println(first+" "+second);
}
}
class Ex19{
public static void main(String args[]){
Pair<String> pair1 = new Pair<String>("Happy", "Day");
pair1.show();
//Pair<int> pair1 = new Pair<int>(1, 2);
pair1.show();
}
}