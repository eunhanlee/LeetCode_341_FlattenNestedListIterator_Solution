import java.util.*;

class Main {

    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(1));
        nestedList.add(new NestedInteger(2));
        List<NestedInteger> nestedList3And4 = new ArrayList<>();
        nestedList3And4.add(new NestedInteger(3));
        nestedList3And4.add(new NestedInteger(4));
        nestedList.add(new NestedInteger(nestedList3And4));
        nestedList.add(new NestedInteger(5));

        NestedIterator iterator = new NestedIterator(nestedList);
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
    }
}
