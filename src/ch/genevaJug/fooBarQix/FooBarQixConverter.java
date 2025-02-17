package ch.genevaJug.fooBarQix;

import java.util.Collections;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * 
 * @author Daniel
 *
 */
public class FooBarQixConverter {

    
    // Unmodifiable SortedMap.
    private final SortedMap<Integer, String> specialValues;
    private FooBarQixConverter () {
        SortedMap<Integer, String> specialValuesTmp = new TreeMap<Integer, String>();
        specialValuesTmp.put(5, "Bar");
        specialValuesTmp.put(3, "Foo");
        specialValuesTmp.put(7, "Qix");
        specialValues = Collections.unmodifiableSortedMap(specialValuesTmp);
    }

    // Singleton with static solution
    private final static FooBarQixConverter instance = new FooBarQixConverter();
    public static FooBarQixConverter getInstance() {
        return instance; 
    } 
   
    /**
     * Convert with following rules:
     *  if number can be divided by 3,5,7 add special Values
     *  if number contain char 3,5,7 add special Values
     *  if no special Values return the number
     * @param number
     * @return
     */
    public String convert(int number) {
        final String numberStr = String.valueOf(number);
        StringBuilder result = new StringBuilder();
        
        // if number can be divided by 3,5,7 add special Values 
        for (Entry<Integer, String> entry : specialValues.entrySet()) {
            if (number % entry.getKey() == 0) {
                result.append(entry.getValue());
            }
        }
        
        // if number contain char 3,5,7 add special Values 
        for (char ch : numberStr.toCharArray()) {
            int key = Character.digit(ch, 10);
            if (specialValues.containsKey(key)) {
                result.append(specialValues.get(key));
            }
        }
        
        return result.length() == 0 ? numberStr : result.toString();
    }
}