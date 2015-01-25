Assignment 1 - Questions
========================

Input Questions
---------------

* Are we guaranteed that "QUIT" will be the last line?
* By "letters", do you refer to the characters represented by Unicode
code points U+0041-U+005a, inclusive and U+0061-U+007a, inclusive?
* What is the encoding of the input? UTF-7? UTF-16? Custom format?
* What is the desired output of the input "ááá"? Specifically, should
diacritics be thrown out and "\u0061\u0300" be parsed as "a", or should both 
characters be thrown out?


Output Questions
----------------

* Is it acceptable to return an empty string due to the processing of "QUIT"
as input? Or should the program terminate output when it sees "QUIT"?
* What is the desired output format? Is it: `String.join(" ", resultStream)`?
i.e. Should there be space or newlines at the end?
* Is the desired output file `stdout` aka `System.out`?
* Should we report repeated palindromes? For example, should the input
"abaaba", produce the output "abaaba aba aba"?


Coding Questions
----------------

* What sort of APIs/tools can we expect the TAs to have? Apache Commons? Guava?
* Is use of StringBuffer instead of StringBuilder acceptable if presenting a
threaded solution?
* Are you a Single Entry Single Exit for Java person?


Style Questions
---------------

* Are you tolerant of `import java.util.*`? :)
* Which horizontal spacing is more preferable:
`if (null == new String ()) { System.out.println ("ok."); }` or
`if (null == new String()) { System.out.println("ok."); }`?
* Tabs or spaces? If spaces, how many?
* 79, 80, 100, or no character line limit?
