# lab7and6
The client software consists of various components: uThr, runtimeThr, localThr & networkThr.

runtimeThr
This thread serves as a middle layer between the uThr (top layer) and localThr & networkThr (both in bottom layer). This thread must be coordinated with those other threads by locks and condition variables. It also maintains 2 concurrent queues: requestQue & returnQue. The requestQue holds items enqueued by uThr's. Each item, along with other essential pieces of data, contains one of 5 commands (nextEven, nextOdd, nextEvenFib, nextLargerRand, nextPrime) that instructs the runtimeThr which calculation to do. The returnQue stores each computed value to be passed to the proper uThr.

localThr
These threads execute on the same local machine as its runtimeThr (which spawns the localThr). Each localThr executes one of 2 tasks: nextEven or nextOdd. (These are independent sequences.) Each command in the requestQue dictates which localThr to spawn & execute (if any). The computed result, along with any other needed pieces of data, is then enqueued in the returnQue.

networkThr
These are also local to the machine of the runtimeThr. A networkThr thread is spawned by the runtimeThr for each of these 3 commands (nextEvenFib, nextLargerRand, nextPrime) enqueued in the requestQue. This thread does not compute any of these values, instead it requests the server to do the calculation (see server description above). When it gets the server reply, it enqueues the result, along with any other needed pieces of data, in the returnQue.

uThr
There are 8 or more uThr's running on the same local machine as its runtimeThr. Each uThr executes 20 iterations. At each iteration a uThr randomly selects one of 5 commands (nextEven, nextOdd, nextEvenFib, nextLargerRand, nextPrime) to enqueue in the requestQue, along with any other needed pieces of data, and waits for the result produced by this command. After its result is enqueued in the returnQue, this thread fetches the returned value and outputs on the terminal.

Note: The above descriptions only specify what the various components of the software system does. Many details corresponding to execution or flows of control remain to be determined by each student team.

SOFTWARE DEMO
Three machines will be needed in the demo of your "remote code execution" software system. One is running the server and 2 are running multiple instances of the client software.

SOME THOUGHTS
Some of the pros & cons of your software implementation include: starvation, fairness, bottleneck, delays, overhead, efficiency, performance, scalability, robustness, etc. Students are encouraged to implement the most effective software. Students are encouraged to seek assistance & review of their designs.

DELIVERABLE
The assignment is to be completed by a team of 3 or 4 students. Each team member will submit his/her individual written report for the project which outlines the strategies and implementation of the software. At minimum, the report should also address software performance, starvation & bottlenecks.

Finally, each report needs to include an assessment of each team member and their contributions, including your own letter grade and a letter grade that you feel each member has earned on this assignment (with justifications).

The team also submits one hard copy of the source code & a separate document that describes each of the classes & their methods (or javadoc in electronic form). It is also highly desirable to include a high level design document of your software to assist with the comprehension & grading of your implementation. 
