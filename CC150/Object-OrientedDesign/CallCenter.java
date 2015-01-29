/** 8.2 Imagine you have a call center with 3 levels of employees: respondent, manager and director.
 *  An incoming call must be first allocated to a respondent who is free. If the respondent can't handle
 *  the call, he/she must escalate the call to a manager. If the manager still can't, the call should be
 *  escalated to a director. Design the classes and data structures. Implement a method dispatchCall() which
 *  assigns a call to the first available employee.
 */
 
/** I think:
 *  const level for respondent/manager/director: 1,2,3
 *  check who is free: boolean field available?
 *  check if he can handle: boolean method handle() return true/false
 *  escalate(): increase level, so the call has field level
 *  dispatchCall(): start from lowest level, check availability, handle(call)
 *  object involved: 
 *  	employee, with 3 subclasses
 *  	call,
 *  	call center {call, employee}
 */
 
abstract class Employee{
	level;
	call;
	availability;
	
	handle();
	escalate();
}

class Call{
	handler;
	level;
	isHandled;
	
	call();
}

class CallCenter{//should be singleton
	incoming_call;
	employees;
	
	dispatchCall()
}