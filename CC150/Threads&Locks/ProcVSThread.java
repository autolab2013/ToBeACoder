/** 
 *  16.1 What's the difference between a thread and a process?
 */
 
A process: an instance of a program in execution. Starts with a primary thread. Processes don't share address space and memory.
One cannot access another one's variable or data structure. Their communication can be done in 
RPC, pipe, file sockets, etc.

A thread: a particular execution path of a proc. all threads share proc heap memory, can be used to 
communicate. Each has its own register and stack.


//from stackoverflow
Process
Each process provides the resources needed to execute a program. A process has a virtual address space, executable code, 
open handles to system objects, a security context, a unique process identifier, environment variables, a priority class,
 minimum and maximum working set sizes, and at least one thread of execution. Each process is started with a single thread,
 often called the primary thread, but can create additional threads from any of its threads.

Thread
A thread is the entity within a process that can be scheduled for execution. All threads of a process share its virtual 
address space and system resources. In addition, each thread maintains exception handlers, a scheduling priority,
 thread local storage, a unique thread identifier, and a set of structures the system will use to save the
 thread context until it is scheduled. The thread context includes the thread's set of machine registers, 
 the kernel stack, a thread environment block, and a user stack in the address space of the thread's process. 
 Threads can also have their own security context, which can be used for impersonating clients.