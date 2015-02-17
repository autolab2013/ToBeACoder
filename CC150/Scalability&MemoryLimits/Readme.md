Chap 10
===

1. The step-by-step approach
	1. suppose the machine has unlimited memory and can hold all the data
	2. consider how much capacity one machine has. What would happen when splitting data? How does machine look up data?
	3. solve problems

2. What you need to know: information, strategies and issues
	1. A typical system:
	
	component|typical capacity
	---------|----------------
	hard drive space|?
	memory|?
	internet transfer latency|?
	
	2. dividing up lots of data:
		1. by order of appearance: a queue, a large lookup table
		2. by hash value: hash(key)%N
		3. by actual value: e.g. by location
		4. arbitrarily:
