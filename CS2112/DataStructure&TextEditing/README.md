Text editor
===

The text editor supports:
  - text search
  - spell checking
  - autocompletion. 
  
These features, specified by interfaces ```SearchModule```, ```SpellCheckModule```, and ```AutoCompleteModule```.

Factory class``` ModuleFactory``` contains factory methods that should access  implementation
of these features. Instances returned from the factory methods are used by the main text editor program.
