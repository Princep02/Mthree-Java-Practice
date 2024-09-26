package ThirdDay;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CollectionsConcepts {

    public static void main(String[] args) {
        demonstrateList();
        demonstrateSet();
        demonstrateQueue();
        demonstrateMap();
        demonstrateUtilityClasses();
    }

    private static void demonstrateList() {
        System.out.println("\n--- List Interfaces ---");

        // ArrayList: Dynamic array implementation
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);

        // LinkedList: Doubly-linked list implementation
        List<String> linkedList = new LinkedList<>(arrayList);
        linkedList.add(1, "Blueberry");
        System.out.println("LinkedList: " + linkedList);

        // Vector: Thread-safe dynamic array (legacy class)
        Vector<String> vector = new Vector<>(arrayList);
        vector.add("Date");
        System.out.println("Vector: " + vector);

        // Stack: LIFO stack (extends Vector, legacy class)
        Stack<String> stack = new Stack<>();
        stack.push("Elderberry");
        stack.push("Fig");
        System.out.println("Stack: " + stack);
        System.out.println("Popped from stack: " + stack.pop());

        // Operations
        Collections.sort(arrayList);
        System.out.println("Sorted ArrayList: " + arrayList);
        System.out.println("Binary search for 'Cherry': " + Collections.binarySearch(arrayList, "Cherry"));
    }

    private static void demonstrateSet() {
        System.out.println("\n--- Set Interfaces ---");

        // HashSet: Hash table implementation, no guaranteed order
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Blue");
        hashSet.add("Red"); // Duplicate, won't be added
        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet: Hash table and linked list implementation, maintains insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Dog");
        linkedHashSet.add("Cat");
        linkedHashSet.add("Bird");
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet: Red-black tree implementation, sorted order
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Zebra");
        treeSet.add("Elephant");
        treeSet.add("Lion");
        System.out.println("TreeSet: " + treeSet);

        // Operations
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
        Set<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D"));
        set1.retainAll(set2); // Intersection
        System.out.println("Intersection: " + set1);
    }

    private static void demonstrateQueue() {
        System.out.println("\n--- Queue Interfaces ---");

        // PriorityQueue: Priority heap implementation
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(5);
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Poll from PriorityQueue: " + priorityQueue.poll());

        // LinkedList as Queue: FIFO queue
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("Queue: " + queue);
        System.out.println("Poll from Queue: " + queue.poll());

        // Deque: Double-ended queue
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Front");
        deque.addLast("Back");
        System.out.println("Deque: " + deque);
        System.out.println("Poll first from Deque: " + deque.pollFirst());
        System.out.println("Poll last from Deque: " + deque.pollLast());

        // BlockingQueue: Thread-safe queue with blocking operations
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.offer("Task 1");
        blockingQueue.offer("Task 2");
        System.out.println("BlockingQueue: " + blockingQueue);
    }

    private static void demonstrateMap() {
        System.out.println("\n--- Map Interfaces ---");

        // HashMap: Hash table implementation
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        System.out.println("HashMap: " + hashMap);

        // LinkedHashMap: Hash table and linked list implementation, maintains insertion order
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("USA", "Washington D.C.");
        linkedHashMap.put("UK", "London");
        linkedHashMap.put("Japan", "Tokyo");
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // TreeMap: Red-black tree implementation, sorted order
        Map<String, Double> treeMap = new TreeMap<>();
        treeMap.put("Pi", 3.14159);
        treeMap.put("Phi", 1.61803);
        treeMap.put("e", 2.71828);
        System.out.println("TreeMap: " + treeMap);

        // Hashtable: Thread-safe hash table (legacy class)
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "First");
        hashtable.put(2, "Second");
        System.out.println("Hashtable: " + hashtable);

        // ConcurrentHashMap: Thread-safe hash table, better performance than Hashtable
        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Concurrent", 1);
        concurrentMap.put("Hash", 2);
        concurrentMap.put("Map", 3);
        System.out.println("ConcurrentHashMap: " + concurrentMap);

        // Operations
        System.out.println("Keys in HashMap: " + hashMap.keySet());
        System.out.println("Values in HashMap: " + hashMap.values());
        System.out.println("Entries in HashMap: " + hashMap.entrySet());
    }

    private static void demonstrateUtilityClasses() {
        System.out.println("\n--- Utility Classes ---");

        // Arrays utility class
        int[] numbers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        System.out.println("Binary search for 5: " + Arrays.binarySearch(numbers, 5));

        // Collections utility class
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        Collections.reverse(list);
        System.out.println("Reversed list: " + list);
        Collections.shuffle(list);
        System.out.println("Shuffled list: " + list);
        System.out.println("Max element: " + Collections.max(list));
        System.out.println("Min element: " + Collections.min(list));

        // Unmodifiable collections
        List<String> unmodifiableList = Collections.unmodifiableList(new ArrayList<>(list));
        // unmodifiableList.add("date"); // This would throw UnsupportedOperationException

        // Synchronized collections
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>(list));
        System.out.println("Synchronized list: " + synchronizedList);

        // Java 8 Streams
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenSquares = numbers2.stream()
                                            .filter(n -> n % 2 == 0)
                                            .map(n -> n * n)
                                            .collect(Collectors.toList());
        System.out.println("Even squares: " + evenSquares);
    }
}