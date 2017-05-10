

/**
 * @author http://zenika.developpez.com/tutoriels/java/patterns-command/
 *
 */

@FunctionalInterface
public interface Command {
  void execute();
}

public interface Conversation<C extends Command> {
	  void exec(C cmd);
	  void undo();
	  void redo();
	}

public class TypeString implements CompensableCommand, MementoableCommand {
	 
	  private final Display display;
	  private final String stringToType;
	 
	  public TypeString(Display display, String stringToType) {
	    this.display = display;
	    this.stringToType = stringToType;
	  }
	 
	  @Override public void execute() {
	    display.append(stringToType);
	  }
	 
	[...]
	}


public class Display {
	 
	  private final LinkedList<String> displayElements = new LinkedList<>();
	 
	  public void append(String stringToAppend) {
	    displayElements.addLast(stringToAppend);
	  }
	 
	  public String displayed() {
	    // Collectors.joining est équivalent à un foreach+StringBuilder mais plus fonctionnel 
	    // (évite l'itération externe/style impératif)
	    return displayElements.stream().collect(Collectors.joining());
	  }
	 
	[...]
	}


/**
*  @param <C> Type of executed commands
* @param <S> Type of stored state (commands or mementos)
*/
public abstract class AbstractConversation<C extends Command, S> implements Conversation<C> {
    protected final Stack<S> undos, redos;
 
    public AbstractConversation() {
        this.undos= new Stack<S>();
        this.redos= new Stack<S>();
    }
}
AbstractConversation utilise la classe Stack (classe interne au framework):
 
public class Stack<T> {
 
    //Delegate to avoid exposing too many Deque methods
    private final Deque<T> stack = new LinkedList<>();
 
    /**
     * @return null if stack is empty
     */
    public T pop() {
        return stack.pollLast(); //Not using pop since it throws NoSuchElementException if the deque is empty
    }
 
    public void push(T cmd) {
        stack.addLast(cmd);
    }
 
    public void clear() {
        stack.clear();
    }
 
    public void forEachFifo(Consumer<? super T> action) {
        stack.stream().forEachOrdered(action);
    }
}

public interface CompensableCommand extends Command {
	  void compensate();
	}


public class CompensationConversation extends AbstractConversation<CompensableCommand, CompensableCommand> {
	 
    @Override public void exec(CompensableCommand todo) {
        todo.execute();
        undos.push(todo);
        redos.clear();
    }
 
    @Override public void undo() {
        CompensableCommand latestCmd = undos.pop();
        if(latestCmd==null) return;
        latestCmd.compensate();
        redos.push(latestCmd);
    }
 
    @Override public void redo() {
        CompensableCommand latestCmd = redos.pop();
        if(latestCmd==null) return;
        latestCmd.execute();
        undos.push(latestCmd);
    }
}

public class TypeString implements CompensableCommand {
    @Override public void compensate() {
        display.unappend();
    }
}

public class Macro implements Command {
	 
	  private final List<Command> parts;
	  public Macro(List<Command> parts) {
	    this.parts = parts;
	  }
	 
	  @Override public void execute() {
	    this.parts.forEach(c -> c.execute());
	  }
	}







/**
* Undo is noop when there were no execs
* undo --> ""
*/
@Test public void basicNoopUndo() {
  Conversation<C> commands = newConversation();
 
  commands.undo();
  assertEquals("", display.displayed());
}
 
/**
* Redo is noop when there were no undos
* redo --> ""
*/
@Test public void basicNoopRedo() {
  Conversation<C> commands = newConversation();
 
  commands.redo();
  assertEquals("", display.displayed());
}
 
/**
* Basic undo
* a    --> "a"
* undo --> ""
*/
@Test public void basicUndo() {
  Conversation<C> commands = newConversation();
 
  commands.exec(typeString("a"));
  assertEquals("a", display.displayed());
 
  commands.undo();
  assertEquals("", display.displayed());
}
 
/**
* Basic redo
* a    --> "a"
* undo --> ""
* redo --> "a"
*/
@Test public void basicRedo() {
  Conversation<C> commands = newConversation();
 
  commands.exec(typeString("a"));
  assertEquals("a", display.displayed());
 
  commands.undo();
  assertEquals("", display.displayed());
 
  commands.redo(); 
  assertEquals("a", display.displayed());
}
 
/**
* a    --> "a"
* b    --> "ab"
* undo --> "a"
* undo --> ""
* redo --> "a"
* redo --> "ab"
*/
@Test public void exec_exec_undo_undo_redo_redo() {
  Conversation<C> commands = newConversation();
 
  commands.exec(typeString("a"));
  assertEquals("a", display.displayed());
 
  commands.exec(typeString("b"));
  assertEquals("ab", display.displayed());
 
  commands.undo();
  assertEquals("a", display.displayed());
 
  commands.undo();
  assertEquals("", display.displayed());
 
  commands.redo();
  assertEquals("a", display.displayed());
 
  commands.redo();
  assertEquals("ab", display.displayed());
}


public class CommandUndoTest_Compensation_Typing_Test extends CommandUndoTest_Typing<CompensableCommand> {
    @Override protected Conversation<CompensableCommand> newConversation() {
        return new CompensationConversation();
    }
 
    @Override protected CompensableCommand typeString(String stringToType) {
        return new TypeString(display, stringToType);
    }
}
 
public class CommandUndoTest_Replay_Typing_Test extends CommandUndoTest_Typing<Command> {
    @Override protected Conversation<Command> newConversation() {
        return new ReplayConversation(()->{
            display.reset();
        });
    }
 
    @Override protected Command typeString(String stringToType) {
        return new TypeString(display, stringToType);
    }
}
 
public class CommandUndoTest_Memento_Typing_Test extends CommandUndoTest_Typing<MementoableCommand> {
    @Override protected Conversation<MementoableCommand> newConversation() {
        return new MementoConversation();
    }
 
    @Override protected MementoableCommand typeString(String stringToType) {
        return new TypeString(display, stringToType);
    }
}

