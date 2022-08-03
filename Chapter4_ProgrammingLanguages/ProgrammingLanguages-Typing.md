# Programming Languages - Typing
## Overview

Programming languages can be "strongly" typed, "weakly" typed, or somewhere in between. "Strong" and "weak" typed is not well defined, but it generally means how strict or loose the type systems of the languages are. That is, how strictly are types required to be defined throughout code and at compile time.

A more succinct discussion is statically vs. dynamically typed. Statically typed languages check types at compile time, whereas dynamicaly typed languages do not ridgidly check types (e.g. a variable could have a number or boolean).

Generally, strong/weak can be thought of in relation to the compiler, whereas static/dynamic can be thought of in relation to how the language instructions interacts with types.

## More Details and Definitions

Generally, strongly typed languages have stricter typing rules at compile time, which implies errors and exceptions are more likely to occur at compile time. Weakly typed languages have less strict typing rules at compile time, and as such, type checking, and therefore errors or erroneious results happens at run time. 

**Strong/weak**:
- Weak: compiler doesn't enforce correct typing
    ```
    "12345" * 1 === 12345  // string * number => number
    ```
- Strong: comppiler wants you to explictly operate on same/operable types
    ```
    (int) "12345" * 1 === 12345
    ```

**Dynamic/static**:
- Dynamically typed: value's type is enforced, but the variable simply represents any value of any type
    ```
    x = 12345;              // number
    x = "string";           // string
    x = { key: "value" };   // object
    y = 123 + x;            // error or implicit conversion must take place.
    ```
- Statically typed: variable type is strongly enforced
    ```
    int x = 12345;      // binds x to the type int
    x = "string";       // too late, x is an integer - error
    string y = 123;     // error or implicit conversion must take place.
    ```

#
## Distinguishing Features
- Above

# 
## Language examples
- **Java** - "strongly typed". Statically typed, where types are checked at compile time. 
- **Python** - "strongly typed" but dynamic - does not make use of static type checking but typing errors are prevented at runtime
- **JavaScript** - "weakly typed". There is no static typing in JS.
- **TypeScript** - "strongly typed" JavaScript. There is static typing that's checked in the "transpile" process to bring TS to native JS code.

#
## Strengths and Weaknesses

**Strengths**:
- Dynamic - faster coding experience
- Static - do not hve unchecked runtime errors

**Weaknesses**:
- Dynamic - can have ambiguity with what the type a variable is and pesky runtime errors
- Static - can have overtyping and too much overhead and boilerplate

#
## Example uses
- Above languages examples

#
## Resources
- https://en.wikipedia.org/wiki/Strong_and_weak_typing
- https://stackoverflow.com/a/964983
- https://stackoverflow.com/questions/2690544/what-is-the-difference-between-a-strongly-typed-language-and-a-statically-typed

#