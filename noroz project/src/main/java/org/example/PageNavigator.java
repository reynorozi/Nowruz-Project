package org.example;

import java.util.ArrayList;
import java.util.List;

public class PageNavigator {
    // Stack to hold the history of pages for navigation
    private static final List<Page> pageStack = new ArrayList<>();

    // Method to push a page onto the stack (navigate to a new page)
    public static void push(Page page) {
        pageStack.add(page); // Add the page to the stack
    }

    // Method to pop the current page from the stack (go back)
    public static void pop() {
        if (!pageStack.isEmpty()) {
            pageStack.remove(pageStack.size() - 1); // Remove the last page from the stack
        }
    }

    // Method to get the previous page (page before the current one)
    public static Page getPreviousPage() {
        if (pageStack.size() >= 2) {
            return pageStack.get(pageStack.size() - 2); // Return the page before the current one
        }
        return null; // If no previous page exists, return null
    }

    // Method to go back to the previous page and show it
    public static void goBack() {
        if (pageStack.size() >= 2) {
            // Remove the current page from the stack
            pageStack.remove(pageStack.size() - 1);
            // Show the previous page (last item in the stack)
            pageStack.get(pageStack.size() - 1).show();
        } else {
            System.out.println("No previous page."); // If there's no previous page, print a message
        }
    }

    // Method to show a specific page and push it onto the stack
    public static void showPage(Page page) {
        push(page); // Push the page onto the stack
        page.show(); // Show the page
    }

    // Method to clear all pages from the stack (reset navigation history)
    public static void clear() {
        pageStack.clear(); // Clear the page stack
    }
}
