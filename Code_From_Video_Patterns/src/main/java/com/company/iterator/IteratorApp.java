package com.company.iterator;

public class IteratorApp {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        Iterator it = tasks.getIterator();
        while (it.hasNext()) {
            System.out.println((String) it.next());
        }
    }
}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Container {
    Iterator getIterator();
}

class Tasks implements Container {
    String[] tasks = {"Build house", "Have a son", "Grow a tree"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
