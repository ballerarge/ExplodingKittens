Logistics

1: When will a formal code inspection be warrented?
	At merge requests and development branches to master. 

2: Who will take the lead on moderating inspections?
	One of the members of the group who didn't write the branch should inspect the branch, as they will be most unbiased towards what was written.

3: How will you share the results of inspections?
	Results will be shared at group meetings, and comments about certain aspects of the 
	inspection will be written in the code for user view. (To be removed later)

Criteria

4: What are the key "code smells" from each chapter of Clean Code? THIS IS THE BIG
	QUESTION. Appendix A of Clean Code might help you recall them.

	Chapter 2: Names -> Nondescriptive Names Smell
	Chapter 3: Functions -> Long Methods Smell
	Chapter 4: Comments -> Dispensable Smell (Comments Smell in particular). Comments
		unnecessary most of time. Code to make people understand without comments.
	Chapter 5: Formatting -> Inconsistencies between programmers. Use linter. Set up
		shared preferences for group to use.
	Chapter 6: Demeter -> Chain of method calls, each relating to previous method.
		Relates to Message Chains Smell. Another smell is Inappropriate Intimacy.
	Chapter 7: Error Handling -> Custom exceptions to reduce the occurance of Shotgun
		Surgery Smell.
	Chapter 9: Unit Testing -> Long Method Smell
	Chapter 10: Classes -> Large Class, Data Class, Lazy Class Smells. Objects vs Data
		Structures. Avoid hybrid classes. Extracting objects and data structures apart
		improves design in general. Single responsibility principle.
	Chapter 12: TDD -> Duplicate Code Smell. No duplicate code.

5: Wll everyone apply all criteria from every chapter from Clean Code? Or will each person specialize in a few criteria?
	Everyone should have these ideas in the back of their mind when coding, so as to not make some mistakes at the beginning. Once the code review is happening, people could specialize in certain criteria so as to find more specific instances of bad code smells to fix. We could also rotate criteria to look for once everyone has finished observing their specific criteria.

Scope

6: Will your team inspect every file in your codebase? Every file you touch in your feature branch? Or something else entirely?
	Initially, every file we touch in the branch will be inspected. Once they are deemed to be ok to merge, the files will be merged into master, and they will once again be inspected to make sure the merge didn't screw anything up.

7: Of those files, will each person look at every file in consideration? Or will your team assign different files to different people?
	Branches will be inspected by the developers who contributed to the branch. This is because they have the most knowledge of how everything works. Once they have deemed it acceptable, the rest of the group members will glance over it to make sure nothing major was missed. Then it will be merged into the upper branch, and another inspection of the code will take place to make sure the merge didn't screw anything up.

Tools

8: To what extent can your inspection criteria be automated? Automation will increase your inspection's speed and reliability.
	We can set up continuous integration on Git, which will run the tests for us when we commit our project. We can also create an Eclipse preferences file for the members of the group to share, so everyone has the same formatting throughout the branches.

9: Which aspects of your inspection criteria will need human intervention?
	Human intervention will be needed for anything that cannot be automated, such as whether the code is of good quality or not. Certain smells that cannot be tested for or weeded out from the preferences need to be overlooked manually.