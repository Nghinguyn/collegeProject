package org.example;

interface List{
    public int size();
    public void add(int x);
    public int get(int index);
    public boolean contains(int x);
    public boolean remove(int x); // remove element with the given data, return false if not found
    public String toString();
}

