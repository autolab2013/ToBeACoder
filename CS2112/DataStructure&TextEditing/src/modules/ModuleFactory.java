package modules;

/**
 * A factory class for creating instances of various module implementations.
 */
public class ModuleFactory {

    /** Return an instance of an implementation of autocompletion module. */
    public static AutoCompleteModule getAutoComplete() {
        return new MyAutoComplete();
    }

    /** Return an instance of an implementation of spell check module. */
    public static SpellCheckModule getSpellCheck() {
        return new MySpellCheck();
    }

    /** Return an instance of an implementation of text search module. */
    public static SearchModule getSearchModule() {
        // TODO implement
        return null;
    }

}
