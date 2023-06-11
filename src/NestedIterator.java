import java.util.*;

/**
 * Iterator to flatten a nested list of integers.
 */
public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> iterList;

    /**
     * Constructs a new NestedIterator with the given nested list.
     *
     * @param nestedList the nested list of integers
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        iterList = new ArrayDeque<>();
        flattenList(nestedList);
    }

    /**
     * Returns the next integer in the nested list.
     *
     * @return the next integer
     * @throws NoSuchElementException if there are no more elements
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterList.pop().getInteger();
    }

    /**
     * Checks if there are more integers in the nested list.
     *
     * @return true if there are more integers, false otherwise
     */
    @Override
    public boolean hasNext() {
        while (!iterList.isEmpty() && !iterList.peek().isInteger()) {
            List<NestedInteger> nestedList = iterList.pop().getList();
            flattenList(nestedList);
        }
        return !iterList.isEmpty();
    }

    /**
     * Flattens a nested list by pushing its elements onto the stack in reverse order.
     *
     * @param nestedList the nested list to flatten
     */
    private void flattenList(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            iterList.push(nestedList.get(i));
        }
    }
}
