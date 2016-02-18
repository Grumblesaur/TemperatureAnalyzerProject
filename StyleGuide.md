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
  * 1500 : Functions, Methods, and Variables  
  * 1700 : Comments and Docstrings  
  
0000 : Repository Guidelines
----------------------------
While I initially thought we should work with a system where  
we have a master repository and individual development forks,  
I get the feeling we'll be better served with just some  
rules for dictating our code contributions. Everyone will be  
made a contributor to this primary repository.  

However, because of this, we must adhere to these rules:  

### 0100 : Commits
Commit often and ALWAYS provide a useful commit message that  
denotes the changes you made. Swear words in commit messages  
will be frowned upon, and commit messages that consist  
entirely of swears will bring *ten myriad years of suffering*  
*upon your family.*  

### 0300 : Pushing
Before you push code to the master repository, ensure that:  
  * **Your code compiles.**
  * The module(s) you have made or edited work for at least a few basic test cases.
  * You have made a commit per the guidelines in 0100.

Pushing untested code or code that fails to compile will  
force *someone else* on the team to fix your broken code.  
Don't do that. If your code doesn't work yet, do a commit  
and come back to it later on your own machine. Shoot one of  
us a text or an email if you need a hand piecing a function  
or algorithm together.  

If your code has some bugs in it but works for general cases,  
**leave a comment** in the commit message *and* **in the source**  
**file where you made your changes.**  

### 0500 : Pulling
Before you begin working on the project source code, **always** be  
sure to pull down from the master repository.  

Before you pull code to your local repository, ensure that:  
  * You have made a commit to your local repository. *This will allow git to auto-merge if necessary.*  

### 0700 : Merging
Doing a manual merge with git can be bad news. I'll add information  
here as we go (we're bound to run into a merge issue at least once).  
Usually git will resolve merges on its own, but if you get an error  
on a `git push` or a `git pull` that relates to merging, alert a  
Tapper in the group text.  


1000 : Programming Style
------------------------


