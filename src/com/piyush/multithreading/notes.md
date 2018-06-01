MonoCore v/s multicore processor.
- af


Who is responsible for CPU sharing ?
- Thread scheduler

There are three reasons for a scheduler to pause a thread.
- Waiting for data: input/output operation renders core to idle state
- CPU sharing: other threads waiting to get their time slice
- inter-thread communication: A thread might be waiting for another thread to do something.

What is Race Condition ?
- More than one thread may be accessing same variable/field/object (read/write) at the same time and can cause inconsistency in the value of variable. Example, singleton objects.

Reentrant Lock

Deadlock

Thread States :

1. New
2. Runnable
3. Terminated
4. Blocked : Waiting at the entrance of sync block
5. Waiting : On wait() awaken by notify()
6. Timed Waiting : Sleep(timeout) or wait(timout)

Synchronization
1. Ensures that only one thread code executes a piece of code at a time.
2. Prevents race condition

Ordering read/write on muliticore CPU

Problem with multicore CPU is that they can store read/write varibles on different caches(L1, L2) or memory causing inconsistancy in its values

Visibility of a variable:

Changes made on the variable by a CPU core should be visible to other core and must not just remain on their individual caches.
All the synchronized writes are visible.

All the shared variables should be accessed in a volatile way or synchronized way.

What 'happens before link' is ?

**False Sharing**
A CPU cache is organised in lines of data.Each line can hold 8 longs (64 bytes).
When a visible variable is modified in an L1 cache, all the lines are marked dirty for the other caches and the CPU has to update the catch
by reading the data from main memory. This causes a performance hit.



Synchronization is about atomicity and only one thread can execute a piece of code at a time.
Volatile is about visibility of variables through multiple caches.

