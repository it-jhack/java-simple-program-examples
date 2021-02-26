package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {

        // Map<K,V>
//        It's a Key/Value pair collection.
//        •Does not allow key object repetitions.
//        •Elements are indexed by key object (no position)
//        •Elements access, insertion, and deletion are fast.
//
//        Common use: cookies, local storage, any key-value model.
//
//        Main implementations:
//         •HashSet: faster - O(1) hash table operations - and not ordinated
//         •TreeSet: slower - O(log(n)) in Red-Black tree operations - and
//             ordinated by object's compareTo (Comparator)
//         •LinkedHashSet: medium speed. Elements in added order.

        // Some important methods:
//        • put(key, value), remove(key), containsKey(key), get(key)
//            • Based on equals() e hashCode()
//            • If equals() and hashCode() do not exist, pointers comparison is used
//        • clear()
//        • size()
//        • keySet() - returns a Set<K>
//        • values() - returns a Collection<V>

        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "maria"); //key, value: inserts element into map
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "9-9999-9999");

        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }

        System.out.println("#1 ---------------------------------");

        cookies.remove("email");
        // Map doesn't allow key repetition, so phone wil be updated to new value
        cookies.put("phone", "9-8888-8888"); // different phone

        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }

        System.out.println("#2 ---------------------------------");

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone number: " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email"));
        System.out.println("Size: " + cookies.size());

        System.out.println("#3 ---------------------------------");

        System.out.println("ALL COOKIES:");
        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }

    }
}
