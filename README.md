hello everyone, this is our new code repository.... enjoy

the following are a few steps to follow to get a feel for how git works,

step 1,
in the maze repository, make a new text file called "your name".txt
for example, i would make a file called simon.txt using the command:
$ touch simon.txt

next execute the command:
$ git status

this command is used to find out the state of your repository, this 
should have printed out something like:

------------------------------------------------------------------

simons-air:maze SHRobilliard$ git status
On branch master
Your branch is up-to-date with 'origin/master'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)

	.README.md.swp
	simon.txt

nothing added to commit but untracked files present (use "git add" to track)

------------------------------------------------------------------

now, to add this file to the repository's tracked files, use the command:
$ git add simon.txt

this file is now tracked

to commit the changes to the repository, you can use the command:

$ git commit -a -m 'some description of what you have done'

this will then print out a bunch of shit which is entirely useless to the
average human being.

it is worth noting that commit does not alter the online repository, it's 
just one step you use to 'clean' your repository before pushing. The point is
to 'commit' to the changes that you've made to your local repository.

the next step is to push your changes to the master repository or 
'origin master'. to do this you must first ensure that you are up to date
with master. do this by pulling from the master. Note you can only pull, if
your local repo is clean, if it is dirty git will tell you to commit any changes to
tracked files. the command is:

$ git pull origin master

this will moste likely say something like you are up to date with origin master.

you can now push your changes to the master with:

$ git push origin master

and hey presto, your changes are committed. Take a look at your changes by visiting
https://github.com/mechatronicBliss/maze