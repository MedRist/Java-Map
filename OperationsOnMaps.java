import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/*
Created 30-07-2017
By Mohamed Boudouar.
 */

public class OperationsOnMaps{


    // Convert a Text into a list of Strings.
    // Param: the path of the file
    // Return List of Strings.
    public static List<String> textToList(String path)
    {
        File file =new File(path);
        List<String> list =new LinkedList<>();
        Scanner in =null;
        try {
             in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (in.hasNext())
        {
                list.add(in.next());
        }
        return list;
    }

    //Create a Set of String from a list of Strings
    // Sets a DS without repetition of values.
    public static Set<String> toSet(List<String> l)
    {
        return new TreeSet<>(l);
    }


    //Constructs a new, tree set, sorted according to the specified comparator.
    //if c is null, then it is a natural ordering

    public static TreeSet<Produit> toTset(List<Produit>l, Comparator<Produit> c)
    {
        TreeSet<Produit> treeSet=new TreeSet<>(c);
        treeSet.addAll(l);
        return treeSet;
    }

    //Return a map of String,Integer, for each string the number of frequency in the list.
    public static Map<String, Integer> occ(List<String> list)
    {
        HashMap<String,Integer> map =new HashMap<>();
        for (String item: list) {
                  Integer i=map.get(item);
                  if (i == null ) map.put(item,1);
                  else map.put(item,i+1);
        }
        return map;
    }

    //The inverse Function of the previous, this time we return a Map of Integer and a set, so for each frequency we create a set
    // of elements which has the same frequency.
    //Example : <M,2>, <A,1>, <C,1>,<K,1>, <N,7>
    // Return : <1, {A, C, K }>, <2,{M}>, <7,{N}>
   public static  Map<Integer,Set<String>> reci(List<String> l)
   {
       Map<Integer,Set<String>> map =new HashMap<>();
       Map<String,Integer> occ =occ(l);
       Set<String> set;
       for (Map.Entry<String,Integer> entr :  occ.entrySet())
       {
            if (map.containsKey(entr.getValue())) {
                set=map.get(entr.getValue());
            }else{
                set =new HashSet<>();
            }
           set.add(entr.getKey());
           map.put(entr.getValue(),set);


       }
       return map;

   }
}
