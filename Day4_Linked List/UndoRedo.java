class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    private TextState head;
    private TextState current;
    private int size = 0;
    private final int MAX_SIZE = 10;
    public void type(String newContent) {
        TextState newState = new TextState(newContent);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        } else {
            head = newState;
        }
        current = newState;
        size++;
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
        System.out.println("Typed: \"" + current.content + "\"");
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public void display() {
        if (current != null) {
            System.out.println("Current Text: [" + current.content + "]");
        } else {
            System.out.println("Editor is empty.");
        }
    }
}

public class UndoRedo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.type("Hello");
        editor.type("Hello World");
        editor.type("Hello World!");
        editor.display();
        editor.undo();
        editor.display();
        editor.undo();
        editor.display();
        editor.redo();
        editor.display();
        editor.type("Hello Java");
        editor.redo();
        editor.display();
    }
}