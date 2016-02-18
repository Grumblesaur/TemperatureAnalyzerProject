CPSC 430 TAP Style & Repository Guide
=====================================

Table of Contents
-----------------
0000 : Repository Guidelines  
  * 0100 : Commits  
  * 0300 : Pushing  
  * 0500 : Pulling  
  * 0700 : Merging  
  
1000 : Programming Style  
  * 1100 : API Resources  
  * 1300 : Classes  
  * 1500 : Functions & Methods  
  * 1700 : Variables  
  * 1800 : Flow Control  
  * 1900 : Comments and Docstrings  
  
0000 : Repository Guidelines
----------------------------
While I initially thought we should work with a system where we have a 
master repository and individual development forks, I get the feeling  
we'll be better served with just some rules for dictating our code  
contributions. Everyone will be made a contributor to this primary  
repository.  

However, because of this, we must adhere to these rules:  

### 0100 : Commits
Commit often and ALWAYS provide a useful commit message that denotes the  
changes you made. Swear words in commit messages will be frowned upon, and  
commit messages that consist entirely of swears will bring *ten myriad*
*years of suffering upon your family.*  

### 0300 : Pushing
Before you push code to the master repository, ensure that:  
  * **Your code compiles.**
  * The module(s) you have made or edited work for at least a few basic test cases.
  * You have made a commit per the guidelines in 0100.

Pushing untested code or code that fails to compile will force *someone*  
*else* on the team to fix your broken code. Don't do that. If your code  
doesn't work yet, do a commit and come back to it later on your own  
machine. Shoot one of us a text or an email if you need a hand piecing a  
function or algorithm together.  

If your code has some bugs in it but works for general cases, **leave a**  
**comment** in the commit message *and* **in the source** **file where**  
**you made your changes.**  

### 0500 : Pulling
Before you begin working on the project source code, **always** be sure to  
pull down from the master repository.  

Before you pull code to your local repository, ensure that:  
  * You have made a commit to your local repository. *This will allow git to auto-merge if necessary.*  

### 0700 : Merging
Doing a manual merge with git can be bad news. I'll add information here  
as we go (we're bound to run into a merge issue at least once). Usually  
git will resolve merges on its own, but if you get an error on a  
`git push` or a `git pull` that relates to merging, alert another Tapper  
in the group text.  


1000 : Programming Style
------------------------

For the sake of easier debugging, easier reading, and smoother flow when  
modules of the code change hands between us, we're going to adhere to our  
own ad-hoc set of rules. Since we'll be working in Java, our practices are  
going to, in some respects, mirror the styles evident in Java's API and  
many example programs.

### 1100 : API Resources
When declaring part of the API as being in a source file's namespace, or  
in other words, using an `import` statement, each module should be  
`import`ed separately. Don't use wildcard imports. Examples as follows:  

GOOD:
    import java.util.Scanner;
    import java.io.IOException;

BAD:
    import java.util.*;

Group resources together by category. `util` modules should be next to  
other `util` modules, `io` with `io`, etc. Exceptions should be separated  
from other classes. Example:  

    /* API Resources */
    import java.util.Scanner;
	import java.util.RandomAccess;
	import java.lang.Integer;
	import java.lang.Double;
	import java.io.PrintWriter;
	import java.io.File;
    
    /* API Exceptions */
    import java.io.IOException;
    import java.lang.IndexOutOfBoundsException;
    import java.lang.ArithmeticException;

And so on. If using external resources (i.e. libraries found elsewhere),  
`import` modules and exceptions in their own comment-marked block.  

### 1300 : Classes
Before you write a class, find out if someone else has already made one we  
could be using instead. Like Dr. Polack suggests, if it takes you more  
than a day or two to find it, you're better off writing it yourself.  

Standard encapsulation rules apply. If we have need to do any object-  
oriented processing, then use appropriate accessor methods for reading and  
writing object fields. Make private helper methods where appropriate.  

It is more likely, however, that we'd be creating classes with `static`  
helper methods than true object-oriented code, due to the fact that we're  
using a database.  

Class names should be `UpperCamelCase` not `mixedCamelCase` -- the first  
letter being capitalized helps to signal that it's a class.

Bracing for classes will be akin to what's called "the one true brace  
style" in the C community. Open brace occurs on the same line as the class  
header, padded by a space. Closing brace occurs on its own line. Example:  

GOOD:
    public class StyleExample {
        // code goes here
    }

BAD:
    public class StyleExample{
        // code goes here
    }

    public class StyleExample2
    {
        // code goes here
    }

VERY BAD:
    public class StyleExample{
        // code goes here }

In other words, the closing brace of the class declaration should line up  
with the first character of its declaration.  

### 1500 : Functions & Methods
This is the meat of the code right here, and since it requires the most  
brainpower to grok, we want to make it as descriptive as possible so we  
expend the energy of fewer brain cells to merely parse it.  

Functions and methods should have descriptive names, preferably verbs or  
verb phrases, but use whatever seems appropriate. If you think the meaning  
of its name might not be intuitive, mark it with a comment or try to come  
up with a better name. Function and method names should be written in  
`camelCase` if it is longer than one word. Additionally, functions/methods  
should be braced like classes. Examples:  

GOOD:
    public String toString() {
        // follows Java API style
    }
	
    public static int[] piecewiseSumOf(int[] a, int[] b) {
        // Compound words should not be camelCased because they are their
        // own lexical units
    }

BAD:
    public String to_string{
        // don't use snake_case
        // pad your braces with spaces, yo
    }
    
    public static char FooBarFunc()
    {
        // don't use crummy names
        // don't use UpperCamelCase
        // don't use this brace style
    }

### 1700 : Variables
Variables should use `mixedCamelCase`, as with methods and functions.  
Single words (including compound words), of course, can be lowercase. If  
you include the word "my" or the type of the variable in the variable's  
name, you will be visited by the moderator of reddit.com/r/badcode in your  
sleep. You have been warned. Examples:  

GOOD:
    float cashOnHand = wallet.cash + pockets.cash;
    String filename = defaultFilename;

BAD:
    float my_cash = wallet.cash + pockets.cash; // NO NO NO
    String fileName = defaultFileName; // this is a compound word!

### 1800 : Flow Control


### 1900 : Comments & Docstrings
